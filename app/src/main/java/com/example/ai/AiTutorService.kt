package com.example.ai

import com.example.model.Language
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

data class ChatMessage(
    val id: String = java.util.UUID.randomUUID().toString(),
    val text: String,
    val isUser: Boolean,
    val translationUrdu: String = "",
    val romanUrdu: String = "",
    val correctionTip: String = "",
    val timestamp: Long = System.currentTimeMillis()
)

class AiTutorService {
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(25, TimeUnit.SECONDS)
        .build()

    suspend fun sendMessage(
        userMessage: String,
        targetLanguage: Language,
        apiKey: String,
        conversationHistory: List<ChatMessage>
    ): ChatMessage {
        val trimmedKey = apiKey.trim()
        if (trimmedKey.isNotEmpty()) {
            try {
                return callGeminiApi(userMessage, targetLanguage, trimmedKey, conversationHistory)
            } catch (e: Exception) {
                // If API fails or key is invalid, fall back smoothly to simulated expert response with guidance
                val simulated = generateSmartFallbackReply(userMessage, targetLanguage)
                return simulated.copy(
                    correctionTip = "Note: Gemini API key error (${e.message ?: "network"}). Using built-in Academy Coach mode."
                )
            }
        } else {
            return generateSmartFallbackReply(userMessage, targetLanguage)
        }
    }

    private suspend fun callGeminiApi(
        userMessage: String,
        targetLanguage: Language,
        apiKey: String,
        history: List<ChatMessage>
    ): ChatMessage = withContext(Dispatchers.IO) {
        val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey"

        val systemInstruction = """
            You are 'Ustaad AI', an encouraging, patient language coach at BIZOlingo Language Academy.
            The user is an Urdu speaker who is learning ${targetLanguage.nameEn} (${targetLanguage.nameNative}), especially for jobs in Germany (Ausbildung, logistics, hospitality, technical, services) and global communication.
            Format your response STRICTLY as a valid JSON object with the following fields:
            {
              "reply": "The response in ${targetLanguage.nameEn} (simple, natural, encouraging).",
              "urdu": "Urdu translation in Urdu script.",
              "roman": "Roman Urdu meaning/pronunciation guide.",
              "correction": "Kindly point out any grammar/spelling mistake the student made, or say 'Shabash! Zabardast koshish' in Roman Urdu.",
              "followUpQuestion": "A short follow-up practice question in ${targetLanguage.nameEn}."
            }
        """.trimIndent()

        val contentsArray = JSONArray()

        // Context / History
        for (msg in history.takeLast(4)) {
            val role = if (msg.isUser) "user" else "model"
            contentsArray.put(
                JSONObject().apply {
                    put("role", role)
                    put("parts", JSONArray().put(JSONObject().put("text", msg.text)))
                }
            )
        }

        // Current message
        contentsArray.put(
            JSONObject().apply {
                put("role", "user")
                put("parts", JSONArray().put(JSONObject().put("text", userMessage)))
            }
        )

        val requestBodyJson = JSONObject().apply {
            put("contents", contentsArray)
            put(
                "systemInstruction",
                JSONObject().put(
                    "parts",
                    JSONArray().put(JSONObject().put("text", systemInstruction))
                )
            )
            put(
                "generationConfig",
                JSONObject().apply {
                    put("responseMimeType", "application/json")
                    put("temperature", 0.7)
                }
            )
        }

        val request = Request.Builder()
            .url(url)
            .post(requestBodyJson.toString().toRequestBody("application/json".toMediaType()))
            .build()

        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            val errBody = response.body?.string() ?: ""
            throw RuntimeException("Gemini HTTP ${response.code}: $errBody")
        }

        val resString = response.body?.string() ?: ""
        val jsonRes = JSONObject(resString)
        val candidate = jsonRes.getJSONArray("candidates").getJSONObject(0)
        val textPart = candidate.getJSONObject("content").getJSONArray("parts").getJSONObject(0).getString("text")

        val parsed = JSONObject(textPart)
        val reply = parsed.optString("reply", "Sehr gut gemacht!")
        val followUp = parsed.optString("followUpQuestion", "")
        val fullReply = if (followUp.isNotEmpty()) "$reply $followUp" else reply
        val urdu = parsed.optString("urdu", "بہت خوب کوشش!")
        val roman = parsed.optString("roman", "Bohot achi koshish!")
        val correction = parsed.optString("correction", "Grammar bilkul theek hai.")

        ChatMessage(
            text = fullReply,
            isUser = false,
            translationUrdu = urdu,
            romanUrdu = roman,
            correctionTip = correction
        )
    }

    private fun generateSmartFallbackReply(userMessage: String, targetLanguage: Language): ChatMessage {
        val lower = userMessage.lowercase().trim()

        if (targetLanguage.id == "de") {
            return when {
                lower.contains("hallo") || lower.contains("guten") || lower.contains("hi") || lower.contains("salam") -> {
                    ChatMessage(
                        text = "Hallo! Schön, dass Sie da sind. Wie kann ich Ihnen heute beim Deutschlernen helfen?",
                        isUser = false,
                        translationUrdu = "ہیلو! آپ کو یہاں دیکھ کر خوشی ہوئی۔ آج میں جرمن سیکھنے میں آپ کی کیا مدد کر سکتا ہوں؟",
                        romanUrdu = "Hallo! Aap ko yahan dekh kar khushi hui. Aaj main German seekhne mein aap ki kya madad kar sakta hoon?",
                        correctionTip = "Shabash! 'Hallo' keh kar baat shuru karna bilkul theek hai."
                    )
                }
                lower.contains("arbeit") || lower.contains("job") || lower.contains("schicht") || lower.contains("ausbildung") -> {
                    ChatMessage(
                        text = "Sehr gut! Für eine Ausbildung oder Arbeit in Deutschland ist B1 oder B2 ideal. Welche Fachrichtung interessiert Sie am meisten?",
                        isUser = false,
                        translationUrdu = "بہت خوب! جرمنی میں Ausbildung یا نوکری کے لیے B1 یا B2 بہترین ہے۔ آپ کو کس شعبے میں سب سے زیادہ دلچسپی ہے؟",
                        romanUrdu = "Bohot khoob! Ausbildung ke liye B1/B2 behtareen hai. Aap ko kis shobay mein interest hai?",
                        correctionTip = "Workplace vocabulary note: 'Die Schicht' ka matlab shift duty hota hai."
                    )
                }
                lower.contains("hilfe") || lower.contains("help") || lower.contains("madad") -> {
                    ChatMessage(
                        text = "Kein Problem! Sie können sagen: 'Könnten Sie mir bitte helfen?' Möchten Sie diesen Satz nachsprechen?",
                        isUser = false,
                        translationUrdu = "کوئی مسئلہ نہیں! آپ کہہ سکتے ہیں: کیا آپ براہ کرم میری مدد کر سکتے ہیں؟ کیا آپ یہ بولنا چاہیں گے؟",
                        romanUrdu = "Koi masla nahi! Aap keh sakte hain: 'Könnten Sie mir bitte helfen?'. Is jumlay ko repeat karein.",
                        correctionTip = "Tip: 'Könnten Sie...' bohot ba-adab (polite) tariqa hai madad mangne ka."
                    )
                }
                lower.contains("pause") || lower.contains("break") || lower.contains("essen") -> {
                    ChatMessage(
                        text = "Die Mittagspause dauert meistens dreißig Minuten. Sagen Sie: 'Ich mache jetzt eine kurze Pause.'",
                        isUser = false,
                        translationUrdu = "دوپہر کا وقفہ عموما تیس منٹ کا ہوتا ہے۔ آپ کہیں: 'میں اب مختصر وقفہ لے رہا ہوں۔'",
                        romanUrdu = "Break aam taur par 30 minute ka hota hai. 'Ich mache jetzt eine kurze Pause' bolein.",
                        correctionTip = "Daftar mein break batane ke liye ye behtareen jumla hai."
                    )
                }
                else -> {
                    ChatMessage(
                        text = "Das ist ein interessanter Satz! Sprechen Sie weiter auf Deutsch: 'Ich möchte jeden Tag zehn Minuten üben.'",
                        isUser = false,
                        translationUrdu = "یہ ایک دلچسپ جملہ ہے! جرمن میں مزید بولیں: 'میں روزانہ دس منٹ پریکٹس کرنا چاہتا ہوں۔'",
                        romanUrdu = "Ye acha jumla hai! Mazeed bole: 'Ich möchte jeden Tag zehn Minuten üben.' (Main rozana 10 minute mashq karna chahta hoon).",
                        correctionTip = "Shabash! Rozana choti choti baat cheet se rawani aati hai."
                    )
                }
            }
        } else {
            return when {
                lower.contains("hello") || lower.contains("hi") || lower.contains("salam") -> {
                    ChatMessage(
                        text = "Hello! Welcome to BIZOlingo Academy. What topic would you like to practice today?",
                        isUser = false,
                        translationUrdu = "ہیلو! BIZOlingo اکیڈمی میں خوش آمدید۔ آج آپ کس موضوع پر مشق کرنا چاہیں گے؟",
                        romanUrdu = "Hello! Academy mein welcome. Aaj kis topic par practice karna chahenge?",
                        correctionTip = "Great start! Polite greetings build conversational confidence."
                    )
                }
                lower.contains("work") || lower.contains("job") || lower.contains("career") -> {
                    ChatMessage(
                        text = "Excellent ambition! What role or industry are you planning to work in?",
                        isUser = false,
                        translationUrdu = "شاندار ارادہ! آپ کس شعبے میں کام کرنے کا منصوبہ بنا رہے ہیں؟",
                        romanUrdu = "Shandar irada! Aap kis industry mein kaam karna chahte hain?",
                        correctionTip = "Practice saying: 'I have experience in logistics and teamwork.'"
                    )
                }
                else -> {
                    ChatMessage(
                        text = "Good job trying to communicate! Try saying: 'I want to improve my speaking fluency.'",
                        isUser = false,
                        translationUrdu = "بات چیت کرنے کی اچھی کوشش! یہ بول کر دیکھیں: 'میں اپنی روانی کو بہتر بنانا چاہتا ہوں۔'",
                        romanUrdu = "Achi koshish! Bolein: 'I want to improve my speaking fluency.'",
                        correctionTip = "Consistent daily practice boosts fluency!"
                    )
                }
            }
        }
    }
}
