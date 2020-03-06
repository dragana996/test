package com.example.myapplication;

import android.content.Context;

import androidx.test.espresso.ViewInteraction;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.myapplication", appContext.getPackageName());
    }

/*    @Test
    public void check_Download() {
        onView(withText("Download")).check(matches(isDisplayed()));
        onView(withId(R.id.download_button)).check((matches(isEnabled())));
        onView(withId(R.id.download_button)).perform(click());
    }

    @Test
    public void check_Cancel() {
        onView(withText("Cancel")).check((matches(isDisplayed())));
        onView(withId(R.id.cancel_button)).check(matches(not(isEnabled())));
    }

    @Test
    public void check_dis_Cancel() {
        onView(withId(R.id.inf_textview)).check(matches(isDisplayed()));
    }
 */

    @Test
    public void printSmt() {
        onView(withId(R.id.cancel_button)).check(matches(isDisplayed()));
        onView(withId(R.id.cancel_button)).perform(click());

        onView(withText("Success")).check(matches(isDisplayed()));
    }
}
