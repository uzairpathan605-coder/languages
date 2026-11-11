package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
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
import com.example.audio.SpeechHelper
import com.example.model.AppStrings
import com.example.model.Language
import com.example.model.Lesson
import com.example.model.UserProfile
import com.example.ui.components.ChunkyButton
import com.example.ui.components.ChunkyButtonColor
import com.example.ui.components.ChunkyCard
import com.example.ui.components.StreakCelebrationModal
import com.example.ui.components.TtsNoticeBanner
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    language: Language,
    userProfile: UserProfile,
    speechHelper: SpeechHelper,
    onToggleLearned: (String) -> Unit,
    onLessonCompleted: (String) -> Unit,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    var isSlowMode by remember { mutableStateOf(userProfile.isSpeechSlow) }
    val isSpeaking by speechHelper.isSpeaking.collectAsState()
    val currentSpeakingId by speechHelper.currentSpeakingId.collectAsState()
    val ttsNotice by speechHelper.ttsNotice.collectAsState()

    val learnedCount = lesson.sentences.count { userProfile.isSentenceLearned(it.id) }
    val isAllLearned = learnedCount == lesson.sentences.size
    val uiLang = userProfile.uiLanguage

    var showStreakCelebration by remember { mutableStateOf(false) }
    var hasShownCelebrationForSession by remember { mutableStateOf(false) }

    LaunchedEffect(isAllLearned) {
        if (isAllLearned) {
            if (!userProfile.isLessonCompleted(lesson.id)) {
                onLessonCompleted(lesson.id)
            }
            if (!hasShownCelebrationForSession) {
                hasShownCelebrationForSession = true
                showStreakCelebration = true
            }
        }
    }

    if (showStreakCelebration) {
        StreakCelebrationModal(
            userProfile = userProfile,
            xpGained = 50,
            onDismiss = { showStreakCelebration = false },
            onContinue = {
                showStreakCelebration = false
                onBack()
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "${lesson.iconEmoji} ${lesson.title}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 1
                        )
                        Text(
                            text = "${language.nameNative} • ${lesson.level.code} Level",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("lesson_back_button")) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(
                            text = if (isSlowMode) "🐢 Slow" else "🐇 Normal",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Switch(
                            checked = isSlowMode,
                            onCheckedChange = { isSlowMode = it },
                            modifier = Modifier.testTag("slow_speech_switch")
                        )
                    }
                }
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 6.dp,
                shadowElevation = 10.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "${AppStrings.get("learned", uiLang)}: $learnedCount of ${lesson.sentences.size}",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 14.sp,
                            color = if (isAllLearned) DuolingoGreenShadow else DuolingoBlue
                        )
                        Text(
                            text = "+10 XP per sentence | +50 XP bonus",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Box(modifier = Modifier.width(150.dp)) {
                        ChunkyButton(
                            onClick = {
                                val items = lesson.sentences.map { it.id to it.targetText }
                                speechHelper.playSequence(items, language.ttsLanguageTag, isSlowMode)
                            },
                            colorStyle = if (isSpeaking) ChunkyButtonColor.ORANGE else ChunkyButtonColor.GREEN,
                            testTag = "play_all_button"
                        ) {
                            Icon(
                                imageVector = if (isSpeaking) Icons.Default.VolumeUp else Icons.Default.PlayArrow,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isSpeaking) AppStrings.get("speaking", uiLang) else AppStrings.get("play_all", uiLang),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .testTag("lesson_sentences_list"),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {
            // TTS Notice if voice pack missing
            ttsNotice?.let { notice ->
                item {
                    TtsNoticeBanner(
                        noticeMessage = notice,
                        onOpenSettings = { speechHelper.openTtsSettings() },
                        onDismiss = { speechHelper.dismissNotice() }
                    )
                }
            }

            // STUDY METHOD BANNER (Listen -> Repeat slowly -> Speak aloud -> Tick)
            item {
                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = DuolingoBlueLight.copy(alpha = 0.5f),
                    borderColor = DuolingoBlue
                ) {
                    Text(
                        text = AppStrings.get("study_method_title", uiLang),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        color = DuolingoBlueShadow
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        listOf(
                            AppStrings.get("step_listen", uiLang),
                            AppStrings.get("step_slow", uiLang),
                            AppStrings.get("step_speak", uiLang),
                            AppStrings.get("step_tick", uiLang)
                        ).forEachIndexed { i, stepText ->
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surface,
                                border = androidx.compose.foundation.BorderStroke(1.dp, DuolingoBlue.copy(alpha = 0.4f))
                            ) {
                                Text(
                                    text = stepText,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Roman Urdu Grammar Tip Box
            item {
                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = DuolingoYellowLight,
                    borderColor = DuolingoYellowShadow
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "💡", fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = AppStrings.get("grammar_tip", uiLang),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp,
                            color = DuolingoYellowShadow
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = lesson.grammarTipRomanUrdu,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF78350F)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "English: ${lesson.grammarTipEn}",
                        fontSize = 11.sp,
                        color = Color(0xFF78350F).copy(alpha = 0.8f)
                    )
                }
            }

            // All 8 Sentence Cards
            items(lesson.sentences) { sentence ->
                val isLearned = userProfile.isSentenceLearned(sentence.id)
                val isThisSpeaking = isSpeaking && currentSpeakingId == sentence.id

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("sentence_card_${sentence.id}"),
                    shape = RoundedCornerShape(22.dp),
                    color = if (isThisSpeaking) DuolingoGreenLight.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(
                        2.dp,
                        if (isThisSpeaking) DuolingoGreen
                        else if (isLearned) DuolingoGreenLight
                        else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                    ),
                    shadowElevation = 2.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Surface(
                                    color = MaterialTheme.colorScheme.surfaceVariant,
                                    shape = CircleShape,
                                    modifier = Modifier.size(40.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(text = sentence.emoji, fontSize = 20.sp)
                                    }
                                }
                                Text(
                                    text = sentence.targetText,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 19.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            // Chunky 3D round audio listen button
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        speechHelper.speakText(
                                            id = sentence.id,
                                            text = sentence.targetText,
                                            languageTag = language.ttsLanguageTag,
                                            isSlow = isSlowMode
                                        )
                                    }
                                    .background(if (isThisSpeaking) DuolingoGreen else DuolingoBlue)
                                    .testTag("listen_btn_${sentence.id}"),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = if (isThisSpeaking) Icons.Default.VolumeUp else Icons.Default.VolumeDown,
                                    contentDescription = "Listen",
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // English
                        Text(
                            text = sentence.englishText,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Urdu Script
                        Text(
                            text = sentence.urduText,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = DuolingoGreen
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        // Roman Urdu
                        Text(
                            text = "Roman: ${sentence.romanUrduText}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Tick Learned Box
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { onToggleLearned(sentence.id) },
                            color = if (isLearned) DuolingoGreenLight.copy(alpha = 0.6f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(12.dp),
                            border = if (isLearned) androidx.compose.foundation.BorderStroke(1.5.dp, DuolingoGreen) else null
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isLearned) "Learned (+10 XP) ✅" else AppStrings.get("mark_learned", uiLang),
                                    fontSize = 12.sp,
                                    fontWeight = if (isLearned) FontWeight.ExtraBold else FontWeight.Bold,
                                    color = if (isLearned) DuolingoGreenShadow else MaterialTheme.colorScheme.onSurface
                                )
                                Checkbox(
                                    checked = isLearned,
                                    onCheckedChange = { onToggleLearned(sentence.id) },
                                    colors = CheckboxDefaults.colors(checkedColor = DuolingoGreen),
                                    modifier = Modifier.testTag("learned_checkbox_${sentence.id}")
                                )
                            }
                        }
                    }
                }
            }

            if (isAllLearned) {
                item {
                    ChunkyCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showStreakCelebration = true }
                            .testTag("lesson_completed_celebration_banner"),
                        containerColor = DuolingoGreenLight,
                        borderColor = DuolingoGreen
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "🎉", fontSize = 42.sp)
                            Text(
                                text = "Lesson Completed! Shabash!",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 18.sp,
                                color = DuolingoGreenShadow
                            )
                            Text(
                                text = "+50 XP bonus earned! Daily streak extended.",
                                fontSize = 12.sp,
                                color = DuolingoGreenShadow
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                onClick = { showStreakCelebration = true },
                                colors = ButtonDefaults.buttonColors(containerColor = DuolingoGreen),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier.testTag("celebrate_streak_again_btn")
                            ) {
                                Text(
                                    text = "🔥 View Streak Celebration Animation",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
