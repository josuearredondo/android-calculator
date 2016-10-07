package com.josue.calculator;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalculatorActivityUITestEspresso {

    @Rule
    public ActivityTestRule<CalculatorActivity> mActivityTestRule =
            new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void btnResetTestEspresso() {
        ViewInteraction button = onView(withId(R.id.btnC));
        button.check(matches(isDisplayed()));
    }
    public void btnSevenTestEspresso() {
        ViewInteraction button2 = onView(withId(R.id.btnSeven));
        button2.check(matches(isDisplayed()));
    }

    public void btnEightTestEspresso() {
        ViewInteraction button4 = onView(withId(R.id.btnEight));
        button4.check(matches(isDisplayed()));
    }
    public void btnNineTestEspresso() {
        ViewInteraction button5 = onView(withId(R.id.btnNine));
        button5.check(matches(isDisplayed()));
    }
    public void btnDivTestEspresso() {
        ViewInteraction button6 = onView(withId(R.id.btnDiv));
        button6.check(matches(isDisplayed()));
    }
    public void btnFourTestEspresso() {
        ViewInteraction button7 = onView(withId(R.id.btnFour));
        button7.check(matches(isDisplayed()));
    }
    public void btnFiveTestEspresso() {
        ViewInteraction button8 = onView(withId(R.id.btnFive));
        button8.check(matches(isDisplayed()));
    }
    public void btnSixTestEspresso() {
        ViewInteraction button9 = onView(withId(R.id.btnSix));
        button9.check(matches(isDisplayed()));
    }
    public void btnMultTestEspresso() {
        ViewInteraction button10 = onView(withId(R.id.btnMult));
        button10.check(matches(isDisplayed()));
    }
    public void btnOneTestEspresso() {
        ViewInteraction button11 = onView(withId(R.id.btnOne));
        button11.check(matches(isDisplayed()));
    }
    public void btnTwoTestEspresso() {
        ViewInteraction button12 = onView(withId(R.id.btnTwo));
        button12.check(matches(isDisplayed()));
    }
    public void btnThreeTestEspresso() {
        ViewInteraction button13 = onView(withId(R.id.btnThree));
        button13.check(matches(isDisplayed()));
    }
    public void btnSubTestEspresso() {
        ViewInteraction button14 = onView(withId(R.id.btnSub));
        button14.check(matches(isDisplayed()));
    }
    public void btnZeroTestEspresso() {
        ViewInteraction button15 = onView(withId(R.id.btnZero));
        button15.check(matches(isDisplayed()));
    }
    public void btnCommaTestEspresso() {
        ViewInteraction button16 = onView(withId(R.id.btnComma));
        button16.check(matches(isDisplayed()));
    }
    public void btnAddTestEspresso() {
        ViewInteraction button17 = onView(withId(R.id.btnAdd));
        button17.check(matches(isDisplayed()));
    }
    public void btnEqualTestEspresso() {
        ViewInteraction button18 = onView(withId(R.id.btnEqual));
        button18.check(matches(isDisplayed()));
    }
    /*
    public void btnEqualTestEspresso() {
        ViewInteraction button18 = onView(
                allOf(withId(R.id.btnEqual),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout6),
                                        childAtPosition(
                                                withId(R.id.root_layout),
                                                5)),
                                0),
                        isDisplayed()));
        button18.check(matches(isDisplayed()));
    }*/

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
