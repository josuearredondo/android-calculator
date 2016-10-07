package com.josue.calculator;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Human Booster on 07/10/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorActivityTestEspresso {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<CalculatorActivity> mActivityRule = new ActivityTestRule<>(
            CalculatorActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }




    @Test
    public void btnEqualTestEspresso() {
        ViewInteraction buttonEquals = onView(withId(R.id.btnEqual));
        // Type text and then press the button.
        onView(withId(R.id.tvDigit)).perform();

        //(typeText(mString), closeSoftKeyboard());
        onView(withId(R.id.btnEqual)).perform();

        buttonEquals.check(matches(isDisplayed()));
    }

    /*public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(mStringToBetyped)));
    }*/
}
