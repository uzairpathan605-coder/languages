package com.example.data

import com.example.model.BasicCategory
import com.example.model.BasicItem

object BasicsDataRepository {
    fun getBasicsForLanguage(languageId: String): Map<BasicCategory, List<BasicItem>> {
        return BasicCategory.entries.associateWith { category ->
            getItems(languageId, category)
        }
    }

    private fun getItems(langId: String, category: BasicCategory): List<BasicItem> {
        return when (category) {
            BasicCategory.ALPHABET -> getAlphabetItems(langId)
            BasicCategory.DAYS -> getDaysItems(langId)
            BasicCategory.MONTHS -> getMonthsItems(langId)
            BasicCategory.NUMBERS -> getNumbersItems(langId)
            BasicCategory.COLOURS -> getColoursItems(langId)
            BasicCategory.QUESTIONS -> getQuestionItems(langId)
            BasicCategory.PHRASES -> getPhrasesItems(langId)
        }
    }

    private fun getAlphabetItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_b_a1", BasicCategory.ALPHABET, "A a", "Say: 'Ah' (like car)", "Letter A", "حرف A (آہ)", "A (Ah)"),
                BasicItem("de_b_b1", BasicCategory.ALPHABET, "B b", "Say: 'Bay'", "Letter B", "حرف B (بے)", "B (Bay)"),
                BasicItem("de_b_c1", BasicCategory.ALPHABET, "C c", "Say: 'Tsay'", "Letter C", "حرف C (تسئے)", "C (Tsay)"),
                BasicItem("de_b_d1", BasicCategory.ALPHABET, "D d", "Say: 'Day'", "Letter D", "حرف D (ڈے)", "D (Day)"),
                BasicItem("de_b_e1", BasicCategory.ALPHABET, "E e", "Say: 'Ay'", "Letter E", "حرف E (اے)", "E (Ay)"),
                BasicItem("de_b_ei", BasicCategory.ALPHABET, "EI / ei", "Say: 'Eye' (like my)", "Sound 'Ei' = Eye", "آواز 'Ei' (آئی)", "Sound: Eye"),
                BasicItem("de_b_ie", BasicCategory.ALPHABET, "IE / ie", "Say: 'Eee' (like see)", "Sound 'Ie' = Eeee", "آواز 'Ie' (لمبی ای)", "Sound: Eeee"),
                BasicItem("de_b_sch", BasicCategory.ALPHABET, "SCH / sch", "Say: 'Sh' (like shoe)", "Sound 'Sch' = Sh", "آواز 'Sch' (شین)", "Sound: Shh"),
                BasicItem("de_b_ch", BasicCategory.ALPHABET, "CH / ch", "Say: Soft 'kh' in throat", "Sound 'Ch' = Kh", "آواز 'Ch' (خے)", "Sound: Kh"),
                BasicItem("de_b_ae", BasicCategory.ALPHABET, "Ä ä", "Say: 'Eh' (like bed)", "Umlaut Ä", "حرف Ä (اے)", "A-Umlaut: Eh"),
                BasicItem("de_b_oe", BasicCategory.ALPHABET, "Ö ö", "Pucker lips, say 'Er'", "Umlaut Ö", "حرف Ö", "O-Umlaut: Er"),
                BasicItem("de_b_ue", BasicCategory.ALPHABET, "Ü ü", "Pucker lips, say 'Eee'", "Umlaut Ü", "حرف Ü", "U-Umlaut: Uee"),
                BasicItem("de_b_sz", BasicCategory.ALPHABET, "ß (Eszett)", "Say: Sharp 'ss'", "Sharp double S", "حرف ß (تیز سین)", "Eszett: Sharp S")
            )
        } else {
            listOf(
                BasicItem("${langId}_b_a", BasicCategory.ALPHABET, "A", "Pronounced as /eɪ/ or /a/", "Letter A", "حرف اے", "Pehla harf A"),
                BasicItem("${langId}_b_b", BasicCategory.ALPHABET, "B", "Pronounced as /b/", "Letter B", "حرف بی", "Harf B"),
                BasicItem("${langId}_b_c", BasicCategory.ALPHABET, "C", "Pronounced as /k/ or /s/", "Letter C", "حرف سی", "Harf C"),
                BasicItem("${langId}_b_d", BasicCategory.ALPHABET, "D", "Pronounced as /d/", "Letter D", "حرف ڈی", "Harf D"),
                BasicItem("${langId}_b_e", BasicCategory.ALPHABET, "E", "Pronounced as /iː/ or /e/", "Letter E", "حرف ای", "Harf E")
            )
        }
    }

    private fun getDaysItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_d_1", BasicCategory.DAYS, "Montag", "Say: 'Mon-tahk'", "Monday", "پیر", "Peer (Monday)"),
                BasicItem("de_d_2", BasicCategory.DAYS, "Dienstag", "Say: 'Deens-tahk'", "Tuesday", "منگل", "Mangal (Tuesday)"),
                BasicItem("de_d_3", BasicCategory.DAYS, "Mittwoch", "Say: 'Mit-vokh'", "Wednesday", "بدھ", "Budh (Wednesday)"),
                BasicItem("de_d_4", BasicCategory.DAYS, "Donnerstag", "Say: 'Don-ers-tahk'", "Thursday", "جمعرات", "Jumerat (Thursday)"),
                BasicItem("de_d_5", BasicCategory.DAYS, "Freitag", "Say: 'Fry-tahk'", "Friday", "جمعہ", "Jummah (Friday)"),
                BasicItem("de_d_6", BasicCategory.DAYS, "Samstag", "Say: 'Zams-tahk'", "Saturday", "ہفتہ", "Hafta (Saturday)"),
                BasicItem("de_d_7", BasicCategory.DAYS, "Sonntag", "Say: 'Zon-tahk'", "Sunday", "اتوار", "Itwar (Sunday)")
            )
        } else {
            listOf(
                BasicItem("${langId}_d_1", BasicCategory.DAYS, "Monday", "Say: 'Mun-day'", "Monday", "پیر", "Peer (Monday)"),
                BasicItem("${langId}_d_2", BasicCategory.DAYS, "Tuesday", "Say: 'Tewz-day'", "Tuesday", "منگل", "Mangal (Tuesday)"),
                BasicItem("${langId}_d_3", BasicCategory.DAYS, "Wednesday", "Say: 'Wenz-day'", "Wednesday", "بدھ", "Budh (Wednesday)"),
                BasicItem("${langId}_d_4", BasicCategory.DAYS, "Thursday", "Say: 'Thurz-day'", "Thursday", "جمعرات", "Jumerat (Thursday)"),
                BasicItem("${langId}_d_5", BasicCategory.DAYS, "Friday", "Say: 'Fry-day'", "Friday", "جمعہ", "Jummah (Friday)"),
                BasicItem("${langId}_d_6", BasicCategory.DAYS, "Saturday", "Say: 'Sat-er-day'", "Saturday", "ہفتہ", "Hafta (Saturday)"),
                BasicItem("${langId}_d_7", BasicCategory.DAYS, "Sunday", "Say: 'Sun-day'", "Sunday", "اتوار", "Itwar (Sunday)")
            )
        }
    }

    private fun getMonthsItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_m_1", BasicCategory.MONTHS, "Januar", "Say: 'Yah-noo-ahr'", "January", "جنوری", "Janwari"),
                BasicItem("de_m_2", BasicCategory.MONTHS, "Februar", "Say: 'Fay-broo-ahr'", "February", "فروری", "Farwari"),
                BasicItem("de_m_3", BasicCategory.MONTHS, "März", "Say: 'Mehrts'", "March", "مارچ", "March"),
                BasicItem("de_m_4", BasicCategory.MONTHS, "April", "Say: 'Ah-pril'", "April", "اپریل", "April"),
                BasicItem("de_m_5", BasicCategory.MONTHS, "Mai", "Say: 'My'", "May", "مئی", "May"),
                BasicItem("de_m_6", BasicCategory.MONTHS, "Juni", "Say: 'Yoo-nee'", "June", "جون", "June"),
                BasicItem("de_m_7", BasicCategory.MONTHS, "Juli", "Say: 'Yoo-lee'", "July", "جولائی", "July"),
                BasicItem("de_m_8", BasicCategory.MONTHS, "August", "Say: 'Ow-goost'", "August", "اگست", "August"),
                BasicItem("de_m_9", BasicCategory.MONTHS, "September", "Say: 'Zep-tem-ber'", "September", "ستمبر", "September"),
                BasicItem("de_m_10", BasicCategory.MONTHS, "Oktober", "Say: 'Ok-toh-ber'", "October", "اکتوبر", "October"),
                BasicItem("de_m_11", BasicCategory.MONTHS, "November", "Say: 'No-vem-ber'", "November", "نومبر", "November"),
                BasicItem("de_m_12", BasicCategory.MONTHS, "Dezember", "Say: 'Day-tsem-ber'", "December", "دسمبر", "December")
            )
        } else {
            listOf(
                BasicItem("${langId}_m_1", BasicCategory.MONTHS, "January", "Say: 'Jan-yoo-airy'", "January", "جنوری", "January"),
                BasicItem("${langId}_m_2", BasicCategory.MONTHS, "February", "Say: 'Feb-roo-airy'", "February", "فروری", "February"),
                BasicItem("${langId}_m_3", BasicCategory.MONTHS, "March", "Say: 'Mahrtch'", "March", "مارچ", "March"),
                BasicItem("${langId}_m_4", BasicCategory.MONTHS, "April", "Say: 'Ay-pril'", "April", "اپریل", "April"),
                BasicItem("${langId}_m_5", BasicCategory.MONTHS, "May", "Say: 'May'", "May", "مئی", "May"),
                BasicItem("${langId}_m_6", BasicCategory.MONTHS, "June", "Say: 'Joon'", "June", "جون", "June"),
                BasicItem("${langId}_m_7", BasicCategory.MONTHS, "July", "Say: 'Joo-lye'", "July", "جولائی", "July"),
                BasicItem("${langId}_m_8", BasicCategory.MONTHS, "August", "Say: 'Aw-gust'", "August", "اگست", "August"),
                BasicItem("${langId}_m_9", BasicCategory.MONTHS, "September", "Say: 'Sep-tem-ber'", "September", "ستمبر", "September"),
                BasicItem("${langId}_m_10", BasicCategory.MONTHS, "October", "Say: 'Ok-toh-ber'", "October", "اکتوبر", "October"),
                BasicItem("${langId}_m_11", BasicCategory.MONTHS, "November", "Say: 'No-vem-ber'", "November", "نومبر", "November"),
                BasicItem("${langId}_m_12", BasicCategory.MONTHS, "December", "Say: 'Dee-sem-ber'", "December", "دسمبر", "December")
            )
        }
    }

    private fun getNumbersItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_n_0", BasicCategory.NUMBERS, "0 = Null", "Say: 'Nool'", "Zero", "صفر", "Sifar (0)"),
                BasicItem("de_n_1", BasicCategory.NUMBERS, "1 = Eins", "Say: 'Iynts'", "One", "ایک", "Ek (1)"),
                BasicItem("de_n_2", BasicCategory.NUMBERS, "2 = Zwei", "Say: 'Tsvy'", "Two", "دو", "Do (2)"),
                BasicItem("de_n_3", BasicCategory.NUMBERS, "3 = Drei", "Say: 'Dry'", "Three", "تین", "Teen (3)"),
                BasicItem("de_n_4", BasicCategory.NUMBERS, "4 = Vier", "Say: 'Feer'", "Four", "چار", "Char (4)"),
                BasicItem("de_n_5", BasicCategory.NUMBERS, "5 = Fünf", "Say: 'Fewnf'", "Five", "پانچ", "Paanch (5)"),
                BasicItem("de_n_10", BasicCategory.NUMBERS, "10 = Zehn", "Say: 'Tsayn'", "Ten", "دس", "Das (10)"),
                BasicItem("de_n_20", BasicCategory.NUMBERS, "20 = Zwanzig", "Say: 'Tsvan-tsikh'", "Twenty", "بیس", "Bees (20)"),
                BasicItem("de_n_50", BasicCategory.NUMBERS, "50 = Fünfzig", "Say: 'Fewnf-tsikh'", "Fifty", "پچاس", "Pachaas (50)"),
                BasicItem("de_n_100", BasicCategory.NUMBERS, "100 = Hundert", "Say: 'Hoon-dert'", "One Hundred", "سو", "Sau (100)"),
                BasicItem("de_n_500", BasicCategory.NUMBERS, "500 = Fünfhundert", "Say: 'Fewnf-hoon-dert'", "Five Hundred", "پانچ سو", "Paanch sau (500)"),
                BasicItem("de_n_1000", BasicCategory.NUMBERS, "1000 = Tausend", "Say: 'Tow-zent'", "One Thousand", "ایک ہزار", "Ek Hazar (1000)")
            )
        } else {
            listOf(
                BasicItem("${langId}_n_0", BasicCategory.NUMBERS, "0 = Zero", "Say: 'Zee-ro'", "Zero", "صفر", "Zero (0)"),
                BasicItem("${langId}_n_1", BasicCategory.NUMBERS, "1 = One", "Say: 'Wun'", "One", "ایک", "Ek (1)"),
                BasicItem("${langId}_n_2", BasicCategory.NUMBERS, "2 = Two", "Say: 'Too'", "Two", "دو", "Do (2)"),
                BasicItem("${langId}_n_5", BasicCategory.NUMBERS, "5 = Five", "Say: 'Fyve'", "Five", "پانچ", "Paanch (5)"),
                BasicItem("${langId}_n_10", BasicCategory.NUMBERS, "10 = Ten", "Say: 'Ten'", "Ten", "دس", "Das (10)"),
                BasicItem("${langId}_n_100", BasicCategory.NUMBERS, "100 = Hundred", "Say: 'Hun-dred'", "Hundred", "سو", "Sau (100)"),
                BasicItem("${langId}_n_1000", BasicCategory.NUMBERS, "1000 = Thousand", "Say: 'Thow-zand'", "Thousand", "ہزار", "Hazar (1000)")
            )
        }
    }

    private fun getColoursItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_c_1", BasicCategory.COLOURS, "Rot 🔴", "Say: 'Roht'", "Red", "سرخ / لال", "Laal / Surkh"),
                BasicItem("de_c_2", BasicCategory.COLOURS, "Blau 🔵", "Say: 'Blow'", "Blue", "نیلا", "Neela"),
                BasicItem("de_c_3", BasicCategory.COLOURS, "Grün 🟢", "Say: 'Grew-n'", "Green", "سبز / ہرا", "Sabz / Hara"),
                BasicItem("de_c_4", BasicCategory.COLOURS, "Gelb 🟡", "Say: 'Gelp'", "Yellow", "پیلا", "Peela"),
                BasicItem("de_c_5", BasicCategory.COLOURS, "Schwarz ⚫", "Say: 'Shvarts'", "Black", "کالا / سیاہ", "Kala / Siyah"),
                BasicItem("de_c_6", BasicCategory.COLOURS, "Weiß ⚪", "Say: 'Vice'", "White", "سفید", "Safaid"),
                BasicItem("de_c_7", BasicCategory.COLOURS, "Braun 🟤", "Say: 'Brown'", "Brown", "بھورا", "Bhoora")
            )
        } else {
            listOf(
                BasicItem("${langId}_c_1", BasicCategory.COLOURS, "Red 🔴", "Say: 'Red'", "Red", "لال", "Laal"),
                BasicItem("${langId}_c_2", BasicCategory.COLOURS, "Blue 🔵", "Say: 'Bloo'", "Blue", "نیلا", "Neela"),
                BasicItem("${langId}_c_3", BasicCategory.COLOURS, "Green 🟢", "Say: 'Green'", "Green", "سبز", "Sabz"),
                BasicItem("${langId}_c_4", BasicCategory.COLOURS, "Yellow 🟡", "Say: 'Yel-oh'", "Yellow", "پیلا", "Peela"),
                BasicItem("${langId}_c_5", BasicCategory.COLOURS, "Black ⚫", "Say: 'Blak'", "Black", "کالا", "Kala"),
                BasicItem("${langId}_c_6", BasicCategory.COLOURS, "White ⚪", "Say: 'Wyte'", "White", "سفید", "Safaid")
            )
        }
    }

    private fun getQuestionItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_q_1", BasicCategory.QUESTIONS, "Wer?", "Say: 'Vair'", "Who?", "کون؟", "Kaun?"),
                BasicItem("de_q_2", BasicCategory.QUESTIONS, "Was?", "Say: 'Vahs'", "What?", "کیا؟", "Kya?"),
                BasicItem("de_q_3", BasicCategory.QUESTIONS, "Wo?", "Say: 'Voh'", "Where?", "کہاں؟", "Kahan?"),
                BasicItem("de_q_4", BasicCategory.QUESTIONS, "Wann?", "Say: 'Vahn'", "When?", "کب؟", "Kab?"),
                BasicItem("de_q_5", BasicCategory.QUESTIONS, "Warum?", "Say: 'Vah-room'", "Why?", "کیوں؟", "Kyun?"),
                BasicItem("de_q_6", BasicCategory.QUESTIONS, "Wie?", "Say: 'Vee'", "How?", "کیسے؟", "Kaise?"),
                BasicItem("de_q_7", BasicCategory.QUESTIONS, "Wie viel?", "Say: 'Vee feel'", "How much?", "کتنا؟", "Kitna?"),
                BasicItem("de_q_8", BasicCategory.QUESTIONS, "Wohin?", "Say: 'Voh-hin'", "Where to?", "کہاں کو؟", "Kahan ko (direction)?")
            )
        } else {
            listOf(
                BasicItem("${langId}_q_1", BasicCategory.QUESTIONS, "Who?", "Say: 'Hoo'", "Who?", "کون؟", "Kaun?"),
                BasicItem("${langId}_q_2", BasicCategory.QUESTIONS, "What?", "Say: 'Wut'", "What?", "کیا؟", "Kya?"),
                BasicItem("${langId}_q_3", BasicCategory.QUESTIONS, "Where?", "Say: 'Wair'", "Where?", "کہاں؟", "Kahan?"),
                BasicItem("${langId}_q_4", BasicCategory.QUESTIONS, "When?", "Say: 'Wen'", "When?", "کب؟", "Kab?"),
                BasicItem("${langId}_q_5", BasicCategory.QUESTIONS, "Why?", "Say: 'Wye'", "Why?", "کیوں؟", "Kyun?"),
                BasicItem("${langId}_q_6", BasicCategory.QUESTIONS, "How?", "Say: 'How'", "How?", "کیسے؟", "Kaise?")
            )
        }
    }

    private fun getPhrasesItems(langId: String): List<BasicItem> {
        return if (langId == "de") {
            listOf(
                BasicItem("de_p_1", BasicCategory.PHRASES, "Bitte", "Say: 'Bit-teh'", "Please / You're welcome", "براہ کرم / خوش آمدید", "Please / Welcome"),
                BasicItem("de_p_2", BasicCategory.PHRASES, "Danke schön", "Say: 'Dahn-keh shern'", "Thank you very much", "بہت بہت شکریہ", "Bohot shukriya"),
                BasicItem("de_p_3", BasicCategory.PHRASES, "Entschuldigung", "Say: 'Ent-shool-dee-goong'", "Excuse me / Sorry", "معاف کیجیے گا", "Maaf kijiye ga"),
                BasicItem("de_p_4", BasicCategory.PHRASES, "Ja / Nein", "Say: 'Yah' / 'Nine'", "Yes / No", "ہاں / نہیں", "Haan / Nahi"),
                BasicItem("de_p_5", BasicCategory.PHRASES, "Kein Problem", "Say: 'Kyne pro-blaym'", "No problem", "کوئی مسئلہ نہیں", "Koi masla nahi"),
                BasicItem("de_p_6", BasicCategory.PHRASES, "Ich verstehe nicht", "Say: 'Ikh fer-shtay-eh nikht'", "I do not understand", "مجھے سمجھ نہیں آئی", "Mujhe samajh nahi aayi"),
                BasicItem("de_p_7", BasicCategory.PHRASES, "Sprechen Sie Englisch?", "Say: 'Shprekh-en zee eng-lish'", "Do you speak English?", "کیا آپ انگریزی بولتے ہیں؟", "Kya aap English bolte hain?")
            )
        } else {
            listOf(
                BasicItem("${langId}_p_1", BasicCategory.PHRASES, "Please", "Say: 'Pleez'", "Please", "براہ کرم", "Please"),
                BasicItem("${langId}_p_2", BasicCategory.PHRASES, "Thank you", "Say: 'Thank yoo'", "Thank you", "شکریہ", "Shukriya"),
                BasicItem("${langId}_p_3", BasicCategory.PHRASES, "Excuse me", "Say: 'Ex-kyooz mee'", "Excuse me", "معاف کیجیے گا", "Maaf kijiye ga"),
                BasicItem("${langId}_p_4", BasicCategory.PHRASES, "Yes / No", "Say: 'Yes / No'", "Yes / No", "ہاں / نہیں", "Haan / Nahi"),
                BasicItem("${langId}_p_5", BasicCategory.PHRASES, "No problem", "Say: 'No prob-lem'", "No problem", "کوئی بات نہیں", "Koi baat nahi")
            )
        }
    }
}
