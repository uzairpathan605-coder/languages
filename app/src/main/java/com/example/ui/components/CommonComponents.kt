package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Language
import com.example.model.SupportedLanguages
import com.example.model.UserProfile
import com.example.ui.theme.*

@Composable
fun TopStatsBar(
    userProfile: UserProfile,
    currentLanguage: Language,
    onLanguageClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onStreakClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val hasUnreadNotification = !userProfile.hasStudiedToday()

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 3.dp,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Selected Language Switcher Pill
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onLanguageClick() }
                    .testTag("language_switcher_button"),
                color = DuolingoGreenLight.copy(alpha = 0.5f),
                shape = RoundedCornerShape(16.dp),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, DuolingoGreen.copy(alpha = 0.4f))
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(text = currentLanguage.flag, fontSize = 20.sp)
                    Column {
                        Text(
                            text = currentLanguage.nameNative,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Switch language",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Stats row (Streak 🔥, XP ⚡, Hearts ❤️, Bell 🔔)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Streak
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier
                        .then(
                            if (onStreakClick != null) {
                                Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { onStreakClick() }
                                    .padding(horizontal = 4.dp, vertical = 2.dp)
                            } else Modifier
                        )
                        .testTag("streak_counter")
                ) {
                    Text(text = "🔥", fontSize = 16.sp)
                    Text(
                        text = "${userProfile.streakDays}",
                        fontWeight = FontWeight.ExtraBold,
                        color = DuolingoOrange,
                        fontSize = 14.sp
                    )
                }

                // XP Points
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.testTag("xp_counter")
                ) {
                    Text(text = "⚡", fontSize = 16.sp)
                    Text(
                        text = "${userProfile.xp}",
                        fontWeight = FontWeight.ExtraBold,
                        color = DuolingoYellowShadow,
                        fontSize = 14.sp
                    )
                }

                // Hearts
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.testTag("hearts_counter")
                ) {
                    Text(text = "❤️", fontSize = 16.sp)
                    Text(
                        text = "${userProfile.hearts}",
                        fontWeight = FontWeight.ExtraBold,
                        color = DuolingoRed,
                        fontSize = 14.sp
                    )
                }

                // Notifications Bell with Red Badge
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .clickable { onNotificationClick() }
                        .testTag("notifications_bell_button"),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(22.dp)
                    )
                    if (hasUnreadNotification) {
                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .align(Alignment.TopEnd)
                                .background(DuolingoRed, CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LanguageSelectionDialog(
    selectedLanguageId: String,
    onSelectLanguage: (String) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column {
                Text(
                    text = "Select Language",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
                Text(
                    text = "زبان منتخب کریں (15 زبانیں)",
                    fontSize = 13.sp,
                    color = DuolingoGreen
                )
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 420.dp)
            ) {
                androidx.compose.foundation.lazy.LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(SupportedLanguages.ALL.size) { index ->
                        val lang = SupportedLanguages.ALL[index]
                        val isSelected = lang.id == selectedLanguageId
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .clickable {
                                    onSelectLanguage(lang.id)
                                    onDismiss()
                                }
                                .testTag("select_lang_${lang.id}"),
                            color = if (isSelected) DuolingoGreenLight.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(16.dp),
                            border = if (isSelected) androidx.compose.foundation.BorderStroke(2.dp, DuolingoGreen) else null
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Text(text = lang.flag, fontSize = 26.sp)
                                    Column {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = "${lang.nameNative} (${lang.nameEn})",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 14.sp
                                            )
                                            if (lang.isPrimaryJobFocus) {
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Surface(
                                                    color = DuolingoYellowLight,
                                                    shape = RoundedCornerShape(4.dp)
                                                ) {
                                                    Text(
                                                        text = "Jobs & Ausbildung",
                                                        fontSize = 10.sp,
                                                        color = DuolingoYellowShadow,
                                                        fontWeight = FontWeight.ExtraBold,
                                                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                                    )
                                                }
                                            }
                                        }
                                        Text(
                                            text = lang.nameUrdu + " — " + lang.descriptionUrdu,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Selected",
                                        tint = DuolingoGreen,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss,
                modifier = Modifier.testTag("dialog_close_button")
            ) {
                Text("Close", fontWeight = FontWeight.Bold)
            }
        }
    )
}

@Composable
fun TtsNoticeBanner(
    noticeMessage: String,
    onOpenSettings: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        color = DuolingoOrangeLight,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, DuolingoOrangeShadow)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.VolumeUp,
                contentDescription = "Audio notice",
                tint = DuolingoOrangeShadow,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Speech Voice Notice",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = DuolingoOrangeShadow
                )
                Text(
                    text = noticeMessage,
                    fontSize = 11.sp,
                    color = Color(0xFF78350F)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextButton(
                        onClick = onOpenSettings,
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                        modifier = Modifier.testTag("open_tts_settings_button")
                    ) {
                        Text("TTS Settings", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = DuolingoOrangeShadow)
                    }
                    TextButton(
                        onClick = onDismiss,
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                    ) {
                        Text("Dismiss", fontSize = 11.sp, color = Color(0xFF78350F))
                    }
                }
            }
        }
    }
}
