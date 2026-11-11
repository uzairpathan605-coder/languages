package com.example.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CefrLevel
import com.example.model.DayActivity
import com.example.model.UserProfile
import com.example.ui.theme.*

enum class ChunkyButtonColor {
    GREEN, BLUE, ORANGE, RED, SURFACE
}

@Composable
fun ChunkyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colorStyle: ChunkyButtonColor = ChunkyButtonColor.GREEN,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    testTag: String = "chunky_button",
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val faceColor = when (colorStyle) {
        ChunkyButtonColor.GREEN -> DuolingoGreen
        ChunkyButtonColor.BLUE -> DuolingoBlue
        ChunkyButtonColor.ORANGE -> DuolingoOrange
        ChunkyButtonColor.RED -> DuolingoRed
        ChunkyButtonColor.SURFACE -> MaterialTheme.colorScheme.surface
    }

    val shadowColor = when (colorStyle) {
        ChunkyButtonColor.GREEN -> DuolingoGreenShadow
        ChunkyButtonColor.BLUE -> DuolingoBlueShadow
        ChunkyButtonColor.ORANGE -> DuolingoOrangeShadow
        ChunkyButtonColor.RED -> DuolingoRedShadow
        ChunkyButtonColor.SURFACE -> MaterialTheme.colorScheme.outline
    }

    val textColor = when (colorStyle) {
        ChunkyButtonColor.SURFACE -> MaterialTheme.colorScheme.onSurface
        else -> Color.White
    }

    val topOffset by animateDpAsState(
        targetValue = if (isPressed && enabled) 4.dp else 0.dp,
        animationSpec = tween(durationMillis = 60),
        label = "press_offset"
    )

    val shadowHeight = 4.dp
    val cornerRadius = 18.dp

    Box(
        modifier = modifier
            .testTag(testTag)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
    ) {
        // Bottom Shadow Layer
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(top = shadowHeight)
                .background(
                    color = if (enabled) shadowColor else Color.Gray.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(cornerRadius)
                )
        )

        // Top Face Layer
        Surface(
            modifier = Modifier
                .offset(y = topOffset)
                .fillMaxWidth(),
            shape = RoundedCornerShape(cornerRadius),
            color = if (enabled) faceColor else Color.LightGray.copy(alpha = 0.5f),
            shadowElevation = 0.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CompositionLocalProvider(LocalContentColor provides textColor) {
                    content()
                }
            }
        }
    }
}

@Composable
fun ChunkyCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 22.dp,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    borderColor: Color = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, borderColor, RoundedCornerShape(cornerRadius)),
        shape = RoundedCornerShape(cornerRadius),
        color = containerColor,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}

@Composable
fun Streak7DayRow(
    userProfile: UserProfile,
    onStreakClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val activities = remember(userProfile.studiedDates) {
        userProfile.getLast7DaysActivity()
    }

    ChunkyCard(
        modifier = modifier.then(
            if (onStreakClick != null) Modifier.clickable { onStreakClick() } else Modifier
        ),
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "🔥", fontSize = 26.sp)
                Column {
                    Text(
                        text = "${userProfile.streakDays} Day Streak!",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp,
                        color = DuolingoOrange
                    )
                    Text(
                        text = if (userProfile.hasStudiedToday()) "You studied today! Great job!"
                        else "Study today to keep your streak alive!",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Surface(
                color = if (userProfile.hasStudiedToday()) DuolingoGreenLight else DuolingoOrangeLight,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = if (userProfile.hasStudiedToday()) "ACTIVE ✅" else "AT RISK ⚠️",
                    color = if (userProfile.hasStudiedToday()) DuolingoGreenShadow else DuolingoOrangeShadow,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // 7-Day row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            activities.forEach { act ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = act.dayName,
                        fontSize = 12.sp,
                        fontWeight = if (act.isToday) FontWeight.Bold else FontWeight.Medium,
                        color = if (act.isToday) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Surface(
                        shape = CircleShape,
                        color = when {
                            act.isStudied -> DuolingoOrange
                            act.isToday -> DuolingoOrangeLight
                            else -> MaterialTheme.colorScheme.surfaceVariant
                        },
                        border = if (act.isToday) androidx.compose.foundation.BorderStroke(2.dp, DuolingoOrange) else null,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            if (act.isStudied) {
                                Text(text = "🔥", fontSize = 16.sp)
                            } else if (act.isToday) {
                                Text(text = "•", fontSize = 20.sp, color = DuolingoOrange, fontWeight = FontWeight.Bold)
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LevelWindingPath(
    selectedLevel: CefrLevel,
    isGerman: Boolean,
    onSelectLevel: (CefrLevel) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val levels = CefrLevel.entries

        levels.forEachIndexed { index, level ->
            val isSelected = level == selectedLevel
            // Winding horizontal offsets: Center, Right (50dp), Center, Left (-50dp), Center, Right (50dp)
            val horizontalOffset = when (index % 4) {
                1 -> 50.dp
                3 -> (-50).dp
                else -> 0.dp
            }

            // Node Component
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.offset(x = horizontalOffset)
                ) {
                    // Chunky Round 3D Node
                    val nodeColor = if (isSelected) DuolingoGreen else DuolingoBlue
                    val nodeShadow = if (isSelected) DuolingoGreenShadow else DuolingoBlueShadow

                    Box(
                        modifier = Modifier
                            .size(76.dp)
                            .testTag("node_${level.code.lowercase()}")
                            .clickable { onSelectLevel(level) }
                    ) {
                        // Bottom shadow layer
                        Box(
                            modifier = Modifier
                                .size(76.dp)
                                .offset(y = 5.dp)
                                .background(nodeShadow, CircleShape)
                        )
                        // Top face
                        Surface(
                            modifier = Modifier.size(76.dp),
                            shape = CircleShape,
                            color = nodeColor,
                            shadowElevation = 0.dp
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = if (index < 2) "⭐" else if (index == 2) "👷" else if (index == 3) "💼" else "🏆",
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = level.code,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 17.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = level.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )

                    if (isGerman && level.germanTag != null) {
                        Surface(
                            color = DuolingoYellowLight,
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.padding(top = 2.dp)
                        ) {
                            Text(
                                text = "🇩🇪 ${level.germanTag}",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = DuolingoYellowShadow,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            // Connecting line to next node
            if (index < levels.size - 1) {
                Box(
                    modifier = Modifier
                        .height(34.dp)
                        .width(6.dp)
                        .background(DuolingoGreen.copy(alpha = 0.35f), RoundedCornerShape(3.dp))
                )
            }
        }
    }
}

@Composable
fun NotificationsModal(
    userProfile: UserProfile,
    onDismiss: () -> Unit
) {
    // Determine real-state notifications
    val notifications = remember(userProfile) {
        val list = mutableListOf<Triple<String, String, String>>() // Icon, Title, Body

        val totalSentences = 240
        val percent = ((userProfile.learnedSentenceIds.size.toFloat() / totalSentences.toFloat()) * 100).toInt()

        if (userProfile.hasStudiedToday()) {
            list.add(
                Triple("🌟", "You studied today — great job!", "You checked in and earned XP. Come back tomorrow to grow your streak!")
            )
        } else {
            list.add(
                Triple("📚", "Your lesson for today is waiting", "Take 5 minutes to learn today's lesson and keep making progress toward your goal.")
            )
        }

        if (userProfile.streakDays > 0 && !userProfile.hasStudiedToday()) {
            list.add(
                Triple("🔥", "Your streak is at risk!", "You have a ${userProfile.streakDays}-day streak. Tick at least one sentence today to protect it!")
            )
        }

        if (percent >= 25) {
            list.add(
                Triple("🏅", "Milestone reached: $percent% — well done!", "You have completed $percent% of your course vocabulary. Excellent consistency!")
            )
        }

        if (userProfile.remindersEnabled) {
            list.add(
                Triple("⏰", "Daily Reminder Active (${userProfile.reminderTime})", "In-app reminder set for ${userProfile.reminderTime}. Regular short sessions beat cramming.")
            )
        }

        list
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "🔔", fontSize = 20.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Your Notifications", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 380.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                notifications.forEach { (icon, title, body) ->
                    ChunkyCard(
                        modifier = Modifier.fillMaxWidth(),
                        cornerRadius = 14.dp,
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(text = icon, fontSize = 22.sp)
                            Column {
                                Text(
                                    text = title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = body,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = DuolingoGreen),
                modifier = Modifier.testTag("dismiss_notifications_button")
            ) {
                Text("Got It! (سمجھ گیا)")
            }
        }
    )
}
