package com.example.model

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

data class UserProfile(
    val name: String = "Student",
    val targetLanguageId: String = "de",
    val uiLanguage: String = "en", // "en", "ur", "roman"
    val experienceLevel: String = "basic", // "basic", "advanced"
    val learningReason: String = "work_germany", // "work_germany", "career", "travel", "study", "fun"
    val startLevel: String = "a1", // "a1", "a2", "b1"
    val dailyGoalMinutes: Int = 10, // 5, 10, 15
    val xp: Int = 120,
    val streakDays: Int = 3,
    val hearts: Int = 5,
    val maxHearts: Int = 5,
    val learnedSentenceIds: Set<String> = emptySet(),
    val completedLessonIds: Set<String> = emptySet(),
    val studiedDates: Set<String> = emptySet(), // Set of "yyyy-MM-dd"
    val isSpeechSlow: Boolean = false,
    val geminiApiKey: String = "",
    val isOnboardingCompleted: Boolean = false,
    val remindersEnabled: Boolean = true,
    val reminderTime: String = "20:00" // "HH:mm"
) {
    fun calculateLevel(): Int {
        return (xp / 100) + 1
    }

    fun xpToNextLevel(): Int {
        val currentLevel = calculateLevel()
        val nextLevelThreshold = currentLevel * 100
        return (nextLevelThreshold - xp).coerceAtLeast(0)
    }

    fun isSentenceLearned(sentenceId: String): Boolean {
        return learnedSentenceIds.contains(sentenceId)
    }

    fun isLessonCompleted(lessonId: String): Boolean {
        return completedLessonIds.contains(lessonId)
    }

    fun hasStudiedToday(): Boolean {
        val todayStr = getTodayDateString()
        return studiedDates.contains(todayStr)
    }

    // Returns list of 7 items (Day abbreviation, dateString, isStudied) for the last 7 calendar days
    fun getLast7DaysActivity(): List<DayActivity> {
        val list = mutableListOf<DayActivity>()
        val cal = Calendar.getInstance()
        val dayFormat = SimpleDateFormat("EEE", Locale.ENGLISH)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        // Generate past 6 days + today (total 7 days)
        for (i in 6 downTo 0) {
            val c = Calendar.getInstance()
            c.add(Calendar.DAY_OF_YEAR, -i)
            val dateStr = dateFormat.format(c.time)
            val dayName = dayFormat.format(c.time).take(1) // M, T, W, T, F, S, S
            val isStudied = studiedDates.contains(dateStr)
            val isToday = i == 0
            list.add(DayActivity(dayName = dayName, dateString = dateStr, isStudied = isStudied, isToday = isToday))
        }
        return list
    }

    companion object {
        fun getTodayDateString(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            return sdf.format(Date())
        }
    }
}

data class DayActivity(
    val dayName: String,
    val dateString: String,
    val isStudied: Boolean,
    val isToday: Boolean
)
