package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
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
import com.example.audio.SpeechHelper
import com.example.data.CourseDataRepository
import com.example.model.Language
import com.example.model.UserProfile
import com.example.ui.components.ChunkyCard
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchVaultScreen(
    currentLanguage: Language,
    userProfile: UserProfile,
    speechHelper: SpeechHelper,
    onToggleLearned: (String) -> Unit,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    var searchQuery by remember { mutableStateOf("") }

    // STRICTLY search ONLY inside the currently selected language as requested!
    val results = remember(searchQuery, currentLanguage.id) {
        if (searchQuery.isBlank()) emptyList()
        else {
            CourseDataRepository.searchSentences(searchQuery, currentLanguage.id)
        }
    }

    val isSpeaking by speechHelper.isSpeaking.collectAsState()
    val currentSpeakingId by speechHelper.currentSpeakingId.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Search Sentence Vault", fontWeight = FontWeight.ExtraBold, fontSize = 17.sp)
                        Text(
                            text = "Searching in ${currentLanguage.flag} ${currentLanguage.nameNative} (${currentLanguage.nameUrdu})",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("search_back_button")) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search English, Urdu, Roman or ${currentLanguage.nameNative}...") },
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = DuolingoGreen) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("global_search_input"),
                shape = RoundedCornerShape(16.dp)
            )

            if (searchQuery.isBlank()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "🔍", fontSize = 52.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Search in ${currentLanguage.nameNative}",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 17.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Type any word like 'shift', 'break', 'Urlaub', 'مدد', 'کام' to immediately find its pronunciation and meaning.",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            } else if (results.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No sentences found for '$searchQuery' in ${currentLanguage.nameNative}.",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                Text(
                    text = "${results.size} sentences found in ${currentLanguage.nameNative}:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 13.sp,
                    color = DuolingoGreen
                )

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(results) { (_, lesson, sentence) ->
                        val isLearned = userProfile.isSentenceLearned(sentence.id)
                        val isThisSpeaking = isSpeaking && currentSpeakingId == sentence.id

                        ChunkyCard(
                            modifier = Modifier.fillMaxWidth(),
                            cornerRadius = 18.dp,
                            borderColor = if (isThisSpeaking) DuolingoGreen else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    color = DuolingoBlueLight,
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = "${lesson.level.code} • ${lesson.title}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = DuolingoBlueShadow,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                IconButton(
                                    onClick = {
                                        speechHelper.speakText(
                                            id = sentence.id,
                                            text = sentence.targetText,
                                            languageTag = currentLanguage.ttsLanguageTag,
                                            isSlow = userProfile.isSpeechSlow
                                        )
                                    },
                                    modifier = Modifier
                                        .size(38.dp)
                                        .clip(CircleShape)
                                        .background(if (isThisSpeaking) DuolingoGreen else DuolingoBlue)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VolumeUp,
                                        contentDescription = "Listen",
                                        tint = Color.White,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "${sentence.emoji} ${sentence.targetText}",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = sentence.englishText,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = sentence.urduText,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = DuolingoGreen
                            )
                            Text(
                                text = "Roman: ${sentence.romanUrduText}",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isLearned) "Learned ✅" else "Mark learned",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isLearned) DuolingoGreenShadow else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Checkbox(
                                    checked = isLearned,
                                    onCheckedChange = { onToggleLearned(sentence.id) },
                                    colors = CheckboxDefaults.colors(checkedColor = DuolingoGreen)
                                )
                            }
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}
