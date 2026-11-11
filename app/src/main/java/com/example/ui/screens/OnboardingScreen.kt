package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.School
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.SupportedLanguages
import com.example.ui.components.ChunkyButton
import com.example.ui.components.ChunkyButtonColor
import com.example.ui.components.ChunkyCard
import com.example.ui.theme.*

@Composable
fun OnboardingScreen(
    onComplete: (name: String, targetLanguageId: String, learningReason: String, startLevel: String, dailyGoalMinutes: Int) -> Unit
) {
    var step by remember { mutableIntStateOf(1) } // 1: Lang, 2: Why learning, 3: Start Level & Details
    var selectedLanguageId by remember { mutableStateOf("de") } // default German
    var learningReason by remember { mutableStateOf("work_germany") }
    var startLevel by remember { mutableStateOf("a1") } // "a1", "a2", "b1"
    var userName by remember { mutableStateOf("") }
    var dailyGoalMinutes by remember { mutableIntStateOf(10) }

    val whyOptions = listOf(
        Triple("work_germany", "Work in Germany 🇩🇪", "جرمنی میں ملازمت اور Ausbildung"),
        Triple("career", "Jobs & career 💼", "ملازمت، پروموشن اور کیریئر"),
        Triple("travel", "Travel & Tourism ✈️", "سیاحت اور نئے ممالک کا سفر"),
        Triple("study", "Study Abroad 🎓", "تعلیم اور یونیورسٹی داخلہ"),
        Triple("fun", "Just for fun 🎉", "شوقیہ اور دماغی ورزش")
    )

    val startLevelOptions = listOf(
        Triple("a1", "From the very basics 🌱", "Start from A1 (حروف، بنیادی الفاظ اور گنتی سے)"),
        Triple("a2", "I know a little 🌿", "Start from A2 (کچھ جملے آتے ہیں، روزمرہ گفتگو سے)"),
        Triple("b1", "Advanced start 🌳", "Start from B1 (ملازمت، دفتر اور ورک پلیس سے)")
    )

    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = 6.dp,
                shadowElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (step > 1) {
                        OutlinedButton(
                            onClick = { step-- },
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier.testTag("onboarding_back_button")
                        ) {
                            Text("Back (پیچھے)", fontWeight = FontWeight.Bold)
                        }
                    } else {
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                    Box(modifier = Modifier.width(180.dp)) {
                        ChunkyButton(
                            onClick = {
                                if (step == 1) {
                                    step = 2
                                } else if (step == 2) {
                                    step = 3
                                } else {
                                    val finalName = userName.trim().ifEmpty { "Student" }
                                    onComplete(finalName, selectedLanguageId, learningReason, startLevel, dailyGoalMinutes)
                                }
                            },
                            colorStyle = ChunkyButtonColor.GREEN,
                            testTag = "onboarding_next_button"
                        ) {
                            Text(
                                text = if (step < 3) "CONTINUE ➔" else "LET'S GO! 🚀",
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
        ) {
            // Hero Illustration Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_workers_hero_1794289077238),
                    contentDescription = "BIZOlingo Academy for all workers",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Surface(
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 14.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            tint = DuolingoGreen
                        )
                        Text(
                            text = "BIZOlingo • German B2 for All Workers & World Languages",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Step 1: Language selection
            if (step == 1) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "1. Which language do you want to learn?",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp
                    )
                    Text(
                        text = "آپ کون سی زبان سیکھنا چاہتے ہیں؟ (15 زبانیں)",
                        fontSize = 13.sp,
                        color = DuolingoGreen,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        items(SupportedLanguages.ALL) { lang ->
                            val isSelected = lang.id == selectedLanguageId
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(18.dp))
                                    .clickable { selectedLanguageId = lang.id }
                                    .testTag("onboarding_lang_${lang.id}"),
                                color = if (isSelected) DuolingoGreenLight.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface,
                                border = androidx.compose.foundation.BorderStroke(
                                    2.dp,
                                    if (isSelected) DuolingoGreen else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                                ),
                                shape = RoundedCornerShape(18.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        Text(text = lang.flag, fontSize = 28.sp)
                                        Column {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text(
                                                    text = "${lang.nameNative} (${lang.nameEn})",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 15.sp
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
                                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                                        )
                                                    }
                                                }
                                            }
                                            Text(
                                                text = "${lang.nameUrdu} — ${lang.descriptionUrdu}",
                                                fontSize = 12.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                    if (isSelected) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Selected",
                                            tint = DuolingoGreen
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (step == 2) {
                // Step 2: "Why are you learning?"
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "2. Why are you learning?",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "آپ یہ زبان کیوں سیکھنا چاہتے ہیں؟",
                        fontSize = 13.sp,
                        color = DuolingoGreen
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        items(whyOptions) { (key, title, subtitle) ->
                            val isSelected = learningReason == key
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(20.dp))
                                    .clickable { learningReason = key }
                                    .testTag("why_option_$key"),
                                color = if (isSelected) DuolingoBlueLight.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface,
                                border = androidx.compose.foundation.BorderStroke(
                                    2.dp,
                                    if (isSelected) DuolingoBlue else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                                ),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = title,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 15.sp,
                                            color = if (isSelected) DuolingoBlueShadow else MaterialTheme.colorScheme.onSurface
                                        )
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = subtitle,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                    if (isSelected) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Selected",
                                            tint = DuolingoBlue
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                // Step 3: Start Level & Details
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "3. Choose your starting level:",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp
                    )
                    Text(
                        text = "آپ کہاں سے شروع کرنا چاہتے ہیں؟",
                        fontSize = 13.sp,
                        color = DuolingoGreen
                    )

                    startLevelOptions.forEach { (code, title, desc) ->
                        val isSelected = startLevel == code
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .clickable { startLevel = code }
                                .testTag("start_level_$code"),
                            color = if (isSelected) DuolingoGreenLight.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface,
                            border = androidx.compose.foundation.BorderStroke(
                                2.dp,
                                if (isSelected) DuolingoGreen else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                            ),
                            shape = RoundedCornerShape(18.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = title,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = desc,
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                if (isSelected) {
                                    Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = DuolingoGreen)
                                }
                            }
                        }
                    }

                    ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "What is your name? (آپ کا نام)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        OutlinedTextField(
                            value = userName,
                            onValueChange = { userName = it },
                            placeholder = { Text("Enter your name e.g. Ali, Bilal") },
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("user_name_input")
                        )
                    }

                    ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Daily Goal (روزانہ کا وقت):",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            listOf(5 to "5 min ⚡", 10 to "10 min 🎯", 15 to "15 min 🔥").forEach { (mins, label) ->
                                FilterChip(
                                    selected = dailyGoalMinutes == mins,
                                    onClick = { dailyGoalMinutes = mins },
                                    label = { Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                                    modifier = Modifier.weight(1f).testTag("goal_${mins}_chip")
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
