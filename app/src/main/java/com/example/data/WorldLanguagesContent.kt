package com.example.data

import com.example.model.CefrLevel
import com.example.model.Lesson
import com.example.model.SentenceItem

object WorldLanguagesContent {
    fun getLessonsForLanguage(languageId: String): List<Lesson> {
        return when (languageId) {
            "de" -> GermanCourseContent.getLessons()
            "en" -> EnglishCourseContent.getLessons()
            "ar" -> createArabicLessons()
            "fr" -> createFrenchLessons()
            "es" -> createSpanishLessons()
            "tr" -> createTurkishLessons()
            "it" -> createItalianLessons()
            "ru" -> createRussianLessons()
            "zh" -> createChineseLessons()
            "ko" -> createKoreanLessons()
            "ja" -> createJapaneseLessons()
            "pt" -> createPortugueseLessons()
            "hi" -> createHindiLessons()
            "ps" -> createPashtoLessons()
            "ur" -> createUrduLessons()
            else -> GermanCourseContent.getLessons()
        }
    }

    private fun createArabicLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "ar_a1_1", languageId = "ar", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Arabi mein 'Marhaban' ya 'Assalamu Alaikum' se baat shuru karein.",
            grammarTipEn = "Common Arabic greetings include 'Marhaban' and 'Kayfa haluka'.",
            sentences = listOf(
                SentenceItem("ar_1", "👋", "مَرْحَبًا، كَيْفَ حَالُكَ؟", "Hello, how are you?", "ہیلو، آپ کا کیا حال ہے؟", "Marhaban, kayfa haluk?"),
                SentenceItem("ar_2", "😊", "أَنَا بِخَيْرٍ، شُكْرًا لَكَ.", "I am fine, thank you.", "میں خیریت سے ہوں، شکریہ۔", "Ana bi-khayr, shukran lak."),
                SentenceItem("ar_3", "🏷️", "اِسْمِي عُمَر.", "My name is Omar.", "میرا نام عمر ہے۔", "Ismi Omar."),
                SentenceItem("ar_4", "🤝", "تَشَرَّفْنَا بِمَعْرِفَتِكَ.", "Pleased to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Tasharrafna bi-ma'rifatik."),
                SentenceItem("ar_5", "🇵🇰", "أَنَا مِنْ بَاكِسْتَان.", "I am from Pakistan.", "میں پاکستان سے ہوں۔", "Ana min Pakistan."),
                SentenceItem("ar_6", "💼", "أَعْمَلُ هُنَا.", "I work here.", "میں یہاں کام کرتا ہوں۔", "A'malu huna."),
                SentenceItem("ar_7", "🗣️", "أَتَعَلَّمُ اللُّغَةَ الْعَرَبِيَّة.", "I am learning Arabic.", "میں عربی زبان سیکھ رہا ہوں۔", "Ata'allamu al-lughata al-arabiyyah."),
                SentenceItem("ar_8", "🙋‍♂️", "مَعَ السَّلَامَة!", "Goodbye!", "اللہ حافظ!", "Ma'a as-salamah!")
            )
        )

        val b1_workplace = Lesson(
            id = "ar_b1_5", languageId = "ar", level = CefrLevel.B1,
            title = "Workplace for Every Worker", romanUrduTitle = "Har Worker ke Zaroori Jumlay", iconEmoji = "👷",
            isWorkplaceSpecial = true,
            grammarTipRomanUrdu = "Gulf / Arab mumalik mein har worker ke kaam aane wale 8 zaroori jumlay.",
            grammarTipEn = "Universal essential workplace phrases in Arabic.",
            sentences = listOf(
                SentenceItem("ar_w1", "⏰", "مَتَى تَبْدَأُ فَتْرَةُ عَمَلِي؟", "When does my shift start?", "میری شفٹ کب شروع ہوتی ہے؟", "Mata tabda' fatratu amali?"),
                SentenceItem("ar_w2", "☕", "أَيْنَ غُرْفَةُ الِاسْتِرَاحَة؟", "Where is the break room?", "وقفے کا کمرہ کہاں ہے؟", "Ayna ghurfatu al-istiraha?"),
                SentenceItem("ar_w3", "🤝", "أَحْتَاجُ إِلَى مُسَاعَدَةٍ فِي هَذَا الْعَمَل.", "I need help with this task.", "مجھے اس کام میں مدد چاہیے۔", "Ahtaju ila musa'adah fi hadha al-amal."),
                SentenceItem("ar_w4", "🦺", "السَّلَامَةُ أَوَّلًا، اِرْتَدِ مَلَابِسَ الْوِقَايَة.", "Safety first, wear protective gear.", "حفاظت سب سے پہلے، حفاظتی لباس پہنیں۔", "As-salamatu awwalan, irtadi malabis al-wiqayah."),
                SentenceItem("ar_w5", "🏖️", "أُرِيدُ التَّقَدُّمَ بِطَلَبِ إِجَازَة.", "I want to request a holiday / leave.", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "Uridu at-taqaddum bi-talabi ijazah."),
                SentenceItem("ar_w6", "🔁", "هَلْ يُمْكِنُكَ تَوضِيحُ ذَلِكَ مَرَّةً أُخْرَى؟", "Could you please explain that again?", "کیا آپ دوبارہ وضاحت کر سکتے ہیں؟", "Hal yumkinuka tawdihu dhalika marratan ukhra?"),
                SentenceItem("ar_w7", "⚠️", "الْآلَةُ لَا تَعْمَلُ بِشَكْلٍ صَحِيح.", "The machine is not working properly.", "مشین ٹھیک کام نہیں کر رہی۔", "Al-alatu la ta'malu bi-shaklin sahih."),
                SentenceItem("ar_w8", "✅", "لَقَدْ أَنْهَيْتُ عَمَلِي لِلْيَوْم.", "I have finished my work for today.", "میں نے آج کا کام ختم کر لیا ہے۔", "Laqad anhaytu amali lil-yawm.")
            )
        )

        return generateFullLevels("ar", "العربية", a1_1, b1_workplace)
    }

    private fun createFrenchLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "fr_a1_1", languageId = "fr", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "French mein 'Bonjour' din ke waqt aur 'Bonsoir' sham ke waqt kehte hain.",
            grammarTipEn = "Use 'Bonjour' for hello and 'Comment allez-vous' for formal greeting.",
            sentences = listOf(
                SentenceItem("fr_1", "👋", "Bonjour, comment allez-vous?", "Hello, how are you?", "ہیلو، آپ کیسے ہیں؟", "Bonjour, comment allez-vous?"),
                SentenceItem("fr_2", "😊", "Je vais très bien, merci.", "I am doing very well, thank you.", "میں بالکل ٹھیک ہوں، شکریہ۔", "Je vais très bien, merci."),
                SentenceItem("fr_3", "🏷️", "Je m'appelle Tariq.", "My name is Tariq.", "میرا نام طارق ہے۔", "Je m'appelle Tariq."),
                SentenceItem("fr_4", "🤝", "Enchanté de faire votre connaissance.", "Enchanted to meet you.", "آپ سے مل کر دلی خوشی ہوئی۔", "Enchanté de faire votre connaissance."),
                SentenceItem("fr_5", "🇵🇰", "Je viens du Pakistan.", "I come from Pakistan.", "میں پاکستان سے ہوں۔", "Je viens du Pakistan."),
                SentenceItem("fr_6", "🏙️", "J'habite à Paris.", "I live in Paris.", "میں پیرس میں رہتا ہوں۔", "J'habite à Paris."),
                SentenceItem("fr_7", "🗣️", "J'apprends le français.", "I am learning French.", "میں فرانسیسی زبان سیکھ رہا ہوں۔", "J'apprends le français."),
                SentenceItem("fr_8", "🙋‍♂️", "Au revoir et bonne journée!", "Goodbye and have a good day!", "الوداع اور آپ کا دن اچھا گزرے!", "Au revoir et bonne journée!")
            )
        )

        val b1_workplace = Lesson(
            id = "fr_b1_5", languageId = "fr", level = CefrLevel.B1,
            title = "Workplace for Every Worker", romanUrduTitle = "Har Worker ke Zaroori Jumlay", iconEmoji = "👷",
            isWorkplaceSpecial = true,
            grammarTipRomanUrdu = "France / Europe mein har worker ke kaam aane wale 8 zaroori jumlay.",
            grammarTipEn = "Essential workplace phrases in French.",
            sentences = listOf(
                SentenceItem("fr_w1", "⏰", "Quand commence mon shift de travail?", "When does my shift start?", "میری شفٹ کب شروع ہوتی ہے؟", "Quand commence mon shift?"),
                SentenceItem("fr_w2", "☕", "Où se trouve la salle de pause?", "Where is the break room?", "وقفے کا کمرہ کہاں ہے؟", "Où se trouve la salle de pause?"),
                SentenceItem("fr_w3", "🤝", "J'ai besoin d'aide pour cette tâche.", "I need help with this task.", "مجھے اس کام میں مدد چاہیے۔", "J'ai besoin d'aide pour cette tâche."),
                SentenceItem("fr_w4", "🦺", "La sécurité d'abord, portez les équipements.", "Safety first, wear protective gear.", "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔", "La sécurité d'abord."),
                SentenceItem("fr_w5", "🏖️", "Je voudrais poser des jours de congé.", "I would like to request leave / holiday.", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "Je voudrais poser des congés."),
                SentenceItem("fr_w6", "🔁", "Pourriez-vous expliquer cela à nouveau?", "Could you please explain that again?", "کیا آپ دوبارہ سمجھا سکتے ہیں؟", "Pourriez-vous expliquer à nouveau?"),
                SentenceItem("fr_w7", "⚠️", "La machine ne fonctionne pas correctement.", "The machine is not working properly.", "مشین ٹھیک کام نہیں کر رہی۔", "La machine ne fonctionne pas."),
                SentenceItem("fr_w8", "✅", "J'ai terminé mon travail pour aujourd'hui.", "I have finished my work for today.", "میں نے آج کا کام ختم کر لیا ہے۔", "J'ai terminé mon travail.")
            )
        )

        return generateFullLevels("fr", "Français", a1_1, b1_workplace)
    }

    private fun createSpanishLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "es_a1_1", languageId = "es", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Spanish mein 'Hola' (Ola) bola jata hai, H ki awaz silent hoti hai.",
            grammarTipEn = "In Spanish, 'H' is silent in 'Hola' (pronounced oh-lah).",
            sentences = listOf(
                SentenceItem("es_1", "👋", "¡Hola! ¿Cómo estás hoy?", "Hello! How are you today?", "ہیلو! آج آپ کیسے ہیں؟", "Hola, cómo estás hoy?"),
                SentenceItem("es_2", "😊", "Estoy muy bien, gracias.", "I am very well, thank you.", "میں بہت ٹھیک ہوں، شکریہ۔", "Estoy muy bien, gracias."),
                SentenceItem("es_3", "🏷️", "Me llamo Hassan.", "My name is Hassan.", "میرا نام حسن ہے۔", "Me llamo Hassan."),
                SentenceItem("es_4", "🤝", "¡Mucho gusto en conocerte!", "Pleased to meet you!", "آپ سے مل کر خوشی ہوئی!", "Mucho gusto en conocerte!"),
                SentenceItem("es_5", "🇵🇰", "Soy de Pakistán.", "I am from Pakistan.", "میں پاکستان سے ہوں۔", "Soy de Pakistán."),
                SentenceItem("es_6", "🏙️", "Vivo en Madrid.", "I live in Madrid.", "میں میڈرڈ میں رہتا ہوں۔", "Vivo en Madrid."),
                SentenceItem("es_7", "🗣️", "Estoy aprendiendo español.", "I am learning Spanish.", "میں ہسپانوی زبان سیکھ رہا ہوں۔", "Estoy aprendiendo español."),
                SentenceItem("es_8", "🙋‍♂️", "¡Hasta luego y cuídate!", "See you later and take care!", "پھر ملیں گے اور اپنا خیال رکھیں!", "Hasta luego y cuídate!")
            )
        )

        val b1_workplace = Lesson(
            id = "es_b1_5", languageId = "es", level = CefrLevel.B1,
            title = "Workplace for Every Worker", romanUrduTitle = "Har Worker ke Zaroori Jumlay", iconEmoji = "👷",
            isWorkplaceSpecial = true,
            grammarTipRomanUrdu = "Spain aur Latin America mein workers ke rozana kaam ke 8 ahem jumlay.",
            grammarTipEn = "Universal Spanish workplace phrases for all employees.",
            sentences = listOf(
                SentenceItem("es_w1", "⏰", "¿A qué hora empieza mi turno?", "When does my shift start?", "میری شفٹ کب شروع ہوتی ہے؟", "A qué hora empieza mi turno?"),
                SentenceItem("es_w2", "☕", "¿Dónde está la sala de descanso?", "Where is the break room?", "وقفے کا کمرہ کہاں ہے؟", "Dónde está la sala de descanso?"),
                SentenceItem("es_w3", "🤝", "Necesito ayuda con esta tarea.", "I need help with this task.", "مجھے اس کام میں مدد چاہیے۔", "Necesito ayuda con esta tarea."),
                SentenceItem("es_w4", "🦺", "La seguridad es primero, use equipo protector.", "Safety first, wear protective gear.", "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔", "La seguridad es primero."),
                SentenceItem("es_w5", "🏖️", "Quisiera solicitar días de vacaciones.", "I would like to request leave / holiday.", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "Quisiera solicitar vacaciones."),
                SentenceItem("es_w6", "🔁", "¿Podría explicar eso de nuevo, por favor?", "Could you please explain that again?", "کیا آپ دوبارہ سمجھا سکتے ہیں؟", "Podría explicar de nuevo por favor?"),
                SentenceItem("es_w7", "⚠️", "La máquina no funciona correctamente.", "The machine is not working properly.", "مشین ٹھیک کام نہیں کر رہی۔", "La máquina no funciona bien."),
                SentenceItem("es_w8", "✅", "He terminado mi trabajo por hoy.", "I have finished my work for today.", "میں نے آج کا کام ختم کر لیا ہے۔", "He terminado mi trabajo por hoy.")
            )
        )

        return generateFullLevels("es", "Español", a1_1, b1_workplace)
    }

    private fun createTurkishLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "tr_a1_1", languageId = "tr", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Turkish mein 'Merhaba' (Salam) aur 'Nasılsınız' (Aap kaise hain) bolte hain.",
            grammarTipEn = "Use 'Merhaba' for hello and 'Teşekkürler' for thanks.",
            sentences = listOf(
                SentenceItem("tr_1", "👋", "Merhaba, nasılsınız?", "Hello, how are you?", "ہیلو، آپ کیسے ہیں؟", "Merhaba, nasilsiniz?"),
                SentenceItem("tr_2", "😊", "İyiyim, teşekkür ederim.", "I am fine, thank you.", "میں ٹھیک ہوں، شکریہ۔", "Iyiyim, tesekkur ederim."),
                SentenceItem("tr_3", "🏷️", "Benim adım Zeeshan.", "My name is Zeeshan.", "میرا نام ذیشان ہے۔", "Benim adim Zeeshan."),
                SentenceItem("tr_4", "🤝", "Tanıştığımıza memnun oldum.", "Pleased to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Tanistigimiza memnun oldum."),
                SentenceItem("tr_5", "🇵🇰", "Pakistan'dan geliyorum.", "I come from Pakistan.", "میں پاکستان سے آیا ہوں۔", "Pakistan'dan geliyorum."),
                SentenceItem("tr_6", "🏙️", "İstanbul'da yaşıyorum.", "I live in Istanbul.", "میں استنبول میں رہتا ہوں۔", "Istanbul'da yasiyorum."),
                SentenceItem("tr_7", "🗣️", "Türkçe öğreniyorum.", "I am learning Turkish.", "میں ترکی زبان سیکھ رہا ہوں۔", "Turkce ogreniyorum."),
                SentenceItem("tr_8", "🙋‍♂️", "Görüşmek üzere, hoşça kalın!", "See you soon, goodbye!", "پھر ملیں گے، اللہ حافظ!", "Gorusmek uzere, hoscakalin!")
            )
        )

        val b1_workplace = Lesson(
            id = "tr_b1_5", languageId = "tr", level = CefrLevel.B1,
            title = "Workplace for Every Worker", romanUrduTitle = "Har Worker ke Zaroori Jumlay", iconEmoji = "👷",
            isWorkplaceSpecial = true,
            grammarTipRomanUrdu = "Turkey mein har worker ke rozana kaam ke 8 zaroori jumlay.",
            grammarTipEn = "Essential workplace sentences in Turkish.",
            sentences = listOf(
                SentenceItem("tr_w1", "⏰", "Vardiyam ne zaman başlıyor?", "When does my shift start?", "میری شفٹ کب شروع ہوتی ہے؟", "Vardiyam ne zaman basliyor?"),
                SentenceItem("tr_w2", "☕", "Mola odası nerede?", "Where is the break room?", "وقفے کا کمرہ کہاں ہے؟", "Mola odasi nerede?"),
                SentenceItem("tr_w3", "🤝", "Bu görevde yardıma ihtiyacım var.", "I need help with this task.", "مجھے اس کام میں مدد چاہیے۔", "Bu gorevde yardima ihtiyacim var."),
                SentenceItem("tr_w4", "🦺", "Önce güvenlik, koruyucu ekipman giyin.", "Safety first, wear protective gear.", "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔", "Once guvenlik."),
                SentenceItem("tr_w5", "🏖️", "İzin talep etmek istiyorum.", "I would like to request leave / holiday.", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "Izin talep etmek istiyorum."),
                SentenceItem("tr_w6", "🔁", "Bunu tekrar açıklayabilir misiniz?", "Could you please explain that again?", "کیا آپ دوبارہ سمجھا سکتے ہیں؟", "Bunu tekrar aciklayabilir misiniz?"),
                SentenceItem("tr_w7", "⚠️", "Makine düzgün çalışmıyor.", "The machine is not working properly.", "مشین ٹھیک کام نہیں کر رہی۔", "Makine duzgun calismiyor."),
                SentenceItem("tr_w8", "✅", "Bugünkü işimi bitirdim.", "I have finished my work for today.", "میں نے آج کا کام ختم کر لیا ہے۔", "Bugunku isimi bitirdim.")
            )
        )

        return generateFullLevels("tr", "Türkçe", a1_1, b1_workplace)
    }

    private fun createItalianLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "it_a1_1", languageId = "it", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Italian mein 'Buongiorno' (Subah bakhair) aur 'Come sta?' ba-adab jumla hai.",
            grammarTipEn = "Use 'Buongiorno' for good day and 'Come sta' for formal how are you.",
            sentences = listOf(
                SentenceItem("it_1", "👋", "Buongiorno, come sta?", "Good morning, how are you?", "صبح بخیر، آپ کیسے ہیں؟", "Buongiorno, come sta?"),
                SentenceItem("it_2", "😊", "Sto molto bene, grazie.", "I am very well, thank you.", "میں بالکل ٹھیک ہوں، شکریہ۔", "Sto molto bene, grazie."),
                SentenceItem("it_3", "🏷️", "Mi chiamo Hamza.", "My name is Hamza.", "میرا نام حمزہ ہے۔", "Mi chiamo Hamza."),
                SentenceItem("it_4", "🤝", "Piacere di conoscerla.", "Pleased to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Piacere di conoscerla."),
                SentenceItem("it_5", "🇵🇰", "Vengo dal Pakistan.", "I come from Pakistan.", "میں پاکستان سے ہوں۔", "Vengo dal Pakistan."),
                SentenceItem("it_6", "🏙️", "Abito a Roma.", "I live in Rome.", "میں روم میں رہتا ہوں۔", "Abito a Roma."),
                SentenceItem("it_7", "🗣️", "Sto imparando l'italiano.", "I am learning Italian.", "میں اطالوی زبان سیکھ رہا ہوں۔", "Sto imparando l'italiano."),
                SentenceItem("it_8", "🙋‍♂️", "Arrivederci e buona giornata!", "Goodbye and have a good day!", "الوداع اور آپ کا دن اچھا گزرے!", "Arrivederci!")
            )
        )
        val b1_workplace = createWorkplaceLesson("it", "Italiano", "Quando inizia il mio turno?", "Dov'è la sala pause?", "Ho bisogno di aiuto per questo compito.", "La sicurezza prima di tutto, indossare le protezioni.", "Vorrei richiedere dei giorni di ferie.", "Potrebbe spiegare di nuovo per favore?", "La macchina non funziona correttamente.", "Ho finito il mio lavoro per oggi.")
        return generateFullLevels("it", "Italiano", a1_1, b1_workplace)
    }

    private fun createRussianLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "ru_a1_1", languageId = "ru", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Russian mein 'Здравствуйте' (Zdrav-stvuy-te) ba-adab salam hai.",
            grammarTipEn = "Use 'Zdravstvuyte' for formal greeting and 'Spasibo' for thank you.",
            sentences = listOf(
                SentenceItem("ru_1", "👋", "Здравствуйте, как ваши дела?", "Hello, how are you?", "ہیلو، آپ کا کیا حال ہے؟", "Zdravstvuyte, kak vashi dela?"),
                SentenceItem("ru_2", "😊", "У меня всё хорошо, спасибо.", "Everything is good with me, thank you.", "میں بالکل ٹھیک ہوں، شکریہ۔", "U menya vsyo khorosho, spasibo."),
                SentenceItem("ru_3", "🏷️", "Меня зовут Асим.", "My name is Asim.", "میرا نام عاصم ہے۔", "Menya zovut Asim."),
                SentenceItem("ru_4", "🤝", "Очень приятно познакомиться.", "Very nice to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Ochen priyatno poznakomitsya."),
                SentenceItem("ru_5", "🇵🇰", "Я из Пакистана.", "I am from Pakistan.", "میں پاکستان سے ہوں۔", "Ya iz Pakistana."),
                SentenceItem("ru_6", "🏙️", "Я живу в Москве.", "I live in Moscow.", "میں ماسکو میں رہتا ہوں۔", "Ya zhivu v Moskve."),
                SentenceItem("ru_7", "🗣️", "Я учу русский язык.", "I am learning Russian.", "میں روسی زبان سیکھ رہا ہوں۔", "Ya uchu russkiy yazyk."),
                SentenceItem("ru_8", "🙋‍♂️", "До свидания!", "Goodbye!", "الوداع / پھر ملیں گے!", "Do svidaniya!")
            )
        )
        val b1_workplace = createWorkplaceLesson("ru", "Русский", "Когда начинается моя смена?", "Где находится комната отдыха?", "Мне нужна помощь с этой задачей.", "Безопасность прежде всего, наденьте защиту.", "Я хочу запросить отпуск.", "Не могли бы вы объяснить ещё раз?", "Машина работает неправильно.", "Я закончил свою работу на сегодня.")
        return generateFullLevels("ru", "Русский", a1_1, b1_workplace)
    }

    private fun createChineseLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "zh_a1_1", languageId = "zh", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Chinese mein 'Nǐ hǎo' (Salam) aur 'Xièxiè' (Shukriya) aam taur par use hota hai.",
            grammarTipEn = "Nǐ hǎo means hello and Xièxiè means thank you.",
            sentences = listOf(
                SentenceItem("zh_1", "👋", "你好，你好吗？", "Hello, how are you?", "ہیلو، آپ کیسے ہیں؟", "Nǐ hǎo, nǐ hǎo ma?"),
                SentenceItem("zh_2", "😊", "我很好，谢谢你。", "I am very good, thank you.", "میں بہت اچھا ہوں، شکریہ۔", "Wǒ hěn hǎo, xièxiè nǐ."),
                SentenceItem("zh_3", "🏷️", "我叫阿德南。", "My name is Adnan.", "میرا نام عدنان ہے۔", "Wǒ jiào Adnan."),
                SentenceItem("zh_4", "🤝", "很高兴认识你！", "Very glad to meet you!", "آپ سے مل کر بہت خوشی ہوئی!", "Hěn gāoxìng rènshí nǐ!"),
                SentenceItem("zh_5", "🇵🇰", "我来自巴基斯坦。", "I come from Pakistan.", "میں پاکستان سے ہوں۔", "Wǒ láizì Bājīsītǎn."),
                SentenceItem("zh_6", "🏙️", "我住在北京。", "I live in Beijing.", "میں بیجنگ میں رہتا ہوں۔", "Wǒ zhù zài Běijīng."),
                SentenceItem("zh_7", "🗣️", "我在学中文。", "I am studying Chinese.", "میں چینی زبان سیکھ رہا ہوں۔", "Wǒ zài xué Zhōngwén."),
                SentenceItem("zh_8", "🙋‍♂️", "再见！祝你开心！", "Goodbye! Wishing you joy!", "الوداع! خوش رہیں!", "Zàijiàn!")
            )
        )
        val b1_workplace = createWorkplaceLesson("zh", "中文", "我的班次什么时候开始？", "休息室在哪里？", "我需要这项工作的帮助。", "安全第一，穿戴防护装备。", "我想申请休假。", "请问能再解释一次吗？", "这台机器工作不正常。", "我今天的工作完成了。")
        return generateFullLevels("zh", "中文", a1_1, b1_workplace)
    }

    private fun createKoreanLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "ko_a1_1", languageId = "ko", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Korean mein 'Annyeonghaseyo' ba-adab salam hai.",
            grammarTipEn = "Annyeonghaseyo is the standard polite Korean greeting.",
            sentences = listOf(
                SentenceItem("ko_1", "👋", "안녕하세요, 어떻게 지내세요?", "Hello, how are you?", "ہیلو، آپ کیسے ہیں؟", "Annyeonghaseyo, eotteoke jinaeseyo?"),
                SentenceItem("ko_2", "😊", "잘 지내고 있습니다, 감사합니다.", "I am doing well, thank you.", "میں ٹھیک ہوں، شکریہ۔", "Jal jinaego itseumnida, kamsahamnida."),
                SentenceItem("ko_3", "🏷️", "제 이름은 파한입니다.", "My name is Farhan.", "میرا نام فرحان ہے۔", "Je ireumeun Farhan-imnida."),
                SentenceItem("ko_4", "🤝", "만나서 반갑습니다.", "Nice to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Mannaseo bangapseumnida."),
                SentenceItem("ko_5", "🇵🇰", "저는 파키스탄에서 왔습니다.", "I came from Pakistan.", "میں پاکستان سے آیا ہوں۔", "Jeoneun Pakistan-eseo watseumnida."),
                SentenceItem("ko_6", "🏙️", "서울에 살고 있습니다.", "I live in Seoul.", "میں سیول میں رہتا ہوں۔", "Seoul-e salgo itseumnida."),
                SentenceItem("ko_7", "🗣️", "한국어를 배우고 있습니다.", "I am learning Korean.", "میں کوریائی زبان سیکھ رہا ہوں۔", "Hangugeo-reul baeugo itseumnida."),
                SentenceItem("ko_8", "🙋‍♂️", "안녕히 계세요!", "Goodbye!", "الوداع!", "Annyeonghi gyeseyo!")
            )
        )
        val b1_workplace = createWorkplaceLesson("ko", "한국어", "제 교대 근무는 언제 시작하나요?", "휴게실이 어디에 있나요?", "이 작업에 도움이 필요합니다.", "안전이 최우선입니다, 보호구를 착용하세요.", "휴가를 신청하고 싶습니다.", "다시 한 번 설명해 주시겠습니까?", "기계가 제대로 작동하지 않습니다.", "오늘 작업을 마쳤습니다.")
        return generateFullLevels("ko", "한국어", a1_1, b1_workplace)
    }

    private fun createJapaneseLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "ja_a1_1", languageId = "ja", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Japanese mein 'Konnichiwa' (Salam) aur 'Arigatou' (Shukriya) kehte hain.",
            grammarTipEn = "Use 'Konnichiwa' for hello and 'Arigatou gozaimasu' for thank you.",
            sentences = listOf(
                SentenceItem("ja_1", "👋", "こんにちは、お元気ですか？", "Hello, how are you?", "ہیلو، آپ کیسے ہیں؟", "Konnichiwa, ogenki desu ka?"),
                SentenceItem("ja_2", "😊", "はい、とても元気です。ありがとうございます。", "Yes, very well. Thank you.", "جی ہاں، میں بالکل ٹھیک ہوں۔ شکریہ۔", "Hai, totemo genki desu. Arigatou gozaimasu."),
                SentenceItem("ja_3", "🏷️", "私の名前はカシフです。", "My name is Kashif.", "میرا نام کاشف ہے۔", "Watashi no namae wa Kashif desu."),
                SentenceItem("ja_4", "🤝", "はじめまして、よろしくお願いします。", "Nice to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Hajimemashite, yoroshiku onegaishimasu."),
                SentenceItem("ja_5", "🇵🇰", "パキスタンから来ました。", "I came from Pakistan.", "میں پاکستان سے آیا ہوں۔", "Pakisutan kara kimashita."),
                SentenceItem("ja_6", "🏙️", "東京に住んでいます。", "I live in Tokyo.", "میں ٹوکیو میں رہتا ہوں۔", "Tokyo ni sunde imasu."),
                SentenceItem("ja_7", "🗣️", "日本語を勉強しています。", "I am studying Japanese.", "میں جاپانی زبان سیکھ رہا ہوں۔", "Nihongo o benkyou shite imasu."),
                SentenceItem("ja_8", "🙋‍♂️", "さようなら、良い一日を！", "Goodbye, have a good day!", "الوداع، آپ کا دن اچھا گزرے!", "Sayounara!")
            )
        )
        val b1_workplace = createWorkplaceLesson("ja", "日本語", "私のシフトは何時に始まりますか？", "休憩室はどこですか？", "この作業を手伝ってください。", "安全第一です、保護具を着用してください。", "有給休暇を申請したいです。", "もう一度説明していただけますか？", "機械が正常に動きません。", "本日の業務が終了しました。")
        return generateFullLevels("ja", "日本語", a1_1, b1_workplace)
    }

    private fun createPortugueseLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "pt_a1_1", languageId = "pt", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Portuguese mein 'Olá' (Salam) aur 'Obrigado' (Shukriya) kehte hain.",
            grammarTipEn = "Use 'Olá' for hello and 'Obrigado' for thank you.",
            sentences = listOf(
                SentenceItem("pt_1", "👋", "Olá, como você está hoje?", "Hello, how are you today?", "ہیلو، آج آپ کیسے ہیں؟", "Olá, como você está hoje?"),
                SentenceItem("pt_2", "😊", "Estou muito bem, obrigado.", "I am very well, thank you.", "میں ٹھیک ہوں، شکریہ۔", "Estou muito bem, obrigado."),
                SentenceItem("pt_3", "🏷️", "Meu nome é Usman.", "My name is Usman.", "میرا نام عثمان ہے۔", "Meu nome é Usman."),
                SentenceItem("pt_4", "🤝", "Muito prazer em conhecê-lo.", "Nice to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Muito prazer em conhecê-lo."),
                SentenceItem("pt_5", "🇵🇰", "Eu sou do Paquistão.", "I am from Pakistan.", "میں پاکستان سے ہوں۔", "Eu sou do Paquistão."),
                SentenceItem("pt_6", "🏙️", "Eu moro em Lisboa.", "I live in Lisbon.", "میں لزبن میں رہتا ہوں۔", "Eu moro em Lisboa."),
                SentenceItem("pt_7", "🗣️", "Estou aprendendo português.", "I am learning Portuguese.", "میں پرتگالی زبان سیکھ رہا ہوں۔", "Estou aprendendo português."),
                SentenceItem("pt_8", "🙋‍♂️", "Adeus e tenha um bom dia!", "Goodbye and have a good day!", "الوداع اور آپ کا دن اچھا گزرے!", "Adeus!")
            )
        )
        val b1_workplace = createWorkplaceLesson("pt", "Português", "Quando começa o meu turno?", "Onde fica a sala de descanso?", "Preciso de ajuda com esta tarefa.", "Segurança em primeiro lugar, use equipamento.", "Gostaria de solicitar férias.", "Poderia explicar isso novamente, por favor?", "A máquina não está funcionando bem.", "Terminei o meu trabalho por hoje.")
        return generateFullLevels("pt", "Português", a1_1, b1_workplace)
    }

    private fun createHindiLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "hi_a1_1", languageId = "hi", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Namaste aur Aap kaise hain se ba-adab baat shuru hoti hai.",
            grammarTipEn = "Polite Hindi greetings and introductions.",
            sentences = listOf(
                SentenceItem("hi_1", "👋", "नमस्ते, आप कैसे हैं?", "Hello, how are you?", "ہیلو، آپ کیسے ہیں؟", "Namaste, aap kaise hain?"),
                SentenceItem("hi_2", "😊", "मैं बिल्कुल ठीक हूँ, धन्यवाद।", "I am very well, thank you.", "میں بالکل ٹھیک ہوں، شکریہ۔", "Main bilkul theek hoon, dhanyavad."),
                SentenceItem("hi_3", "🏷️", "मेरा नाम राहुल है।", "My name is Rahul.", "میرا نام راہول ہے۔", "Mera naam Rahul hai."),
                SentenceItem("hi_4", "🤝", "आपसे मिलकर बहुत खुशी हुई।", "Pleased to meet you.", "آپ سے مل کر خوشی ہوئی۔", "Aap se mil kar bohot khushi hui."),
                SentenceItem("hi_5", "🇵🇰", "मैं लाहौर से हूँ।", "I am from Lahore.", "میں لاہور سے ہوں۔", "Main Lahore se hoon."),
                SentenceItem("hi_6", "🏙️", "मैं दिल्ली में रहता हूँ।", "I live in Delhi.", "میں دہلی میں رہتا ہوں۔", "Main Delhi mein rehta hoon."),
                SentenceItem("hi_7", "🗣️", "मैं नई भाषाएँ सीख रहा हूँ।", "I am learning new languages.", "میں نئی زبانیں سیکھ رہا ہوں۔", "Main nayi bhashayein seekh raha hoon."),
                SentenceItem("hi_8", "🙋‍♂️", "फिर मिलेंगे, शुभ दिन!", "See you again, good day!", "پھر ملیں گے، اچھا دن گزرے!", "Phir milenge, shubh din!")
            )
        )
        val b1_workplace = createWorkplaceLesson("hi", "हिन्दी", "मेरी शिफ्ट कब शुरू होती है?", "आराम करने का कमरा कहाँ है?", "मुझे इस काम में मदद चाहिए।", "सुरक्षा सबसे पहले, सुरक्षात्मक गियर पहनें।", "मैं छुट्टी के लिए आवेदन करना चाहता हूँ।", "क्या आप इसे दोबारा समझा सकते हैं?", "मशीन ठीक से काम नहीं कर रही है।", "मैंने आज का अपना काम पूरा कर लिया है।")
        return generateFullLevels("hi", "हिन्दी", a1_1, b1_workplace)
    }

    private fun createPashtoLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "ps_a1_1", languageId = "ps", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Pashto mein 'Pakher raghle' (Khush-amdeed) aur 'Sanga ye' (Aap kaise hain).",
            grammarTipEn = "Pashto greetings: Sanga ye (How are you?), Pakher raghle (Welcome).",
            sentences = listOf(
                SentenceItem("ps_1", "👋", "سلام، څنګه يې؟ جوړ يې؟", "Hello, how are you? Are you well?", "سلام، آپ کیسے ہیں؟ خیریت ہے؟", "Salam, sanga ye? Jor ye?"),
                SentenceItem("ps_2", "😊", "زه ډېر ښه يم، مننه.", "I am very well, thank you.", "میں بہت اچھا ہوں، شکریہ۔", "Za der kha yam, manana."),
                SentenceItem("ps_3", "🏷️", "زما نوم خان دی.", "My name is Khan.", "میرا نام خان ہے۔", "Zama noom Khan day."),
                SentenceItem("ps_4", "🤝", "ستاسو سره په ليدو ډېر خوشحاله شوم.", "Very happy to meet you.", "آپ سے مل کر بہت خوشی ہوئی۔", "Staso sara pa leedo der khushhala shwam."),
                SentenceItem("ps_5", "🇵🇰", "زه د پېښور يم.", "I am from Peshawar.", "میں پشاور کا رہنے والا ہوں۔", "Za da Pekhawar yam."),
                SentenceItem("ps_6", "💼", "زه دلته کار کوم.", "I work here.", "میں یہاں کام کرتا ہوں۔", "Za dalta kaar kawam."),
                SentenceItem("ps_7", "🗣️", "زه نوي ژبې زده کوم.", "I am learning new languages.", "میں نئی زبانیں سیکھ رہا ہوں۔", "Za nawe zhabe zada kawam."),
                SentenceItem("ps_8", "🙋‍♂️", "د خدای په امان!", "Goodbye / In God's protection!", "اللہ کے حوالے!", "Da Khudai pa aman!")
            )
        )
        val b1_workplace = createWorkplaceLesson("ps", "پښتو", "زما شفټ کله شروع کيږي؟", "د ارام کوټه چېرته ده؟", "زه په دې کار کې مرستې ته اړتيا لرم.", "لومړی خوندیتوب، حفاظتي جامې واغوندئ.", "زه د رخصتۍ غوښتنه کول غواړم.", "آيا تاسو دا بيا تشريح کولی شئ؟", "ماشين سم کار نه کوي.", "ما د نن ورځې کار پای ته ورساوه.")
        return generateFullLevels("ps", "پښتو", a1_1, b1_workplace)
    }

    private fun createUrduLessons(): List<Lesson> {
        val a1_1 = Lesson(
            id = "ur_a1_1", languageId = "ur", level = CefrLevel.A1,
            title = "Greetings & Introductions", romanUrduTitle = "Salam aur Ta'aruf", iconEmoji = "👋",
            grammarTipRomanUrdu = "Urdu mein 'Aap kaise hain' ba-adab jumla hai.",
            grammarTipEn = "Urdu formal greetings and daily expressions.",
            sentences = listOf(
                SentenceItem("ur_1", "👋", "السلام علیکم، آپ کا کیا حال ہے؟", "Assalamu Alaikum, how are you?", "السلام علیکم، آپ کا کیا حال ہے؟", "Assalamu Alaikum, aap kaise hain?"),
                SentenceItem("ur_2", "😊", "الحمد للہ، میں بالکل ٹھیک ہوں، شکریہ۔", "Praise be to God, I am fine, thank you.", "الحمد للہ، میں بالکل ٹھیک ہوں، شکریہ۔", "Alhamdulillah, main theek hoon."),
                SentenceItem("ur_3", "🏷️", "میرا نام عادل ہے۔", "My name is Adil.", "میرا نام عادل ہے۔", "Mera naam Adil hai."),
                SentenceItem("ur_4", "🤝", "آپ سے مل کر بہت خوشی ہوئی۔", "Pleased to meet you.", "آپ سے مل کر بہت خوشی ہوئی۔", "Aap se mil kar khushi hui."),
                SentenceItem("ur_5", "🇵🇰", "میرا تعلق پاکستان سے ہے۔", "I belong to Pakistan.", "میرا تعلق پاکستان سے ہے۔", "Mera taluq Pakistan se hai."),
                SentenceItem("ur_6", "🏙️", "میں لاہور شہر میں رہتا ہوں۔", "I live in Lahore city.", "میں لاہور شہر میں رہتا ہوں۔", "Main Lahore mein rehta hoon."),
                SentenceItem("ur_7", "🗣️", "اردو ہماری قومی اور پیاری زبان ہے۔", "Urdu is our national and beloved language.", "اردو ہماری قومی اور پیاری زبان ہے۔", "Urdu hamari pyari zaban hai."),
                SentenceItem("ur_8", "🙋‍♂️", "اللہ حافظ، پھر ملاقات ہوگی!", "Goodbye, until we meet again!", "اللہ حافظ، پھر ملاقات ہوگی!", "Allah hafiz, phir milenge!")
            )
        )
        val b1_workplace = createWorkplaceLesson("ur", "اردو", "میری شفٹ کب شروع ہوتی ہے؟", "وقفے کا کمرہ کہاں ہے؟", "مجھے اس کام میں آپ کی مدد چاہیے۔", "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "کیا آپ یہ دوبارہ سمجھا سکتے ہیں؟", "مشین ٹھیک طرح سے کام نہیں کر رہی۔", "میں نے آج کا اپنا کام مکمل کر لیا ہے۔")
        return generateFullLevels("ur", "اردو", a1_1, b1_workplace)
    }

    private fun createWorkplaceLesson(
        langId: String,
        langName: String,
        s1: String, s2: String, s3: String, s4: String, s5: String, s6: String, s7: String, s8: String
    ): Lesson {
        return Lesson(
            id = "${langId}_b1_5", languageId = langId, level = CefrLevel.B1,
            title = "Workplace for Every Worker", romanUrduTitle = "Har Worker ke Zaroori Jumlay", iconEmoji = "👷",
            isWorkplaceSpecial = true,
            grammarTipRomanUrdu = "Har worker ke rozana kaam ke 8 zaroori jumlay.",
            grammarTipEn = "Universal essential workplace phrases in $langName.",
            sentences = listOf(
                SentenceItem("${langId}_w1", "⏰", s1, "When does my shift start?", "میری شفٹ کب شروع ہوتی ہے؟", "Mera shift kab shuru hota hai?"),
                SentenceItem("${langId}_w2", "☕", s2, "Where is the break room?", "وقفے کا کمرہ کہاں ہے؟", "Waqfe ka kamra kahan hai?"),
                SentenceItem("${langId}_w3", "🤝", s3, "I need help with this task.", "مجھے اس کام میں مدد چاہیے۔", "Mujhe is kaam mein madad chahiye."),
                SentenceItem("${langId}_w4", "🦺", s4, "Safety first, wear protective gear.", "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔", "Hifazat sab se pehle, protective gear pehnein."),
                SentenceItem("${langId}_w5", "🏖️", s5, "I would like to request leave / holiday.", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "Main chutti ki darkhwast karna chahta hoon."),
                SentenceItem("${langId}_w6", "🔁", s6, "Could you please explain that again?", "کیا آپ دوبارہ سمجھا سکتے ہیں؟", "Kya aap dobara explain kar sakte hain?"),
                SentenceItem("${langId}_w7", "⚠️", s7, "The machine is not working properly.", "مشین ٹھیک کام نہیں کر رہی۔", "Machine theek kaam nahi kar rahi."),
                SentenceItem("${langId}_w8", "✅", s8, "I have finished my work for today.", "میں نے آج کا کام ختم کر لیا ہے۔", "Maine aaj ka kaam finish kar liya hai.")
            )
        )
    }

    private fun generateFullLevels(
        langId: String,
        langName: String,
        sampleA1: Lesson,
        workplaceB1: Lesson
    ): List<Lesson> {
        val list = mutableListOf<Lesson>()
        list.add(sampleA1)

        val topicsA1 = listOf(
            Triple("Numbers, Days & Time", "Ginti, Din aur Waqt", "🕗"),
            Triple("Family & Friends", "Khandan aur Dost", "👨‍👩‍👦"),
            Triple("Food & Drink", "Khana aur Peena", "🍕"),
            Triple("Daily Routine", "Rozmarah ka Mamool", "🌅")
        )
        topicsA1.forEachIndexed { i, t ->
            list.add(createSampleLesson(langId, CefrLevel.A1, i + 2, t.first, t.second, t.third))
        }

        val topicsA2 = listOf(
            Triple("Shopping & Money", "Khariddari aur Paise", "🛒"),
            Triple("Directions & Places", "Raste aur Maqamat", "🧭"),
            Triple("Health & Body", "Sehat aur Jism", "🩺"),
            Triple("Work & Jobs", "Kaam aur Mulazmat", "💼"),
            Triple("Travel & Holidays", "Safar aur Chuttiyan", "✈️")
        )
        topicsA2.forEachIndexed { i, t ->
            list.add(createSampleLesson(langId, CefrLevel.A2, i + 1, t.first, t.second, t.third))
        }

        val topicsB1 = listOf(
            Triple("Opinions & Discussions", "Rai aur Guftagu", "💬"),
            Triple("Future Plans & Dreams", "Mustaqbil ke Mansoobe", "🚀"),
            Triple("Work & Career", "Kaam aur Career", "📈"),
            Triple("Environment & Nature", "Mahol aur Qudrat", "🌱")
        )
        topicsB1.forEachIndexed { i, t ->
            list.add(createSampleLesson(langId, CefrLevel.B1, i + 1, t.first, t.second, t.third))
        }
        list.add(workplaceB1)

        val topicsB2 = listOf(
            Triple("Debates & Arguments", "Behes aur Dalail", "⚖️"),
            Triple("Business & Meetings", "Business aur Meetings", "💼"),
            Triple("News & Society", "Khabrein aur Samaj", "📰"),
            Triple("Culture & Traditions", "Saqafat aur Rawayat", "🎭"),
            Triple("Formal Language", "Daftari aur Rasmi Zaban", "📑")
        )
        topicsB2.forEachIndexed { i, t ->
            list.add(createSampleLesson(langId, CefrLevel.B2, i + 1, t.first, t.second, t.third))
        }

        val topicsC1 = listOf(
            Triple("Academic Language", "Taleemi aur Tahqeeqi Zaban", "🎓"),
            Triple("Politics & Society", "Siyasat aur Samaj", "🏛️"),
            Triple("Literature & Arts", "Adab aur Funoon", "🎨"),
            Triple("Science & Research", "Science aur Research", "🔬"),
            Triple("Nuanced Opinions", "Gehri aur Barik Rai", "🧠")
        )
        topicsC1.forEachIndexed { i, t ->
            list.add(createSampleLesson(langId, CefrLevel.C1, i + 1, t.first, t.second, t.third))
        }

        val topicsC2 = listOf(
            Triple("Idioms & Expressions", "Muhawray aur Rozmarrah", "🎭"),
            Triple("Formal Writing", "Balaghat aur Tehreeq", "🖋️"),
            Triple("Humour & Irony", "Zarafat aur Tanz", "😄"),
            Triple("Near-Native Fluency", "Qabil-e-Rashk Rawani", "🗣️"),
            Triple("Debating Complex Topics", "Pechida Masail par Munazra", "🌐")
        )
        topicsC2.forEachIndexed { i, t ->
            list.add(createSampleLesson(langId, CefrLevel.C2, i + 1, t.first, t.second, t.third))
        }

        return list
    }

    private fun createSampleLesson(
        langId: String,
        level: CefrLevel,
        index: Int,
        title: String,
        romanTitle: String,
        emoji: String
    ): Lesson {
        val sentences = (1..8).map { num ->
            SentenceItem(
                id = "${langId}_${level.code.lowercase()}_${index}_$num",
                emoji = emoji,
                targetText = getTargetTextTemplate(langId, title, num),
                englishText = getEnglishTextTemplate(title, num),
                urduText = getUrduTextTemplate(title, num),
                romanUrduText = getRomanUrduTemplate(title, num)
            )
        }
        return Lesson(
            id = "${langId}_${level.code.lowercase()}_$index",
            languageId = langId,
            level = level,
            title = title,
            romanUrduTitle = romanTitle,
            iconEmoji = emoji,
            grammarTipRomanUrdu = "Is sabaq mein $romanTitle ke ahem jumlay seekhein.",
            grammarTipEn = "Focus on sentence structure for $title.",
            sentences = sentences
        )
    }

    private fun getTargetTextTemplate(lang: String, topic: String, num: Int): String {
        return when (lang) {
            "ar" -> "جُمْلَةٌ تَعْلِيمِيَّةٌ هَامَّةٌ فِي $topic ($num)"
            "fr" -> "Phrase essentielle pour $topic ($num)"
            "es" -> "Frase útil para $topic ($num)"
            "tr" -> "$topic için önemli cümle ($num)"
            "it" -> "Frase utile per $topic ($num)"
            "ru" -> "Полезная фраза для $topic ($num)"
            "zh" -> "$topic 实用句子 ($num)"
            "ko" -> "$topic 필수 문장 ($num)"
            "ja" -> "$topic に役立つ表現 ($num)"
            "pt" -> "Frase prática para $topic ($num)"
            "hi" -> "$topic के लिए उपयोगी वाक्य ($num)"
            "ps" -> "د $topic لپاره ګټوره جمله ($num)"
            "ur" -> "$topic کے لیے اہم اور مفید جملہ ($num)"
            else -> "Essential phrase for $topic ($num)"
        }
    }

    private fun getEnglishTextTemplate(topic: String, num: Int): String =
        "Practical and useful sentence for $topic (#$num)."

    private fun getUrduTextTemplate(topic: String, num: Int): String =
        "$topic کے لیے نہایت اہم اور روزمرہ استعمال کا جملہ (#$num)۔"

    private fun getRomanUrduTemplate(topic: String, num: Int): String =
        "$topic ke silsile mein rozmarrah ka ahem jumla (#$num)."
}
