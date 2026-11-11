package com.example.data

import com.example.model.CefrLevel
import com.example.model.Lesson
import com.example.model.SentenceItem
import com.example.model.SupportedLanguages

object CourseDataRepository {
    fun getLessons(languageId: String): List<Lesson> {
        return WorldLanguagesContent.getLessonsForLanguage(languageId)
    }

    fun getLessonsByLevel(languageId: String, level: CefrLevel): List<Lesson> {
        return getLessons(languageId).filter { it.level == level }
    }

    fun getLessonById(languageId: String, lessonId: String): Lesson? {
        return getLessons(languageId).firstOrNull { it.id == lessonId }
    }

    fun searchSentences(query: String, languageId: String? = null): List<Triple<String, Lesson, SentenceItem>> {
        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) return emptyList()

        val results = mutableListOf<Triple<String, Lesson, SentenceItem>>()
        val langsToSearch = if (languageId != null) {
            listOf(SupportedLanguages.getById(languageId))
        } else {
            SupportedLanguages.ALL
        }

        for (lang in langsToSearch) {
            val lessons = getLessons(lang.id)
            for (lesson in lessons) {
                for (sentence in lesson.sentences) {
                    val match = sentence.targetText.lowercase().contains(trimmed) ||
                            sentence.englishText.lowercase().contains(trimmed) ||
                            sentence.urduText.contains(trimmed) ||
                            sentence.romanUrduText.lowercase().contains(trimmed)
                    if (match) {
                        results.add(Triple(lang.nameNative, lesson, sentence))
                    }
                }
            }
        }
        return results
    }
}
