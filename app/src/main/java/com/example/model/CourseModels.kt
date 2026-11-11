package com.example.model

enum class CefrLevel(
    val code: String,
    val title: String,
    val description: String,
    val germanTag: String? = null
) {
    A1(
        code = "A1",
        title = "Beginner (A1)",
        description = "Greetings, numbers, family, food & daily life basics."
    ),
    A2(
        code = "A2",
        title = "Elementary (A2)",
        description = "Shopping, directions, health, work tasks & travel."
    ),
    B1(
        code = "B1",
        title = "Intermediate (B1)",
        description = "Workplace discussions, opinions, shift duties & career.",
        germanTag = "Ausbildung minimum"
    ),
    B2(
        code = "B2",
        title = "Upper Intermediate (B2)",
        description = "Business meetings, debates, culture & professional fluency.",
        germanTag = "Best for all jobs in Germany"
    ),
    C1(
        code = "C1",
        title = "Advanced (C1)",
        description = "Academic language, scientific research, politics & complex society."
    ),
    C2(
        code = "C2",
        title = "Mastery / Native Fluency (C2)",
        description = "Idioms, nuanced humor, formal writing & native command."
    );

    companion object {
        fun fromCode(code: String): CefrLevel =
            entries.firstOrNull { it.code.equals(code, ignoreCase = true) } ?: A1
    }
}

data class SentenceItem(
    val id: String,
    val emoji: String,
    val targetText: String,
    val englishText: String,
    val urduText: String,
    val romanUrduText: String,
    val contextNotes: String = ""
)

data class Lesson(
    val id: String,
    val languageId: String,
    val level: CefrLevel,
    val title: String,
    val romanUrduTitle: String,
    val iconEmoji: String,
    val grammarTipRomanUrdu: String,
    val grammarTipEn: String,
    val isWorkplaceSpecial: Boolean = false,
    val sentences: List<SentenceItem>
)

enum class BasicCategory(val title: String, val titleUrdu: String, val emoji: String) {
    ALPHABET("Alphabet & Sounds", "حروفِ تہجی اور تلفظ", "🔤"),
    DAYS("Days of the Week", "ہفتے کے دن", "📅"),
    MONTHS("Months of the Year", "سال کے مہینے", "🗓️"),
    NUMBERS("Numbers (0 - 1000)", "گنتی اور اعداد", "🔢"),
    COLOURS("Colours", "رنگوں کے نام", "🎨"),
    QUESTIONS("Question Words", "سوالیہ الفاظ", "❓"),
    PHRASES("Daily-Life Phrases", "روزمرہ ضروری جملے", "💬")
}

data class BasicItem(
    val id: String,
    val category: BasicCategory,
    val targetText: String,
    val pronunciationGuide: String, // "How to say it"
    val englishText: String,
    val urduText: String,
    val romanUrduText: String
)
