package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.SpeechHelper
import com.example.data.CourseDataRepository
import com.example.model.Language
import com.example.model.SentenceItem
import com.example.model.UserProfile
import com.example.ui.components.ChunkyButton
import com.example.ui.components.ChunkyButtonColor
import com.example.ui.components.ChunkyCard
import com.example.ui.theme.*

data class QuizQuestion(
    val sentence: SentenceItem,
    val prompt: String,
    val promptUrdu: String,
    val options: List<String>,
    val correctIndex: Int,
    val isListeningType: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeQuizScreen(
    language: Language,
    userProfile: UserProfile,
    speechHelper: SpeechHelper,
    onAddXp: (Int) -> Unit,
    onDecrementHeart: () -> Unit,
    onRefillHearts: () -> Unit,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    val allSentences = remember(language.id) {
        CourseDataRepository.getLessons(language.id).flatMap { it.sentences }
    }

    var questionIndex by remember { mutableIntStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isAnswerSubmitted by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }
    var earnedXpTotal by remember { mutableIntStateOf(0) }

    // Generate questions pool
    val questions = remember(allSentences) {
        if (allSentences.size < 4) emptyList()
        else {
            val shuffled = allSentences.shuffled()
            (0 until 5.coerceAtMost(shuffled.size)).map { idx ->
                val targetSentence = shuffled[idx]
                val distractors = allSentences.filter { it.id != targetSentence.id }.shuffled().take(3)
                val allOptions = (listOf(targetSentence) + distractors).shuffled()
                val correctPos = allOptions.indexOfFirst { it.id == targetSentence.id }

                val isListening = idx % 2 == 0
                if (isListening) {
                    QuizQuestion(
                        sentence = targetSentence,
                        prompt = "Listen to audio & pick correct meaning:",
                        promptUrdu = "آواز سنیں اور درست اردو معنی منتخب کریں:",
                        options = allOptions.map { it.urduText },
                        correctIndex = correctPos,
                        isListeningType = true
                    )
                } else {
                    QuizQuestion(
                        sentence = targetSentence,
                        prompt = "How do you say in ${language.nameNative}?",
                        promptUrdu = "${language.nameNative} میں یہ بات کیسے کہیں گے؟",
                        options = allOptions.map { it.targetText },
                        correctIndex = correctPos,
                        isListeningType = false
                    )
                }
            }
        }
    }

    val currentQuestion = questions.getOrNull(questionIndex)

    LaunchedEffect(questionIndex) {
        currentQuestion?.let { q ->
            if (q.isListeningType) {
                speechHelper.speakText(
                    id = q.sentence.id,
                    text = q.sentence.targetText,
                    languageTag = language.ttsLanguageTag,
                    isSlow = userProfile.isSpeechSlow
                )
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Practice Quiz (مشق)", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "❤️", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${userProfile.hearts}/${userProfile.maxHearts}",
                                fontWeight = FontWeight.ExtraBold,
                                color = DuolingoRed
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("quiz_back_button")) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            if (userProfile.hearts > 0 && currentQuestion != null) {
                Surface(
                    tonalElevation = 6.dp,
                    shadowElevation = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        if (isAnswerSubmitted) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = if (isCorrect) "🎉 Shabash! Correct! (+15 XP)" else "❌ Incorrect! -1 Heart",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = if (isCorrect) DuolingoGreenShadow else DuolingoRed
                                )
                            }
                            Text(
                                text = "Answer: ${currentQuestion.sentence.targetText} — ${currentQuestion.sentence.romanUrduText}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                        ChunkyButton(
                            onClick = {
                                if (!isAnswerSubmitted) {
                                    val isRight = selectedOptionIndex == currentQuestion.correctIndex
                                    isAnswerSubmitted = true
                                    isCorrect = isRight
                                    if (isRight) {
                                        earnedXpTotal += 15
                                        onAddXp(15)
                                    } else {
                                        onDecrementHeart()
                                    }
                                } else {
                                    if (questionIndex < questions.size - 1) {
                                        questionIndex++
                                        selectedOptionIndex = null
                                        isAnswerSubmitted = false
                                        isCorrect = false
                                    } else {
                                        questionIndex++
                                    }
                                }
                            },
                            enabled = selectedOptionIndex != null,
                            colorStyle = if (isAnswerSubmitted && isCorrect) ChunkyButtonColor.GREEN
                            else if (isAnswerSubmitted) ChunkyButtonColor.ORANGE
                            else ChunkyButtonColor.GREEN,
                            testTag = "quiz_action_button"
                        ) {
                            Text(
                                text = if (!isAnswerSubmitted) "CHECK ANSWER (تصدیق کریں)"
                                else if (questionIndex < questions.size - 1) "NEXT QUESTION (اگلا سوال) ➔"
                                else "FINISH QUIZ (مکمل کریں) 🏆",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (userProfile.hearts <= 0) {
                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = DuolingoRed.copy(alpha = 0.1f),
                    borderColor = DuolingoRed
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(text = "💔", fontSize = 54.sp)
                        Text(
                            text = "You are out of hearts!",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 19.sp,
                            color = DuolingoRed
                        )
                        Text(
                            text = "دل ختم ہو گئے۔ فوری ری فل کریں تاکہ پڑھائی جاری رہ سکے۔",
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                        Box(modifier = Modifier.width(220.dp)) {
                            ChunkyButton(
                                onClick = onRefillHearts,
                                colorStyle = ChunkyButtonColor.RED,
                                testTag = "refill_hearts_button"
                            ) {
                                Icon(imageVector = Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Refill Hearts (5/5) ❤️", fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }
            } else if (currentQuestion == null || questionIndex >= questions.size) {
                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = DuolingoGreenLight,
                    borderColor = DuolingoGreen
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(text = "🏆", fontSize = 56.sp)
                        Text(
                            text = "Quiz Completed! شاندار کارکردگی!",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = DuolingoGreenShadow
                        )
                        Text(
                            text = "Total XP Earned: +$earnedXpTotal XP",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = DuolingoGreenShadow
                        )
                        Box(modifier = Modifier.width(200.dp)) {
                            ChunkyButton(
                                onClick = onBack,
                                colorStyle = ChunkyButtonColor.GREEN,
                                testTag = "quiz_finish_button"
                            ) {
                                Text("Back to Dashboard", fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }
            } else {
                LinearProgressIndicator(
                    progress = { (questionIndex.toFloat() + 1) / questions.size.toFloat() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    color = DuolingoGreen,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )

                Text(
                    text = "Question ${questionIndex + 1} of ${questions.size}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = currentQuestion.prompt,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp
                )
                Text(
                    text = currentQuestion.promptUrdu,
                    fontSize = 13.sp,
                    color = DuolingoGreen
                )

                ChunkyCard(
                    modifier = Modifier.fillMaxWidth(),
                    cornerRadius = 18.dp,
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            if (!currentQuestion.isListeningType) {
                                Text(
                                    text = currentQuestion.sentence.urduText,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = DuolingoGreen
                                )
                                Text(
                                    text = "English: ${currentQuestion.sentence.englishText}",
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = "Roman: ${currentQuestion.sentence.romanUrduText}",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                )
                            } else {
                                Text(
                                    text = "Tap speaker to hear audio",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        IconButton(
                            onClick = {
                                speechHelper.speakText(
                                    id = currentQuestion.sentence.id,
                                    text = currentQuestion.sentence.targetText,
                                    languageTag = language.ttsLanguageTag,
                                    isSlow = userProfile.isSpeechSlow
                                )
                            },
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(DuolingoBlue)
                                .testTag("quiz_audio_repeat_button")
                        ) {
                            Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Play audio", tint = Color.White)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                currentQuestion.options.forEachIndexed { optIdx, optText ->
                    val isSelected = selectedOptionIndex == optIdx
                    val isThisCorrect = isAnswerSubmitted && optIdx == currentQuestion.correctIndex
                    val isThisWrong = isAnswerSubmitted && isSelected && !isCorrect

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .clickable(enabled = !isAnswerSubmitted) {
                                selectedOptionIndex = optIdx
                            }
                            .testTag("quiz_option_$optIdx"),
                        shape = RoundedCornerShape(18.dp),
                        color = when {
                            isThisCorrect -> DuolingoGreenLight
                            isThisWrong -> DuolingoRed.copy(alpha = 0.15f)
                            isSelected -> DuolingoBlueLight.copy(alpha = 0.5f)
                            else -> MaterialTheme.colorScheme.surface
                        },
                        border = androidx.compose.foundation.BorderStroke(
                            2.dp,
                            when {
                                isThisCorrect -> DuolingoGreen
                                isThisWrong -> DuolingoRed
                                isSelected -> DuolingoBlue
                                else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                            }
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = optText,
                                fontSize = 15.sp,
                                fontWeight = if (isSelected || isThisCorrect) FontWeight.ExtraBold else FontWeight.Normal,
                                color = when {
                                    isThisCorrect -> DuolingoGreenShadow
                                    isThisWrong -> DuolingoRed
                                    else -> MaterialTheme.colorScheme.onSurface
                                },
                                modifier = Modifier.weight(1f)
                            )
                            if (isThisCorrect) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = "Correct", tint = DuolingoGreen)
                            } else if (isThisWrong) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = "Wrong", tint = DuolingoRed)
                            }
                        }
                    }
                }
            }
        }
    }
}
