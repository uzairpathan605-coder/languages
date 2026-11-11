package com.example.model

data class Language(
    val id: String,
    val nameEn: String,
    val nameNative: String,
    val nameUrdu: String,
    val flag: String,
    val ttsLanguageTag: String,
    val isPrimaryJobFocus: Boolean = false,
    val descriptionUrdu: String = ""
)

object SupportedLanguages {
    val ALL = listOf(
        Language(
            id = "de",
            nameEn = "German",
            nameNative = "Deutsch",
            nameUrdu = "جرمن",
            flag = "🇩🇪",
            ttsLanguageTag = "de-DE",
            isPrimaryJobFocus = true,
            descriptionUrdu = "جرمنی میں Ausbildung اور نوکریوں کے لیے لازمی (B1 / B2)"
        ),
        Language(
            id = "en",
            nameEn = "English",
            nameNative = "English",
            nameUrdu = "انگریزی",
            flag = "🇬🇧",
            ttsLanguageTag = "en-US",
            descriptionUrdu = "عالمی کاروبار، کیریئر اور روزمرہ گفتگو کے لیے"
        ),
        Language(
            id = "ur",
            nameEn = "Urdu",
            nameNative = "اردو",
            nameUrdu = "اردو",
            flag = "🇵🇰",
            ttsLanguageTag = "ur-PK",
            descriptionUrdu = "قومی اور مادری زبان"
        ),
        Language(
            id = "ar",
            nameEn = "Arabic",
            nameNative = "العربية",
            nameUrdu = "عربی",
            flag = "🇸🇦",
            ttsLanguageTag = "ar-SA",
            descriptionUrdu = "خلیجی ممالک میں کام اور روزمرہ گفتگو کے لیے"
        ),
        Language(
            id = "fr",
            nameEn = "French",
            nameNative = "Français",
            nameUrdu = "فرانسیسی",
            flag = "🇫🇷",
            ttsLanguageTag = "fr-FR",
            descriptionUrdu = "یورپ اور کینیڈا کے لیے اہم زبان"
        ),
        Language(
            id = "es",
            nameEn = "Spanish",
            nameNative = "Español",
            nameUrdu = "ہسپانوی",
            flag = "🇪🇸",
            ttsLanguageTag = "es-ES",
            descriptionUrdu = "دنیا کی دوسری سب سے زیادہ بولی جانے والی زبان"
        ),
        Language(
            id = "it",
            nameEn = "Italian",
            nameNative = "Italiano",
            nameUrdu = "اطالوی",
            flag = "🇮🇹",
            ttsLanguageTag = "it-IT",
            descriptionUrdu = "اٹلی میں رہائش اور کام کے لیے"
        ),
        Language(
            id = "tr",
            nameEn = "Turkish",
            nameNative = "Türkçe",
            nameUrdu = "ترکی",
            flag = "🇹🇷",
            ttsLanguageTag = "tr-TR",
            descriptionUrdu = "ترکی اور یورپ میں کارآمد زبان"
        ),
        Language(
            id = "ru",
            nameEn = "Russian",
            nameNative = "Русский",
            nameUrdu = "روسی",
            flag = "🇷🇺",
            ttsLanguageTag = "ru-RU",
            descriptionUrdu = "وسطی ایشیا اور مشرقی یورپ کے لیے"
        ),
        Language(
            id = "zh",
            nameEn = "Chinese",
            nameNative = "中文",
            nameUrdu = "چینی (مینڈرن)",
            flag = "🇨🇳",
            ttsLanguageTag = "zh-CN",
            descriptionUrdu = "بین الاقوامی تجارت کی سب سے بڑی زبان"
        ),
        Language(
            id = "ko",
            nameEn = "Korean",
            nameNative = "한국어",
            nameUrdu = "کوریائی",
            flag = "🇰🇷",
            ttsLanguageTag = "ko-KR",
            descriptionUrdu = "جنوبی کوریا میں روزگار اور تعلیم کے لیے"
        ),
        Language(
            id = "ja",
            nameEn = "Japanese",
            nameNative = "日本語",
            nameUrdu = "جاپانی",
            flag = "🇯🇵",
            ttsLanguageTag = "ja-JP",
            descriptionUrdu = "جاپان میں فنی ملازمتوں کے لیے"
        ),
        Language(
            id = "pt",
            nameEn = "Portuguese",
            nameNative = "Português",
            nameUrdu = "پرتگالی",
            flag = "🇵🇹",
            ttsLanguageTag = "pt-PT",
            descriptionUrdu = "پرتگال اور برازیل کے لیے اہم زبان"
        ),
        Language(
            id = "hi",
            nameEn = "Hindi",
            nameNative = "हिन्दी",
            nameUrdu = "ہندی",
            flag = "🇮🇳",
            ttsLanguageTag = "hi-IN",
            descriptionUrdu = "برصغیر پاک و ہند کی زبان"
        ),
        Language(
            id = "ps",
            nameEn = "Pashto",
            nameNative = "پښتو",
            nameUrdu = "پشتو",
            flag = "🇦🇫",
            ttsLanguageTag = "ps-AF",
            descriptionUrdu = "خیبر پختونخوا اور افغانستان کی زبان"
        )
    )

    fun getById(id: String): Language {
        return ALL.firstOrNull { it.id == id } ?: ALL.first()
    }
}
