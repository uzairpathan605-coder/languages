package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.example.data.BasicsDataRepository
import com.example.model.BasicCategory
import com.example.model.Language
import com.example.model.UserProfile
import com.example.ui.components.ChunkyCard
import com.example.ui.components.TtsNoticeBanner
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicsScreen(
    language: Language,
    userProfile: UserProfile,
    speechHelper: SpeechHelper,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    var selectedCategory by remember { mutableStateOf(BasicCategory.ALPHABET) }
    val basicsMap = remember(language.id) { BasicsDataRepository.getBasicsForLanguage(language.id) }
    val items = basicsMap[selectedCategory] ?: emptyList()

    val isSpeaking by speechHelper.isSpeaking.collectAsState()
    val currentSpeakingId by speechHelper.currentSpeakingId.collectAsState()
    val ttsNotice by speechHelper.ttsNotice.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Zero to Hero — Basics",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 17.sp
                        )
                        Text(
                            text = "${language.nameNative} (${language.nameUrdu}) • تلفظ اور بنیادی باتیں",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("basics_back_button")) {
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
        ) {
            ttsNotice?.let { notice ->
                TtsNoticeBanner(
                    noticeMessage = notice,
                    onOpenSettings = { speechHelper.openTtsSettings() },
                    onDismiss = { speechHelper.dismissNotice() }
                )
            }

            // Categories Tab Row
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(BasicCategory.entries) { category ->
                    val isSelected = category == selectedCategory
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedCategory = category },
                        label = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = category.emoji)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = category.title,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium
                                )
                            }
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = DuolingoGreenLight,
                            selectedLabelColor = DuolingoGreenShadow
                        ),
                        modifier = Modifier.testTag("basic_cat_${category.name.lowercase()}")
                    )
                }
            }

            // List of Basics
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items) { item ->
                    val isThisSpeaking = isSpeaking && currentSpeakingId == item.id

                    ChunkyCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("basic_item_${item.id}"),
                        cornerRadius = 20.dp,
                        containerColor = if (isThisSpeaking) DuolingoGreenLight.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface,
                        borderColor = if (isThisSpeaking) DuolingoGreen else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.targetText,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))

                                Surface(
                                    color = DuolingoBlueLight,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        text = "🗣️ How to say: ${item.pronunciationGuide}",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = DuolingoBlueShadow,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "English: ${item.englishText}",
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = item.urduText,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = DuolingoGreen
                                )
                                Text(
                                    text = "Roman: ${item.romanUrduText}",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
                                )
                            }

                            // Audio listen button
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        speechHelper.speakText(
                                            id = item.id,
                                            text = item.targetText,
                                            languageTag = language.ttsLanguageTag,
                                            isSlow = userProfile.isSpeechSlow
                                        )
                                    }
                                    .background(if (isThisSpeaking) DuolingoGreen else DuolingoBlue)
                                    .testTag("basic_listen_${item.id}"),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = "Listen pronunciation",
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
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
}
