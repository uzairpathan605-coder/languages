package com.example.model

object AppStrings {
    fun get(key: String, lang: String): String {
        return when (lang) {
            "ur" -> URDU[key] ?: ENGLISH[key] ?: key
            "roman" -> ROMAN_URDU[key] ?: ENGLISH[key] ?: key
            else -> ENGLISH[key] ?: key
        }
    }

    private val ENGLISH = mapOf(
        // Tabs
        "tab_learn" to "Learn",
        "tab_basics" to "Basics",
        "tab_ai_tutor" to "AI Tutor",
        "tab_quiz" to "Quiz",
        "tab_settings" to "Settings",

        // Dashboard
        "curriculum_path" to "Curriculum Path",
        "today_lesson" to "TODAY'S LESSON",
        "continue" to "CONTINUE",
        "completed" to "completed",
        "mastery" to "Mastery",
        "streak_flame" to "Day Streak",
        "last_7_days" to "Last 7 Days Activity",
        "ausbildung_minimum" to "Ausbildung Minimum",
        "best_for_jobs" to "Best for all jobs in Germany",
        "workplace_badge" to "All Workers",
        "quick_search" to "Search",
        "quick_basics" to "Basics",
        "quick_ai" to "AI Tutor",
        "quick_quiz" to "Quiz",

        // Lesson
        "study_method_title" to "4-Step Study Method:",
        "step_listen" to "1. Listen 👂",
        "step_slow" to "2. Repeat Slowly 🐢",
        "step_speak" to "3. Speak Aloud 🗣️",
        "step_tick" to "4. Tick Learned ✅",
        "learned" to "Learned",
        "mark_learned" to "Mark as learned (+10 XP)",
        "play_all" to "Play All",
        "speaking" to "Speaking...",
        "slow_speech" to "Slow Mode (0.65x)",
        "grammar_tip" to "Grammar Tip (Roman Urdu)",

        // Notifications
        "notifications" to "Notifications",
        "no_notifications" to "No new notifications",
        "notif_lesson_waiting" to "Your lesson for today is waiting! Keep moving forward.",
        "notif_streak_risk" to "Your streak is at risk! Tick at least one sentence today.",
        "notif_studied_today" to "You studied today — great job! Keep it up tomorrow.",
        "notif_milestone" to "Milestone reached: %d%% — well done!",
        "notif_reminder" to "Daily Reminder: Time for your 10-minute language practice!",

        // Settings
        "settings_title" to "Settings & Profile",
        "profile_section" to "Learner Profile",
        "name" to "Name",
        "daily_goal" to "Daily Goal",
        "start_level" to "Start Level",
        "learning_reason" to "Why Learning",
        "save_profile" to "Save Profile",
        "app_language" to "App Language (Menus & Buttons)",
        "app_language_desc" to "Changes all buttons, tabs, and menu chrome.",
        "daily_reminder" to "Daily Practice Reminder",
        "reminder_time" to "Reminder Time",
        "reminder_note" to "Note: Reminders show inside the app when it is opened; a web app cannot send phone push notifications while closed.",
        "start_again" to "Start Again (Redo Setup)",
        "start_again_desc" to "Return to the first-launch setup flow and redo onboarding.",
        "about" to "About BIZOlingo",
        "about_desc" to "BIZOlingo Language Academy v1.2 — Dedicated to hard-working learners worldwide for Germany Ausbildung and global careers.",
        "reset_progress" to "Reset Learning Progress"
    )

    private val ROMAN_URDU = mapOf(
        // Tabs
        "tab_learn" to "Seekhein",
        "tab_basics" to "Bunyadi",
        "tab_ai_tutor" to "Ustaad AI",
        "tab_quiz" to "Quiz",
        "tab_settings" to "Settings",

        // Dashboard
        "curriculum_path" to "Sabaq ka Rasta (Path)",
        "today_lesson" to "AAJ KA SABAQ",
        "continue" to "JARI RAKHEIN",
        "completed" to "mukammal",
        "mastery" to "Kamyabi",
        "streak_flame" to "Streak (Rozana)",
        "last_7_days" to "Pichle 7 Din ki Activity",
        "ausbildung_minimum" to "Ausbildung ke liye Lazmi",
        "best_for_jobs" to "Germany mein Har Job ke liye Best",
        "workplace_badge" to "Har Worker ke liye",
        "quick_search" to "Talash",
        "quick_basics" to "Bunyadi",
        "quick_ai" to "AI Ustaad",
        "quick_quiz" to "Quiz",

        // Lesson
        "study_method_title" to "Sabaq Parhne ke 4 Asaan Steps:",
        "step_listen" to "1. Pehle Suniye 👂",
        "step_slow" to "2. Ahista Dohrayein 🐢",
        "step_speak" to "3. Ooncha Bolein 🗣️",
        "step_tick" to "4. Tick Lagayein ✅",
        "learned" to "Seekh Liya",
        "mark_learned" to "Seekh liya (+10 XP)",
        "play_all" to "Sab Suno",
        "speaking" to "Bol raha hai...",
        "slow_speech" to "Ahista Aawaz (0.65x)",
        "grammar_tip" to "Grammar Tip (Roman Urdu)",

        // Notifications
        "notifications" to "Notifications",
        "no_notifications" to "Koi nayi notification nahi hai",
        "notif_lesson_waiting" to "Aaj ka sabaq aap ka intezar kar raha hai! Zaroor parhein.",
        "notif_streak_risk" to "Aap ki streak khatray mein hai! Aaj kam az kam ek jumla parhein.",
        "notif_studied_today" to "Aap ne aaj parhai ki — shabash! Kal bhi jari rakhein.",
        "notif_milestone" to "Milestone: %d%% sabaq mukammal ho gaya — bohot khoob!",
        "notif_reminder" to "Daily Reminder: زبان سیکھنے کا وقت ہو گیا!",

        // Settings
        "settings_title" to "Settings aur Profile",
        "profile_section" to "Learner ki Profile",
        "name" to "Naam",
        "daily_goal" to "Rozana ka Goal",
        "start_level" to "Start Level",
        "learning_reason" to "Seekhne ki Wajah",
        "save_profile" to "Profile Save Karein",
        "app_language" to "App ki Zaban (Buttons aur Menus)",
        "app_language_desc" to "Tamam buttons, tabs aur menu ki zaban badalta hai.",
        "daily_reminder" to "Rozana Parhai ka Reminder",
        "reminder_time" to "Reminder ka Waqt",
        "reminder_note" to "Wazahat: Reminders app kholne par nazar aate hain; browser band hone par notifications nahi aateen.",
        "start_again" to "Dobara Shuru Karein (Redo Setup)",
        "start_again_desc" to "Pehli dafa wale setup par wapas jayein.",
        "about" to "BIZOlingo ke Baare Mein",
        "about_desc" to "BIZOlingo Language Academy v1.2 — Germany Ausbildung aur tamam jobs ke liye.",
        "reset_progress" to "Sari Progress Khatam Karein (Reset)"
    )

    private val URDU = mapOf(
        // Tabs
        "tab_learn" to "سیکھیں",
        "tab_basics" to "بنیادی",
        "tab_ai_tutor" to "استاد AI",
        "tab_quiz" to "کوئز",
        "tab_settings" to "ترتیبات",

        // Dashboard
        "curriculum_path" to "نصاب کا راستہ (لیولز)",
        "today_lesson" to "آج کا سبق",
        "continue" to "جاری رکھیں",
        "completed" to "مکمل",
        "mastery" to "مہارت",
        "streak_flame" to "مسلسل پڑھائی (اسٹریک)",
        "last_7_days" to "پچھلے 7 دن کی کارکردگی",
        "ausbildung_minimum" to "Ausbildung کے لیے لازمی",
        "best_for_jobs" to "جرمنی میں تمام ملازمتوں کے لیے بہترین",
        "workplace_badge" to "تمام ورکرز کے لیے",
        "quick_search" to "تلاش",
        "quick_basics" to "بنیادی",
        "quick_ai" to "AI استاد",
        "quick_quiz" to "کوئز",

        // Lesson
        "study_method_title" to "سبق سیکھنے کے 4 اہم مراحل:",
        "step_listen" to "1. سنیں 👂",
        "step_slow" to "2. آہستہ دہرائیں 🐢",
        "step_speak" to "3. اونچی آواز میں بولیں 🗣️",
        "step_tick" to "4. نشان لگائیں ✅",
        "learned" to "سیکھ لیا",
        "mark_learned" to "سیکھ لیا گیا (+10 XP)",
        "play_all" to "تمام سنیں",
        "speaking" to "آواز جاری ہے...",
        "slow_speech" to "آہستہ آواز (0.65x)",
        "grammar_tip" to "گرامر کی رہنمائی (رومن اردو)",

        // Notifications
        "notifications" to "اطلاعات (نوٹیفیکیشنز)",
        "no_notifications" to "کوئی نئی اطلاع موجود نہیں ہے",
        "notif_lesson_waiting" to "آج کا سبق آپ کا منتظر ہے! آگے بڑھتے رہیں۔",
        "notif_streak_risk" to "آپ کی اسٹریک خطرے میں ہے! آج کم از کم ایک جملہ ضرور پڑھیں۔",
        "notif_studied_today" to "آپ نے آج پڑھائی مکمل کر لی — شاباش!",
        "notif_milestone" to "شاندار سنگ میل: %d%% نصاب مکمل!",
        "notif_reminder" to "روزانہ کی یاد دہانی: زبان کی مشق کا وقت ہو گیا!",

        // Settings
        "settings_title" to "ترتیبات اور پروفائل",
        "profile_section" to "طالب علم کی پروفائل",
        "name" to "نام",
        "daily_goal" to "روزانہ کا وقت",
        "start_level" to "ابتدائی سطح (لیول)",
        "learning_reason" to "سیکھنے کا مقصد",
        "save_profile" to "پروفائل محفوظ کریں",
        "app_language" to "ایپ کی زبان (بٹن اور مینیو)",
        "app_language_desc" to "تمام مینیوز، ٹیبز اور بٹنوں کی زبان تبدیل کرتا ہے۔",
        "daily_reminder" to "روزانہ یاد دہانی (نوٹیفیکیشن)",
        "reminder_time" to "یاد دہانی کا وقت",
        "reminder_note" to "وضاحت: نوٹیفیکیشن ایپ کھولنے پر سامنے آئیں گے؛ ایپ بند ہونے پر خودکار پش میسج نہیں آتے۔",
        "start_again" to "دوبارہ نیا آغاز کریں (شروع سے سیٹ اپ)",
        "start_again_desc" to "پہلی دفعہ کے تعارفی مراحل پر واپس جائیں۔",
        "about" to "BIZOlingo کے بارے میں",
        "about_desc" to "BIZOlingo لینگویج اکیڈمی v1.2 — جرمنی میں Ausbildung اور تمام شعبہ جات میں کامیابی کے لیے۔",
        "reset_progress" to "تمام سابقہ ریکارڈ صاف کریں"
    )
}
