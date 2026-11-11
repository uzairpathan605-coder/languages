package com.example.data

import com.example.model.CefrLevel
import com.example.model.Lesson
import com.example.model.SentenceItem

object GermanCourseContent {
    fun getLessons(): List<Lesson> {
        return listOf(
            // A1
            createA1Lesson1(),
            createA1Lesson2(),
            createA1Lesson3(),
            createA1Lesson4(),
            createA1Lesson5(),

            // A2
            createA2Lesson1(),
            createA2Lesson2(),
            createA2Lesson3(),
            createA2Lesson4(),
            createA2Lesson5(),

            // B1 (includes Workplace for Every Worker)
            createB1Lesson1(),
            createB1Lesson2(),
            createB1Lesson3(),
            createB1Lesson4(),
            createB1WorkplaceLesson(),

            // B2 (German Job focus!)
            createB2Lesson1(),
            createB2Lesson2(),
            createB2Lesson3(),
            createB2Lesson4(),
            createB2Lesson5(),

            // C1
            createC1Lesson1(),
            createC1Lesson2(),
            createC1Lesson3(),
            createC1Lesson4(),
            createC1Lesson5(),

            // C2
            createC2Lesson1(),
            createC2Lesson2(),
            createC2Lesson3(),
            createC2Lesson4(),
            createC2Lesson5()
        )
    }

    private fun createA1Lesson1() = Lesson(
        id = "de_a1_1",
        languageId = "de",
        level = CefrLevel.A1,
        title = "Greetings & Introductions",
        romanUrduTitle = "Salam-Dua aur Ta'aruf",
        iconEmoji = "👋",
        grammarTipRomanUrdu = "German mein 'Sie' ba-adab (formal) ke liye use hota hai aur 'du' doston ke liye.",
        grammarTipEn = "Use 'Sie' for formal respect and 'du' for informal friends.",
        sentences = listOf(
            SentenceItem("de_a1_1_1", "👋", "Guten Morgen!", "Good morning!", "صبح بخیر!", "Guten Morgen! (Subah bakhair!)"),
            SentenceItem("de_a1_1_2", "🤝", "Hallo, wie geht es Ihnen?", "Hello, how are you? (formal)", "ہیلو، آپ کا کیا حال ہے؟", "Hallo, aap kaise hain? (ba-adab)"),
            SentenceItem("de_a1_1_3", "😊", "Mir geht es gut, danke.", "I am doing well, thank you.", "میں ٹھیک ہوں، شکریہ۔", "Main theek hoon, shukriya."),
            SentenceItem("de_a1_1_4", "🏷️", "Ich heiße Ali.", "My name is Ali.", "میرا نام علی ہے۔", "Mera naam Ali hai."),
            SentenceItem("de_a1_1_5", "🇵🇰", "Ich komme aus Pakistan.", "I come from Pakistan.", "میرا تعلق پاکستان سے ہے۔", "Main Pakistan se aya hoon."),
            SentenceItem("de_a1_1_6", "🏙️", "Ich wohne in Berlin.", "I live in Berlin.", "میں برلن میں رہتا ہوں۔", "Main Berlin mein rehta hoon."),
            SentenceItem("de_a1_1_7", "🗣️", "Ich lerne Deutsch.", "I am learning German.", "میں جرمن زبان سیکھ رہا ہوں۔", "Main German seekh raha hoon."),
            SentenceItem("de_a1_1_8", "🙋‍♂️", "Auf Wiedersehen!", "Goodbye!", "الوداع! / پھر ملیں گے!", "Phir milenge! (Goodbye)")
        )
    )

    private fun createA1Lesson2() = Lesson(
        id = "de_a1_2",
        languageId = "de",
        level = CefrLevel.A1,
        title = "Numbers, Days & Time",
        romanUrduTitle = "Ginti, Din aur Waqt",
        iconEmoji = "🕗",
        grammarTipRomanUrdu = "German mein waqt batate waqt 'Uhr' ka lafz istemal hota hai (e.g. 8 Uhr = 8 baje).",
        grammarTipEn = "State time using 'Uhr' (e.g., Es ist acht Uhr = It is 8 o'clock).",
        sentences = listOf(
            SentenceItem("de_a1_2_1", "🔢", "Eins, zwei, drei, vier, fünf.", "One, two, three, four, five.", "ایک، دو، تین، چار، پانچ۔", "Ek, do, teen, char, paanch."),
            SentenceItem("de_a1_2_2", "📅", "Heute ist Montag.", "Today is Monday.", "آج پیر کا دن ہے۔", "Aaj Peer (Monday) hai."),
            SentenceItem("de_a1_2_3", "🗓️", "Morgen ist Dienstag.", "Tomorrow is Tuesday.", "کل منگل کا دن ہے۔", "Kal Mangal hai."),
            SentenceItem("de_a1_2_4", "⏰", "Wie spät ist es?", "What time is it?", "کیا وقت ہوا ہے؟", "Kitne baje hain?"),
            SentenceItem("de_a1_2_5", "🕗", "Es ist acht Uhr morgens.", "It is eight o'clock in the morning.", "صبح کے آٹھ بجے ہیں۔", "Subah ke aath baje hain."),
            SentenceItem("de_a1_2_6", "⏳", "Ich habe keine Zeit.", "I have no time.", "میرے پاس وقت نہیں ہے۔", "Mere paas waqt nahi hai."),
            SentenceItem("de_a1_2_7", "📆", "Das Wochenende ist kurz.", "The weekend is short.", "ہفتہ وار چھٹی مختصر ہے۔", "Weekend chota hai."),
            SentenceItem("de_a1_2_8", "🎯", "Um wie viel Uhr treffen wir uns?", "At what time do we meet?", "ہم کتنے بجے ملیں گے؟", "Hum kis waqt milenge?")
        )
    )

    private fun createA1Lesson3() = Lesson(
        id = "de_a1_3",
        languageId = "de",
        level = CefrLevel.A1,
        title = "Family & Friends",
        romanUrduTitle = "Khandan aur Dost",
        iconEmoji = "👨‍👩‍👦",
        grammarTipRomanUrdu = "German mein muzakkar (male) ke liye 'mein' aur muannas (female) ke liye 'meine' lagta hai.",
        grammarTipEn = "Use 'mein' for masculine/neuter and 'meine' for feminine nouns.",
        sentences = listOf(
            SentenceItem("de_a1_3_1", "👨", "Das ist mein Vater.", "This is my father.", "یہ میرے والد ہیں۔", "Ye mere abbu hain."),
            SentenceItem("de_a1_3_2", "👩", "Das ist meine Mutter.", "This is my mother.", "یہ میری والدہ ہیں۔", "Ye meri ammi hain."),
            SentenceItem("de_a1_3_3", "👦", "Ich habe einen Bruder.", "I have a brother.", "میرا ایک بھائی ہے۔", "Mera ek bhai hai."),
            SentenceItem("de_a1_3_4", "👧", "Ich habe eine Schwester.", "I have a sister.", "میری ایک بہن ہے۔", "Meri ek behen hai."),
            SentenceItem("de_a1_3_5", "🧑‍🤝‍🧑", "Er ist mein bester Freund.", "He is my best friend.", "وہ میرا بہترین دوست ہے۔", "Wo mera behtareen dost hai."),
            SentenceItem("de_a1_3_6", "🏡", "Meine Familie ist groß.", "My family is big.", "میرا خاندان بڑا ہے۔", "Mera khandan bada hai."),
            SentenceItem("de_a1_3_7", "👶", "Mein Kind ist drei Jahre alt.", "My child is three years old.", "میرا بچہ تین سال کا ہے۔", "Mera bacha 3 saal ka hai."),
            SentenceItem("de_a1_3_8", "❤️", "Ich liebe meine Familie.", "I love my family.", "مجھے اپنے خاندان سے پیار ہے۔", "Mujhe apne khandan se muhabbat hai.")
        )
    )

    private fun createA1Lesson4() = Lesson(
        id = "de_a1_4",
        languageId = "de",
        level = CefrLevel.A1,
        title = "Food & Drink",
        romanUrduTitle = "Khana aur Peena",
        iconEmoji = "🍕",
        grammarTipRomanUrdu = "Pasand batane ke liye 'möchten' (chahna) ya 'essen' (khana) ka istemal karein.",
        grammarTipEn = "Use 'Ich möchte...' to politely order food or drinks.",
        sentences = listOf(
            SentenceItem("de_a1_4_1", "💧", "Ich trinke gerne Wasser.", "I like drinking water.", "میں شوق سے پانی پیتا ہوں۔", "Main paani peeta hoon."),
            SentenceItem("de_a1_4_2", "☕", "Ein Kaffee bitte, ohne Zucker.", "A coffee please, without sugar.", "ایک کافی بغیر چینی کے پلیز۔", "Ek coffee baghair cheeni ke please."),
            SentenceItem("de_a1_4_3", "🥖", "Das Brot ist sehr frisch.", "The bread is very fresh.", "روٹی / ڈبل روٹی بہت تازہ ہے۔", "Roti bohot taaza hai."),
            SentenceItem("de_a1_4_4", "🍽️", "Guten Appetit!", "Enjoy your meal!", "کھانا مبارک ہو!", "Khana noosh farmayein!"),
            SentenceItem("de_a1_4_5", "🤤", "Ich habe großen Hunger.", "I am very hungry.", "مجھے سخت بھوک لگی ہے۔", "Mujhe bohot bhook lagi hai."),
            SentenceItem("de_a1_4_6", "🍵", "Möchten Sie Tee?", "Would you like some tea?", "کیا آپ چائے پسند کریں گے؟", "Kya aap chai lenge?"),
            SentenceItem("de_a1_4_7", "🥗", "Das Essen schmeckt lecker.", "The food tastes delicious.", "کھانا بہت لذیذ ہے۔", "Khana bohot mazedar hai."),
            SentenceItem("de_a1_4_8", "💳", "Die Rechnung, bitte.", "The bill, please.", "بل لائیے، پلیز۔", "Bill laiye please.")
        )
    )

    private fun createA1Lesson5() = Lesson(
        id = "de_a1_5",
        languageId = "de",
        level = CefrLevel.A1,
        title = "Daily Routine",
        romanUrduTitle = "Rozmarah ka Mamool",
        iconEmoji = "🌅",
        grammarTipRomanUrdu = "German mein rozana ke kaam ke liye fel (verb) doosre number par ata hai.",
        grammarTipEn = "In German main clauses, the conjugated verb is always in position 2.",
        sentences = listOf(
            SentenceItem("de_a1_5_1", "⏰", "Ich stehe um sechs Uhr auf.", "I wake up at six o'clock.", "میں صبح چھ بجے اٹھتا ہوں۔", "Main 6 baje uthta hoon."),
            SentenceItem("de_a1_5_2", "🚿", "Ich dusche mich jeden Morgen.", "I take a shower every morning.", "میں ہر صبح نہاتا ہوں۔", "Main har subah nahata hoon."),
            SentenceItem("de_a1_5_3", "🍳", "Ich frühstücke um sieben Uhr.", "I eat breakfast at seven.", "میں سات بجے ناشتہ کرتا ہوں۔", "Main saat baje nashta karta hoon."),
            SentenceItem("de_a1_5_4", "🚌", "Ich fahre mit dem Bus zur Arbeit.", "I go to work by bus.", "میں بس سے کام پر جاتا ہوں۔", "Main bus se kaam par jata hoon."),
            SentenceItem("de_a1_5_5", "💻", "Ich arbeite von acht bis fünf.", "I work from eight to five.", "میں آٹھ سے پانچ بجے تک کام کرتا ہوں۔", "Main 8 se 5 kaam karta hoon."),
            SentenceItem("de_a1_5_6", "🏠", "Um sechs Uhr komme ich nach Hause.", "At six o'clock I come home.", "میں چھ بجے گھر آتا ہوں۔", "Main 6 baje ghar wapas aata hoon."),
            SentenceItem("de_a1_5_7", "📖", "Abends lerne ich Deutsch.", "In the evening I study German.", "شام کو میں جرمن زبان پڑھتا ہوں۔", "Shaam ko main German seekhta hoon."),
            SentenceItem("de_a1_5_8", "🛏️", "Ich gehe um elf Uhr schlafen.", "I go to sleep at eleven o'clock.", "میں گیارہ بجے سونے جاتا ہوں۔", "Main 11 baje so jata hoon.")
        )
    )

    // A2 Lessons
    private fun createA2Lesson1() = Lesson(
        id = "de_a2_1",
        languageId = "de",
        level = CefrLevel.A2,
        title = "Shopping & Money",
        romanUrduTitle = "Khariddari aur Paise",
        iconEmoji = "🛒",
        grammarTipRomanUrdu = "Qeemat poochne ke liye 'Wie viel kostet...' istemal hota hai.",
        grammarTipEn = "Use 'Wie viel kostet das?' to ask how much something costs.",
        sentences = listOf(
            SentenceItem("de_a2_1_1", "🏷️", "Wie viel kostet diese Jacke?", "How much does this jacket cost?", "اس جیکٹ کی کیا قیمت ہے؟", "Is jacket ki kya qeemat hai?"),
            SentenceItem("de_a2_1_2", "💶", "Das kostet zwanzig Euro.", "That costs twenty euros.", "اس کی قیمت بیس یورو ہے۔", "Is ki qeemat 20 Euro hai."),
            SentenceItem("de_a2_1_3", "💳", "Kann ich mit Karte zahlen?", "Can I pay by card?", "کیا میں کارڈ سے ادائیگی کر سکتا ہوں؟", "Kya main card se pay kar sakta hoon?"),
            SentenceItem("de_a2_1_4", "🪙", "Ich habe nur Bargeld dabei.", "I only have cash with me.", "میرے پاس صرف نقدی ہے۔", "Mere paas sirf cash hai."),
            SentenceItem("de_a2_1_5", "🛍️", "Ich brauche eine Plastiktüte.", "I need a shopping bag.", "مجھے ایک شاپنگ بیگ چاہیے۔", "Mujhe ek shopping bag chahiye."),
            SentenceItem("de_a2_1_6", "💸", "Das ist mir etwas zu teuer.", "That is a bit too expensive for me.", "یہ میرے لیے تھوڑا مہنگا ہے۔", "Ye mere liye thoda mehnga hai."),
            SentenceItem("de_a2_1_7", "🏷️", "Gibt es hier Rabatt?", "Is there a discount here?", "کیا یہاں رعایت (ڈسکاؤنٹ) ہے؟", "Kya yahan discount hai?"),
            SentenceItem("de_a2_1_8", "🧾", "Geben Sie mir bitte den Kassenbon.", "Please give me the receipt.", "براہ کرم مجھے رسید دیں۔", "Mujhe receipt de dijiye please.")
        )
    )

    private fun createA2Lesson2() = Lesson(
        id = "de_a2_2",
        languageId = "de",
        level = CefrLevel.A2,
        title = "Directions & Places",
        romanUrduTitle = "Raste aur Maqamat",
        iconEmoji = "🧭",
        grammarTipRomanUrdu = "Rasta batane ke liye: geradeaus (seedha), links (baayein), rechts (daayein).",
        grammarTipEn = "German directions: geradeaus (straight), links (left), rechts (right).",
        sentences = listOf(
            SentenceItem("de_a2_2_1", "📍", "Entschuldigung, wo ist der Bahnhof?", "Excuse me, where is the train station?", "معاف کیجیے گا، ریلوے اسٹیشن کہاں ہے؟", "Excuse me, railway station kahan hai?"),
            SentenceItem("de_a2_2_2", "➡️", "Gehen Sie bitte geradeaus.", "Please go straight ahead.", "براہ کرم بالکل سیدھے جائیں۔", "Please seedha jayein."),
            SentenceItem("de_a2_2_3", "↩️", "Biegen Sie an der Ampel links ab.", "Turn left at the traffic light.", "ٹریفک سگنل سے بائیں مڑیں۔", "Traffic light se left mudein."),
            SentenceItem("de_a2_2_4", "🏥", "Das Krankenhaus ist auf der rechten Seite.", "The hospital is on the right side.", "ہسپتال دائیں جانب ہے۔", "Hospital right side par hai."),
            SentenceItem("de_a2_2_5", "🗺️", "Wie weit ist das von hier?", "How far is that from here?", "یہاں سے وہ کتنی دور ہے؟", "Yahan se kitni door hai?"),
            SentenceItem("de_a2_2_6", "🚶", "Es ist fünf Minuten zu Fuß.", "It is five minutes on foot.", "یہ پانچ منٹ کا پیدل راستہ ہے۔", "Paanch minute ka paidal rasta hai."),
            SentenceItem("de_a2_2_7", "🚌", "Welcher Bus fährt ins Zentrum?", "Which bus goes to the city center?", "کون سی بس شہر کے مرکز جاتی ہے؟", "Kaunsi bus city center jati hai?"),
            SentenceItem("de_a2_2_8", "🆘", "Ich habe mich verirrt.", "I am lost.", "میں راستہ بھول گیا ہوں۔", "Main rasta bhatak gaya hoon.")
        )
    )

    private fun createA2Lesson3() = Lesson(
        id = "de_a2_3",
        languageId = "de",
        level = CefrLevel.A2,
        title = "Health & Body",
        romanUrduTitle = "Sehat aur Jism",
        iconEmoji = "🩺",
        grammarTipRomanUrdu = "Dard batane ke liye: 'Ich habe Kopfschmerzen' ya 'Mein Kopf tut weh'.",
        grammarTipEn = "Express pain: 'Ich habe...-schmerzen' or 'Mein... tut weh'.",
        sentences = listOf(
            SentenceItem("de_a2_3_1", "🤕", "Ich habe starke Kopfschmerzen.", "I have a severe headache.", "مجھے شدید سر درد ہے۔", "Mujhe bohot sar dard hai."),
            SentenceItem("de_a2_3_2", "🤒", "Ich fühle mich krank und habe Fieber.", "I feel sick and have a fever.", "میری طبیعت خراب ہے اور بخار ہے۔", "Meri tabiyat kharab hai aur bukhar hai."),
            SentenceItem("de_a2_3_3", "👨‍⚕️", "Ich brauche einen Termin beim Arzt.", "I need an appointment with the doctor.", "مجھے ڈاکٹر سے وقت (اپوائنٹمنٹ) چاہیے۔", "Mujhe doctor ka appointment chahiye."),
            SentenceItem("de_a2_3_4", "💊", "Nehmen Sie diese Tablette nach dem Essen.", "Take this tablet after eating.", "یہ گولی کھانے کے بعد لیں۔", "Ye tablet khane ke baad lein."),
            SentenceItem("de_a2_3_5", "😷", "Ich habe Husten und Halsschmerzen.", "I have a cough and a sore throat.", "مجھے کھانسی اور گلے میں درد ہے۔", "Mujhe khansi aur gale mein dard hai."),
            SentenceItem("de_a2_3_6", "🏥", "Ich muss zur Apotheke gehen.", "I must go to the pharmacy.", "مجھے میڈیکل اسٹور (فارمیسی) جانا ہے۔", "Mujhe pharmacy jana hai."),
            SentenceItem("de_a2_3_7", "🩺", "Gute Besserung!", "Get well soon!", "اللہ آپ کو جلد صحت دے!", "Jald sehatyab hon!"),
            SentenceItem("de_a2_3_8", "🩹", "Wo ist die Notaufnahme?", "Where is the emergency room?", "ایمرجنسی وارڈ کہاں ہے؟", "Emergency room kahan hai?")
        )
    )

    private fun createA2Lesson4() = Lesson(
        id = "de_a2_4",
        languageId = "de",
        level = CefrLevel.A2,
        title = "Work & Jobs",
        romanUrduTitle = "Kaam aur Mulazmat",
        iconEmoji = "💼",
        grammarTipRomanUrdu = "Pesha batane ke liye 'Ich arbeite als...' (Main bataur... kaam karta hoon).",
        grammarTipEn = "Use 'Ich arbeite als [profession]' to state your job role.",
        sentences = listOf(
            SentenceItem("de_a2_4_1", "👷", "Ich arbeite als Fachkraft.", "I work as a skilled specialist.", "میں بطور ہنر مند ورکر کام کرتا ہوں۔", "Main bataur skilled worker kaam karta hoon."),
            SentenceItem("de_a2_4_2", "⏰", "Meine Arbeitszeit beginnt um sieben.", "My working hours start at seven.", "میرے کام کا وقت سات بجے شروع ہوتا ہے۔", "Mera kaam 7 baje shuru hota hai."),
            SentenceItem("de_a2_4_3", "👔", "Mein Kollege ist sehr hilfsbereit.", "My colleague is very helpful.", "میرا ساتھی ورکر بہت مددگار ہے۔", "Mera colleague bohot helpful hai."),
            SentenceItem("de_a2_4_4", "🏭", "Ich arbeite in einem großen Betrieb.", "I work in a large company / facility.", "میں ایک بڑی کمپنی میں کام کرتا ہوں۔", "Main ek badi company mein kaam karta hoon."),
            SentenceItem("de_a2_4_5", "🤝", "Wir arbeiten im Team zusammen.", "We work together in a team.", "ہم ٹیم میں مل کر کام کرتے ہیں۔", "Hum team mein mil kar kaam karte hain."),
            SentenceItem("de_a2_4_6", "📋", "Ich erledige meine Aufgaben pünktlich.", "I complete my tasks punctually.", "میں اپنے کام وقت پر پورے کرتا ہوں۔", "Main apne tasks waqt par karta hoon."),
            SentenceItem("de_a2_4_7", "☕", "Um zwölf Uhr machen wir Pause.", "At twelve o'clock we take a break.", "بارہ بجے ہم وقفہ (بریک) لیتے ہیں۔", "12 baje hum break lete hain."),
            SentenceItem("de_a2_4_8", "📝", "Ich habe meinen Arbeitsvertrag unterschrieben.", "I signed my employment contract.", "میں نے اپنے معاہدہ ملازمت پر دستخط کر دیے۔", "Maine job contract sign kar diya.")
        )
    )

    private fun createA2Lesson5() = Lesson(
        id = "de_a2_5",
        languageId = "de",
        level = CefrLevel.A2,
        title = "Travel & Holidays",
        romanUrduTitle = "Safar aur Chuttiyan",
        iconEmoji = "✈️",
        grammarTipRomanUrdu = "Safar ke waseele ke liye 'mit dem Zug' (train se) ya 'mit dem Flugzeug' lagta hai.",
        grammarTipEn = "Use 'mit dem...' for public transportation methods.",
        sentences = listOf(
            SentenceItem("de_a2_5_1", "🎫", "Ich möchte eine Fahrkarte kaufen.", "I would like to buy a travel ticket.", "میں سفر کا ٹکٹ خریدنا چاہتا ہوں۔", "Main ticket khareedna chahta hoon."),
            SentenceItem("de_a2_5_2", "🚆", "Der Zug hat zehn Minuten Verspätung.", "The train is delayed by ten minutes.", "ٹرین دس منٹ تاخیر کا شکار ہے۔", "Train 10 minute late hai."),
            SentenceItem("de_a2_5_3", "🏨", "Ich habe ein Zimmer im Hotel reserviert.", "I reserved a room in the hotel.", "میں نے ہوٹل میں کمرہ بک کرایا ہے۔", "Maine hotel mein kamra book karwaya hai."),
            SentenceItem("de_a2_5_4", "🧳", "Mein Koffer ist sehr schwer.", "My suitcase is very heavy.", "میرا سوٹ کیس بہت وزنی ہے۔", "Mera suitcase bohot bhari hai."),
            SentenceItem("de_a2_5_5", "🏖️", "Ich fahre nächste Woche in den Urlaub.", "I am going on vacation next week.", "میں اگلے ہفتے چھٹیوں پر جا رہا ہوں۔", "Main agle hafte chuttiyon par ja raha hoon."),
            SentenceItem("de_a2_5_6", "🛂", "Hier ist mein Reisepass.", "Here is my passport.", "یہ رہا میرا پاسپورٹ۔", "Ye mera passport hai."),
            SentenceItem("de_a2_5_7", "🛫", "Der Flug startet pünktlich.", "The flight departs on schedule.", "پرواز وقت پر روانہ ہو رہی ہے۔", "Flight time par take-off kar rahi hai."),
            SentenceItem("de_a2_5_8", "✨", "Gute Reise und viel Spaß!", "Have a good trip and have fun!", "آپ کا سفر خوشگوار ہو!", "Aap ka safar acha guzre!")
        )
    )

    // B1 Lessons
    private fun createB1Lesson1() = Lesson(
        id = "de_b1_1",
        languageId = "de",
        level = CefrLevel.B1,
        title = "Opinions & Discussions",
        romanUrduTitle = "Rai aur Guftagu",
        iconEmoji = "💬",
        grammarTipRomanUrdu = "Rai dene ke liye 'Meiner Meinung nach...' (Meri rai ke mutabiq) istemal karein.",
        grammarTipEn = "Express your opinion politely using 'Meiner Meinung nach...'.",
        sentences = listOf(
            SentenceItem("de_b1_1_1", "🤔", "Meiner Meinung nach ist das eine gute Idee.", "In my opinion, that is a good idea.", "میری رائے میں یہ ایک اچھا خیال ہے۔", "Meri rai mein ye acha idea hai."),
            SentenceItem("de_b1_1_2", "👍", "Ich stimme Ihnen vollkommen zu.", "I agree with you completely.", "میں آپ کی بات سے مکمل متفق ہوں۔", "Main aap se muttahid / sehmat hoon."),
            SentenceItem("de_b1_1_3", "👎", "Da bin ich anderer Meinung.", "I have a different opinion on that.", "اس پر میری رائے مختلف ہے۔", "Mera is par mukhtalif khayal hai."),
            SentenceItem("de_b1_1_4", "💡", "Darf ich einen Vorschlag machen?", "May I make a suggestion?", "کیا میں ایک تجویز پیش کر سکتا ہوں؟", "Kya main ek suggestion de sakta hoon?"),
            SentenceItem("de_b1_1_5", "🗣️", "Das sehe ich genauso.", "I see it exactly the same way.", "میں بھی ایسا ہی دیکھتا ہوں۔", "Mera bhi yahi sochna hai."),
            SentenceItem("de_b1_1_6", "❓", "Was halten Sie von diesem Plan?", "What do you think of this plan?", "اس منصوبے کے بارے میں آپ کی کیا رائے ہے؟", "Is plan ke bare mein aap kya sochte hain?"),
            SentenceItem("de_b1_1_7", "⚖️", "Es gibt Vor- und Nachteile.", "There are advantages and disadvantages.", "اس کے فائدے اور نقصانات دونوں ہیں۔", "Is ke faide aur nuqsanat dono hain."),
            SentenceItem("de_b1_1_8", "🤝", "Lassen Sie uns einen Kompromiss finden.", "Let us find a compromise.", "آئیں مل کر ایک درمیانی راستہ نکالتے ہیں۔", "Chalein beech ka rasta nikaalte hain.")
        )
    )

    private fun createB1Lesson2() = Lesson(
        id = "de_b1_2",
        languageId = "de",
        level = CefrLevel.B1,
        title = "Future Plans & Dreams",
        romanUrduTitle = "Mustaqbil ke Mansoobe",
        iconEmoji = "🚀",
        grammarTipRomanUrdu = "Mustaqbil (future) ke liye 'werden + fel' ya 'Ich habe vor...' istemal hota hai.",
        grammarTipEn = "Talk about future intentions using 'Ich habe vor, zu...' or 'werden'.",
        sentences = listOf(
            SentenceItem("de_b1_2_1", "🎓", "Ich möchte eine Ausbildung in Deutschland machen.", "I want to do vocational training in Germany.", "میں جرمنی میں Ausbildung کرنا چاہتا ہوں۔", "Main Germany mein Ausbildung karna chahta hoon."),
            SentenceItem("de_b1_2_2", "💼", "Mein Ziel ist es, eine feste Stelle zu finden.", "My goal is to find a permanent position.", "میرا مقصد مستقل ملازمت حاصل کرنا ہے۔", "Mera maqsad permanent job haasil karna hai."),
            SentenceItem("de_b1_2_3", "📈", "Ich werde hart an meiner Zukunft arbeiten.", "I will work hard on my future.", "میں اپنے مستقبل کے لیے سخت محنت کروں گا۔", "Main mustaqbil ke liye sakht mehnat karunga."),
            SentenceItem("de_b1_2_4", "🇩🇪", "In fünf Jahren möchte ich fließend Deutsch sprechen.", "In 5 years I want to speak German fluently.", "پانچ سالوں میں، میں روانی سے جرمن بولنا چاہتا ہوں۔", "5 saal mein main fluent bolna chahta hoon."),
            SentenceItem("de_b1_2_5", "🏠", "Ich spare Geld für eine eigene Wohnung.", "I am saving money for my own apartment.", "میں اپنے فلیٹ کے لیے پیسے جمع کر رہا ہوں۔", "Main apne apartment ke liye bachat kar raha hoon."),
            SentenceItem("de_b1_2_6", "✈️", "Ich plane eine Reise in meine Heimat.", "I am planning a trip to my homeland.", "میں اپنے وطن کا دورہ کرنے کا منصوبہ بنا رہا ہوں۔", "Main watan wapas jane ka plan bana raha hoon."),
            SentenceItem("de_b1_2_7", "📚", "Ich besuche einen B2-Sprachkurs.", "I attend a B2 language course.", "میں B2 زبان کے کورس میں داخلہ لے رہا ہوں۔", "Main B2 course join kar raha hoon."),
            SentenceItem("de_b1_2_8", "🌟", "Träume werden wahr, wenn man fleißig ist.", "Dreams come true if you are hardworking.", "محنت کرنے سے خواب سچ ہوتے ہیں۔", "Mehnat se khwab sach hote hain.")
        )
    )

    private fun createB1Lesson3() = Lesson(
        id = "de_b1_3",
        languageId = "de",
        level = CefrLevel.B1,
        title = "Work & Career",
        romanUrduTitle = "Kaam aur Career",
        iconEmoji = "📈",
        grammarTipRomanUrdu = "Apni salahiyat batane ke liye 'Ich habe Erfahrung im Bereich...' istemal karein.",
        grammarTipEn = "Describe qualifications with 'Ich habe Erfahrung in...'.",
        sentences = listOf(
            SentenceItem("de_b1_3_1", "📄", "Hier ist mein vollständiger Lebenslauf.", "Here is my complete curriculum vitae (CV).", "یہ میری مکمل سی وی (CV) ہے۔", "Ye meri complete CV hai."),
            SentenceItem("de_b1_3_2", "💼", "Ich habe drei Jahre Berufserfahrung.", "I have three years of professional experience.", "میرے پاس تین سال کا کام کا تجربہ ہے۔", "Mere paas 3 saal ka work experience hai."),
            SentenceItem("de_b1_3_3", "🎯", "Ich lerne schnell neue Abläufe.", "I quickly learn new operational procedures.", "میں نئے طریقے اور کام تیزی سے سیکھتا ہوں۔", "Main naye procedures jaldi seekhta hoon."),
            SentenceItem("de_b1_3_4", "🤝", "Ich arbeite gerne im Schichtdienst.", "I am happy to work in shift duty.", "میں خوشی سے شفٹ ڈیوٹی میں کام کرتا ہوں۔", "Main shift duties karne ko tayyar hoon."),
            SentenceItem("de_b1_3_5", "🗣️", "Ich kann mich gut auf Deutsch verständigen.", "I can communicate well in German.", "میں جرمن میں اچھی بات چیت کر سکتا ہوں۔", "Main German mein theek baat cheet kar sakta hoon."),
            SentenceItem("de_b1_3_6", "📞", "Wann kann ich zum Vorstellungsgespräch kommen?", "When can I come for the job interview?", "میں انٹرویو کے لیے کب حاضر ہو سکتا ہوں؟", "Main interview ke liye kab aa sakta hoon?"),
            SentenceItem("de_b1_3_7", "🏅", "Ich bin zuverlässig und pünktlich.", "I am reliable and punctual.", "میں قابلِ بھروسا اور وقت کا پابند ہوں۔", "Main zimmedar aur waqt ka paband hoon."),
            SentenceItem("de_b1_3_8", "📊", "Ich möchte mich beruflich weiterbilden.", "I want to advance my professional training.", "میں اپنے کیریئر کی تربیت کو آگے بڑھانا چاہتا ہوں۔", "Main career mein mazeed training chahta hoon.")
        )
    )

    private fun createB1Lesson4() = Lesson(
        id = "de_b1_4",
        languageId = "de",
        level = CefrLevel.B1,
        title = "Environment & Media",
        romanUrduTitle = "Mahol aur Technology",
        iconEmoji = "🌱",
        grammarTipRomanUrdu = "Zaroorat ya qanoon ke liye 'müssen' ya 'sollte' ka istemal hota hai.",
        grammarTipEn = "Express obligation or eco-friendly habits with modal verbs.",
        sentences = listOf(
            SentenceItem("de_b1_4_1", "♻️", "Mülltrennung ist in Deutschland sehr wichtig.", "Waste separation is very important in Germany.", "جرمنی میں کچرے کو الگ الگ کرنا بہت اہم ہے۔", "Germany mein recycling bohot ahem hai."),
            SentenceItem("de_b1_4_2", "⚡", "Wir müssen Energie und Strom sparen.", "We must save energy and electricity.", "ہمیں توانائی اور بجلی کی بچت کرنی چاہیے۔", "Humein bijli bachanay ki zaroorat hai."),
            SentenceItem("de_b1_4_3", "📱", "Ich nutze mein Smartphone für Recherchen.", "I use my smartphone for research.", "میں تحقیق اور تلاش کے لیے اسمارٹ فون استعمال کرتا ہوں۔", "Main search ke liye smartphone use karta hoon."),
            SentenceItem("de_b1_4_4", "🚆", "Öffentliche Verkehrsmittel schonen die Umwelt.", "Public transportation protects the environment.", "پبلک ٹرانسپورٹ ماحول کے لیے بہتر ہے۔", "Public transport mahol ke liye behtar hai."),
            SentenceItem("de_b1_4_5", "💻", "Digitale Medien erleichtern die Arbeit.", "Digital media makes work easier.", "ڈیجیٹل ذرائع سے کام آسان ہو جاتا ہے۔", "Digital tools se kaam asaan hota hai."),
            SentenceItem("de_b1_4_6", "🌳", "Wir sollten mehr Bäume pflanzen.", "We should plant more trees.", "ہمیں زیادہ درخت لگانے چاہئیں۔", "Humein zyada darakht lagane chahiye."),
            SentenceItem("de_b1_4_7", "📰", "Ich lese täglich die aktuellen Nachrichten.", "I read current news daily.", "میں روزانہ تازہ ترین خبریں پڑھتا ہوں۔", "Main rozana taaza khabrein parhta hoon."),
            SentenceItem("de_b1_4_8", "🌍", "Klimaschutz geht uns alle an.", "Climate protection concerns all of us.", "ماحول کا تحفظ ہم سب کی ذمہ داری ہے۔", "Environment bachaana sab ki zimmedari hai.")
        )
    )

    // Special REQUIRED lesson for B1: Workplace for Every Worker!
    private fun createB1WorkplaceLesson() = Lesson(
        id = "de_b1_5",
        languageId = "de",
        level = CefrLevel.B1,
        title = "Workplace for Every Worker",
        romanUrduTitle = "Har Worker ke Rozana Kaam ke Jumlay",
        iconEmoji = "👷",
        isWorkplaceSpecial = true,
        grammarTipRomanUrdu = "Ye 8 jumlay har worker ke liye lazmi hain chahe aap warehouse, hotel, factory, delivery ya kisi bhi shobay mein hon!",
        grammarTipEn = "Universal essential workplace phrases for any job in Germany (Ausbildung, logistics, hospitality, technical, services).",
        sentences = listOf(
            SentenceItem(
                id = "de_b1_5_1",
                emoji = "⏰",
                targetText = "Wann beginnt meine Schicht?",
                englishText = "When does my shift start?",
                urduText = "میری شفٹ کب شروع ہوتی ہے؟",
                romanUrduText = "Mera shift kab shuru hota hai?",
                contextNotes = "Shift timing inquiry"
            ),
            SentenceItem(
                id = "de_b1_5_2",
                emoji = "☕",
                targetText = "Wo ist der Pausenraum?",
                englishText = "Where is the break room?",
                urduText = "وقفے کا کمرہ کہاں ہے؟",
                romanUrduText = "Waqfe ka kamra kahan hai?",
                contextNotes = "Break room / rest area"
            ),
            SentenceItem(
                id = "de_b1_5_3",
                emoji = "🤝",
                targetText = "Ich brauche Hilfe bei dieser Aufgabe.",
                englishText = "I need help with this task.",
                urduText = "مجھے اس کام میں مدد چاہیے۔",
                romanUrduText = "Mujhe is kaam mein madad chahiye.",
                contextNotes = "Asking for workplace assistance"
            ),
            SentenceItem(
                id = "de_b1_5_4",
                emoji = "🦺",
                targetText = "Sicherheit geht vor, Schutzkleidung tragen.",
                englishText = "Safety first, wear protective gear.",
                urduText = "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔",
                romanUrduText = "Hifazat sab se pehle, hifazati saman pehnein.",
                contextNotes = "Workplace safety rule"
            ),
            SentenceItem(
                id = "de_b1_5_5",
                emoji = "🏖️",
                targetText = "Ich möchte Urlaub beantragen.",
                englishText = "I would like to request leave / holiday.",
                urduText = "میں چھٹی کی درخواست کرنا چاہتا ہوں۔",
                romanUrduText = "Main chutti ki darkhwast karna chahta hoon.",
                contextNotes = "Leave request to supervisor"
            ),
            SentenceItem(
                id = "de_b1_5_6",
                emoji = "🔁",
                targetText = "Könnten Sie das bitte noch einmal erklären?",
                englishText = "Could you please explain that again?",
                urduText = "کیا آپ دوبارہ سمجھا سکتے ہیں؟",
                romanUrduText = "Kya aap dobara samjha sakte hain?",
                contextNotes = "Polite request for clarification"
            ),
            SentenceItem(
                id = "de_b1_5_7",
                emoji = "⚠️",
                targetText = "Die Maschine funktioniert nicht richtig.",
                englishText = "The machine is not working properly.",
                urduText = "مشین ٹھیک کام نہیں کر رہی۔",
                romanUrduText = "Machine theek kaam nahi kar rahi.",
                contextNotes = "Reporting equipment issue"
            ),
            SentenceItem(
                id = "de_b1_5_8",
                emoji = "✅",
                targetText = "Ich habe meine Arbeit für heute beendet.",
                englishText = "I have finished my work for today.",
                urduText = "میں نے آج کا کام ختم کر لیا ہے۔",
                romanUrduText = "Maine aaj ka kaam khatam kar liya hai.",
                contextNotes = "End of shift sign-off"
            )
        )
    )

    // B2 Lessons (Tagged: Best for all jobs in Germany)
    private fun createB2Lesson1() = Lesson(
        id = "de_b2_1",
        languageId = "de",
        level = CefrLevel.B2,
        title = "Debates & Arguments",
        romanUrduTitle = "Behes aur Dalail",
        iconEmoji = "⚖️",
        grammarTipRomanUrdu = "Dalaeel pesh karte waqt 'Einerseits... andererseits' (Ek taraf... doosri taraf) use karein.",
        grammarTipEn = "Structure arguments logically using 'Einerseits..., andererseits...'.",
        sentences = listOf(
            SentenceItem("de_b2_1_1", "⚖️", "Einerseits verstehe ich den Punkt, andererseits gibt es Risiken.", "On one hand I understand the point, on the other hand there are risks.", "ایک طرف میں نکتہ سمجھتا ہوں، دوسری طرف خطرات ہیں۔", "Ek taraf baat theek hai, doosri taraf risks hain."),
            SentenceItem("de_b2_1_2", "🎯", "Dieses Argument überzeugt mich nicht vollständig.", "This argument does not completely convince me.", "یہ دلیل مجھے پوری طرح مطمئن نہیں کرتی۔", "Ye daleel mujhe poori tarah convince nahi karti."),
            SentenceItem("de_b2_1_3", "💡", "Wir müssen die langfristigen Folgen bedenken.", "We must consider the long-term consequences.", "ہمیں طویل مدتی نتائج کو مدنظر رکھنا ہوگا۔", "Humein long-term asraat sochne honge."),
            SentenceItem("de_b2_1_4", "📊", "Die Daten sprechen eine eindeutige Sprache.", "The data speaks a very clear language.", "اعداد و شمار بالکل واضح ہیں۔", "Data bilkul clear hai."),
            SentenceItem("de_b2_1_5", "🤝", "Trotz unterschiedlicher Ansichten finden wir eine Lösung.", "Despite different views we will find a solution.", "مختلف خیالات کے باوجود ہم حل تلاش کریں گے۔", "Ikhtilaf ke bawajood hum solution nikaalenge."),
            SentenceItem("de_b2_1_6", "🔍", "Lassen Sie uns die Ursachen genauer analysieren.", "Let us analyze the root causes more precisely.", "آئیں وجوہات کا گہرائی سے تجزیہ کرتے ہیں۔", "Chalein causes ko gehrai se check karein."),
            SentenceItem("de_b2_1_7", "🗣️", "Ich möchte diesen Standpunkt bekräftigen.", "I would like to reinforce this viewpoint.", "میں اس مؤقف کی تائید کرنا چاہتا ہوں۔", "Main is point ki support karta hoon."),
            SentenceItem("de_b2_1_8", "✅", "Wir sind uns in den wesentlichen Punkten einig.", "We are in agreement on the essential points.", "ہم بنیادی نکات پر متفق ہیں۔", "Hum ahem points par agree karte hain.")
        )
    )

    private fun createB2Lesson2() = Lesson(
        id = "de_b2_2",
        languageId = "de",
        level = CefrLevel.B2,
        title = "Business & Meetings",
        romanUrduTitle = "Business aur Meetings",
        iconEmoji = "💼",
        grammarTipRomanUrdu = "Meeting mein ba-adab bolne ke liye 'Konjunktiv II' (könnten, würden, hätten) istemal hota hai.",
        grammarTipEn = "Use polite subjunctive forms (könnten, würden) in professional meetings.",
        sentences = listOf(
            SentenceItem("de_b2_2_1", "📋", "Herzlich willkommen zu unserer heutigen Besprechung.", "Welcome to our meeting today.", "ہماری آج کی میٹنگ میں خوش آمدید۔", "Aaj ki meeting mein khush-amdeed."),
            SentenceItem("de_b2_2_2", "📌", "Kommen wir direkt zum ersten Tagesordnungspunkt.", "Let us get directly to the first agenda item.", "آئیں براہ راست پہلے ایجنڈے پر آتے ہیں۔", "Pehle agenda point par baat karte hain."),
            SentenceItem("de_b2_2_3", "📈", "Die Produktivität hat sich deutlich verbessert.", "Productivity has clearly improved.", "پیداواری صلاحیت میں نمایاں بہتری آئی ہے۔", "Productivity mein wazeh behtari aayi hai."),
            SentenceItem("de_b2_2_4", "🗓️", "Wir müssen die Frist unbedingt einhalten.", "We must strictly adhere to the deadline.", "ہمیں ڈیڈ لائن کی سختی سے پابندی کرنی ہوگی۔", "Humein deadline par kaam poora karna hoga."),
            SentenceItem("de_b2_2_5", "🤝", "Ich übernehme die Verantwortung für dieses Projekt.", "I take responsibility for this project.", "میں اس پروجیکٹ کی ذمہ داری لیتا ہوں۔", "Main is project ki zimmedari leta hoon."),
            SentenceItem("de_b2_2_6", "📧", "Ich werde das Protokoll per E-Mail zusenden.", "I will send the meeting minutes by email.", "میں میٹنگ کا خلاصہ ای میل کر دوں گا۔", "Main meeting minutes email kar dunga."),
            SentenceItem("de_b2_2_7", "👥", "Gibt es noch offene Fragen von Ihrer Seite?", "Are there any remaining open questions from your side?", "کیا آپ کی طرف سے کوئی سوال باقی ہے؟", "Kya aap ki taraf se koi sawal hai?"),
            SentenceItem("de_b2_2_8", "🎯", "Vielen Dank für Ihre geschätzte Mitarbeit.", "Thank you very much for your valued collaboration.", "آپ کے قیمتی تعاون کا بہت شکریہ۔", "Aap ke ta'awun ka shukriya.")
        )
    )

    private fun createB2Lesson3() = Lesson(
        id = "de_b2_3",
        languageId = "de",
        level = CefrLevel.B2,
        title = "News & Society",
        romanUrduTitle = "Khabrein aur Samaj",
        iconEmoji = "📰",
        grammarTipRomanUrdu = "Passive voice (Passiv) ka istemal akhbarat aur news mein aam hota hai.",
        grammarTipEn = "Passive voice (wurde gebaut / wird gefördert) is standard in news media.",
        sentences = listOf(
            SentenceItem("de_b2_3_1", "📰", "Die Regierung plant umfassende Reformen.", "The government plans comprehensive reforms.", "حکومت جامع اصلاحات کا منصوبہ بنا رہی ہے۔", "Hukumat bari reforms plan kar rahi hai."),
            SentenceItem("de_b2_3_2", "💼", "Der Arbeitsmarkt sucht qualifizierte Fachkräfte.", "The job market seeks qualified specialists.", "ملازمت کی مارکیٹ میں ہنر مند افراد کی طلب ہے۔", "Job market mein skilled workers ki demand hai."),
            SentenceItem("de_b2_3_3", "🏙️", "Wohnraum in Großstädten wird knapper.", "Living space in major cities is becoming scarcer.", "بڑے شہروں میں رہائش کی جگہ کم ہو رہی ہے۔", "Bare shehron mein rehne ki jagah kam ho rahi hai."),
            SentenceItem("de_b2_3_4", "🌱", "Erneuerbare Energien gewinnen an Bedeutung.", "Renewable energy is gaining significance.", "قابلِ تجدید توانائی کی اہمیت بڑھ رہی ہے۔", "Solar/Wind energy ahem hoti ja rahi hai."),
            SentenceItem("de_b2_3_5", "💶", "Die Inflationsrate ist leicht gesunken.", "The inflation rate has slightly dropped.", "مہنگائی کی شرح میں معمولی کمی آئی ہے۔", "Mehangai thodi kam hui hai."),
            SentenceItem("de_b2_3_6", "🌐", "Integration erfordert gegenseitigen Respekt.", "Integration requires mutual respect.", "معاشرے میں ہم آہنگی باہمی عزت کا تقاضا کرتی ہے۔", "Integration ke liye apas ka respect zaroori hai."),
            SentenceItem("de_b2_3_7", "🗳️", "Bürger beteiligen sich aktiv am Diskurs.", "Citizens actively participate in the discourse.", "شہری بحث و مباحثے میں سرگرمی سے حصہ لیتے ہیں۔", "Log mashware mein hissa le rahe hain."),
            SentenceItem("de_b2_3_8", "✨", "Chancengleichheit ist das Fundament der Demokratie.", "Equal opportunity is the foundation of democracy.", "مواقع کی برابری جمہوریت کی بنیاد ہے۔", "Sab ko barabar mawake milna democracy ki bunyad hai.")
        )
    )

    private fun createB2Lesson4() = Lesson(
        id = "de_b2_4",
        languageId = "de",
        level = CefrLevel.B2,
        title = "Culture & Traditions",
        romanUrduTitle = "Saqafat aur Rawayat",
        iconEmoji = "🎭",
        grammarTipRomanUrdu = "Saqafati baten karte waqt 'Es ist üblich...' (Ye aam riwaj hai) bolte hain.",
        grammarTipEn = "Use 'Es ist üblich...' to describe customs and traditions.",
        sentences = listOf(
            SentenceItem("de_b2_4_1", "🇩🇪", "Pünktlichkeit gilt in Deutschland als Tugend.", "Punctuality is considered a virtue in Germany.", "جرمنی میں وقت کی پابندی کو بڑی خوبی سمجھا جاتا ہے۔", "Germany mein waqt ki pabandi bohot ahem hai."),
            SentenceItem("de_b2_4_2", "🎄", "Weihnachten ist ein traditionelles Familienfest.", "Christmas is a traditional family celebration.", "کرسمس ایک روایتی خاندانی تہوار ہے۔", "Christmas khandan ke saath manaya jata hai."),
            SentenceItem("de_b2_4_3", "📚", "Deutschland hat eine reiche Literaturgeschichte.", "Germany has a rich literary history.", "جرمنی کی ادبی تاریخ بہت شاندار ہے۔", "Germany ki adabi tareekh shandar hai."),
            SentenceItem("de_b2_4_4", "🤝", "Vereine spielen eine große gesellschaftliche Rolle.", "Clubs play a major social role.", "انجمنیں اور کلب سماجی زندگی میں بڑا کردار ادا کرتے ہیں۔", "Clubs aur socieites ahem role play karte hain."),
            SentenceItem("de_b2_4_5", "🍽️", "Regionale Spezialitäten sind sehr vielfältig.", "Regional specialties are very diverse.", "علاقائی کھانے اور روایات بہت متنوع ہیں۔", "Har ilaqa ke apne khasoosi khane hain."),
            SentenceItem("de_b2_4_6", "🏰", "Historische Schlösser ziehen Touristen an.", "Historic castles attract tourists.", "تاریخی قلعے سیاحوں کو اپنی طرف کھینچتے ہیں۔", "Tareekhi qilay tourists ko attract karte hain."),
            SentenceItem("de_b2_4_7", "🎶", "Klassische Musik hat hier tiefe Wurzeln.", "Classical music has deep roots here.", "کلاسیکی موسیقی کی جڑیں یہاں بہت گہری ہیں۔", "Classical music ka yahan bara maqam hai."),
            SentenceItem("de_b2_4_8", "🌍", "Kultureller Austausch bereichert das Leben.", "Cultural exchange enriches life.", "ثقافتی تبادلہ زندگی کو خوبصورت بناتا ہے۔", "Cultural exchange se seekhne ko milta hai.")
        )
    )

    private fun createB2Lesson5() = Lesson(
        id = "de_b2_5",
        languageId = "de",
        level = CefrLevel.B2,
        title = "Formal Workplace Language",
        romanUrduTitle = "Daftari aur Rasmi Zaban",
        iconEmoji = "📑",
        grammarTipRomanUrdu = "Emails mein 'Sehr geehrte Damen und Herren' aur aakhir mein 'Mit freundlichen Grüßen' likha jata hai.",
        grammarTipEn = "Formal letters: Start with 'Sehr geehrte...' and end with 'Mit freundlichen Grüßen'.",
        sentences = listOf(
            SentenceItem("de_b2_5_1", "✉️", "Sehr geehrte Damen und Herren,", "Dear Sir or Madam,", "محترم خواتین و حضرات،", "Sehr geehrte Damen und Herren (Rasmi aaghaz)"),
            SentenceItem("de_b2_5_2", "📝", "Bezugnehmend auf Ihr Schreiben vom Montag...", "Referring to your letter from Monday...", "پیر کے روز آپ کے خط کے حوالے سے...", "Aap ke khat ke hawale se..."),
            SentenceItem("de_b2_5_3", "📎", "Im Anhang finden Sie die gewünschten Unterlagen.", "In the attachment you will find the requested documents.", "منسلک فائل میں مطلوبہ دستاویزات موجود ہیں۔", "Attachment mein documents mojood hain."),
            SentenceItem("de_b2_5_4", "🤝", "Ich stehe Ihnen für Rückfragen gerne zur Verfügung.", "I am gladly at your disposal for questions.", "کسی بھی سوال کی صورت میں، میں حاضر ہوں۔", "Kisi bhi sawal ke liye main hazir hoon."),
            SentenceItem("de_b2_5_5", "✍️", "Mit freundlichen Grüßen,", "Yours sincerely / With kind regards,", "نیک تمناؤں کے ساتھ،", "Mit freundlichen Grüßen (Rasmi ikhtitam)"),
            SentenceItem("de_b2_5_6", "📋", "Bitte bestätigen Sie den Erhalt dieser Nachricht.", "Please confirm receipt of this message.", "براہ کرم اس پیغام کی وصولی کی تصدیق کریں۔", "Is message ki wasooli confirm karein please."),
            SentenceItem("de_b2_5_7", "⏳", "Wir bitten um etwas Geduld.", "We ask for your patience.", "ہم آپ سے تھوڑے صبر کی گزارش کرتے ہیں۔", "Thoda sabr darkaar hai."),
            SentenceItem("de_b2_5_8", "🏢", "Es war mir eine Freude, mit Ihnen zu kooperieren.", "It was a pleasure to cooperate with you.", "آپ کے ساتھ کام کر کے خوشی ہوئی۔", "Aap ke saath kaam karke khushi hui.")
        )
    )

    // C1 Lessons
    private fun createC1Lesson1() = Lesson(
        id = "de_c1_1",
        languageId = "de",
        level = CefrLevel.C1,
        title = "Academic Language",
        romanUrduTitle = "Taleemi aur Tahqeeqi Zaban",
        iconEmoji = "🎓",
        grammarTipRomanUrdu = "Nominalstil (ism par mabni jumlay) C1 mein scientific baaton ke liye istemal hota hai.",
        grammarTipEn = "Use nominal style (substantives instead of verbs) for academic precision.",
        sentences = listOf(
            SentenceItem("de_c1_1_1", "🔬", "Die Studie belegt einen signifikanten Zusammenhang.", "The study proves a significant correlation.", "یہ تحقیق ایک اہم تعلق کو ثابت کرتی ہے۔", "Tahqeeq ek ahem connection sabit karti hai."),
            SentenceItem("de_c1_1_2", "📚", "Aus wissenschaftlicher Perspektive ist dies plausibel.", "From a scientific perspective, this is plausible.", "سائنسی نقطہ نظر سے یہ بات قرینِ قیاس ہے۔", "Scientific point of view se ye baat samajh aati hai."),
            SentenceItem("de_c1_1_3", "📊", "Die empirischen Befunde stützen diese Hypothese.", "Empirical findings support this hypothesis.", "مشاہداتی شواہد اس مفروضے کو تقویت دیتے ہیں۔", "Empirical data is hypothesis ko support karta hai."),
            SentenceItem("de_c1_1_4", "🔍", "Eine differenzierte Betrachtung ist unerlässlich.", "A differentiated examination is essential.", "ایک گہرا اور الگ الگ جائزہ ناگزیر ہے۔", "Gehra tajzia lazmi hai."),
            SentenceItem("de_c1_1_5", "💡", "Daraus lässt sich folgende Schlussfolgerung ziehen.", "From this, the following conclusion can be drawn.", "اس سے درج ذیل نتیجہ اخذ کیا جا سکتا ہے۔", "Is se ye result nikalta hai."),
            SentenceItem("de_c1_1_6", "📖", "Die Relevanz dieser Theorie steht außer Frage.", "The relevance of this theory is beyond question.", "اس نظریے کی اہمیت شک و شبہ سے بالاتر ہے۔", "Is theory ki importance par koi shak nahi."),
            SentenceItem("de_c1_1_7", "📑", "Es bedarf weiterer interdisziplinärer Forschung.", "It requires further interdisciplinary research.", "اس میں مزید بین الشعبہ جاتی تحقیق کی ضرورت ہے۔", "Mazeed research darkaar hai."),
            SentenceItem("de_c1_1_8", "🎯", "Die Publikation stieß auf breite Resonanz.", "The publication met with wide response.", "اس اشاعت کو وسیع پزیرائی ملی۔", "Is research paper ko khoob saraha gaya.")
        )
    )

    private fun createC1Lesson2() = Lesson(
        id = "de_c1_2",
        languageId = "de",
        level = CefrLevel.C1,
        title = "Politics & Society",
        romanUrduTitle = "Siyasat aur Mo'ashra",
        iconEmoji = "🏛️",
        grammarTipRomanUrdu = "Gehri guftagu ke liye 'In Anbetracht der Tatsache...' (Is haqeeqat ko mad-e-nazar rakhte hue) ka istemal karein.",
        grammarTipEn = "Elevate formal discourse with complex prepositions like 'In Anbetracht...'.",
        sentences = listOf(
            SentenceItem("de_c1_2_1", "🏛️", "In Anbetracht der Lage sind Reformen unumgänglich.", "Considering the situation, reforms are inevitable.", "صورتحال کے پیشِ نظر اصلاحات ناگزیر ہیں۔", "Soorathal ke tehat reforms zaroori hain."),
            SentenceItem("de_c1_2_2", "⚖️", "Rechtsstaatlichkeit ist das Rückgrat unserer Ordnung.", "Rule of law is the backbone of our order.", "قانون کی حکمرانی ہمارے نظام کی ریڑھ کی ہڈی ہے۔", "Qanoon ki hukmrani bunyadi cheez hai."),
            SentenceItem("de_c1_2_3", "🗳️", "Bürgerschaftliches Engagement stärkt das Gemeinwesen.", "Civic engagement strengthens the community.", "شہری شمولیت معاشرے کو مضبوط بناتی ہے۔", "Civic participation society ko mazboot karti hai."),
            SentenceItem("de_c1_2_4", "🌐", "Globalisierung bringt Verflechtungen mit sich.", "Globalization brings complex interdependencies.", "گلوبلائزیشن سے باہمی انحصار بڑھتا ہے۔", "Globalization se dunya apas mein jud chuki hai."),
            SentenceItem("de_c1_2_5", "💡", "Transparenz schafft Vertrauen in Institutionen.", "Transparency builds trust in institutions.", "شفافیت اداروں پر اعتماد پیدا کرتی ہے۔", "Shafafiyat se trust banta hai."),
            SentenceItem("de_c1_2_6", "🌱", "Nachhaltigkeit muss oberste Priorität genießen.", "Sustainability must enjoy top priority.", "پائیداری کو اولین ترجیح ملنی چاہیے۔", "Sustainability sab se pehle honi chahiye."),
            SentenceItem("de_c1_2_7", "👥", "Soziale Gerechtigkeit bewahrt den inneren Frieden.", "Social justice preserves internal harmony.", "سماجی انصاف اندرونی امن کا ضامن ہے۔", "Social justice se aman qayam rehta hai."),
            SentenceItem("de_c1_2_8", "🤝", "Pluralismus bereichert demokratische Prozesse.", "Pluralism enriches democratic processes.", "کثریت پسندی جمہوری عمل کو مضبوط بناتی ہے۔", "Mukhtalif aara se jamhooriat mazboot hoti hai.")
        )
    )

    private fun createC1Lesson3() = Lesson(
        id = "de_c1_3",
        languageId = "de",
        level = CefrLevel.C1,
        title = "Literature & Arts",
        romanUrduTitle = "Adab aur Funoon",
        iconEmoji = "🎨",
        grammarTipRomanUrdu = "Adabi asloob mein jazbaat aur tashbeeh ka khoobsurat istemal hota hai.",
        grammarTipEn = "Use nuanced imagery and stylistic phrasing to critique art.",
        sentences = listOf(
            SentenceItem("de_c1_3_1", "🎭", "Das Werk spiegelt die Zerrissenheit der Epoche wider.", "The work reflects the inner turmoil of the era.", "یہ فن پارہ اپنے دور کی کشمکش کی عکاسی کرتا ہے۔", "Ye fun para us daur ki kashmakash dikhata hai."),
            SentenceItem("de_c1_3_2", "📖", "Die Metapher verleiht dem Text poetische Tiefe.", "The metaphor gives the text poetic depth.", "استعارہ تحریر کو شعری گہرائی بخشتا ہے۔", "Iste'aara (metaphor) text ko gehrai deta hai."),
            SentenceItem("de_c1_3_3", "🎨", "Die Ästhetik des Gemäldes fasziniert das Publikum.", "The aesthetics of the painting captivates the audience.", "تصویر کی جمالیات شائقین کو مسحور کرتی ہے۔", "Painting ki khubsurti dil jeet leti hai."),
            SentenceItem("de_c1_3_4", "🎻", "Die Symphonie erzeugt eine melancholische Stimmung.", "The symphony generates a melancholic mood.", "موسیقی اداس کیفیت پیدا کرتی ہے۔", "Music udaas aur pur-kashish mahaul banata hai."),
            SentenceItem("de_c1_3_5", "✍️", "Der Autor hinterfragt gesellschaftliche Konventionen.", "The author questions societal conventions.", "مصنف معاشرتی روایات پر سوال اٹھاتا ہے۔", "Writer purani rasmon par sawal uthata hai."),
            SentenceItem("de_c1_3_6", "🌟", "Ein Meisterwerk von zeitloser Gültigkeit.", "A masterpiece of timeless validity.", "ایک لازوال شاہکار۔", "Ek la-zawal masterpiece."),
            SentenceItem("de_c1_3_7", "📜", "Kreativität entspringt oft dem Widerstand.", "Creativity often springs from resistance.", "تخلیق اکثر مشکلات اور مزاحمت سے جنم لیتی ہے۔", "Takhleeq mushkil halat mein nikharti hai."),
            SentenceItem("de_c1_3_8", "🏛️", "Das kulturelle Erbe muss bewahrt werden.", "Cultural heritage must be preserved.", "ثقافتی ورثے کا تحفظ لازمی ہے۔", "Saqafati virsay ki hifazat zaroori hai.")
        )
    )

    private fun createC1Lesson4() = Lesson(
        id = "de_c1_4",
        languageId = "de",
        level = CefrLevel.C1,
        title = "Science & Research",
        romanUrduTitle = "Science aur Research",
        iconEmoji = "🔬",
        grammarTipRomanUrdu = "Sainsi nateejay batane ke liye 'Es wurde nachgewiesen, dass...' istemal karein.",
        grammarTipEn = "Express scientific certainty with impersonal passive clauses.",
        sentences = listOf(
            SentenceItem("de_c1_4_1", "🧪", "Es wurde nachgewiesen, dass die Reaktion beschleunigt wird.", "It has been proven that the reaction is accelerated.", "یہ ثابت ہو چکا ہے کہ عمل تیز ہو جاتا ہے۔", "Ye prove ho chuka hai ke reaction fast hota hai."),
            SentenceItem("de_c1_4_2", "🧬", "Die Genomforschung eröffnet neue medizinische Horizonte.", "Genome research opens up new medical horizons.", "جین ریسرچ طب کے نئے افق کھول رہی ہے۔", "Genetics medicine ke naye raaste khol rahi hai."),
            SentenceItem("de_c1_4_3", "💻", "Künstliche Intelligenz revolutioniert den Alltag.", "Artificial intelligence is revolutionizing daily life.", "مصنوعی ذہانت روزمرہ زندگی میں انقلاب لا رہی ہے۔", "AI rozmarrah zindagi badal rahi hai."),
            SentenceItem("de_c1_4_4", "🔭", "Präzise Messungen bestätigten die mathematischen Modelle.", "Precise measurements confirmed the mathematical models.", "درست پیمائشوں نے ریاضیاتی ماڈلز کی تصدیق کی۔", "Sahi measurements ne calculations ko confirm kiya."),
            SentenceItem("de_c1_4_5", "💡", "Innovationen bedürfen beträchtlicher Investitionen.", "Innovations require substantial investments.", "نئی ایجادات کے لیے خاطر خواہ سرمایہ کاری درکار ہے۔", "Inventions ke liye bari investment darkaar hai."),
            SentenceItem("de_c1_4_6", "📊", "Die Reproduzierbarkeit der Ergebnisse ist essenziell.", "The reproducibility of results is essential.", "نتائج کا دوبارہ ثابت ہونا لازمی ہے۔", "Results ka har dafa theek nikalna lazmi hai."),
            SentenceItem("de_c1_4_7", "🌱", "Ökologische Verträglichkeit wird stets geprüft.", "Ecological compatibility is constantly tested.", "ماحولیاتی اثرات کی ہمیشہ جانچ پڑتال کی جاتی ہے۔", "Mahol par asraat hamesha test kiye jate hain."),
            SentenceItem("de_c1_4_8", "🏆", "Wissenschaftlicher Fortschritt dient dem Wohle der Menschheit.", "Scientific progress serves the well-being of mankind.", "سائنسی ترقی انسانیت کی بھلائی کے لیے ہے۔", "Science ki tarakki insaniyat ki bhalai ke liye hai.")
        )
    )

    private fun createC1Lesson5() = Lesson(
        id = "de_c1_5",
        languageId = "de",
        level = CefrLevel.C1,
        title = "Nuanced Opinions",
        romanUrduTitle = "Gehri aur Barik Rai",
        iconEmoji = "🧠",
        grammarTipRomanUrdu = "Nuance batane ke liye 'Zwar... aber' (Agarche... lekin) ka asloob nihayat ahem hai.",
        grammarTipEn = "Balance concessions and rebuttals with 'Zwar..., aber dennoch...'.",
        sentences = listOf(
            SentenceItem("de_c1_5_1", "⚖️", "Zwar ist der Ansatz vielversprechend, aber dennoch riskant.", "Although the approach is promising, it is still risky.", "اگرچہ طریقہ امید افزا ہے، لیکن پھر بھی پرخطر ہے۔", "Agarche tariqa acha hai, par risky hai."),
            SentenceItem("de_c1_5_2", "🔍", "Man darf diese Entwicklung keinesfalls unterschätzen.", "One must under no circumstances underestimate this trend.", "اس پیش رفت کو ہرگز کم نہ سمجھا جائے۔", "Is taraqqi ko halka nahi lena chahiye."),
            SentenceItem("de_c1_5_3", "💡", "Es gilt, alle Eventualitäten sorgfältig abzuwägen.", "It is crucial to carefully weigh all eventualities.", "تمام امکانی صورتوں کا باریک بینی سے جائزہ لینا ہوگا۔", "Har cheez ko achi tarah taulna zaroori hai."),
            SentenceItem("de_c1_5_4", "🗣️", "Ich plädiere für eine pragmatische Herangehensweise.", "I advocate for a pragmatic approach.", "میں عملی اور حقیقت پسندانہ رویے کی وکالت کرتا ہوں۔", "Main practical tariqa-e-kar ki sifarish karta hoon."),
            SentenceItem("de_c1_5_5", "📌", "Dies widerspricht den bisherigen Erfahrungswerten.", "This contradicts past empirical values.", "یہ ماضی کے تجربات کے برعکس ہے۔", "Ye purane tajurbat ke mukhalif hai."),
            SentenceItem("de_c1_5_6", "🤝", "Ein konstruktiver Dialog führt stets zum Ziel.", "Constructive dialogue always leads to the goal.", "مثبت بات چیت ہمیشہ منزل تک لے جاتی ہے۔", "Positive discussion se result nikalta hai."),
            SentenceItem("de_c1_5_7", "🌐", "Differenzierung verhindert voreilige Verallgemeinerungen.", "Differentiation prevents hasty generalizations.", "تفریق اور فہم جلد بازی کی عمومی باتوں کو روکتی ہے۔", "Sahi samajh se ghalat fehmi door hoti hai."),
            SentenceItem("de_c1_5_8", "✨", "Weitsicht ist in Krisenzeiten unerlässlich.", "Foresight is essential in times of crisis.", "بحران کے وقت دور اندیشی ناگزیر ہے۔", "Mushkil waqt mein door-andeshi lazmi hai.")
        )
    )

    // C2 Lessons (Near Native Mastery)
    private fun createC2Lesson1() = Lesson(
        id = "de_c2_1",
        languageId = "de",
        level = CefrLevel.C2,
        title = "Idioms & Expressions",
        romanUrduTitle = "Muhawray aur Rozmarrah (Redewendungen)",
        iconEmoji = "🎭",
        grammarTipRomanUrdu = "German muhawray lafzi nahi hote, unka maqsad samajhna zaroori hai.",
        grammarTipEn = "Idiomatic mastery: never translate word for word.",
        sentences = listOf(
            SentenceItem("de_c2_1_1", "🍀", "Ich drücke dir ganz fest die Daumen!", "I keep my fingers crossed for you!", "میری دعائیں اور نیک تمنائیں آپ کے ساتھ ہیں!", "Main aap ke liye dua-go hoon! (Best of luck)"),
            SentenceItem("de_c2_1_2", "🍎", "Man muss in den sauren Apfel beißen.", "One has to bite the bullet.", "ناگوار کام بھی مجبوری میں کرنا پڑتا ہے۔", "Kharwa ghoont peena parta hai."),
            SentenceItem("de_c2_1_3", "🚆", "Ich verstehe nur Bahnhof.", "It's all Greek to me / I understand nothing.", "مجھے کچھ سمجھ نہیں آ رہا۔", "Mujhe kuch palle nahi parh raha."),
            SentenceItem("de_c2_1_4", "🧈", "Alles in Butter!", "Everything is fine and dandy!", "سب کچھ بالکل ٹھیک ٹھاک ہے!", "Sab bilkul first class hai!"),
            SentenceItem("de_c2_1_5", "🥖", "Das geht weg wie warme Semmeln.", "That is selling like hot cakes.", "یہ ہاتھوں ہاتھ بک رہا ہے۔", "Ye hathon haath bik raha hai."),
            SentenceItem("de_c2_1_6", "🔨", "Den Nagel auf den Kopf treffen.", "To hit the nail on the head.", "بالکل ٹھیک نشانے پر بات کرنا۔", "Nishane par teer maarna."),
            SentenceItem("de_c2_1_7", "🐷", "Da hast du aber Schwein gehabt!", "You got really lucky there!", "آپ کی قسمت بہت اچھی تھی!", "Aap ki bari qismat thi!"),
            SentenceItem("de_c2_1_8", "☕", "Abwarten und Tee trinken.", "Wait and see patiently.", "صبر کریں اور انتظار کریں۔", "Sabar ka ghoont bharein aur intezar karein.")
        )
    )

    private fun createC2Lesson2() = Lesson(
        id = "de_c2_2",
        languageId = "de",
        level = CefrLevel.C2,
        title = "Formal Writing & Eloquence",
        romanUrduTitle = "Aala Tareen Tehreeq aur Fasahat",
        iconEmoji = "🖋️",
        grammarTipRomanUrdu = "C2 mein lafzon ka intekhab intehai pur-waqar aur moazziz hota hai.",
        grammarTipEn = "Refined vocabulary for diplomacy, senior governance, and law.",
        sentences = listOf(
            SentenceItem("de_c2_2_1", "📜", "Wir beehren uns, Ihnen folgendes mitzuteilen.", "We have the honor to inform you of the following.", "ہمیں آپ کو مطلع کرنے کا شرف حاصل ہے۔", "Humein aap ko batane ka sharaf haasil hai."),
            SentenceItem("de_c2_2_2", "🤝", "In Würdigung Ihrer außerordentlichen Verdienste...", "In appreciation of your extraordinary merits...", "آپ کی غیر معمولی خدمات کے اعتراف میں...", "Aap ki be-misaal khidmaat ke aite-raaf mein..."),
            SentenceItem("de_c2_2_3", "⚖️", "Vorbehaltlich etwaiger behördlicher Genehmigungen.", "Subject to any regulatory approvals.", "سرکاری اجازت ناموں کے حصول سے مشروط۔", "Sarkari ijazat se mashroot."),
            SentenceItem("de_c2_2_4", "🖋️", "Hiermit bestätige ich die Richtigkeit der Angaben an Eides statt.", "I hereby affirm the accuracy in lieu of an oath.", "میں حلفیہ ان تفصیلات کی درستگی کی تصدیق کرتا ہوں۔", "Main halfan is ki tasdeeq karta hoon."),
            SentenceItem("de_c2_2_5", "🏛️", "Im Einklang mit den verfassungsrechtlichen Grundsätzen.", "In accordance with constitutional principles.", "آئینی اصولوں کے عین مطابق۔", "Aaeeni asoolon ke mutabiq."),
            SentenceItem("de_c2_2_6", "🕊️", "Wir versichern Ihnen unsere vollste Hochachtung.", "We assure you of our highest consideration.", "ہم آپ کی مکمل عزت و تکریم کی یقین دہانی کراتے ہیں۔", "Hum aap ko aala tareen ehtiram pesh karte hain."),
            SentenceItem("de_c2_2_7", "📑", "Das Vertragswerk tritt mit sofortiger Wirkung in Kraft.", "The treaty enters into force with immediate effect.", "معاہدہ فوری طور پر نافذ العمل ہوگا۔", "Agreement foran naafiz-ul-amal hoga."),
            SentenceItem("de_c2_2_8", "✨", "Möge dieses Vorhaben von Erfolg gekrönt sein.", "May this venture be crowned with success.", "اللہ کرے کہ یہ منصوبہ کامیابی سے ہمکنار ہو۔", "Khuda kare ke ye mansooba kamyab ho.")
        )
    )

    private fun createC2Lesson3() = Lesson(
        id = "de_c2_3",
        languageId = "de",
        level = CefrLevel.C2,
        title = "Humour & Irony",
        romanUrduTitle = "Zarafat aur Tanz (Humor & Irony)",
        iconEmoji = "😄",
        grammarTipRomanUrdu = "German tanz (irony) hamesha sanjeeda chehre ke saath ada hota hai.",
        grammarTipEn = "Master dry German humor, sarcasm, and playful wit.",
        sentences = listOf(
            SentenceItem("de_c2_3_1", "☔", "Typisches Kaiserwetter heute!", "Typical magnificent weather today! (said in heavy rain)", "آج کیا شاندار دھوپ نکلی ہے! (شدید بارش میں طنز)", "Kamaal ka mausam hai! (barish mein mazaq)"),
            SentenceItem("de_c2_3_2", "😴", "Da kommt aber richtig Feierabendstimmung auf.", "That really sets the after-work mood.", "اب آ رہا ہے نہ چھٹی کا مزہ۔", "Ab kaam se chutti ka feel aa raha hai."),
            SentenceItem("de_c2_3_3", "🤷‍♂️", "Wer den Schaden hat, braucht für den Spott nicht zu sorgen.", "He who has the damage needs not worry about mockery.", "نقصان والے کا مذاق اڑانے والے خود پہنچ جاتے ہیں۔", "Jiska nuqsan ho, log mazaq khud hi uda lete hain."),
            SentenceItem("de_c2_3_4", "🐌", "Die Bahn kommt heute mal wieder überraschend pünktlich.", "The train is surprisingly on time today (irony).", "آج ٹرین حیرت انگیز طور پر وقت پر ہے۔", "Aaj train time par aa gayi, ajeeb baat hai."),
            SentenceItem("de_c2_3_5", "💡", "Das hast du ja wieder glänzend eingefädelt.", "You set that up brilliantly again! (teasing)", "واہ! کیا شاندار انتظام کیا ہے تم نے!", "Wah! Kya scheme lagayi hai!"),
            SentenceItem("de_c2_3_6", "😆", "Ironie ist der Humor der Gebildeten.", "Irony is the humor of the educated.", "طنز و مزاح باشعور انسان کی نشانی ہے۔", "Irony parhe likhe logon ka mazaq hai."),
            SentenceItem("de_c2_3_7", "🎉", "Man soll den Tag nicht vor dem Abend loben.", "Don't count your chickens before they hatch.", "دن ختم ہونے سے پہلے تعریف مت کرو۔", "Pehle se khushian mat manao."),
            SentenceItem("de_c2_3_8", "😉", "Das war ja ein Schuss in den Ofen.", "That was a complete flop.", "یہ تیر نشانے کے بالکل الٹ جا لگا۔", "Ye to bilkul flop ho gaya.")
        )
    )

    private fun createC2Lesson4() = Lesson(
        id = "de_c2_4",
        languageId = "de",
        level = CefrLevel.C2,
        title = "Near-Native Fluency",
        romanUrduTitle = "Muntakhab Qabil-e-Rashk Rawani",
        iconEmoji = "🗣️",
        grammarTipRomanUrdu = "Mukhtalif shobon ki istalahat ko rawani se jodna C2 ka meyar hai.",
        grammarTipEn = "Effortless, seamless command of conversational subtleties.",
        sentences = listOf(
            SentenceItem("de_c2_4_1", "🌊", "Er spricht Deutsch wie seine eigene Muttersprache.", "He speaks German like his own mother tongue.", "وہ اپنی مادری زبان کی طرح جرمن بولتا ہے۔", "Wo bilkul native ki tarah German bolta hai."),
            SentenceItem("de_c2_4_2", "🎯", "Er findet intuitiv die treffendsten Worte.", "He intuitively finds the most apt words.", "وہ فطری طور پر بہترین الفاظ چنتا ہے۔", "Wo khud-ba-khud lajawab alfaaz bolta hai."),
            SentenceItem("de_c2_4_3", "💡", "Zwischen den Zeilen lesen können.", "Being able to read between the lines.", "چھپے ہوئے مفہوم کو سمجھ لینا۔", "Baat ki teh tak pohanch jana."),
            SentenceItem("de_c2_4_4", "🤝", "Sich mühelos in jeder Gesellschaftsschicht bewegen.", "To navigate effortlessly in any social stratum.", "ہر محفل میں بلا جھجک گھل مل جانا۔", "Har group mein asaani se baat karna."),
            SentenceItem("de_c2_4_5", "⚡", "Spontan und schlagfertig reagieren.", "To react spontaneously and quick-wittedly.", "برجستہ اور حاضر جوابی سے ردعمل دینا۔", "Hazir-jawabi se foran jawab dena."),
            SentenceItem("de_c2_4_6", "🎭", "Den Tonfall der Situation exakt anpassen.", "To adjust tone of voice precisely to the context.", "حالات کے مطابق لہجہ تبدیل کر لینا۔", "Mahaul dekh kar lehja badalna."),
            SentenceItem("de_c2_4_7", "📖", "Kulturelle Anspielungen sofort deuten.", "To decode cultural allusions instantly.", "ثقافتی اشاروں کو فورا سمجھ لینا۔", "Cultural references ko turant samajhna."),
            SentenceItem("de_c2_4_8", "🌟", "Wahre Meisterschaft zeigt sich in der Leichtigkeit.", "True mastery shows in effortless ease.", "حقیقی مہارت آسانی اور بے ساختگی میں جھلکتی ہے۔", "Asal ustaad wo hai jise mushkil kaam bhi asaan lage.")
        )
    )

    private fun createC2Lesson5() = Lesson(
        id = "de_c2_5",
        languageId = "de",
        level = CefrLevel.C2,
        title = "Debating Complex Topics",
        romanUrduTitle = "Pechida Masail par Munazra",
        iconEmoji = "🌐",
        grammarTipRomanUrdu = "Falsafiyana aur ilmi behes mein daleel ko aage rakhna zaroori hota hai.",
        grammarTipEn = "Synthesizing contradictory viewpoints at an expert level.",
        sentences = listOf(
            SentenceItem("de_c2_5_1", "🧬", "Bioethische Fragestellungen erfordern Augenmaß.", "Bioethical questions require prudent judgment.", "حیاتیاتی اخلاقیات تدبر اور احتیاط کا تقاضا کرتی ہیں۔", "Bioethics mein bohot ehtiyat zaroori hai."),
            SentenceItem("de_c2_5_2", "⚖️", "Freiheit und Sicherheit stehen im permanenten Spannungsverhältnis.", "Freedom and security stand in constant tension.", "آزادی اور تحفظ کے درمیان ہمیشہ کشمکش رہتی ہے۔", "Azadi aur security ka aapas mein balance mushkil hai."),
            SentenceItem("de_c2_5_3", "🤖", "Die Souveränität des Menschen im Zeitalter der Algorithmen.", "Human sovereignty in the age of algorithms.", "الگورتھم کے دور میں انسان کا خودمختار وجود۔", "Computer algorithms ke daur mein insani ikhtiyar."),
            SentenceItem("de_c2_5_4", "🌍", "Globale Ressourcenverteilung ist ein moralischer Prüfstein.", "Global resource distribution is a moral touchstone.", "عالمی وسائل کی تقسیم ایک اخلاقی امتحان ہے۔", "Dunya ke resources baantna bara akhlaqi test hai."),
            SentenceItem("de_c2_5_5", "🏛️", "Institutionelle Resilienz schützt vor gesellschaftlicher Spaltung.", "Institutional resilience protects against polarization.", "اداروں کی مضبوطی سماجی تقسیم سے بچاتی ہے۔", "Mazboot institutions qom ko tootne se bachate hain."),
            SentenceItem("de_c2_5_6", "💡", "Ein Paradigmenwechsel zeichnet sich am Horizont ab.", "A paradigm shift is emerging on the horizon.", "فکری تبدیلی کے آثار افق پر نمودار ہو رہے ہیں۔", "Soch ka naya daur shuru ho raha hai."),
            SentenceItem("de_c2_5_7", "🔍", "Kritischer Rationalismus als Fundament der Erkenntnis.", "Critical rationalism as foundation of knowledge.", "تنقیدی عقل پسندی علم و ادراک کی بنیاد ہے۔", "Aql aur daleel ilm ki bunyad hai."),
            SentenceItem("de_c2_5_8", "🏆", "Der Diskurs muss von gegenseitiger Integrität getragen sein.", "The discourse must be borne by mutual integrity.", "مکالمے کی بنیاد باہمی دیانت داری پر ہونی چاہیے۔", "Guftagu mein dono taraf honesty honi chahiye.")
        )
    )
}
