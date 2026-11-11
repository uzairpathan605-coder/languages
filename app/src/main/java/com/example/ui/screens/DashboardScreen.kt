package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.CourseDataRepository
import com.example.model.*
import com.example.ui.components.*
import com.example.ui.theme.*

@Composable
fun DashboardScreen(
    userProfile: UserProfile,
    onSelectLanguage: (String) -> Unit,
    onOpenLesson: (Lesson) -> Unit,
    onOpenBasics: () -> Unit,
    onOpenAiTutor: () -> Unit,
    onOpenPractice: () -> Unit,
    onOpenSearch: () -> Unit,
    onToggleReminder: (Boolean) -> Unit
) {
    var showLanguageDialog by remember { mutableStateOf(false) }
    var showNotificationsModal by remember { mutableStateOf(false) }
    var showStreakCelebration by remember { mutableStateOf(false) }

    // Initial level determined by user's chosen start level: a1 -> A1, a2 -> A2, b1 -> B1
    var selectedLevel by remember {
        mutableStateOf(
            when (userProfile.startLevel) {
                "b1" -> CefrLevel.B1
                "a2" -> CefrLevel.A2
                else -> CefrLevel.A1
            }
        )
    }

    val currentLanguage = SupportedLanguages.getById(userProfile.targetLanguageId)
    val lessonsForLevel = CourseDataRepository.getLessonsByLevel(currentLanguage.id, selectedLevel)

    // Calculate level progress
    val allLevelLessons = CourseDataRepository.getLessons(currentLanguage.id)
    val totalSentences = allLevelLessons.sumOf { it.sentences.size }
    val learnedSentencesCount = allLevelLessons.sumOf { lesson ->
        lesson.sentences.count { userProfile.isSentenceLearned(it.id) }
    }
    val progressPercent = if (totalSentences > 0) (learnedSentencesCount.toFloat() / totalSentences.toFloat()) else 0f

    // Today's lesson respects starting level filter!
    val startLevelCefr = when (userProfile.startLevel) {
        "b1" -> CefrLevel.B1
        "a2" -> CefrLevel.A2
        else -> CefrLevel.A1
    }
    val eligibleLessons = allLevelLessons.filter { it.level.ordinal >= startLevelCefr.ordinal }
    val todayLesson = eligibleLessons.firstOrNull { !userProfile.isLessonCompleted(it.id) } ?: eligibleLessons.firstOrNull() ?: allLevelLessons.first()

    val uiLang = userProfile.uiLanguage

    if (showLanguageDialog) {
        LanguageSelectionDialog(
            selectedLanguageId = userProfile.targetLanguageId,
            onSelectLanguage = onSelectLanguage,
            onDismiss = { showLanguageDialog = false }
        )
    }

    if (showNotificationsModal) {
        NotificationsModal(
            userProfile = userProfile,
            onDismiss = { showNotificationsModal = false }
        )
    }

    if (showStreakCelebration) {
        StreakCelebrationModal(
            userProfile = userProfile,
            xpGained = 50,
            onDismiss = { showStreakCelebration = false }
        )
    }

    Scaffold(
        topBar = {
            TopStatsBar(
                userProfile = userProfile,
                currentLanguage = currentLanguage,
                onLanguageClick = { showLanguageDialog = true },
                onNotificationClick = { showNotificationsModal = true },
                onStreakClick = { showStreakCelebration = true }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .testTag("dashboard_content_column"),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {
            // Streak & 7-Day Activity Row Card
            item {
                Streak7DayRow(
                    userProfile = userProfile,
                    onStreakClick = { showStreakCelebration = true },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Chunky Hero Banner
            item {
                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_workers_hero_1794289077238),
                            contentDescription = "Diverse workers",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Surface(
                            color = Color.Black.copy(alpha = 0.45f),
                            modifier = Modifier.fillMaxSize()
                        ) {}
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(12.dp)
                        ) {
                            Text(
                                text = "BIZOlingo Academy for All Workers",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                            Text(
                                text = "Ausbildung & German Jobs • Healthcare, Logistics, Hotels, Drivers & IT",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${currentLanguage.nameNative} ${AppStrings.get("mastery", uiLang)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Text(
                            text = "${(progressPercent * 100).toInt()}% ${AppStrings.get("completed", uiLang)}",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp,
                            color = DuolingoGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { progressPercent },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        color = DuolingoGreen,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }

            // Today's Lesson Card with Chunky 3D Button
            todayLesson.let { lesson ->
                item {
                    ChunkyCard(
                        modifier = Modifier.fillMaxWidth(),
                        containerColor = DuolingoGreenLight.copy(alpha = 0.45f),
                        borderColor = DuolingoGreen.copy(alpha = 0.6f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Surface(
                                    color = DuolingoGreen,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        text = "${AppStrings.get("today_lesson", uiLang)} • ${lesson.level.code}",
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "${lesson.iconEmoji} ${lesson.title}",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = lesson.romanUrduTitle,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Box(modifier = Modifier.width(130.dp)) {
                                ChunkyButton(
                                    onClick = { onOpenLesson(lesson) },
                                    colorStyle = ChunkyButtonColor.GREEN,
                                    testTag = "continue_lesson_button"
                                ) {
                                    Text(
                                        text = AppStrings.get("continue", uiLang),
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 13.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Chunky Shortcut Action Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        ChunkyButton(
                            onClick = onOpenSearch,
                            colorStyle = ChunkyButtonColor.SURFACE,
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
                            testTag = "quick_search_button"
                        ) {
                            Text("🔍", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(AppStrings.get("quick_search", uiLang), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        ChunkyButton(
                            onClick = onOpenBasics,
                            colorStyle = ChunkyButtonColor.BLUE,
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
                            testTag = "quick_basics_button"
                        ) {
                            Text("🔤", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(AppStrings.get("quick_basics", uiLang), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        ChunkyButton(
                            onClick = onOpenAiTutor,
                            colorStyle = ChunkyButtonColor.ORANGE,
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
                            testTag = "quick_ai_tutor_button"
                        ) {
                            Text("🎙️", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(AppStrings.get("quick_ai", uiLang), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        ChunkyButton(
                            onClick = onOpenPractice,
                            colorStyle = ChunkyButtonColor.GREEN,
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
                            testTag = "quick_practice_button"
                        ) {
                            Text("⚡", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(AppStrings.get("quick_quiz", uiLang), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // LEVEL WINDING PATH (A1 -> C2 nodes on a winding path!)
            item {
                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = AppStrings.get("curriculum_path", uiLang),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Tap node to switch level",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    LevelWindingPath(
                        selectedLevel = selectedLevel,
                        isGerman = currentLanguage.id == "de",
                        onSelectLevel = { level -> selectedLevel = level }
                    )
                }
            }

            // Lessons in Selected Level Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${selectedLevel.title} Lessons (${lessonsForLevel.size})",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp
                    )
                    if (currentLanguage.id == "de" && selectedLevel.germanTag != null) {
                        Surface(
                            color = DuolingoYellowLight,
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = selectedLevel.germanTag!!,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = DuolingoYellowShadow,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            // Lessons list for that level
            items(lessonsForLevel) { lesson ->
                val isCompleted = userProfile.isLessonCompleted(lesson.id)
                val learnedInLesson = lesson.sentences.count { userProfile.isSentenceLearned(it.id) }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { onOpenLesson(lesson) }
                        .testTag("lesson_card_${lesson.id}"),
                    color = if (lesson.isWorkplaceSpecial) DuolingoBlueLight.copy(alpha = 0.45f)
                    else MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        2.dp,
                        if (isCompleted) DuolingoGreen
                        else if (lesson.isWorkplaceSpecial) DuolingoBlue
                        else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                    ),
                    shadowElevation = 2.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Surface(
                                color = if (isCompleted) DuolingoGreen else MaterialTheme.colorScheme.surfaceVariant,
                                shape = CircleShape,
                                modifier = Modifier.size(48.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(text = lesson.iconEmoji, fontSize = 22.sp)
                                }
                            }

                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = lesson.title,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 15.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    if (lesson.isWorkplaceSpecial) {
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Surface(
                                            color = DuolingoBlue,
                                            shape = RoundedCornerShape(4.dp)
                                        ) {
                                            Text(
                                                text = AppStrings.get("workplace_badge", uiLang),
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color.White,
                                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                }
                                Text(
                                    text = lesson.romanUrduTitle,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "$learnedInLesson of ${lesson.sentences.size} sentences learned",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isCompleted) DuolingoGreenShadow else DuolingoBlue
                                )
                            }
                        }

                        if (isCompleted) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Completed",
                                tint = DuolingoGreen,
                                modifier = Modifier.size(28.dp)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "Start",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
