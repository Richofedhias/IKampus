package com.example.i_kampus;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.i_kampus.homeUser.Awal.Kategori;
import com.example.i_kampus.homeUser.Awal.Login;
import com.example.i_kampus.model.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.i_kampus", appContext.getPackageName());
//    }
@Rule
public ActivityTestRule<Login> activityRule =
        new ActivityTestRule<>(Login.class);



    @Test
    public void useAppContext() throws InterruptedException {

        // Context of the app under test.
        onView(withId(R.id.namaLengkap)).perform(typeText("bla@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.namaLengkap)).check(matches(withText("bla@gmail.com")));
        onView(withId(R.id.password)).check(matches(withText("12345678")));
        onView(withId(R.id.login)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.kampus)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.pencarianKampus)).perform(typeText("Telkom University"),closeSoftKeyboard());
        Thread.sleep(3000);
        onView(withId(R.id.search)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.infoKampus)).perform(click());
        Thread.sleep(3000);
        Espresso.pressBack();
        onView(withId(R.id.infoPresentase)).perform(click());
        Thread.sleep(3000);
        Espresso.pressBack();
        Espresso.pressBack();
        onView(withText("Ya")).inRoot(isDialog()) // <---
                .check(matches(isDisplayed()))
                .perform(click());
        onView(withId(R.id.namaLengkap)).perform(typeText("bla@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.namaLengkap)).check(matches(withText("bla@gmail.com")));
        onView(withId(R.id.password)).check(matches(withText("12345678")));
        onView(withId(R.id.login)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.kuesioner)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.penjurusan)).perform(click());
        onView(withId(R.id.mulai)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceA)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceB)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceC)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceD)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceA)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceB)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceC)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceD)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceA)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceB)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceC)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceD)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceA)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceB)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choiceC)).perform(click());
        Thread.sleep(3000);


    }
}
