package com.example.data

import com.example.model.CefrLevel
import com.example.model.Lesson
import com.example.model.SentenceItem

object EnglishCourseContent {
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

            // B1
            createB1Lesson1(),
            createB1Lesson2(),
            createB1Lesson3(),
            createB1Lesson4(),
            createB1WorkplaceLesson(),

            // B2
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
        id = "en_a1_1",
        languageId = "en",
        level = CefrLevel.A1,
        title = "Greetings & Introductions",
        romanUrduTitle = "Salam-Dua aur Ta'aruf",
        iconEmoji = "👋",
        grammarTipRomanUrdu = "Angrezi mein 'Nice to meet you' pehli mulaqat mein kehte hain.",
        grammarTipEn = "Use 'Nice to meet you' when meeting someone for the first time.",
        sentences = listOf(
            SentenceItem("en_a1_1_1", "👋", "Hello, how are you today?", "Hello, how are you today?", "ہیلو، آج آپ کیسے ہیں؟", "Hello, aaj aap kaise hain?"),
            SentenceItem("en_a1_1_2", "😊", "I am very good, thank you.", "I am very good, thank you.", "میں بہت اچھا ہوں، شکریہ۔", "Main bohot theek hoon, thanks."),
            SentenceItem("en_a1_1_3", "🏷️", "My name is Bilal.", "My name is Bilal.", "میرا نام بلال ہے۔", "Mera naam Bilal hai."),
            SentenceItem("en_a1_1_4", "🤝", "Nice to meet you!", "Nice to meet you!", "آپ سے مل کر خوشی ہوئی!", "Aap se mil kar khushi hui!"),
            SentenceItem("en_a1_1_5", "🇵🇰", "I am from Pakistan.", "I am from Pakistan.", "میرا تعلق پاکستان سے ہے۔", "Main Pakistan se hoon."),
            SentenceItem("en_a1_1_6", "🏙️", "I live in London.", "I live in London.", "میں لندن میں رہتا ہوں۔", "Main London mein rehta hoon."),
            SentenceItem("en_a1_1_7", "🗣️", "I speak Urdu and English.", "I speak Urdu and English.", "میں اردو اور انگریزی بولتا ہوں۔", "Main Urdu aur English bolta hoon."),
            SentenceItem("en_a1_1_8", "🙋‍♂️", "Have a wonderful day!", "Have a wonderful day!", "آپ کا دن بہت اچھا گزرے!", "Aap ka din shandar guzre!")
        )
    )

    private fun createA1Lesson2() = Lesson(
        id = "en_a1_2",
        languageId = "en",
        level = CefrLevel.A1,
        title = "Numbers, Days & Time",
        romanUrduTitle = "Ginti, Din aur Waqt",
        iconEmoji = "🕗",
        grammarTipRomanUrdu = "Waqt batane ke liye 'It is...' aur din ke sath 'on' lagate hain (e.g., on Monday).",
        grammarTipEn = "Use preposition 'on' for days: 'on Monday', 'on Friday'.",
        sentences = listOf(
            SentenceItem("en_a1_2_1", "🔢", "One, two, three, four, five.", "One, two, three, four, five.", "ایک، دو، تین، چار، پانچ۔", "Ek, do, teen, char, paanch."),
            SentenceItem("en_a1_2_2", "📅", "Today is Monday.", "Today is Monday.", "آج پیر کا دن ہے۔", "Aaj Monday hai."),
            SentenceItem("en_a1_2_3", "⏰", "What time is it right now?", "What time is it right now?", "ابھی کیا وقت ہوا ہے؟", "Abhi kya time hua hai?"),
            SentenceItem("en_a1_2_4", "🕗", "It is eight o'clock in the morning.", "It is eight o'clock in the morning.", "صبح کے آٹھ بجے ہیں۔", "Subah ke 8 baje hain."),
            SentenceItem("en_a1_2_5", "🗓️", "We meet on Friday afternoon.", "We meet on Friday afternoon.", "ہم جمعہ کی سہ پہر ملیں گے۔", "Hum Friday afternoon ko milenge."),
            SentenceItem("en_a1_2_6", "⏳", "Please wait for five minutes.", "Please wait for five minutes.", "براہ کرم پانچ منٹ انتظار کریں۔", "5 minute intezar karein please."),
            SentenceItem("en_a1_2_7", "📆", "Tomorrow is my day off.", "Tomorrow is my day off.", "کل میری چھٹی ہے۔", "Kal mera off-day hai."),
            SentenceItem("en_a1_2_8", "🎯", "I am always on time.", "I am always on time.", "میں ہمیشہ وقت پر پہنچتا ہوں۔", "Main hamesha waqt ka paband hoon.")
        )
    )

    private fun createA1Lesson3() = Lesson(
        id = "en_a1_3",
        languageId = "en",
        level = CefrLevel.A1,
        title = "Family & Friends",
        romanUrduTitle = "Khandan aur Dost",
        iconEmoji = "👨‍👩‍👦",
        grammarTipRomanUrdu = "Angrezi mein 'This is my...' se family members ka ta'aruf karwayein.",
        grammarTipEn = "Introduce people using 'This is my brother / mother / friend'.",
        sentences = listOf(
            SentenceItem("en_a1_3_1", "👨", "This is my father.", "This is my father.", "یہ میرے والد ہیں۔", "Ye mere father hain."),
            SentenceItem("en_a1_3_2", "👩", "This is my mother.", "This is my mother.", "یہ میری والدہ ہیں۔", "Ye meri mother hain."),
            SentenceItem("en_a1_3_3", "👦", "I have two younger brothers.", "I have two younger brothers.", "میرے دو چھوٹے بھائی ہیں۔", "Mere do chote bhai hain."),
            SentenceItem("en_a1_3_4", "👧", "My sister lives in Canada.", "My sister lives in Canada.", "میری بہن کینیڈا میں رہتی ہے۔", "Meri behen Canada mein rehti hai."),
            SentenceItem("en_a1_3_5", "🤝", "He is my closest friend.", "He is my closest friend.", "وہ میرا سب سے قریبی دوست ہے۔", "Wo mera sab se pakka dost hai."),
            SentenceItem("en_a1_3_6", "🏡", "We live together in a nice house.", "We live together in a nice house.", "ہم ایک اچھے گھر میں ساتھ رہتے ہیں۔", "Hum ek achay ghar mein sath rehte hain."),
            SentenceItem("en_a1_3_7", "👶", "My nephew is very cute.", "My nephew is very cute.", "میرا بھتیجا بہت پیارا ہے۔", "Mera bhatija bohot pyara hai."),
            SentenceItem("en_a1_3_8", "❤️", "Family comes first in life.", "Family comes first in life.", "زندگی میں خاندان سب سے پہلے آتا ہے۔", "Zindagi mein family pehle aati hai.")
        )
    )

    private fun createA1Lesson4() = Lesson(
        id = "en_a1_4",
        languageId = "en",
        level = CefrLevel.A1,
        title = "Food & Drink",
        romanUrduTitle = "Khana aur Peena",
        iconEmoji = "🍕",
        grammarTipRomanUrdu = "Restaurant mein 'I would like...' (Main lena chahunga) sab se ba-adab jumla hai.",
        grammarTipEn = "Order politely using 'I would like a glass of water, please'.",
        sentences = listOf(
            SentenceItem("en_a1_4_1", "💧", "A glass of clean water, please.", "A glass of clean water, please.", "ایک گلاس صاف پانی، پلیز۔", "Ek glass saaf paani please."),
            SentenceItem("en_a1_4_2", "☕", "I drink black tea every morning.", "I drink black tea every morning.", "میں ہر صبح کالی چائے پیتا ہوں۔", "Main har subah black tea peeta hoon."),
            SentenceItem("en_a1_4_3", "🍕", "Can I order a vegetable pizza?", "Can I order a vegetable pizza?", "کیا میں سبزیوں والا پیزا آرڈر کر سکتا ہوں؟", "Kya main veg pizza order kar sakta hoon?"),
            SentenceItem("en_a1_4_4", "🍽️", "This dish is very delicious.", "This dish is very delicious.", "یہ کھانا بہت لذیذ ہے۔", "Ye khana bohot mazedar hai."),
            SentenceItem("en_a1_4_5", "🤤", "I am hungry, let us eat.", "I am hungry, let us eat.", "مجھے بھوک لگی ہے، آئیں کھاتے ہیں۔", "Mujhe bhook lagi hai, chalo khana khate hain."),
            SentenceItem("en_a1_4_6", "🥗", "Fresh salad is good for health.", "Fresh salad is good for health.", "تازہ سلاد صحت کے لیے اچھا ہے۔", "Fresh salad sehat ke liye acha hai."),
            SentenceItem("en_a1_4_7", "💳", "Could you bring the bill, please?", "Could you bring the bill, please?", "کیا آپ بل لا سکتے ہیں، پلیز؟", "Bill laa dijiye please?"),
            SentenceItem("en_a1_4_8", "✨", "Thank you for the wonderful meal.", "Thank you for the wonderful meal.", "شاندار کھانے کا شکریہ۔", "Lajawab khane ka bohot shukriya.")
        )
    )

    private fun createA1Lesson5() = Lesson(
        id = "en_a1_5",
        languageId = "en",
        level = CefrLevel.A1,
        title = "Daily Routine",
        romanUrduTitle = "Rozmarah ka Mamool",
        iconEmoji = "🌅",
        grammarTipRomanUrdu = "Present simple tense mein 'I wake up', 'I go to work' aam aadat ke liye use hota hai.",
        grammarTipEn = "Use simple present tense for habitual daily actions.",
        sentences = listOf(
            SentenceItem("en_a1_5_1", "⏰", "I wake up at six in the morning.", "I wake up at six in the morning.", "میں صبح چھ بجے جاگتا ہوں۔", "Main subah 6 baje jagta hoon."),
            SentenceItem("en_a1_5_2", "🚿", "I take a shower and get dressed.", "I take a shower and get dressed.", "میں نہاتا ہوں اور کپڑے بدلتا ہوں۔", "Main nahata hoon aur kapde pehanta hoon."),
            SentenceItem("en_a1_5_3", "🍳", "I eat breakfast with my family.", "I eat breakfast with my family.", "میں اپنے گھر والوں کے ساتھ ناشتہ کرتا ہوں۔", "Main family ke sath nashta karta hoon."),
            SentenceItem("en_a1_5_4", "🚌", "I take the bus to work.", "I take the bus to work.", "میں کام پر جانے کے لیے بس پکڑتا ہوں۔", "Main kaam par bus se jata hoon."),
            SentenceItem("en_a1_5_5", "💻", "I work diligently until five PM.", "I work diligently until five PM.", "میں شام پانچ بجے تک تندہی سے کام کرتا ہوں۔", "Main 5 baje tak mehnat se kaam karta hoon."),
            SentenceItem("en_a1_5_6", "🏠", "I arrive home in the evening.", "I arrive home in the evening.", "میں شام کو گھر پہنچتا ہوں۔", "Main shaam ko ghar pohnchta hoon."),
            SentenceItem("en_a1_5_7", "📖", "I read a book before bed.", "I read a book before bed.", "میں سونے سے پہلے کتاب پڑھتا ہوں۔", "Main sone se pehle kitaab parhta hoon."),
            SentenceItem("en_a1_5_8", "🛏️", "Good night, sweet dreams!", "Good night, sweet dreams!", "شب بخیر، اچھے خواب دیکھیں!", "Shab-bakhair, achay khwab dekhein!")
        )
    )

    // A2 Lessons
    private fun createA2Lesson1() = Lesson(
        id = "en_a2_1",
        languageId = "en",
        level = CefrLevel.A2,
        title = "Shopping & Money",
        romanUrduTitle = "Khariddari aur Paise",
        iconEmoji = "🛒",
        grammarTipRomanUrdu = "Qeemat poochne ke liye 'How much is this?' ya 'How much does it cost?'.",
        grammarTipEn = "Ask prices politely with 'How much is this item, please?'.",
        sentences = listOf(
            SentenceItem("en_a2_1_1", "🏷️", "How much does this cost?", "How much does this cost?", "اس کی قیمت کتنی ہے؟", "Is ki qeemat kitni hai?"),
            SentenceItem("en_a2_1_2", "💳", "Do you accept credit card payments?", "Do you accept credit card payments?", "کیا آپ کریڈٹ کارڈ کی ادائیگی قبول کرتے ہیں؟", "Kya aap credit card payment lete hain?"),
            SentenceItem("en_a2_1_3", "👕", "Can I try this shirt on?", "Can I try this shirt on?", "کیا میں یہ شرٹ پہن کر دیکھ سکتا ہوں؟", "Kya main ye shirt try kar sakta hoon?"),
            SentenceItem("en_a2_1_4", "🛍️", "Where is the changing room?", "Where is the changing room?", "کپڑے بدلنے کا کمرہ کہاں ہے؟", "Changing room kahan hai?"),
            SentenceItem("en_a2_1_5", "🏷️", "Is there any special discount today?", "Is there any special discount today?", "کیا آج کوئی خاص رعایت (ڈسکاؤنٹ) ہے؟", "Kya aaj koi special discount hai?"),
            SentenceItem("en_a2_1_6", "🪙", "Here is your change and receipt.", "Here is your change and receipt.", "یہ رہے آپ کے بقایا پیسے اور رسید۔", "Ye rahe aap ke bache hue paise aur receipt."),
            SentenceItem("en_a2_1_7", "💸", "This is too expensive for me.", "This is too expensive for me.", "یہ میرے لیے بہت مہنگا ہے۔", "Ye bohot mehnga hai."),
            SentenceItem("en_a2_1_8", "👍", "I will take this one, thank you.", "I will take this one, thank you.", "میں یہ لوں گا، شکریہ۔", "Main ye khareedunga, shukriya.")
        )
    )

    private fun createA2Lesson2() = Lesson(
        id = "en_a2_2",
        languageId = "en",
        level = CefrLevel.A2,
        title = "Directions & Places",
        romanUrduTitle = "Raste aur Maqamat",
        iconEmoji = "🧭",
        grammarTipRomanUrdu = "Rasta batane ke liye 'Go straight' (seedha jayein), 'Turn right' (daayein mudein).",
        grammarTipEn = "Direction keywords: straight, turn left, turn right, opposite to.",
        sentences = listOf(
            SentenceItem("en_a2_2_1", "📍", "Excuse me, where is the nearest metro station?", "Excuse me, where is the nearest metro station?", "معاف کیجیے گا، قریبی میٹرو اسٹیشن کہاں ہے؟", "Qareebi metro station kahan hai?"),
            SentenceItem("en_a2_2_2", "➡️", "Go straight down this street.", "Go straight down this street.", "اس گلی میں بالکل سیدھا جائیں۔", "Is raste par seedha jayein."),
            SentenceItem("en_a2_2_3", "↪️", "Turn right at the second corner.", "Turn right at the second corner.", "دوسرے کونے سے دائیں مڑیں۔", "Doosray corner se right turn lein."),
            SentenceItem("en_a2_2_4", "🏥", "The hospital is opposite the post office.", "The hospital is opposite the post office.", "ہسپتال ڈاک خانے کے سامنے ہے۔", "Hospital post office ke bilkul samne hai."),
            SentenceItem("en_a2_2_5", "🚶", "It is only a ten minute walk.", "It is only a ten minute walk.", "یہ صرف دس منٹ کا پیدل فاصلہ ہے۔", "Sirf 10 minute ka paidal rasta hai."),
            SentenceItem("en_a2_2_6", "🗺️", "Could you show me on Google Maps?", "Could you show me on Google Maps?", "کیا آپ نقشے پر دکھا سکتے ہیں؟", "Kya aap map par dikha sakte hain?"),
            SentenceItem("en_a2_2_7", "🚕", "Let us take a taxi instead.", "Let us take a taxi instead.", "آئیں اس کے بجائے ٹیکسی لے لیتے ہیں۔", "Chalo taxi le lete hain."),
            SentenceItem("en_a2_2_8", "🎯", "You have arrived at your destination.", "You have arrived at your destination.", "آپ اپنی منزل پر پہنچ چکے ہیں۔", "Aap manzil par pohanch gaye hain.")
        )
    )

    private fun createA2Lesson3() = Lesson(
        id = "en_a2_3",
        languageId = "en",
        level = CefrLevel.A2,
        title = "Health & Body",
        romanUrduTitle = "Sehat aur Jism",
        iconEmoji = "🩺",
        grammarTipRomanUrdu = "Bimari batane ke liye: 'I have a headache' ya 'My back hurts'.",
        grammarTipEn = "Use 'I have a...' for medical symptoms (fever, cold, sore throat).",
        sentences = listOf(
            SentenceItem("en_a2_3_1", "🤒", "I am feeling sick and have a fever.", "I am feeling sick and have a fever.", "میری طبیعت ناساز ہے اور مجھے بخار ہے۔", "Mujhe bukhar hai aur tabiyat kharab hai."),
            SentenceItem("en_a2_3_2", "🤕", "My head hurts really badly.", "My head hurts really badly.", "میرے سر میں بہت شدید درد ہے۔", "Mere sar mein bohot shadeed dard hai."),
            SentenceItem("en_a2_3_3", "👨‍⚕️", "I would like to book a doctor appointment.", "I would like to book a doctor appointment.", "میں ڈاکٹر سے اپوائنٹمنٹ بک کرنا چاہتا ہوں۔", "Main doctor appointment book karna chahta hoon."),
            SentenceItem("en_a2_3_4", "💊", "Take this medicine twice a day.", "Take this medicine twice a day.", "یہ دوا دن میں دو بار لیں۔", "Ye dawa din mein 2 dafa lein."),
            SentenceItem("en_a2_3_5", "😷", "I have a cough and runny nose.", "I have a cough and runny nose.", "مجھے کھانسی اور زکام ہے۔", "Mujhe khansi aur zukaam hai."),
            SentenceItem("en_a2_3_6", "🏥", "Where can I find an open pharmacy?", "Where can I find an open pharmacy?", "کھلی ہوئی فارمیسی کہاں مل سکتی ہے؟", "Khuli pharmacy kahan milegi?"),
            SentenceItem("en_a2_3_7", "🛏️", "Get plenty of rest and drink warm water.", "Get plenty of rest and drink warm water.", "خوب آرام کریں اور نیم گرم پانی پئیں۔", "Aram karein aur garam paani piyein."),
            SentenceItem("en_a2_3_8", "🩺", "Wishing you a speedy recovery!", "Wishing you a speedy recovery!", "آپ کی جلد صحت یابی کی دعا ہے!", "Jald sehatyab hon!")
        )
    )

    private fun createA2Lesson4() = Lesson(
        id = "en_a2_4",
        languageId = "en",
        level = CefrLevel.A2,
        title = "Work & Jobs",
        romanUrduTitle = "Kaam aur Mulazmat",
        iconEmoji = "💼",
        grammarTipRomanUrdu = "Apni post batane ke liye 'I work as a...' (Main bataur... kaam karta hoon).",
        grammarTipEn = "Use 'I work as a [job title]' in English interviews.",
        sentences = listOf(
            SentenceItem("en_a2_4_1", "👷", "I work as a customer service specialist.", "I work as a customer service specialist.", "میں کسٹمر سروس سپیشلسٹ کے طور پر کام کرتا ہوں۔", "Main customer service mein kaam karta hoon."),
            SentenceItem("en_a2_4_2", "⏰", "My work shift begins at nine sharp.", "My work shift begins at nine sharp.", "میرے کام کی شفٹ ٹھیک نو بجے شروع ہوتی ہے۔", "Meri shift theek 9 baje shuru hoti hai."),
            SentenceItem("en_a2_4_3", "👔", "Our manager is very understanding.", "Our manager is very understanding.", "ہمارے مینیجر بہت سمجھدار اور معاون ہیں۔", "Hamare manager bohot cooperative hain."),
            SentenceItem("en_a2_4_4", "🤝", "Teamwork makes the dream work.", "Teamwork makes the dream work.", "ٹیم کے ساتھ مل کر کام کرنے سے کامیابی ملتی ہے۔", "Teamwork se har mushkil asaan hoti hai."),
            SentenceItem("en_a2_4_5", "📋", "Please check this task checklist.", "Please check this task checklist.", "براہ کرم اس کام کی فہرست چیک کریں۔", "Checklist check kar lijiye please."),
            SentenceItem("en_a2_4_6", "☕", "Let us take a quick tea break.", "Let us take a quick tea break.", "آئیں چائے کا ایک مختصر وقفہ لیتے ہیں۔", "Chalo chai ka chota sa break lete hain."),
            SentenceItem("en_a2_4_7", "📞", "I will call the supplier right away.", "I will call the supplier right away.", "میں ابھی سپلائر کو فون کرتا ہوں۔", "Main abhi supplier ko call karta hoon."),
            SentenceItem("en_a2_4_8", "📝", "I have submitted my daily progress report.", "I have submitted my daily progress report.", "میں نے اپنی روزانہ کی رپورٹ جمع کرا دی ہے۔", "Maine daily report submit kar di hai.")
        )
    )

    private fun createA2Lesson5() = Lesson(
        id = "en_a2_5",
        languageId = "en",
        level = CefrLevel.A2,
        title = "Travel & Holidays",
        romanUrduTitle = "Safar aur Chuttiyan",
        iconEmoji = "✈️",
        grammarTipRomanUrdu = "Mustaqbil ke safar ke liye 'I am going to travel next month' use karein.",
        grammarTipEn = "Use 'going to' for planned travel: 'I am going to visit Dubai'.",
        sentences = listOf(
            SentenceItem("en_a2_5_1", "🎫", "I need to book a round-trip ticket.", "I need to book a round-trip ticket.", "مجھے آنے جانے کا ریٹرن ٹکٹ بک کرنا ہے۔", "Mujhe return ticket book karna hai."),
            SentenceItem("en_a2_5_2", "🛫", "The flight will take off on time.", "The flight will take off on time.", "پرواز وقت پر روانہ ہوگی۔", "Flight time par take-off karegi."),
            SentenceItem("en_a2_5_3", "🏨", "Does the hotel room include breakfast?", "Does the hotel room include breakfast?", "کیا ہوٹل کے کمرے میں ناشتہ شامل ہے؟", "Kya hotel room mein nashta shamil hai?"),
            SentenceItem("en_a2_5_4", "🧳", "Keep your luggage safe and locked.", "Keep your luggage safe and locked.", "اپنے سامان کی حفاظت کریں اور تالا لگائیں۔", "Apna saman safe rakhein."),
            SentenceItem("en_a2_5_5", "🛂", "Please show your boarding pass and passport.", "Please show your boarding pass and passport.", "براہ کرم اپنا بورڈنگ پاس اور پاسپورٹ دکھائیں۔", "Boarding pass aur passport dikhayein."),
            SentenceItem("en_a2_5_6", "🏖️", "I love exploring new cities and cultures.", "I love exploring new cities and cultures.", "مجھے نئے شہروں اور ثقافتوں کو دیکھنا پسند ہے۔", "Mujhe naye sheher dekhna pasand hai."),
            SentenceItem("en_a2_5_7", "📸", "Can you take a picture of us, please?", "Can you take a picture of us, please?", "کیا آپ ہماری ایک تصویر لے سکتے ہیں؟", "Kya aap hamari photo le sakte hain?"),
            SentenceItem("en_a2_5_8", "✨", "Have a safe and pleasant journey!", "Have a safe and pleasant journey!", "آپ کا سفر محفوظ اور خوشگوار ہو!", "Khairiat se pohnchein aur safe travel karein!")
        )
    )

    // B1 Lessons
    private fun createB1Lesson1() = Lesson(
        id = "en_b1_1",
        languageId = "en",
        level = CefrLevel.B1,
        title = "Opinions & Discussions",
        romanUrduTitle = "Rai aur Guftagu",
        iconEmoji = "💬",
        grammarTipRomanUrdu = "Apni rai batane ke liye 'From my perspective...' ya 'I believe that...'.",
        grammarTipEn = "Introduce your viewpoints: 'In my honest opinion...', 'I firmly believe...'.",
        sentences = listOf(
            SentenceItem("en_b1_1_1", "🤔", "In my honest opinion, this strategy will succeed.", "In my honest opinion, this strategy will succeed.", "میری دیانت دارانہ رائے میں یہ حکمت عملی کامیاب ہوگی۔", "Meri rai mein ye tareeqa kamyab hoga."),
            SentenceItem("en_b1_1_2", "👍", "I completely agree with your assessment.", "I completely agree with your assessment.", "میں آپ کے جائزے سے مکمل اتفاق کرتا ہوں۔", "Main aap ki baat se poora agree karta hoon."),
            SentenceItem("en_b1_1_3", "👎", "I respectfully disagree with that conclusion.", "I respectfully disagree with that conclusion.", "میں مؤدبانہ انداز میں اس نتیجے سے اختلاف کرتا ہوں۔", "Mera is se thoda ikhtilaf hai."),
            SentenceItem("en_b1_1_4", "💡", "Let us consider another creative alternative.", "Let us consider another creative alternative.", "آئیں کسی اور متبادل حل پر غور کرتے ہیں۔", "Kisi aur option par ghor karte hain."),
            SentenceItem("en_b1_1_5", "⚖️", "We have to weigh the pros and cons carefully.", "We have to weigh the pros and cons carefully.", "ہمیں فائدے اور نقصانات کو احتیاط سے پرکھنا ہوگا۔", "Pros aur cons ko achi tarah dekhna hoga."),
            SentenceItem("en_b1_1_6", "🗣️", "Could you elaborate a bit more on that point?", "Could you elaborate a bit more on that point?", "کیا آپ اس نکتے کی تھوڑی اور وضاحت کر سکتے ہیں؟", "Kya is point ko thoda aur samjha sakte hain?"),
            SentenceItem("en_b1_1_7", "🤝", "Finding common ground is our top priority.", "Finding common ground is our top priority.", "مشترکہ مفاہمت تلاش کرنا ہماری اولین ترجیح ہے۔", "Dono ki marzi ka rasta nikaalna priority hai."),
            SentenceItem("en_b1_1_8", "🎯", "That sounds like a fair and balanced compromise.", "That sounds like a fair and balanced compromise.", "یہ ایک منصفانہ اور متوازن حل لگتا ہے۔", "Ye ek behtareen samjhota lagta hai.")
        )
    )

    private fun createB1Lesson2() = Lesson(
        id = "en_b1_2",
        languageId = "en",
        level = CefrLevel.B1,
        title = "Future Plans & Dreams",
        romanUrduTitle = "Mustaqbil ke Mansoobe",
        iconEmoji = "🚀",
        grammarTipRomanUrdu = "Mustaqbil ke iradon ke liye 'I intend to...' ya 'I am determined to...'.",
        grammarTipEn = "Express strong intentions with 'I plan to' or 'I am aiming to'.",
        sentences = listOf(
            SentenceItem("en_b1_2_1", "🎓", "I am studying hard to pass my certification.", "I am studying hard to pass my certification.", "میں اپنا سرٹیفکیٹ پاس کرنے کے لیے سخت پڑھائی کر رہا ہوں۔", "Main certification pass karne ke liye mehnat kar raha hoon."),
            SentenceItem("en_b1_2_2", "💼", "My ambition is to build an international career.", "My ambition is to build an international career.", "میری خواہش ہے کہ بین الاقوامی کیریئر بناؤں۔", "Mera khwab international career banana hai."),
            SentenceItem("en_b1_2_3", "🏠", "I hope to buy a peaceful house for my parents.", "I hope to buy a peaceful house for my parents.", "مجھے امید ہے کہ والدین کے لیے ایک پرسکون گھر خریدوں گا۔", "Umeed hai walidain ke liye ghar khareedunga."),
            SentenceItem("en_b1_2_4", "🌟", "Continuous self-improvement is the key to success.", "Continuous self-improvement is the key to success.", "مسلسل سیکھنا ہی کامیابی کی کنجی ہے۔", "Roz kuch naya seekhna kamyabi deta hai."),
            SentenceItem("en_b1_2_5", "📈", "I am investing my time in mastering new skills.", "I am investing my time in mastering new skills.", "میں نئی مہارتیں حاصل کرنے میں اپنا وقت لگا رہا ہوں۔", "Main nayi skills seekhne par waqt laga raha hoon."),
            SentenceItem("en_b1_2_6", "✈️", "I want to travel across European countries.", "I want to travel across European countries.", "میں یورپی ممالک کا سفر کرنا چاہتا ہوں۔", "Main Europe dekhna chahta hoon."),
            SentenceItem("en_b1_2_7", "🌐", "Speaking multiple languages opens global doors.", "Speaking multiple languages opens global doors.", "کئی زبانیں بولنا دنیا کے دروازے کھولتا ہے۔", "Kayi zabanein bolne se mawake barhte hain."),
            SentenceItem("en_b1_2_8", "🏆", "Never give up on your biggest dreams.", "Never give up on your biggest dreams.", "اپنے بڑے خوابوں پر کبھی ہار مت مانیں۔", "Apne khwabon par kabhi himmat mat haro.")
        )
    )

    private fun createB1Lesson3() = Lesson(
        id = "en_b1_3",
        languageId = "en",
        level = CefrLevel.B1,
        title = "Work & Career",
        romanUrduTitle = "Kaam aur Career",
        iconEmoji = "📈",
        grammarTipRomanUrdu = "Past experience batane ke liye Present Perfect: 'I have worked in logistics for 3 years'.",
        grammarTipEn = "Use Present Perfect to talk about accumulated work experience.",
        sentences = listOf(
            SentenceItem("en_b1_3_1", "📄", "Here is my updated resume with all references.", "Here is my updated resume with all references.", "یہ رہا میرا اپ ڈیٹڈ ریزیومے مع حوالہ جات۔", "Ye mera updated resume hai."),
            SentenceItem("en_b1_3_2", "💼", "I have five years of hands-on technical experience.", "I have five years of hands-on technical experience.", "میرے پاس پانچ سال کا عملی تکنیکی تجربہ ہے۔", "Mere paas 5 saal ka practical tajurba hai."),
            SentenceItem("en_b1_3_3", "⏱️", "I perform exceptionally well under pressure.", "I perform exceptionally well under pressure.", "میں دباؤ کے تحت بہت شاندار کارکردگی دکھاتا ہوں۔", "Main pressure mein acha kaam karta hoon."),
            SentenceItem("en_b1_3_4", "🤝", "I communicate clearly with clients and coworkers.", "I communicate clearly with clients and coworkers.", "میں گاہکوں اور ساتھیوں سے واضح بات چیت کرتا ہوں۔", "Main clients aur team se clear baat karta hoon."),
            SentenceItem("en_b1_3_5", "💡", "I constantly look for ways to optimize workflow.", "I constantly look for ways to optimize workflow.", "میں کام کے طریقے کو بہتر بنانے کے مواقع تلاش کرتا رہتا ہوں۔", "Main kaam asaan aur behtar karne ki koshish karta hoon."),
            SentenceItem("en_b1_3_6", "📞", "Thank you for the interview invitation.", "Thank you for the interview invitation.", "انٹرویو کی دعوت کا شکریہ۔", "Interview ki dawat ka shukriya."),
            SentenceItem("en_b1_3_7", "🏅", "Dedication and honesty are my core values.", "Dedication and honesty are my core values.", "لگن اور دیانت داری میری بنیادی اقدار ہیں۔", "Mehnat aur imandari meri bunyad hain."),
            SentenceItem("en_b1_3_8", "🚀", "I am ready to embrace new professional challenges.", "I am ready to embrace new professional challenges.", "میں نئے پیشہ ورانہ چیلنجز قبول کرنے کو تیار ہوں۔", "Main naye challenges ke liye bilkul ready hoon.")
        )
    )

    private fun createB1Lesson4() = Lesson(
        id = "en_b1_4",
        languageId = "en",
        level = CefrLevel.B1,
        title = "Environment & Technology",
        romanUrduTitle = "Mahol aur Technology",
        iconEmoji = "🌱",
        grammarTipRomanUrdu = "Naseehat ke liye 'We should reduce plastic waste' (Humein plastic kam use karna chahiye).",
        grammarTipEn = "Use 'should' or 'ought to' for environmental responsibility.",
        sentences = listOf(
            SentenceItem("en_b1_4_1", "♻️", "Recycling plastic helps protect our planet.", "Recycling plastic helps protect our planet.", "پلاسٹک کو دوبارہ قابلِ استعمال بنانا سیارے کی حفاظت کرتا ہے۔", "Plastic recycle karna zaroori hai."),
            SentenceItem("en_b1_4_2", "⚡", "Clean solar energy reduces electricity costs.", "Clean solar energy reduces electricity costs.", "صاف شمسی توانائی بجلی کے اخراجات کم کرتی ہے۔", "Solar energy bijli ka kharcha kam karti hai."),
            SentenceItem("en_b1_4_3", "📱", "Modern apps make everyday tasks very efficient.", "Modern apps make everyday tasks very efficient.", "جدید ایپس روزمرہ کے کاموں کو آسان بناتی ہیں۔", "Modern apps se kaam asaan ho gaya hai."),
            SentenceItem("en_b1_4_4", "🚗", "Electric vehicles produce zero tailpipe emissions.", "Electric vehicles produce zero tailpipe emissions.", "الیکٹرک گاڑیاں دھواں خارج نہیں کرتیں۔", "Electric cars dhuan nahi chorti."),
            SentenceItem("en_b1_4_5", "🌳", "Planting trees fights global warming effectively.", "Planting trees fights global warming effectively.", "درخت لگانا ماحولیاتی تبدیلیوں کے خلاف مؤثر ہے۔", "Darakht lagane se garmi kam hoti hai."),
            SentenceItem("en_b1_4_6", "💻", "Remote work saves daily commuting time.", "Remote work saves daily commuting time.", "گھر سے کام کرنے سے روزانہ سفر کا وقت بچتا ہے۔", "Ghar se kaam karne se travel time bachta hai."),
            SentenceItem("en_b1_4_7", "🌊", "We must keep oceans and water sources clean.", "We must keep oceans and water sources clean.", "ہمیں سمندروں اور پانی کے ذرائع کو صاف رکھنا چاہیے۔", "Samandar aur daryao ko saaf rakhna chahiye."),
            SentenceItem("en_b1_4_8", "🌍", "Future generations depend on today's choices.", "Future generations depend on today's choices.", "مستقبل کی نسلیں ہمارے آج کے فیصلوں پر منحصر ہیں۔", "Aane wali nasal ka mustaqbil hamare aaj par hai.")
        )
    )

    // B1 Workplace special for English
    private fun createB1WorkplaceLesson() = Lesson(
        id = "en_b1_5",
        languageId = "en",
        level = CefrLevel.B1,
        title = "Workplace for Every Worker",
        romanUrduTitle = "Har Worker ke Rozana Kaam ke Jumlay",
        iconEmoji = "👷",
        isWorkplaceSpecial = true,
        grammarTipRomanUrdu = "Har international worker ke liye ye 8 jumlay rozana kaam mein sab se zyada bole jate hain.",
        grammarTipEn = "Universal essential workplace phrases for any job (retail, warehouse, hospitality, IT, logistics).",
        sentences = listOf(
            SentenceItem("en_b1_5_1", "⏰", "When does my shift start?", "When does my shift start?", "میری شفٹ کب شروع ہوتی ہے؟", "Mera shift kab shuru hota hai?"),
            SentenceItem("en_b1_5_2", "☕", "Where is the break room?", "Where is the break room?", "وقفے کا کمرہ کہاں ہے؟", "Waqfe ka kamra kahan hai?"),
            SentenceItem("en_b1_5_3", "🤝", "I need help with this task.", "I need help with this task.", "مجھے اس کام میں مدد چاہیے۔", "Mujhe is kaam mein madad chahiye."),
            SentenceItem("en_b1_5_4", "🦺", "Safety first, wear protective gear.", "Safety first, wear protective gear.", "حفاظت سب سے پہلے، حفاظتی سامان پہنیں۔", "Hifazat sab se pehle, protective gear pehnein."),
            SentenceItem("en_b1_5_5", "🏖️", "I would like to request leave / holiday.", "I would like to request leave / holiday.", "میں چھٹی کی درخواست کرنا چاہتا ہوں۔", "Main chutti ki darkhwast karna chahta hoon."),
            SentenceItem("en_b1_5_6", "🔁", "Could you please explain that again?", "Could you please explain that again?", "کیا آپ دوبارہ سمجھا سکتے ہیں؟", "Kya aap dobara explain kar sakte hain?"),
            SentenceItem("en_b1_5_7", "⚠️", "The machine is not working properly.", "The machine is not working properly.", "مشین ٹھیک کام نہیں کر رہی۔", "Machine theek kaam nahi kar rahi."),
            SentenceItem("en_b1_5_8", "✅", "I have finished my work for today.", "I have finished my work for today.", "میں نے آج کا کام ختم کر لیا ہے۔", "Maine aaj ka kaam finish kar liya hai.")
        )
    )

    // B2, C1, C2 samples
    private fun createB2Lesson1() = Lesson(
        id = "en_b2_1",
        languageId = "en",
        level = CefrLevel.B2,
        title = "Debates & Arguments",
        romanUrduTitle = "Behes aur Dalail",
        iconEmoji = "⚖️",
        grammarTipRomanUrdu = "Do mukhtalif pehlu batane ke liye 'On the one hand..., on the other hand...'.",
        grammarTipEn = "Structure formal arguments logically with discourse markers.",
        sentences = listOf(
            SentenceItem("en_b2_1_1", "⚖️", "On one hand there are opportunities, yet there are risks.", "On one hand there are opportunities, yet there are risks.", "ایک طرف مواقع ہیں، لیکن دوسری طرف خطرات بھی ہیں۔", "Ek taraf mawake hain par risks bhi."),
            SentenceItem("en_b2_1_2", "🎯", "I see your point, but let us look at the evidence.", "I see your point, but let us look at the evidence.", "میں آپ کی بات سمجھتا ہوں، لیکن شواہد کو بھی دیکھیں۔", "Aap ki baat theek hai par proof dekhein."),
            SentenceItem("en_b2_1_3", "💡", "We must take all external factors into consideration.", "We must take all external factors into consideration.", "ہمیں تمام بیرونی عوامل کو مدنظر رکھنا ہوگا۔", "Tamam baato ko zehen mein rakhna hoga."),
            SentenceItem("en_b2_1_4", "📊", "The analytical data clearly supports this stance.", "The analytical data clearly supports this stance.", "تجزیاتی ڈیٹا واضح طور پر اس مؤقف کی حمایت کرتا ہے۔", "Data is baat ko prove karta hai."),
            SentenceItem("en_b2_1_5", "🤝", "Despite differing views, we can reach consensus.", "Despite differing views, we can reach consensus.", "مختلف آراء کے باوجود ہم متفقہ حل تک پہنچ سکتے ہیں۔", "Ikhtilaf ke bawajood ittefaq ho sakta hai."),
            SentenceItem("en_b2_1_6", "🔍", "Let us evaluate the core problem systematically.", "Let us evaluate the core problem systematically.", "آئیں مسئلے کا باقاعدہ منظم طریقے سے جائزہ لیں۔", "Asal problem ko tarteeb se dekhte hain."),
            SentenceItem("en_b2_1_7", "🗣️", "I would like to emphasize this critical aspect.", "I would like to emphasize this critical aspect.", "میں اس اہم پہلو پر زور دینا چاہوں گا۔", "Main is ahem point par zor dena chahta hoon."),
            SentenceItem("en_b2_1_8", "✅", "We have reached an agreement on all essential matters.", "We have reached an agreement on all essential matters.", "ہم تمام ضروری امور پر متفق ہو چکے ہیں۔", "Hum tamam ahem baaton par agree kar chuke hain.")
        )
    )

    private fun createB2Lesson2() = Lesson(
        id = "en_b2_2",
        languageId = "en",
        level = CefrLevel.B2,
        title = "Business & Meetings",
        romanUrduTitle = "Business aur Meetings",
        iconEmoji = "💼",
        grammarTipRomanUrdu = "Professional meetings mein formal phrases istemal hote hain.",
        grammarTipEn = "Chair meetings using formal English discourse.",
        sentences = listOf(
            SentenceItem("en_b2_2_1", "📋", "Welcome everyone to our quarterly review meeting.", "Welcome everyone to our quarterly review meeting.", "سہ ماہی جائزے کے اجلاس میں خوش آمدید۔", "Quarterly meeting mein sab ko welcome."),
            SentenceItem("en_b2_2_2", "📌", "Let us move straight to the primary agenda item.", "Let us move straight to the primary agenda item.", "آئیں براہ راست پہلے ایجنڈے کے نکتے پر چلتے ہیں۔", "Seedha pehle agenda par aate hain."),
            SentenceItem("en_b2_2_3", "📈", "Our performance indicators showed notable growth.", "Our performance indicators showed notable growth.", "ہماری کارکردگی کے اشاریے نمایاں ترقی ظاہر کرتے ہیں۔", "Performance mein wazeh behtari aayi hai."),
            SentenceItem("en_b2_2_4", "🗓️", "Meeting this upcoming milestone is vital.", "Meeting this upcoming milestone is vital.", "اگلی تاریخ تک ہدف مکمل کرنا ناگزیر ہے۔", "Is milestone tak kaam finish karna zaroori hai."),
            SentenceItem("en_b2_2_5", "🤝", "I will spearhead this initiative moving forward.", "I will spearhead this initiative moving forward.", "میں آگے بڑھ کر اس منصوبے کی قیادت کروں گا۔", "Main is project ko aage lead karunga."),
            SentenceItem("en_b2_2_6", "📧", "I will distribute the action items via email.", "I will distribute the action items via email.", "میں اگلے اقدامات کی تفصیل بذریعہ ای میل بھیج دوں گا۔", "Main action items email kar dunga."),
            SentenceItem("en_b2_2_7", "👥", "Are there any further questions or concerns?", "Are there any further questions or concerns?", "کیا کوئی مزید سوالات یا تحفظات ہیں؟", "Kya koi mazeed sawal hai?"),
            SentenceItem("en_b2_2_8", "🎯", "Thank you all for your valuable contribution.", "Thank you all for your valuable contribution.", "آپ کی قیمتی شرکت اور تعاون کا شکریہ۔", "Aap sab ke ta'awun ka bohot shukriya.")
        )
    )

    private fun createB2Lesson3() = Lesson(
        id = "en_b2_3",
        languageId = "en",
        level = CefrLevel.B2,
        title = "News & Society",
        romanUrduTitle = "Khabrein aur Samaj",
        iconEmoji = "📰",
        grammarTipRomanUrdu = "Media English mein passive voice aur formal reporting verbs lagte hain.",
        grammarTipEn = "News reporting employs formal passive structures.",
        sentences = listOf(
            SentenceItem("en_b2_3_1", "📰", "The committee proposed comprehensive economic reforms.", "The committee proposed comprehensive economic reforms.", "کمیٹی نے جامع معاشی اصلاحات کی تجویز پیش کی۔", "Committee ne barhi reforms propose ki hain."),
            SentenceItem("en_b2_3_2", "💼", "Skilled professionals are in high market demand.", "Skilled professionals are in high market demand.", "ہنر مند افراد کی مارکیٹ میں زبردست مانگ ہے۔", "Skilled logon ki market mein demand hai."),
            SentenceItem("en_b2_3_3", "🏙️", "Affordable urban housing remains a persistent challenge.", "Affordable urban housing remains a persistent challenge.", "شہروں میں سستی رہائش بدستور ایک چیلنج ہے۔", "Shehron mein sasti rihaish bada masla hai."),
            SentenceItem("en_b2_3_4", "🌱", "Sustainable infrastructure drives sustainable prosperity.", "Sustainable infrastructure drives sustainable prosperity.", "پائیدار انفراسٹرکچر خوشحالی کو فروغ دیتا ہے۔", "Sustainable kaam se khushhali aati hai."),
            SentenceItem("en_b2_3_5", "💶", "Central banks monitored exchange rate volatility.", "Central banks monitored exchange rate volatility.", "مرکزی بینکوں نے شرح تبادلہ کے اتار چڑھاؤ پر نظر رکھی۔", "Banks currency rates par nazar rakhe hue hain."),
            SentenceItem("en_b2_3_6", "🌐", "Cultural empathy fosters communal cohesion.", "Cultural empathy fosters communal cohesion.", "ثقافتی ہمدردی باہمی ہم آہنگی کو پروان چڑھاتی ہے۔", "Apas ki hamdardi se mo'ashra mazboot hota hai."),
            SentenceItem("en_b2_3_7", "🗳️", "Active civic participation shapes progressive policy.", "Active civic participation shapes progressive policy.", "شہریوں کی سرگرم شرکت ترقی پسند پالیسیاں بناتی ہے۔", "Awam ki shirkat se achi policies banti hain."),
            SentenceItem("en_b2_3_8", "✨", "Equality before law is a cardinal constitutional right.", "Equality before law is a cardinal constitutional right.", "قانون کے سامنے برابری بنیادی آئینی حق ہے۔", "Qanoon ki nazar mein barabari sab ka haq hai.")
        )
    )

    private fun createB2Lesson4() = Lesson(
        id = "en_b2_4",
        languageId = "en",
        level = CefrLevel.B2,
        title = "Culture & Traditions",
        romanUrduTitle = "Saqafat aur Rawayat",
        iconEmoji = "🎭",
        grammarTipRomanUrdu = "Saqafati riwayaat bayan karne ke liye customary practices ka zikr karein.",
        grammarTipEn = "Describe traditions using cultural idioms.",
        sentences = listOf(
            SentenceItem("en_b2_4_1", "🌍", "Hospitality is deeply ingrained in Eastern heritage.", "Hospitality is deeply ingrained in Eastern heritage.", "مہمان نوازی مشرقی ورثے کا جزوِ لاینفک ہے۔", "Mehman-nawazi hamari tehzeeb ka hissa hai."),
            SentenceItem("en_b2_4_2", "🎉", "Festivals bring diverse communities together in joy.", "Festivals bring diverse communities together in joy.", "تہوار مختلف برادریوں کو خوشی میں یکجا کرتے ہیں۔", "Tehwar sab ko khushi mein milate hain."),
            SentenceItem("en_b2_4_3", "📚", "Folklore conveys timeless wisdom across generations.", "Folklore conveys timeless wisdom across generations.", "لوک کہانیاں نسل در نسل دانائی منتقل کرتی ہیں۔", "Lok kahaniyan aqal o daanai deti hain."),
            SentenceItem("en_b2_4_4", "🎨", "Artistic expression reflects societal evolutions.", "Artistic expression reflects societal evolutions.", "فنی اظہار معاشرتی ارتقاء کی عکاسی کرتا ہے۔", "Art society ke badlao ko dikhata hai."),
            SentenceItem("en_b2_4_5", "🍽️", "Traditional spices define the culinary identity.", "Traditional spices define the culinary identity.", "روایتی مصالحہ جات کھانوں کی شناخت بناتے ہیں۔", "Rawayati masalay khano ki pehchan hain."),
            SentenceItem("en_b2_4_6", "🏰", "Historical landmarks tell stories of ancient civilizations.", "Historical landmarks tell stories of ancient civilizations.", "تاریخی عمارات قدیم تہذیبوں کی کہانیاں سناتی ہیں۔", "Tareekhi jaghein purani civilizations ki kahani hain."),
            SentenceItem("en_b2_4_7", "🎶", "Music transcends linguistic and geographical barriers.", "Music transcends linguistic and geographical barriers.", "موسیقی زبان اور جغرافیے کی رکاوٹوں سے ماورا ہے۔", "Music zaban o sarhadon se be-niaz hai."),
            SentenceItem("en_b2_4_8", "✨", "Preserving cultural heritage enriches human civilization.", "Preserving cultural heritage enriches human civilization.", "ثقافتی ورثے کی حفاظت انسانی تہذیب کو مالامال کرتی ہے۔", "Virsa bachana insaniyat ki khidmat hai.")
        )
    )

    private fun createB2Lesson5() = Lesson(
        id = "en_b2_5",
        languageId = "en",
        level = CefrLevel.B2,
        title = "Formal Workplace Communication",
        romanUrduTitle = "Daftari aur Rasmi Zaban",
        iconEmoji = "📑",
        grammarTipRomanUrdu = "Email shuru karne ke liye 'Dear Sir or Madam' aur aakhir mein 'Sincerely' likhein.",
        grammarTipEn = "Master business letter etiquette and email sign-offs.",
        sentences = listOf(
            SentenceItem("en_b2_5_1", "✉️", "Dear Sir or Madam, I am writing regarding your inquiry.", "Dear Sir or Madam, I am writing regarding your inquiry.", "محترم جناب/محترمہ، میں آپ کی استفسار کے حوالے سے لکھ رہا ہوں۔", "Dear Sir/Madam, main aap ke inquiry ke silsile mein likh raha hoon."),
            SentenceItem("en_b2_5_2", "📝", "Please find attached the official documentation.", "Please find attached the official documentation.", "برائے کرم منسلک سرکاری دستاویزات ملاحظہ فرمائیں۔", "Official documents attachment mein mojood hain."),
            SentenceItem("en_b2_5_3", "🤝", "I would appreciate your feedback at your earliest convenience.", "I would appreciate your feedback at your earliest convenience.", "جلد از جلد آپ کی رائے کا خیرمقدم کروں گا۔", "Jaldi jawab mile to meherbani hogi."),
            SentenceItem("en_b2_5_4", "✍️", "Sincerely yours, Muhammad Bilal.", "Sincerely yours, Muhammad Bilal.", "مخلص، محمد بلال۔", "Sincerely yours (Rasmi sign-off)"),
            SentenceItem("en_b2_5_5", "📋", "Kindly confirm receipt of the contractual agreement.", "Kindly confirm receipt of the contractual agreement.", "معاہدے کی وصولی کی تصدیق فرمائیں۔", "Agreement milne ki tasdeeq karein please."),
            SentenceItem("en_b2_5_6", "⏳", "We are working diligently to expedite the shipment.", "We are working diligently to expedite the shipment.", "ہم سامان کی ترسیل کو تیز تر بنانے کے لیے کوشاں ہیں۔", "Hum shipment jaldi bhejne par kaam kar rahe hain."),
            SentenceItem("en_b2_5_7", "🏢", "It has been an absolute privilege working alongside you.", "It has been an absolute privilege working alongside you.", "آپ کے ساتھ کام کرنا باعثِ فخر رہا ہے۔", "Aap ke sath kaam karna faqr ki baat hai."),
            SentenceItem("en_b2_5_8", "🎯", "Do not hesitate to reach out should you require assistance.", "Do not hesitate to reach out should you require assistance.", "کسی بھی مدد کی ضرورت ہو تو بلا جھجک رابطہ کریں۔", "Kisi madad ki zaroorat ho to foran rabta karein.")
        )
    )

    // C1 Lessons
    private fun createC1Lesson1() = Lesson(
        id = "en_c1_1",
        languageId = "en",
        level = CefrLevel.C1,
        title = "Academic Language",
        romanUrduTitle = "Taleemi aur Tahqeeqi Zaban",
        iconEmoji = "🎓",
        grammarTipRomanUrdu = "Academic English mein precise research vocabulary istemal hoti hai.",
        grammarTipEn = "Use precise scholarly vocabulary for academic analysis.",
        sentences = listOf(
            SentenceItem("en_c1_1_1", "🔬", "Empirical evidence corroborates the initial hypothesis.", "Empirical evidence corroborates the initial hypothesis.", "مشاہداتی شواہد ابتدائی مفروضے کی توثیق کرتے ہیں۔", "Data is baat ko prove karta hai."),
            SentenceItem("en_c1_1_2", "📚", "The qualitative paradigm yields nuanced ethnographic insights.", "The qualitative paradigm yields nuanced ethnographic insights.", "معیاری طریقہ کار گہرے مشاہداتی بصیرت فراہم کرتا ہے۔", "Qualitative research se gehra ilm milta hai."),
            SentenceItem("en_c1_1_3", "📊", "Statistical significance was observed across all cohorts.", "Statistical significance was observed across all cohorts.", "تمام گروپوں میں شماریاتی اہمیت واضح طور پر دیکھی گئی۔", "Sab groups mein wazeh results mile."),
            SentenceItem("en_c1_1_4", "🔍", "This treatise scrutinizes the socioeconomic ramifications.", "This treatise scrutinizes the socioeconomic ramifications.", "یہ مقالہ سماجی و معاشی اثرات کا باریک بینی سے جائزہ لیتا ہے۔", "Ye research paper asraat ka jaiza leta hai."),
            SentenceItem("en_c1_1_5", "💡", "Hence, the postulate withstands rigorous methodological tests.", "Hence, the postulate withstands rigorous methodological tests.", "چنانچہ یہ اصول سخت امتحانی طریقوں پر پورا اترتا ہے۔", "Ye principle har test par poora utarta hai."),
            SentenceItem("en_c1_1_6", "📖", "The literature review synthesizes contradictory viewpoints.", "The literature review synthesizes contradictory viewpoints.", "ادبی جائزہ متضاد آراء کو یکجا کر کے پیش کرتا ہے۔", "Literature review mukhtalif aara ko milata hai."),
            SentenceItem("en_c1_1_7", "📑", "Interdisciplinary discourse enriches scientific discovery.", "Interdisciplinary discourse enriches scientific discovery.", "بین الشعبہ جاتی مکالمہ سائنسی دریافتوں کو نکھارتا ہے۔", "Mukhtalif fields mil kar kaam karein to taraqqi hoti hai."),
            SentenceItem("en_c1_1_8", "🎯", "Peer-reviewed publications preserve academic rigor.", "Peer-reviewed publications preserve academic rigor.", "ماہرین کی جانچ پڑتال علمی معیار کو برقرار رکھتی ہے۔", "Checking se research ka standard qayam rehta hai.")
        )
    )

    private fun createC1Lesson2() = Lesson(
        id = "en_c1_2", languageId = "en", level = CefrLevel.C1,
        title = "Politics & Society", romanUrduTitle = "Siyasat aur Samaj", iconEmoji = "🏛️",
        grammarTipRomanUrdu = "Civic governance aur policy discourse ke jumlay.", grammarTipEn = "Discourse on governance, policy, and human rights.",
        sentences = listOf(
            SentenceItem("en_c1_2_1", "🏛️", "Constitutional checks and balances safeguard public liberties.", "Constitutional checks and balances safeguard public liberties.", "آئینی توازن عوام کی آزادیوں کا تحفظ کرتا ہے۔", "Aaeeni balance azadi ko mehfooz rakhta hai."),
            SentenceItem("en_c1_2_2", "⚖️", "Judicial impartiality underpins societal trust.", "Judicial impartiality underpins societal trust.", "عدالتی غیر جانبداری معاشرتی اعتماد کی ضامن ہے۔", "Adalat ka insaf awam ka aitbar barhata hai."),
            SentenceItem("en_c1_2_3", "🗳️", "Electoral integrity is paramount to democratic legitimacy.", "Electoral integrity is paramount to democratic legitimacy.", "انتخابی شفافیت جمہوری جواز کے لیے ناگزیر ہے۔", "Saaf elections jamhooriat ke liye zaroori hain."),
            SentenceItem("en_c1_2_4", "🌐", "Geopolitical dynamics require diplomatic dexterity.", "Geopolitical dynamics require diplomatic dexterity.", "جغرافیائی سیاسی حالات سفارتی مہارت کے متقاضی ہیں۔", "International halat mein chust diplomacy chahiye."),
            SentenceItem("en_c1_2_5", "💡", "Public transparency mitigates systemic corruption.", "Public transparency mitigates systemic corruption.", "عوامی شفافیت بدعنوانی کو روکتی ہے۔", "Shafafiyat se rishwat-khori khatam hoti hai."),
            SentenceItem("en_c1_2_6", "🌱", "Sustainable development mitigates resource depletion.", "Sustainable development mitigates resource depletion.", "پائیدار ترقی وسائل کے زیاں کو روکتی ہے۔", "Sahi taraqqi se resources bachaye ja sakte hain."),
            SentenceItem("en_c1_2_7", "👥", "Egalitarian values empower marginalized segments.", "Egalitarian values empower marginalized segments.", "مساوات کے اقدار پسماندہ طبقات کو بااختیار بناتے ہیں۔", "Barabari se ghareeb tabqay ko taqat milti hai."),
            SentenceItem("en_c1_2_8", "🤝", "Bipartisan consensus facilitates transformative legislation.", "Bipartisan consensus facilitates transformative legislation.", "مشترکہ اتفاقِ رائے انقلابی قانون سازی کو آسان بناتا ہے۔", "Mil kar qanoon banana asaan hota hai.")
        )
    )

    private fun createC1Lesson3() = Lesson(
        id = "en_c1_3", languageId = "en", level = CefrLevel.C1,
        title = "Literature & Arts", romanUrduTitle = "Adab aur Funoon", iconEmoji = "🎨",
        grammarTipRomanUrdu = "Adabi asloob aur tanqeedi alfaz.", grammarTipEn = "Aesthetic critique and literary analysis.",
        sentences = listOf(
            SentenceItem("en_c1_3_1", "🎭", "The protagonist epitomizes existential disillusionment.", "The protagonist epitomizes existential disillusionment.", "مرکزی کردار وجودی مایوسی کی عکاسی کرتا ہے۔", "Hero zindagi ki mayoosi dikhata hai."),
            SentenceItem("en_c1_3_2", "📖", "Alliteration and cadence bestow lyrical elegance.", "Alliteration and cadence bestow lyrical elegance.", "آوازوں کی ہم آہنگی تحریر کو نغمگی عطا کرتی ہے۔", "Lafzon ka aahang shayari jaisa lutf deta hai."),
            SentenceItem("en_c1_3_3", "🎨", "The chiaroscuro technique intensifies dramatic tension.", "The chiaroscuro technique intensifies dramatic tension.", "روشنی اور سائے کا امتزاج تصویر میں جان ڈالتا ہے۔", "Light aur dark ka balance tasveer ko gehra karta hai."),
            SentenceItem("en_c1_3_4", "🎻", "The crescendo evokes overwhelming emotional resonance.", "The crescendo evokes overwhelming emotional resonance.", "موسیقی کی اونچی دھن دلی جذبات کو جھنجھوڑتی ہے۔", "Music dil par asar karta hai."),
            SentenceItem("en_c1_3_5", "✍️", "The allegorical narrative critiques authoritarian dogmatism.", "The allegorical narrative critiques authoritarian dogmatism.", "تمثیلی کہانی آمرانہ سوچ پر گہری چوٹ کرتی ہے۔", "Kahani amriyat par tanz karti hai."),
            SentenceItem("en_c1_3_6", "🌟", "A masterstroke of unassailable genius.", "A masterstroke of unassailable genius.", "بے مثال ذہانت کا شاہکار۔", "Be-misaal zehanat ka shahkar."),
            SentenceItem("en_c1_3_7", "📜", "Artistic autonomy must remain inviolable.", "Artistic autonomy must remain inviolable.", "فنکارانہ خودمختاری کا تقدس پامال نہیں ہونا چاہیے۔", "Art ki azadi par pabandi nahi honi chahiye."),
            SentenceItem("en_c1_3_8", "🏛️", "Monumental architectures immortalize cultural memory.", "Monumental architectures immortalize cultural memory.", "عظیم الشان عمارتیں ثقافتی یادوں کو امر کر دیتی ہیں۔", "Shandar buildings tareekh ko zinda rakhti hain.")
        )
    )

    private fun createC1Lesson4() = Lesson(
        id = "en_c1_4", languageId = "en", level = CefrLevel.C1,
        title = "Science & Research", romanUrduTitle = "Science aur Research", iconEmoji = "🔬",
        grammarTipRomanUrdu = "Technological innovation aur empirical science.", grammarTipEn = "Advanced scientific discovery and methodology.",
        sentences = listOf(
            SentenceItem("en_c1_4_1", "🧪", "Catalytic converters expedite thermodynamic equilibrium.", "Catalytic converters expedite thermodynamic equilibrium.", "کیٹالسٹ کیمیکل توازن کو تیز تر کرتے ہیں۔", "Catalysts reaction ko fast karte hain."),
            SentenceItem("en_c1_4_2", "🧬", "CRISPR gene editing unlocks uncharted therapeutic frontiers.", "CRISPR gene editing unlocks uncharted therapeutic frontiers.", "جین ایڈیٹنگ علاج کے نئے راستے کھولتی ہے۔", "Gene editing bimariyon ka ilaj asaan karti hai."),
            SentenceItem("en_c1_4_3", "💻", "Quantum supremacy disrupts cryptographic encryption.", "Quantum supremacy disrupts cryptographic encryption.", "کوانٹم کمپیوٹنگ خفیہ ڈیٹا سیکیورٹی کو بدل دے گی۔", "Quantum computers security ko badal denge."),
            SentenceItem("en_c1_4_4", "🔭", "Astrophysical observations validate general relativity.", "Astrophysical observations validate general relativity.", "فلکیاتی مشاہدات آئن سٹائن کے نظریے کی تصدیق کرتے ہیں۔", "Space observations Einstein ke theory ko confirm karti hain."),
            SentenceItem("en_c1_4_5", "💡", "Disruptive innovation supersedes obsolete paradigms.", "Disruptive innovation supersedes obsolete paradigms.", "نئی اختراعات پرانے طریقوں کی جگہ لے لیتی ہیں۔", "Nayi inventions purane tarike replace karti hain."),
            SentenceItem("en_c1_4_6", "📊", "Rigorous peer review assures methodological integrity.", "Rigorous peer review assures methodological integrity.", "ماہرین کا کڑا امتحان طریقہ کار کی درستگی یقینی بناتا ہے۔", "Checking se tareeqay ka mayar qayam rehta hai."),
            SentenceItem("en_c1_4_7", "🌱", "Ecological equilibrium prevents irreversible biodiversity loss.", "Ecological equilibrium prevents irreversible biodiversity loss.", "ماحولیاتی توازن حیات کے ناپید ہونے کو روکتا ہے۔", "Mahol ka balance janwaron aur podon ko bachata hai."),
            SentenceItem("en_c1_4_8", "🏆", "Scientific inquiry illuminates human consciousness.", "Scientific inquiry illuminates human consciousness.", "سائنسی کھوج انسانی شعور کو روشن کرتی ہے۔", "Science insani soch ko ujla karti hai.")
        )
    )

    private fun createC1Lesson5() = Lesson(
        id = "en_c1_5", languageId = "en", level = CefrLevel.C1,
        title = "Nuanced Opinions", romanUrduTitle = "Gehri aur Barik Rai", iconEmoji = "🧠",
        grammarTipRomanUrdu = "Balanced, sophisticated debate structures.", grammarTipEn = "Weighing ambiguities and complex trade-offs.",
        sentences = listOf(
            SentenceItem("en_c1_5_1", "⚖️", "Whilst the premise is captivating, its feasibility is dubious.", "Whilst the premise is captivating, its feasibility is dubious.", "اگرچہ مفروضہ دلکش ہے، مگر اس کا عملی نفاذ مشکوک ہے۔", "Agarche baat achi hai par amli toor par mushkil hai."),
            SentenceItem("en_c1_5_2", "🔍", "One should refrain from hasty generalizations.", "One should refrain from hasty generalizations.", "جلد بازی کے عمومی نتائج سے گریز کرنا چاہیے۔", "Jaldi mein faisla lene se bachein."),
            SentenceItem("en_c1_5_3", "💡", "We must delineate between causation and mere correlation.", "We must delineate between causation and mere correlation.", "ہمیں اصل وجہ اور محض اتفاقی تعلق میں فرق کرنا ہوگا۔", "Asal wajah aur ittifaq mein farq karna hoga."),
            SentenceItem("en_c1_5_4", "🗣️", "I advocate for a circumspect and judicious evaluation.", "I advocate for a circumspect and judicious evaluation.", "میں محتاط اور دانشمندانہ جائزے کی وکالت کرتا ہوں۔", "Main soch samajh kar faisla karne ka keh raha hoon."),
            SentenceItem("en_c1_5_5", "📌", "This phenomenon defies conventional sociological paradigms.", "This phenomenon defies conventional sociological paradigms.", "یہ مظہر روایتی سماجی نظریات سے مطابقت نہیں رکھتا۔", "Ye baat purani theories se match nahi karti."),
            SentenceItem("en_c1_5_6", "🤝", "Constructive dialogue synthesizes disparate viewpoints.", "Constructive dialogue synthesizes disparate viewpoints.", "مثبت مکالمہ متضاد آراء کو جوڑتا ہے۔", "Achi baat cheet se hal nikalta hai."),
            SentenceItem("en_c1_5_7", "🌐", "Intellectual humility is the cornerstone of wisdom.", "Intellectual humility is the cornerstone of wisdom.", "فکری عاجزی دانائی کی بنیاد ہے۔", "Apni ghalti manna aqalmand hone ki nishani hai."),
            SentenceItem("en_c1_5_8", "✨", "Prudence dictates that we prepare for unexpected contingencies.", "Prudence dictates that we prepare for unexpected contingencies.", "دانشمندی کا تقاضا ہے کہ غیر متوقع حالات کے لیے تیار رہیں۔", "Aqal kehti hai ke har haal ke liye tayyar rahein.")
        )
    )

    // C2 Lessons
    private fun createC2Lesson1() = Lesson(
        id = "en_c2_1", languageId = "en", level = CefrLevel.C2,
        title = "Idioms & Expressions", romanUrduTitle = "Muhawray aur Rozmarrah", iconEmoji = "🎭",
        grammarTipRomanUrdu = "Idiomatic mastery: native fluency expressions.", grammarTipEn = "Common native English idioms and their meanings.",
        sentences = listOf(
            SentenceItem("en_c2_1_1", "🍀", "Break a leg at your presentation today!", "Break a leg at your presentation today! (Good luck)", "آج کی پریزنٹیشن کے لیے نیک تمنائیں!", "Good luck! Kamyab ho kar aao!"),
            SentenceItem("en_c2_1_2", "🌧️", "Every cloud has a silver lining.", "Every cloud has a silver lining.", "ہر مصیبت کے بعد آسانی ہوتی ہے۔", "Har mushkil ke baad asani hai."),
            SentenceItem("en_c2_1_3", "🪙", "A penny for your thoughts?", "A penny for your thoughts? (What are you thinking?)", "آپ کس سوچ میں گم ہیں؟", "Aap kya soch rahe hain?"),
            SentenceItem("en_c2_1_4", "🍎", "Bite the bullet and face the music.", "Bite the bullet and face the music.", "ہمت کر کے مشکل کا سامنا کرو۔", "Himmat baandho aur maslay ka muqabla karo."),
            SentenceItem("en_c2_1_5", "🧊", "Let us break the ice with a fun activity.", "Let us break the ice with a fun activity.", "آئیں جھجک دور کرنے کے لیے دلچسپ سرگرمی کرتے ہیں۔", "Jhijhak door karne ke liye game khelte hain."),
            SentenceItem("en_c2_1_6", "🎯", "You hit the nail right on the head.", "You hit the nail right on the head.", "آپ نے بالکل درست نشانے پر بات کہی۔", "Aap ne bilkul accurate baat ki."),
            SentenceItem("en_c2_1_7", "☕", "It is not my cup of tea.", "It is not my cup of tea (Not my preference).", "یہ میری پسند کا کام نہیں ہے۔", "Ye meri pasand ki cheez nahi hai."),
            SentenceItem("en_c2_1_8", "🌅", "Blessing in disguise.", "Blessing in disguise.", "چھپی ہوئی نعمت۔", "Mushkil ke roop mein chupi rehmat.")
        )
    )

    private fun createC2Lesson2() = Lesson(
        id = "en_c2_2", languageId = "en", level = CefrLevel.C2,
        title = "Formal Writing & Rhetoric", romanUrduTitle = "Balaghat aur Tehreeqi Fasahat", iconEmoji = "🖋️",
        grammarTipRomanUrdu = "Diplomatic and legal rhetorical eloquence.", grammarTipEn = "High-level rhetoric for diplomacy and statecraft.",
        sentences = listOf(
            SentenceItem("en_c2_2_1", "📜", "We have the distinct honor of conveying our sentiments.", "We have the distinct honor of conveying our sentiments.", "ہمیں اپنے جذبات پہنچانے کا اعزاز حاصل ہے۔", "Humein paigham dene ka aizaz haasil hai."),
            SentenceItem("en_c2_2_2", "🤝", "In commemoration of your distinguished service...", "In commemoration of your distinguished service...", "آپ کی شاندار خدمات کی یاد میں...", "Aap ki azeem khidmaat ki yaad mein..."),
            SentenceItem("en_c2_2_3", "⚖️", "Subject to the stipulations set forth in statutory decree.", "Subject to the stipulations set forth in statutory decree.", "قانونی فرمان میں بیان کردہ شرائط کے تحت۔", "Qanooni shara'it ke tehat."),
            SentenceItem("en_c2_2_4", "🖋️", "I solemnly declare under penalty of perjury.", "I solemnly declare under penalty of perjury.", "میں حلفیہ سچائی کا اقرار کرتا ہوں۔", "Main halfan sachayi ka iqrar karta hoon."),
            SentenceItem("en_c2_2_5", "🏛️", "In concordance with universal human rights tenets.", "In concordance with universal human rights tenets.", "انسانی حقوق کے آفاقی اصولوں کی پاسداری میں۔", "Insani haqooq ke asoolon ke mutabiq."),
            SentenceItem("en_c2_2_6", "🕊️", "Please accept the assurances of our highest esteem.", "Please accept the assurances of our highest esteem.", "ہماری دلی عزت و تکریم قبول فرمائیں۔", "Hamara aala tareen ehtiram qabool farmayein."),
            SentenceItem("en_c2_2_7", "📑", "This covenant binds all signatory entities irrevocably.", "This covenant binds all signatory entities irrevocably.", "یہ معاہدہ تمام دستخط کنندگان پر لازمی ہے۔", "Ye agreement sab par laazmi hai."),
            SentenceItem("en_c2_2_8", "✨", "May peace and cordial harmony ever prevail.", "May peace and cordial harmony ever prevail.", "امن اور باہمی پیار ہمیشہ قائم رہے۔", "Aman aur muhabbat hamesha qayam rahe.")
        )
    )

    private fun createC2Lesson3() = Lesson(
        id = "en_c2_3", languageId = "en", level = CefrLevel.C2,
        title = "Humour & Irony", romanUrduTitle = "Zarafat aur Tanz", iconEmoji = "😄",
        grammarTipRomanUrdu = "Dry British and American wit and subtle irony.", grammarTipEn = "Nuanced sarcasm and deadpan comedic delivery.",
        sentences = listOf(
            SentenceItem("en_c2_3_1", "☔", "Delightful weather for a stroll in the hurricane!", "Delightful weather for a stroll in the hurricane!", "طوفان میں چہل قدمی کے لیے کیا دلکش موسم ہے! (طنز)", "Toofan mein sair ka kya maza hai! (mazaq)"),
            SentenceItem("en_c2_3_2", "🐌", "The internet speed is truly breakneck today.", "The internet speed is truly breakneck today. (sarcasm)", "آج انٹرنیٹ کی رفتار تو ہوا سے باتیں کر رہی ہے۔ (طنز)", "Internet ki speed to bohot teez hai! (tanz)"),
            SentenceItem("en_c2_3_3", "🤷‍♂️", "Sarcasm is the lowest form of wit but the highest form of intelligence.", "Sarcasm is the lowest form of wit but highest of intelligence.", "طنز مزاح کا ادنیٰ لیکن ذہانت کا اعلیٰ روپ ہے۔", "Tanz aqalmand logon ka mazaq hota hai."),
            SentenceItem("en_c2_3_4", "😆", "Well, that escalated with astonishing velocity.", "Well, that escalated with astonishing velocity.", "بات دیکھتے ہی دیکھتے کہاں سے کہاں پہنچ گئی۔", "Baat foran barh gayi."),
            SentenceItem("en_c2_3_5", "💡", "Another genius idea that belongs in the Hall of Fame.", "Another genius idea that belongs in the Hall of Fame.", "ایک اور لاجواب خیال جس پر داد ملنی چاہیے۔", "Wah! Kya scheme hai!"),
            SentenceItem("en_c2_3_6", "🎉", "I am overwhelmed by your boundless enthusiasm.", "I am overwhelmed by your boundless enthusiasm.", "آپ کا بے پناہ جوش دیکھ کر میں دنگ رہ گیا۔", "Aap ka josh dekh kar main heran hoon."),
            SentenceItem("en_c2_3_7", "😉", "Clearly, common sense is not so common after all.", "Clearly, common sense is not so common after all.", "صاف ظاہر ہے کہ عقلِ عام اتنی عام نہیں ہے۔", "Common sense sab ke paas nahi hoti."),
            SentenceItem("en_c2_3_8", "🏆", "Patience is a virtue, especially when waiting in line.", "Patience is a virtue, especially when waiting in line.", "قطار میں کھڑے ہو کر انتظار کرنا اصل صبر ہے۔", "Line mein khade hona sabr ka imtehan hai.")
        )
    )

    private fun createC2Lesson4() = Lesson(
        id = "en_c2_4", languageId = "en", level = CefrLevel.C2,
        title = "Near-Native Fluency", romanUrduTitle = "Qabil-e-Rashk Rawani", iconEmoji = "🗣️",
        grammarTipRomanUrdu = "Fluid collocations and unhesitating phrasing.", grammarTipEn = "Unhesitating, effortless native delivery.",
        sentences = listOf(
            SentenceItem("en_c2_4_1", "🌊", "His command of the language is virtually indistinguishable from a native.", "His command is indistinguishable from a native.", "اس کی زبان دانی مقامی بولنے والوں جیسی ہے۔", "Wo native speaker ki tarah bolta hai."),
            SentenceItem("en_c2_4_2", "🎯", "She articulates multifaceted concepts with poise.", "She articulates multifaceted concepts with poise.", "وہ پیچیدہ تصورات بھی وقار سے بیان کرتی ہے۔", "Wo mushkil batein asaani se samjhati hai."),
            SentenceItem("en_c2_4_3", "💡", "Grasping subtext effortlessly during rapid conversation.", "Grasping subtext effortlessly during rapid conversation.", "تیز گفتگو میں بھی اشاروں کو فورا سمجھ لینا۔", "Baat ki teh tak foran pohnchna."),
            SentenceItem("en_c2_4_4", "🤝", "Modulating linguistic tone across diverse social strata.", "Modulating linguistic tone across diverse social strata.", "معاشرے کے ہر طبقے کے مطابق لہجہ ڈھال لینا۔", "Mahaul ke hisab se baat karna."),
            SentenceItem("en_c2_4_5", "⚡", "Instant repartee delivered with understated charm.", "Instant repartee delivered with understated charm.", "پرکشش انداز میں برجستہ حاضر جوابی۔", "Piyaray andaz mein hazir jawabi."),
            SentenceItem("en_c2_4_6", "🎭", "Flawless pronunciation and intonation patterns.", "Flawless pronunciation and intonation patterns.", "بے عیب تلفظ اور اتار چڑھاؤ۔", "Bilkul saaf aur behtareen bol chal."),
            SentenceItem("en_c2_4_7", "📖", "Appreciating idiomatic humor instinctively.", "Appreciating idiomatic humor instinctively.", "محاوراتی مزاح کو فطری طور پر محسوس کرنا۔", "Mazaq ko foran samajh kar enjoy karna."),
            SentenceItem("en_c2_4_8", "🌟", "Mastery manifests when words flow like water.", "Mastery manifests when words flow like water.", "مہارت تب جھلکتی ہے جب الفاظ پانی کی طرح بہتے ہیں۔", "Asal ustaad wo hai jiske alfaaz paani ki tarah behein.")
        )
    )

    private fun createC2Lesson5() = Lesson(
        id = "en_c2_5", languageId = "en", level = CefrLevel.C2,
        title = "Debating Complex Topics", romanUrduTitle = "Pechida Masail par Munazra", iconEmoji = "🌐",
        grammarTipRomanUrdu = "Synthesizing dialectical philosophy and debate.", grammarTipEn = "Mastery of dialectical debate and philosophy.",
        sentences = listOf(
            SentenceItem("en_c2_5_1", "🧬", "Ethical imperatives regarding bioengineering require vigilance.", "Ethical imperatives regarding bioengineering require vigilance.", "حیاتیاتی انجینئرنگ میں اخلاقی حدود پر کڑی نظر رکھنی چاہیے۔", "Bioengineering mein akhlaqi pabandi zaroori hai."),
            SentenceItem("en_c2_5_2", "⚖️", "Balancing liberty with collective security remains precarious.", "Balancing liberty with collective security remains precarious.", "آزادی اور اجتماعی تحفظ کا توازن نازک رہتا ہے۔", "Azadi aur amn ka balance mushkil kaam hai."),
            SentenceItem("en_c2_5_3", "🤖", "Algorithmic governance raises existential human dilemmas.", "Algorithmic governance raises existential human dilemmas.", "الگورتھم کا غلبہ انسانی وجود پر سوالات کھڑے کرتا ہے۔", "AI ki hukmrani se insaniyat par asraat parenge."),
            SentenceItem("en_c2_5_4", "🌍", "Equitable resource stewardship is a generational mandate.", "Equitable resource stewardship is a generational mandate.", "وسائل کی منصفانہ دیکھ بھال نسلوں کی امانت ہے۔", "Dunya ke resources ko barabari se chalana hoga."),
            SentenceItem("en_c2_5_5", "🏛️", "Institutional fortitude withstands populist polarization.", "Institutional fortitude withstands populist polarization.", "اداروں کی مضبوطی انتشار کو روکتی ہے۔", "Mazboot idaray qom ko bacha kar rakhte hain."),
            SentenceItem("en_c2_5_6", "💡", "Dispassionate logic must temper emotive rhetoric.", "Dispassionate logic must temper emotive rhetoric.", "بے لاگ عقل کو جذباتی نعروں پر غالب آنا چاہیے۔", "Jazbaat ke bajaye aqal se kaam lena chahiye."),
            SentenceItem("en_c2_5_7", "🔍", "Intellectual synthesis yields groundbreaking insight.", "Intellectual synthesis yields groundbreaking insight.", "فکری یکجائی انقلابی بصیرت کو جنم دیتی ہے۔", "Soch milne se nayi raaste bante hain."),
            SentenceItem("en_c2_5_8", "🏆", "Integrity remains the bedrock of genuine enlightenment.", "Integrity remains the bedrock of genuine enlightenment.", "دیانت داری حقیقی آگہی کا بنیادی ستون ہے۔", "Imandari hi asal roshni hai.")
        )
    )
}
