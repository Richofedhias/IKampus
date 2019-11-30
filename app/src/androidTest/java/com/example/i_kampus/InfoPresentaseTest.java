package com.example.i_kampus;

import com.example.i_kampus.homeUser.menuUtama.BerandaNew;
import com.example.i_kampus.homeUser.menuUtama.Presentase.Presentase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class InfoPresentaseTest {

    @Rule
    public ActivityTestRule<BerandaNew> activityRule =
            new ActivityTestRule<>(BerandaNew.class);

    @Test
    public void useAppContext() throws InterruptedException {
        // Context of the app under test.
        onView(withId(R.id.infoPresentase)).perform(click());
        Thread.sleep(3000);
    }
}
