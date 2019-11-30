package com.example.i_kampus;

import android.preference.PreferenceActivity;
import android.util.Log;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.i_kampus.homeUser.Awal.Login;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.msebera.android.httpclient.Header;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<Login> activityRule = new ActivityTestRule<>(Login.class);

    @Test
    public void testButtonClick() {
        try{
            SyncHttpClient client = new SyncHttpClient();
            client.get("https://maybetesttosuccess.000webhostapp.com/data.json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    String s = new String(responseBody);
                    try {
                        JSONArray obj = new JSONArray(s);
                        for(int i = 0; i < obj.length(); i++){
                            JSONObject data = obj.getJSONObject(i);
                            String email = data.getString("email");
                            String password = data.getString("password");

                            onView(withId(R.id.namaLengkap)).perform(typeText(email), closeSoftKeyboard());
                            onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());
                            onView(withId(R.id.login)).perform(click());
                            onView(withId(R.id.reset)).perform(click());

                            Thread.sleep(2000);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        }catch(Exception ex){
            Log.e("Error", ex.getMessage());
        }
    }
}
