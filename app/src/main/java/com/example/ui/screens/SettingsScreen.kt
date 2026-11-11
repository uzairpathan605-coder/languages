package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.model.AppStrings
import com.example.model.SupportedLanguages
import com.example.model.UserProfile
import com.example.ui.components.ChunkyButton
import com.example.ui.components.ChunkyButtonColor
import com.example.ui.components.ChunkyCard
import com.example.ui.components.LanguageSelectionDialog
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    userProfile: UserProfile,
    onSelectTargetLanguage: (String) -> Unit,
    onSelectUiLanguage: (String) -> Unit,
    onUpdateProfile: (name: String, goal: Int, startLevel: String, reason: String) -> Unit,
    onSetSpeechSlow: (Boolean) -> Unit,
    onSaveGeminiApiKey: (String) -> Unit,
    onToggleReminder: (Boolean) -> Unit,
    onSetReminderTime: (String) -> Unit,
    onRedoSetup: () -> Unit,
    onResetProgress: () -> Unit,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    var showLanguagePicker by remember { mutableStateOf(false) }
    var showGermanyGuideDialog by remember { mutableStateOf(false) }
    var showResetConfirmDialog by remember { mutableStateOf(false) }
    var showRedoSetupConfirmDialog by remember { mutableStateOf(false) }

    // Editable Profile fields
    var editName by remember(userProfile.name) { mutableStateOf(userProfile.name) }
    var editGoal by remember(userProfile.dailyGoalMinutes) { mutableIntStateOf(userProfile.dailyGoalMinutes) }
    var editStartLevel by remember(userProfile.startLevel) { mutableStateOf(userProfile.startLevel) }
    var editReason by remember(userProfile.learningReason) { mutableStateOf(userProfile.learningReason) }
    var isProfileSavedNotice by remember { mutableStateOf(false) }

    // Reminder Time Picker
    var reminderTime by remember(userProfile.reminderTime) { mutableStateOf(userProfile.reminderTime) }

    // API Key
    var apiKeyInput by remember(userProfile.geminiApiKey) { mutableStateOf(userProfile.geminiApiKey) }
    var keySavedNotice by remember { mutableStateOf(false) }

    val currentLang = SupportedLanguages.getById(userProfile.targetLanguageId)
    val uiLang = userProfile.uiLanguage

    if (showLanguagePicker) {
        LanguageSelectionDialog(
            selectedLanguageId = userProfile.targetLanguageId,
            onSelectLanguage = onSelectTargetLanguage,
            onDismiss = { showLanguagePicker = false }
        )
    }

    if (showGermanyGuideDialog) {
        AlertDialog(
            onDismissRequest = { showGermanyGuideDialog = false },
            title = {
                Text(
                    text = "Germany Ausbildung & Jobs Guide 🇩🇪",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "For ALL professions — logistics, warehouse, hotels, drivers, IT, technicians, and healthcare:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                    Text(text = "• A1 & A2: Basic visa & daily conversation requirement.", fontSize = 12.sp)
                    Text(
                        text = "• B1 (Ausbildung Minimum): Legally required minimum level to start vocational Ausbildung or work permit in Germany.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = DuolingoGreen
                    )
                    Text(
                        text = "• B2 (Best for All Jobs): Guarantees smooth workplace communication, passing exams, and job promotions across Germany.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = DuolingoOrange
                    )
                    Text(text = "• C1 & C2: For university studies, management, and permanent citizenship fluency.", fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "یہ ایپ تمام ہنر مند افراد اور ورکرز کے لیے بنائی گئی ہے تاکہ وہ جرمنی میں بغیر کسی رکاوٹ کے کامیاب کیریئر بنا سکیں۔",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = { showGermanyGuideDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = DuolingoGreen)
                ) {
                    Text("Understood (سمجھ گیا)")
                }
            }
        )
    }

    if (showRedoSetupConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showRedoSetupConfirmDialog = false },
            title = { Text("Start Again (Redo Setup)?", fontWeight = FontWeight.Bold) },
            text = { Text("This will take you back to the first-launch setup flow where you can re-pick your language, goals, and reasons. Your earned XP and learned sentences are kept safe.") },
            confirmButton = {
                Button(
                    onClick = {
                        onRedoSetup()
                        showRedoSetupConfirmDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DuolingoBlue)
                ) {
                    Text("Redo Setup")
                }
            },
            dismissButton = {
                TextButton(onClick = { showRedoSetupConfirmDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showResetConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showResetConfirmDialog = false },
            title = { Text("Reset All Progress?", fontWeight = FontWeight.Bold) },
            text = { Text("This will clear all learned sentences, reset streak to 1, and reset XP back to 0. Are you sure?") },
            confirmButton = {
                Button(
                    onClick = {
                        onResetProgress()
                        showResetConfirmDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DuolingoRed)
                ) {
                    Text("Reset")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetConfirmDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(AppStrings.get("settings_title", uiLang), fontWeight = FontWeight.ExtraBold, fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("settings_back_button")) {
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // EDITABLE PROFILE SECTION
            ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = AppStrings.get("profile_section", uiLang),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = DuolingoGreen
                )
                Spacer(modifier = Modifier.height(10.dp))

                // Name
                Text(text = "${AppStrings.get("name", uiLang)}:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = editName,
                    onValueChange = { editName = it; isProfileSavedNotice = false },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().testTag("profile_name_input")
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Daily Goal
                Text(text = "${AppStrings.get("daily_goal", uiLang)}:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf(5 to "5 min", 10 to "10 min", 15 to "15 min").forEach { (mins, label) ->
                        FilterChip(
                            selected = editGoal == mins,
                            onClick = { editGoal = mins; isProfileSavedNotice = false },
                            label = { Text(label, fontWeight = FontWeight.Bold) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Start Level
                Text(text = "${AppStrings.get("start_level", uiLang)}:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("a1" to "A1 (Basics)", "a2" to "A2 (Know some)", "b1" to "B1 (Advanced)").forEach { (lvl, label) ->
                        FilterChip(
                            selected = editStartLevel == lvl,
                            onClick = { editStartLevel = lvl; isProfileSavedNotice = false },
                            label = { Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isProfileSavedNotice) {
                        Text(text = "Profile updated! ✅", color = DuolingoGreen, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    } else {
                        Spacer(modifier = Modifier.width(4.dp))
                    }

                    Box(modifier = Modifier.width(140.dp)) {
                        ChunkyButton(
                            onClick = {
                                onUpdateProfile(editName, editGoal, editStartLevel, editReason)
                                isProfileSavedNotice = true
                            },
                            colorStyle = ChunkyButtonColor.GREEN,
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                            testTag = "save_profile_button"
                        ) {
                            Text(AppStrings.get("save_profile", uiLang), fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }

            // Target Learning Language Switcher
            ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Learning Language (سیکھنے کی زبان)",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .clickable { showLanguagePicker = true },
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(text = currentLang.flag, fontSize = 26.sp)
                            Column {
                                Text(
                                    text = "${currentLang.nameNative} (${currentLang.nameEn})",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Text(
                                    text = currentLang.nameUrdu,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Text(
                            text = "Switch ➔",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = DuolingoBlue
                        )
                    }
                }
            }

            // APP LANGUAGE (MENUS & BUTTONS CHROME)
            ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = AppStrings.get("app_language", uiLang),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp
                )
                Text(
                    text = AppStrings.get("app_language_desc", uiLang),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("en" to "English", "ur" to "اردو (Urdu)", "roman" to "Roman Urdu").forEach { (code, label) ->
                        FilterChip(
                            selected = userProfile.uiLanguage == code,
                            onClick = { onSelectUiLanguage(code) },
                            label = { Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                            modifier = Modifier.weight(1f).testTag("ui_lang_$code")
                        )
                    }
                }
            }

            // Germany Ausbildung & Jobs Guide
            ChunkyCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showGermanyGuideDialog = true },
                containerColor = DuolingoYellowLight,
                borderColor = DuolingoYellowShadow
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "🇩🇪", fontSize = 28.sp)
                        Column {
                            Text(
                                text = "Ausbildung & German Jobs Guide",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                color = DuolingoYellowShadow
                            )
                            Text(
                                text = "Why B1 is minimum & B2 is best for all workers in Germany",
                                fontSize = 11.sp,
                                color = Color(0xFF78350F)
                            )
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Read guide",
                        tint = DuolingoYellowShadow
                    )
                }
            }

            // Daily Practice Reminders & Honest Note
            ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = AppStrings.get("daily_reminder", uiLang),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Enable Daily Study Reminder", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Switch(
                        checked = userProfile.remindersEnabled,
                        onCheckedChange = onToggleReminder,
                        modifier = Modifier.testTag("settings_reminders_switch")
                    )
                }

                if (userProfile.remindersEnabled) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "${AppStrings.get("reminder_time", uiLang)}:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf("09:00", "14:00", "20:00", "21:30").forEach { timeSlot ->
                            FilterChip(
                                selected = reminderTime == timeSlot,
                                onClick = {
                                    reminderTime = timeSlot
                                    onSetReminderTime(timeSlot)
                                },
                                label = { Text(timeSlot, fontWeight = FontWeight.Bold) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = AppStrings.get("reminder_note", uiLang),
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            // AI Voice Tutor (Gemini API Key)
            ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "AI Voice Tutor (Gemini API Key)",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp
                )
                Text(
                    text = "Enter free Gemini key from Google AI Studio. Saved on your device.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = apiKeyInput,
                    onValueChange = { apiKeyInput = it; keySavedNotice = false },
                    placeholder = { Text("AIzaSy... (free key)") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().testTag("gemini_api_key_input")
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (keySavedNotice) {
                        Text(text = "Key saved! ✅", color = DuolingoGreen, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    } else {
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                    Box(modifier = Modifier.width(130.dp)) {
                        ChunkyButton(
                            onClick = {
                                onSaveGeminiApiKey(apiKeyInput)
                                keySavedNotice = true
                            },
                            colorStyle = ChunkyButtonColor.BLUE,
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                            testTag = "save_api_key_button"
                        ) {
                            Text("Save Key", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }

            // Audio & Slow Speech
            ChunkyCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Slow Speech by Default (0.65x)", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Plays all sentence audio at beginner speed", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Switch(
                        checked = userProfile.isSpeechSlow,
                        onCheckedChange = onSetSpeechSlow,
                        modifier = Modifier.testTag("settings_slow_switch")
                    )
                }
            }

            // Start Again (Redo Setup) Button
            Box(modifier = Modifier.fillMaxWidth()) {
                ChunkyButton(
                    onClick = { showRedoSetupConfirmDialog = true },
                    colorStyle = ChunkyButtonColor.SURFACE,
                    testTag = "start_again_button"
                ) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = null, tint = DuolingoBlue)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(AppStrings.get("start_again", uiLang), fontWeight = FontWeight.Bold, color = DuolingoBlue)
                }
            }

            // Reset Learning Progress
            OutlinedButton(
                onClick = { showResetConfirmDialog = true },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = DuolingoRed),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().testTag("reset_progress_button")
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = DuolingoRed)
                Spacer(modifier = Modifier.width(6.dp))
                Text(AppStrings.get("reset_progress", uiLang), fontWeight = FontWeight.Bold)
            }

            // Short About Line
            ChunkyCard(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
            ) {
                Text(
                    text = AppStrings.get("about", uiLang),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = AppStrings.get("about_desc", uiLang),
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
