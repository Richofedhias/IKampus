package com.example.i_kampus;

import com.example.i_kampus.homeUser.Awal.Kategori;
import com.example.i_kampus.homeUser.Awal.Login;
import com.example.i_kampus.homeUser.menuUtama.BerandaNew;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class InfoKampusTest {


        //    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.i_kampus", appContext.getPackageName());
//    }
        @Rule
        public ActivityTestRule<BerandaNew> activityRule =
                new ActivityTestRule<>(BerandaNew.class);

        @Test
        public void useAppContext() throws InterruptedException {
            // Context of the app under test.
            onView(withId(R.id.infoKampus)).perform(click());
            Thread.sleep(3000);
        }
    }

