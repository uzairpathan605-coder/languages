package com.example.audio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class SpeechHelper(private val context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private val scope = CoroutineScope(Dispatchers.Main)
    private var sequenceJob: Job? = null

    private val _isInitialized = MutableStateFlow(false)
    val isInitialized: StateFlow<Boolean> = _isInitialized.asStateFlow()

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _currentSpeakingId = MutableStateFlow<String?>(null)
    val currentSpeakingId: StateFlow<String?> = _currentSpeakingId.asStateFlow()

    private val _ttsNotice = MutableStateFlow<String?>(null)
    val ttsNotice: StateFlow<String?> = _ttsNotice.asStateFlow()

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            _isInitialized.value = true
            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _isSpeaking.value = true
                    _currentSpeakingId.value = utteranceId
                }

                override fun onDone(utteranceId: String?) {
                    _isSpeaking.value = false
                    _currentSpeakingId.value = null
                }

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    _isSpeaking.value = false
                    _currentSpeakingId.value = null
                    _ttsNotice.value = "Audio error occurred. Please check Text-to-Speech settings."
                }

                override fun onError(utteranceId: String?, errorCode: Int) {
                    _isSpeaking.value = false
                    _currentSpeakingId.value = null
                    Log.w("SpeechHelper", "TTS Error: $errorCode for $utteranceId")
                    _ttsNotice.value = "Voice pack notice (code $errorCode). Tap here or go to Android Settings > Accessibility > Text-to-speech to download high quality voice."
                }
            })
        } else {
            _ttsNotice.value = "Text-to-Speech engine initialization failed. Please enable Google Speech Services in device Settings."
        }
    }

    fun speakText(
        id: String,
        text: String,
        languageTag: String,
        isSlow: Boolean = false,
        onDone: (() -> Unit)? = null
    ) {
        stop()

        val engine = tts
        if (engine == null || !_isInitialized.value) {
            _ttsNotice.value = "Speech voice engine is still loading. Please try again in a moment."
            return
        }

        val locale = getLocaleForTag(languageTag)
        val availability = engine.isLanguageAvailable(locale)

        if (availability == TextToSpeech.LANG_MISSING_DATA || availability == TextToSpeech.LANG_NOT_SUPPORTED) {
            // Attempt generic language matching (e.g., "de" if "de-DE" not found)
            val langOnly = Locale(locale.language)
            val langAvailability = engine.isLanguageAvailable(langOnly)
            if (langAvailability == TextToSpeech.LANG_AVAILABLE || langAvailability == TextToSpeech.LANG_COUNTRY_AVAILABLE) {
                engine.language = langOnly
            } else {
                _ttsNotice.value = "Voice for ${locale.displayLanguage} is not installed on this phone. Please install it in Android Settings > Text-to-Speech output."
                return
            }
        } else {
            engine.language = locale
        }

        engine.setSpeechRate(if (isSlow) 0.65f else 1.0f)
        engine.setPitch(1.0f)

        val params = Bundle().apply {
            putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, id)
        }

        _ttsNotice.value = null
        engine.speak(text, TextToSpeech.QUEUE_FLUSH, params, id)
    }

    fun playSequence(
        items: List<Pair<String, String>>, // id to text
        languageTag: String,
        isSlow: Boolean = false,
        onItemStarted: (String) -> Unit = {},
        onCompleted: () -> Unit = {}
    ) {
        stop()
        sequenceJob = scope.launch {
            for (item in items) {
                onItemStarted(item.first)
                speakText(item.first, item.second, languageTag, isSlow)
                // Wait for speech to complete or timeout
                var waitCount = 0
                while (_isSpeaking.value && waitCount < 100) {
                    delay(100)
                    waitCount++
                }
                delay(600) // Pause between sentences
            }
            onCompleted()
        }
    }

    fun stop() {
        sequenceJob?.cancel()
        sequenceJob = null
        tts?.stop()
        _isSpeaking.value = false
        _currentSpeakingId.value = null
    }

    fun openTtsSettings() {
        try {
            val intent = Intent("com.android.settings.TTS_SETTINGS")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        } catch (e: Exception) {
            Log.e("SpeechHelper", "Cannot open TTS settings", e)
        }
    }

    fun dismissNotice() {
        _ttsNotice.value = null
    }

    fun shutdown() {
        stop()
        tts?.shutdown()
        tts = null
    }

    private fun getLocaleForTag(tag: String): Locale {
        return try {
            val parts = tag.split("-", "_")
            if (parts.size >= 2) {
                Locale(parts[0], parts[1])
            } else {
                Locale(parts[0])
            }
        } catch (e: Exception) {
            Locale.GERMAN
        }
    }
}
