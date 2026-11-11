package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.SpeechHelper
import com.example.data.PreferencesManager
import com.example.model.AppStrings
import com.example.model.Lesson
import com.example.model.SupportedLanguages
import com.example.ui.screens.*
import com.example.ui.theme.DuolingoGreen
import com.example.ui.theme.MyApplicationTheme

enum class AppScreen(val stringKey: String, val icon: ImageVector) {
    DASHBOARD("tab_learn", Icons.Default.School),
    BASICS("tab_basics", Icons.Default.MenuBook),
    AI_TUTOR("tab_ai_tutor", Icons.Default.RecordVoiceOver),
    PRACTICE("tab_quiz", Icons.Default.EmojiEvents),
    SETTINGS("tab_settings", Icons.Default.Settings)
}

class MainActivity : ComponentActivity() {
    private lateinit var preferencesManager: PreferencesManager
    private lateinit var speechHelper: SpeechHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        preferencesManager = PreferencesManager(applicationContext)
        speechHelper = SpeechHelper(applicationContext)

        setContent {
            MyApplicationTheme {
                val userProfile by preferencesManager.userProfile.collectAsState()
                var currentScreen by remember { mutableStateOf(AppScreen.DASHBOARD) }
                var activeLesson by remember { mutableStateOf<Lesson?>(null) }
                var isSearchOpen by remember { mutableStateOf(false) }

                val currentLanguage = SupportedLanguages.getById(userProfile.targetLanguageId)
                val uiLang = userProfile.uiLanguage

                if (!userProfile.isOnboardingCompleted) {
                    OnboardingScreen(
                        onComplete = { name, targetLanguageId, learningReason, startLevel, dailyGoalMinutes ->
                            preferencesManager.completeOnboarding(
                                name = name,
                                targetLanguageId = targetLanguageId,
                                learningReason = learningReason,
                                startLevel = startLevel,
                                dailyGoalMinutes = dailyGoalMinutes
                            )
                        }
                    )
                } else if (activeLesson != null) {
                    LessonDetailScreen(
                        lesson = activeLesson!!,
                        language = currentLanguage,
                        userProfile = userProfile,
                        speechHelper = speechHelper,
                        onToggleLearned = { sentenceId ->
                            preferencesManager.toggleSentenceLearned(sentenceId)
                        },
                        onLessonCompleted = { lessonId ->
                            preferencesManager.markLessonCompleted(lessonId)
                        },
                        onBack = { activeLesson = null }
                    )
                } else if (isSearchOpen) {
                    SearchVaultScreen(
                        currentLanguage = currentLanguage,
                        userProfile = userProfile,
                        speechHelper = speechHelper,
                        onToggleLearned = { sentenceId ->
                            preferencesManager.toggleSentenceLearned(sentenceId)
                        },
                        onBack = { isSearchOpen = false }
                    )
                } else {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            NavigationBar(
                                tonalElevation = 6.dp,
                                modifier = Modifier.testTag("main_navigation_bar")
                            ) {
                                AppScreen.entries.forEach { screen ->
                                    val isSelected = currentScreen == screen
                                    val tabLabel = AppStrings.get(screen.stringKey, uiLang)
                                    NavigationBarItem(
                                        selected = isSelected,
                                        onClick = { currentScreen = screen },
                                        icon = {
                                            Icon(
                                                imageVector = screen.icon,
                                                contentDescription = tabLabel
                                            )
                                        },
                                        label = {
                                            Text(
                                                text = tabLabel,
                                                fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                                                fontSize = 11.sp
                                            )
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = DuolingoGreen,
                                            indicatorColor = DuolingoGreen.copy(alpha = 0.15f)
                                        ),
                                        modifier = Modifier.testTag("nav_item_${screen.name.lowercase()}")
                                    )
                                }
                            }
                        }
                    ) { innerPadding ->
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            when (currentScreen) {
                                AppScreen.DASHBOARD -> DashboardScreen(
                                    userProfile = userProfile,
                                    onSelectLanguage = { langId ->
                                        preferencesManager.setTargetLanguage(langId)
                                    },
                                    onOpenLesson = { lesson ->
                                        activeLesson = lesson
                                    },
                                    onOpenBasics = {
                                        currentScreen = AppScreen.BASICS
                                    },
                                    onOpenAiTutor = {
                                        currentScreen = AppScreen.AI_TUTOR
                                    },
                                    onOpenPractice = {
                                        currentScreen = AppScreen.PRACTICE
                                    },
                                    onOpenSearch = {
                                        isSearchOpen = true
                                    },
                                    onToggleReminder = { enabled ->
                                        preferencesManager.toggleReminders(enabled)
                                    }
                                )

                                AppScreen.BASICS -> BasicsScreen(
                                    language = currentLanguage,
                                    userProfile = userProfile,
                                    speechHelper = speechHelper,
                                    onBack = { currentScreen = AppScreen.DASHBOARD }
                                )

                                AppScreen.AI_TUTOR -> AiTutorScreen(
                                    language = currentLanguage,
                                    userProfile = userProfile,
                                    speechHelper = speechHelper,
                                    onOpenSettings = { currentScreen = AppScreen.SETTINGS },
                                    onBack = { currentScreen = AppScreen.DASHBOARD }
                                )

                                AppScreen.PRACTICE -> PracticeQuizScreen(
                                    language = currentLanguage,
                                    userProfile = userProfile,
                                    speechHelper = speechHelper,
                                    onAddXp = { amount ->
                                        preferencesManager.addXp(amount)
                                    },
                                    onDecrementHeart = {
                                        preferencesManager.decrementHeart()
                                    },
                                    onRefillHearts = {
                                        preferencesManager.refillHearts()
                                    },
                                    onBack = { currentScreen = AppScreen.DASHBOARD }
                                )

                                AppScreen.SETTINGS -> SettingsScreen(
                                    userProfile = userProfile,
                                    onSelectTargetLanguage = { langId ->
                                        preferencesManager.setTargetLanguage(langId)
                                    },
                                    onSelectUiLanguage = { selectedUiLang ->
                                        preferencesManager.setUiLanguage(selectedUiLang)
                                    },
                                    onUpdateProfile = { name, goal, startLvl, reason ->
                                        preferencesManager.updateProfile(name, goal, startLvl, reason)
                                    },
                                    onSetSpeechSlow = { isSlow ->
                                        preferencesManager.setSpeechSlow(isSlow)
                                    },
                                    onSaveGeminiApiKey = { key ->
                                        preferencesManager.setGeminiApiKey(key)
                                    },
                                    onToggleReminder = { enabled ->
                                        preferencesManager.toggleReminders(enabled)
                                    },
                                    onSetReminderTime = { time ->
                                        preferencesManager.setReminderTime(time)
                                    },
                                    onRedoSetup = {
                                        preferencesManager.redoSetup()
                                    },
                                    onResetProgress = {
                                        preferencesManager.resetProgress()
                                    },
                                    onBack = { currentScreen = AppScreen.DASHBOARD }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        speechHelper.shutdown()
    }
}
