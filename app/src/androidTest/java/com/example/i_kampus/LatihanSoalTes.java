package com.example.i_kampus;

import android.content.Context;

import android.widget.TextView;

import com.example.i_kampus.homeUser.Awal.Kategori;
import com.example.i_kampus.homeUser.menuKuesioner.KategoriKuesioner;
import com.example.i_kampus.homeUser.menuKuesioner.KuesionerPenjurusan;
import com.example.i_kampus.homeUser.menuKuesioner.MulaiKuesionerPenjurusan;
import com.example.i_kampus.homeUser.menuUtama.LatihanSoal.LatihanSoal;
import com.example.i_kampus.homeUser.menuUtama.LatihanSoal.ResultActivity;
import com.example.i_kampus.model.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class LatihanSoalTes {

    @Rule
    public ActivityTestRule<KategoriKuesioner> intent =
            new ActivityTestRule<>(KategoriKuesioner.class);


    @Test
    public void useAppContext() throws InterruptedException {
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
