package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.CourseDataRepository
import com.example.data.PreferencesManager
import com.example.model.AppStrings
import com.example.model.CefrLevel
import com.example.model.SupportedLanguages
import com.example.model.UserProfile
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("BIZOlingo Language Academy", appName)
    }

    @Test
    fun `verify 15 languages supported`() {
        assertEquals(15, SupportedLanguages.ALL.size)
        val german = SupportedLanguages.getById("de")
        assertEquals("German", german.nameEn)
        assertTrue(german.isPrimaryJobFocus)
    }

    @Test
    fun `verify workplace special lesson in German B1`() {
        val b1Lessons = CourseDataRepository.getLessonsByLevel("de", CefrLevel.B1)
        val workplaceLesson = b1Lessons.firstOrNull { it.isWorkplaceSpecial }
        assertNotNull(workplaceLesson)
        assertEquals(8, workplaceLesson?.sentences?.size)
        val shiftSentence = workplaceLesson?.sentences?.firstOrNull { it.id == "de_b1_5_1" }
        assertEquals("Wann beginnt meine Schicht?", shiftSentence?.targetText)
    }

    @Test
    fun `verify preferences manager progress and study activity`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = PreferencesManager(context)
        prefs.resetProgress()

        assertEquals(0, prefs.userProfile.value.xp)
        prefs.addXp(25)
        assertEquals(25, prefs.userProfile.value.xp)

        val isLearned = prefs.toggleSentenceLearned("test_sentence_1")
        assertTrue(isLearned)
        assertEquals(35, prefs.userProfile.value.xp)

        // Today must be recorded as studied
        assertTrue(prefs.userProfile.value.hasStudiedToday())
        val last7Days = prefs.userProfile.value.getLast7DaysActivity()
        assertEquals(7, last7Days.size)
        assertTrue(last7Days.last().isStudied)
    }

    @Test
    fun `verify app strings localization`() {
        assertEquals("Learn", AppStrings.get("tab_learn", "en"))
        assertEquals("سیکھیں", AppStrings.get("tab_learn", "ur"))
        assertEquals("Seekhein", AppStrings.get("tab_learn", "roman"))
    }

    @Test
    fun `verify redo setup flow`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = PreferencesManager(context)
        prefs.completeOnboarding("Ali", "de", "work_germany", "a1", 10)
        assertTrue(prefs.userProfile.value.isOnboardingCompleted)

        prefs.redoSetup()
        assertFalse(prefs.userProfile.value.isOnboardingCompleted)
    }

    @Test
    fun `verify lesson completion updates streak and awards bonus XP`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = PreferencesManager(context)
        prefs.resetProgress()

        val initialXp = prefs.userProfile.value.xp
        prefs.markLessonCompleted("de_a1_1")

        assertTrue(prefs.userProfile.value.isLessonCompleted("de_a1_1"))
        assertEquals(initialXp + 50, prefs.userProfile.value.xp)
        assertTrue(prefs.userProfile.value.hasStudiedToday())
    }
}
