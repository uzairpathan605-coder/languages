package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Calendar

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("bizolingo_academy_prefs", Context.MODE_PRIVATE)

    private val _userProfile = MutableStateFlow(loadProfile())
    val userProfile: StateFlow<UserProfile> = _userProfile.asStateFlow()

    private fun loadProfile(): UserProfile {
        val learnedSet = prefs.getStringSet("learned_sentences", emptySet()) ?: emptySet()
        val completedLessons = prefs.getStringSet("completed_lessons", emptySet()) ?: emptySet()
        val studiedDates = prefs.getStringSet("studied_dates", emptySet()) ?: emptySet()

        return UserProfile(
            name = prefs.getString("user_name", "Student") ?: "Student",
            targetLanguageId = prefs.getString("target_lang", "de") ?: "de",
            uiLanguage = prefs.getString("ui_lang", "en") ?: "en",
            experienceLevel = prefs.getString("exp_level", "basic") ?: "basic",
            learningReason = prefs.getString("learning_reason", "work_germany") ?: "work_germany",
            startLevel = prefs.getString("start_level", "a1") ?: "a1",
            dailyGoalMinutes = prefs.getInt("daily_goal", 10),
            xp = prefs.getInt("xp_points", 120),
            streakDays = prefs.getInt("streak_days", 3),
            hearts = prefs.getInt("hearts", 5),
            learnedSentenceIds = learnedSet,
            completedLessonIds = completedLessons,
            studiedDates = studiedDates,
            isSpeechSlow = prefs.getBoolean("speech_slow", false),
            geminiApiKey = prefs.getString("gemini_api_key", "") ?: "",
            isOnboardingCompleted = prefs.getBoolean("onboarding_done", false),
            remindersEnabled = prefs.getBoolean("reminders_enabled", true),
            reminderTime = prefs.getString("reminder_time", "20:00") ?: "20:00"
        )
    }

    fun completeOnboarding(
        name: String,
        targetLanguageId: String,
        learningReason: String,
        startLevel: String,
        dailyGoalMinutes: Int
    ) {
        val expLevel = if (startLevel == "b1") "advanced" else "basic"
        prefs.edit()
            .putString("user_name", name)
            .putString("target_lang", targetLanguageId)
            .putString("learning_reason", learningReason)
            .putString("start_level", startLevel)
            .putString("exp_level", expLevel)
            .putInt("daily_goal", dailyGoalMinutes)
            .putBoolean("onboarding_done", true)
            .apply()

        _userProfile.value = _userProfile.value.copy(
            name = name,
            targetLanguageId = targetLanguageId,
            learningReason = learningReason,
            startLevel = startLevel,
            experienceLevel = expLevel,
            dailyGoalMinutes = dailyGoalMinutes,
            isOnboardingCompleted = true
        )
    }

    fun recordStudyActivityToday() {
        val todayStr = UserProfile.getTodayDateString()
        val currentDates = _userProfile.value.studiedDates.toMutableSet()
        if (!currentDates.contains(todayStr)) {
            currentDates.add(todayStr)
            val newStreak = _userProfile.value.streakDays + 1
            prefs.edit()
                .putStringSet("studied_dates", currentDates)
                .putInt("streak_days", newStreak)
                .apply()

            _userProfile.value = _userProfile.value.copy(
                studiedDates = currentDates,
                streakDays = newStreak
            )
        }
    }

    fun setTargetLanguage(languageId: String) {
        prefs.edit().putString("target_lang", languageId).apply()
        _userProfile.value = _userProfile.value.copy(targetLanguageId = languageId)
    }

    fun setUiLanguage(uiLang: String) {
        prefs.edit().putString("ui_lang", uiLang).apply()
        _userProfile.value = _userProfile.value.copy(uiLanguage = uiLang)
    }

    fun setSpeechSlow(isSlow: Boolean) {
        prefs.edit().putBoolean("speech_slow", isSlow).apply()
        _userProfile.value = _userProfile.value.copy(isSpeechSlow = isSlow)
    }

    fun setGeminiApiKey(apiKey: String) {
        prefs.edit().putString("gemini_api_key", apiKey.trim()).apply()
        _userProfile.value = _userProfile.value.copy(geminiApiKey = apiKey.trim())
    }

    fun toggleSentenceLearned(sentenceId: String): Boolean {
        val currentSet = _userProfile.value.learnedSentenceIds.toMutableSet()
        val isNowLearned: Boolean
        val newXp: Int

        if (currentSet.contains(sentenceId)) {
            currentSet.remove(sentenceId)
            isNowLearned = false
            newXp = (_userProfile.value.xp - 10).coerceAtLeast(0)
        } else {
            currentSet.add(sentenceId)
            isNowLearned = true
            newXp = _userProfile.value.xp + 10
            // Record activity for today on tick
            recordStudyActivityToday()
        }

        prefs.edit()
            .putStringSet("learned_sentences", currentSet)
            .putInt("xp_points", newXp)
            .apply()

        _userProfile.value = _userProfile.value.copy(
            learnedSentenceIds = currentSet,
            xp = newXp
        )
        return isNowLearned
    }

    fun markLessonCompleted(lessonId: String) {
        val completed = _userProfile.value.completedLessonIds.toMutableSet()
        if (!completed.contains(lessonId)) {
            completed.add(lessonId)
            val newXp = _userProfile.value.xp + 50
            recordStudyActivityToday()
            prefs.edit()
                .putStringSet("completed_lessons", completed)
                .putInt("xp_points", newXp)
                .apply()
            _userProfile.value = _userProfile.value.copy(
                completedLessonIds = completed,
                xp = newXp
            )
        }
    }

    fun addXp(amount: Int) {
        val newXp = _userProfile.value.xp + amount
        recordStudyActivityToday()
        prefs.edit().putInt("xp_points", newXp).apply()
        _userProfile.value = _userProfile.value.copy(xp = newXp)
    }

    fun decrementHeart(): Int {
        val current = _userProfile.value.hearts
        val newHearts = (current - 1).coerceAtLeast(0)
        prefs.edit().putInt("hearts", newHearts).apply()
        _userProfile.value = _userProfile.value.copy(hearts = newHearts)
        return newHearts
    }

    fun refillHearts() {
        val max = _userProfile.value.maxHearts
        prefs.edit().putInt("hearts", max).apply()
        _userProfile.value = _userProfile.value.copy(hearts = max)
    }

    fun toggleReminders(enabled: Boolean) {
        prefs.edit().putBoolean("reminders_enabled", enabled).apply()
        _userProfile.value = _userProfile.value.copy(remindersEnabled = enabled)
    }

    fun setReminderTime(time: String) {
        prefs.edit().putString("reminder_time", time).apply()
        _userProfile.value = _userProfile.value.copy(reminderTime = time)
    }

    fun updateProfile(
        name: String,
        dailyGoalMinutes: Int,
        startLevel: String,
        learningReason: String
    ) {
        val expLevel = if (startLevel == "b1") "advanced" else "basic"
        prefs.edit()
            .putString("user_name", name)
            .putInt("daily_goal", dailyGoalMinutes)
            .putString("start_level", startLevel)
            .putString("exp_level", expLevel)
            .putString("learning_reason", learningReason)
            .apply()

        _userProfile.value = _userProfile.value.copy(
            name = name,
            dailyGoalMinutes = dailyGoalMinutes,
            startLevel = startLevel,
            experienceLevel = expLevel,
            learningReason = learningReason
        )
    }

    fun redoSetup() {
        prefs.edit().putBoolean("onboarding_done", false).apply()
        _userProfile.value = _userProfile.value.copy(isOnboardingCompleted = false)
    }

    fun resetProgress() {
        prefs.edit()
            .remove("learned_sentences")
            .remove("completed_lessons")
            .remove("studied_dates")
            .putInt("xp_points", 0)
            .putInt("streak_days", 1)
            .putInt("hearts", 5)
            .apply()

        _userProfile.value = _userProfile.value.copy(
            learnedSentenceIds = emptySet(),
            completedLessonIds = emptySet(),
            studiedDates = emptySet(),
            xp = 0,
            streakDays = 1,
            hearts = 5
        )
    }
}
