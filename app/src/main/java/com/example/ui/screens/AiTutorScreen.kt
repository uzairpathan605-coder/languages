package com.example.ui.screens

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai.AiTutorService
import com.example.ai.ChatMessage
import com.example.audio.SpeechHelper
import com.example.model.Language
import com.example.model.UserProfile
import com.example.ui.components.ChunkyCard
import com.example.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiTutorScreen(
    language: Language,
    userProfile: UserProfile,
    speechHelper: SpeechHelper,
    onOpenSettings: () -> Unit,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    val tutorService = remember { AiTutorService() }
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    var inputText by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val messages = remember {
        mutableStateListOf(
            ChatMessage(
                text = if (language.id == "de")
                    "Hallo! Ich bin Ihr Ustaad AI Sprachcoach. Sprechen oder schreiben Sie auf Deutsch mit mir!"
                else
                    "Hello! I am your AI Coach at BIZOlingo. Speak or type with me to practice!",
                isUser = false,
                translationUrdu = "ہیلو! میں آپ کا AI استاد ہوں۔ مجھ سے بولیں یا لکھ کر بات کریں!",
                romanUrdu = "Hallo! Main aap ka Ustaad AI hoon. Bol kar ya likh kar practice karein!",
                correctionTip = "Shuru karein! Ghalati hone par main aap ko guide karunga."
            )
        )
    }

    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val spokenText = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.firstOrNull()
            if (!spokenText.isNullOrBlank()) {
                inputText = spokenText
            }
        }
    }

    fun startVoiceInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, language.ttsLanguageTag)
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak in ${language.nameNative} or English...")
        }
        try {
            speechRecognizerLauncher.launch(intent)
        } catch (e: Exception) {
            // Intent fallback
        }
    }

    fun sendCurrentMessage(customText: String? = null) {
        val textToSend = customText ?: inputText.trim()
        if (textToSend.isEmpty() || isLoading) return

        val userMsg = ChatMessage(text = textToSend, isUser = true)
        messages.add(userMsg)
        inputText = ""
        isLoading = true

        scope.launch {
            listState.animateScrollToItem(messages.size - 1)
            val reply = tutorService.sendMessage(
                userMessage = textToSend,
                targetLanguage = language,
                apiKey = userProfile.geminiApiKey,
                conversationHistory = messages
            )
            messages.add(reply)
            isLoading = false
            listState.animateScrollToItem(messages.size - 1)

            speechHelper.speakText(
                id = reply.id,
                text = reply.text,
                languageTag = language.ttsLanguageTag,
                isSlow = userProfile.isSpeechSlow
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            color = DuolingoGreenLight,
                            shape = CircleShape,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(text = "🤖", fontSize = 18.sp)
                            }
                        }
                        Column {
                            Text("Ustaad AI (Voice Coach)", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                            Text(
                                text = if (userProfile.geminiApiKey.isNotEmpty()) "Gemini 2.5 Flash Online 🟢" else "Built-in Coach Mode 💡",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("ai_tutor_back_button")) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onOpenSettings, modifier = Modifier.testTag("ai_settings_button")) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings / API Key")
                    }
                }
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 6.dp,
                shadowElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    // Quick topic chips
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 6.dp)
                    ) {
                        val scenarioChips = if (language.id == "de") {
                            listOf(
                                "Wie geht es Ihnen?",
                                "Wann beginnt meine Schicht?",
                                "Ich suche eine Ausbildung",
                                "Könnten Sie mir bitte helfen?",
                                "Wo ist der Pausenraum?"
                            )
                        } else {
                            listOf(
                                "Hello, how are you?",
                                "When does my shift start?",
                                "I need help with this task",
                                "Can we take a quick break?"
                            )
                        }
                        items(scenarioChips) { prompt ->
                            SuggestionChip(
                                onClick = { sendCurrentMessage(prompt) },
                                label = { Text(prompt, fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                            )
                        }
                    }

                    // Input Bar (Mic + TextField + Send)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(
                            onClick = { startVoiceInput() },
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(DuolingoBlue)
                                .testTag("voice_input_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Mic,
                                contentDescription = "Speak into microphone",
                                tint = Color.White
                            )
                        }

                        OutlinedTextField(
                            value = inputText,
                            onValueChange = { inputText = it },
                            placeholder = { Text("Speak or type in ${language.nameNative}...", fontSize = 13.sp) },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("ai_chat_input"),
                            shape = RoundedCornerShape(22.dp),
                            maxLines = 3
                        )

                        IconButton(
                            onClick = { sendCurrentMessage() },
                            enabled = inputText.isNotBlank() && !isLoading,
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(if (inputText.isNotBlank()) DuolingoGreen else MaterialTheme.colorScheme.surfaceVariant)
                                .testTag("ai_send_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Send",
                                tint = if (inputText.isNotBlank()) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(messages) { msg ->
                    if (msg.isUser) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Surface(
                                color = DuolingoGreen,
                                shape = RoundedCornerShape(20.dp, 20.dp, 4.dp, 20.dp),
                                modifier = Modifier.widthIn(max = 280.dp)
                            ) {
                                Text(
                                    text = msg.text,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                                )
                            }
                        }
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            ChunkyCard(
                                modifier = Modifier.widthIn(max = 320.dp),
                                cornerRadius = 20.dp
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "🤖 Ustaad AI",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 13.sp,
                                        color = DuolingoGreen
                                    )

                                    IconButton(
                                        onClick = {
                                            speechHelper.speakText(
                                                id = msg.id,
                                                text = msg.text,
                                                languageTag = language.ttsLanguageTag,
                                                isSlow = userProfile.isSpeechSlow
                                            )
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.VolumeUp,
                                            contentDescription = "Listen to AI voice",
                                            tint = DuolingoGreen,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = msg.text,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                if (msg.translationUrdu.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = msg.translationUrdu,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = DuolingoGreen
                                    )
                                }

                                if (msg.romanUrdu.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Roman: ${msg.romanUrdu}",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                if (msg.correctionTip.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        color = DuolingoOrangeLight,
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text(text = "💡", fontSize = 12.sp)
                                            Text(
                                                text = msg.correctionTip,
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = DuolingoOrangeShadow
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (isLoading) {
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(20.dp), color = DuolingoGreen, strokeWidth = 2.dp)
                            Text("Ustaad AI is thinking...", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }
    }
}
