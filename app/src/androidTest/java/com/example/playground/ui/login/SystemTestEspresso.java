package com.example.playground.ui.login;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.playground.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SystemTestEspresso {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void systemTestEspresso() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("fakeusername"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("fakepassword"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.login), withText("Log ind"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction switch_ = onView(
                allOf(withId(R.id.switch1),
                        childAtPosition(
                                allOf(withId(R.id.ViewDBLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        switch_.perform(click());

        ViewInteraction switch_2 = onView(
                allOf(withId(R.id.switch1),
                        childAtPosition(
                                allOf(withId(R.id.ViewDBLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        switch_2.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button2), withText("Tilføj ny Rute"),
                        childAtPosition(
                                allOf(withId(R.id.ViewDBLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.Grading),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("6a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.Location),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("C"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.GripColor),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("Orange"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.GripColor), withText("Orange"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText6.perform(pressImeActionButton());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button), withText("Tilføj Rute"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button5), withText("\uD83D\uDCCA"),
                        childAtPosition(
                                allOf(withId(R.id.ViewDBLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.WeatherAPI), withText("WeatherAPI"),
                        childAtPosition(
                                allOf(withId(R.id.fragments_layout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.LocalData), withText("LocalData"),
                        childAtPosition(
                                allOf(withId(R.id.fragments_layout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editLocalData), withText("New text"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragments_layout),
                                        2),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("Testtext"));

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editLocalData), withText("Testtext"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragments_layout),
                                        2),
                                0),
                        isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.ApplyLocalData), withText("Change and save text"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragments_layout),
                                        2),
                                1),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editLocalData), withText("Testtext"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragments_layout),
                                        2),
                                0),
                        isDisplayed()));
        appCompatEditText9.perform(pressImeActionButton());

        pressBack();

        pressBack();
    }

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
