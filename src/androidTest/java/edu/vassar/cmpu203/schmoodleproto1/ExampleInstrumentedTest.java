package edu.vassar.cmpu203.schmoodleproto1;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import edu.vassar.cmpu203.schmoodleproto1.Controller.MainActivity;

/**
 * Our Espresso tests for Schmoodle
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("edu.vassar.cmpu203.schmoodleproto1", appContext.getPackageName());
    }

    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test

    /**
     * This tests creates a profile, logs in, edits the profile, adds classes, searches
     * for another profile, edits the dashboard by adding an event, gets a recommendation
     * for a profile, and also logs out.
     *
     * @param: none
     * @return: none
     *
     *
     */
    public void testCreateNewProfile() {

        ViewInteraction usernameVi = Espresso.onView(ViewMatchers.withId(R.id.username));
        usernameVi.perform(ViewActions.typeText("wolff"));

        ViewInteraction passwordVi = Espresso.onView(ViewMatchers.withId(R.id.password));
        passwordVi.perform(ViewActions.typeText("l"));

        ViewInteraction loginVi = Espresso.onView(ViewMatchers.withId(R.id.loginButton));
        loginVi.perform(ViewActions.click());

        ViewInteraction makeVi = Espresso.onView(ViewMatchers.withId(R.id.makeEvent));
        makeVi.perform(ViewActions.scrollTo());
        makeVi.perform(ViewActions.click());

        ViewInteraction titleVi = Espresso.onView(ViewMatchers.withId(R.id.newtitle));
        titleVi.perform(ViewActions.typeText("Declare Major!"));

        ViewInteraction contentsVi = Espresso.onView(ViewMatchers.withId(R.id.newcontents));
        contentsVi.perform(ViewActions.typeText("Meet with Rui!"));

        ViewInteraction postVi = Espresso.onView(ViewMatchers.withId(R.id.post));
        postVi.perform(ViewActions.click());

        Espresso.closeSoftKeyboard();

        ViewInteraction backFromCNR = Espresso.onView(ViewMatchers.withId(R.id.backe));
        backFromCNR.perform(ViewActions.click());

        ViewInteraction searchbarVi = Espresso.onView(ViewMatchers.withId(R.id.searchbar));
        searchbarVi.perform(ViewActions.typeText("rui"));

        ViewInteraction initializesearchVi = Espresso.onView(ViewMatchers.withId(R.id.initializesearch));
        initializesearchVi.perform(ViewActions.click());

        ViewInteraction backsrVi = Espresso.onView(ViewMatchers.withId(R.id.backsr));
        backsrVi.perform(ViewActions.click());

        ViewInteraction editprofileVi = Espresso.onView(ViewMatchers.withId(R.id.editprofile));
        editprofileVi.perform(ViewActions.click());

        ViewInteraction newyearVi = Espresso.onView(ViewMatchers.withId(R.id.newyear));
        newyearVi.perform(ViewActions.clearText());
        newyearVi.perform(ViewActions.typeText("200010"));

        ViewInteraction newmajorVi = Espresso.onView(ViewMatchers.withId(R.id.newmajor));
        newmajorVi.perform(ViewActions.clearText());
        newmajorVi.perform(ViewActions.typeText("Computer Science"));

        ViewInteraction implementVi = Espresso.onView(ViewMatchers.withId(R.id.implement));
        implementVi.perform(ViewActions.click());

        ViewInteraction backVi = Espresso.onView(ViewMatchers.withId(R.id.back));
        backVi.perform(ViewActions.click());

        usernameVi.perform(ViewActions.typeText("wolff"));
        passwordVi.perform(ViewActions.typeText("l"));

        loginVi.perform(ViewActions.click());

        backVi.perform(ViewActions.click());

        usernameVi.perform(ViewActions.typeText("rui"));
        passwordVi.perform(ViewActions.typeText("l"));
        loginVi.perform(ViewActions.click());

        ViewInteraction reccVI = Espresso.onView(ViewMatchers.withId(R.id.recc));
        reccVI.perform(ViewActions.click());

        ViewInteraction classfVI  = Espresso.onView(ViewMatchers.withId(R.id.classf));
        classfVI.perform(ViewActions.click());

        ViewInteraction backgr  = Espresso.onView(ViewMatchers.withId(R.id.backgr));
        backgr.perform(ViewActions.click());

        reccVI.perform(ViewActions.click());

        ViewInteraction yearfVI  = Espresso.onView(ViewMatchers.withId(R.id.yearf));
        yearfVI.perform(ViewActions.click());

        backgr.perform(ViewActions.click());

        reccVI.perform(ViewActions.click());

        ViewInteraction majorfVI  = Espresso.onView(ViewMatchers.withId(R.id.majorf));
        majorfVI.perform(ViewActions.click());

        backgr.perform(ViewActions.click());

        backVi.perform(ViewActions.click());

        ViewInteraction signupButtonVi = Espresso.onView(ViewMatchers.withId(R.id.signUpButton));
        signupButtonVi.perform(ViewActions.click());

        ViewInteraction newpass2Vi = Espresso.onView(ViewMatchers.withId(R.id.newpass));
        newpass2Vi.perform(ViewActions.typeText("123"));

        ViewInteraction newname2Vi = Espresso.onView(ViewMatchers.withId(R.id.newname));
        newname2Vi.perform(ViewActions.typeText("LarryKing"));

        ViewInteraction newyear2Vi = Espresso.onView(ViewMatchers.withId(R.id.newyear));
        newyear2Vi.perform(ViewActions.typeText("1776"));

        ViewInteraction newmajor2Vi = Espresso.onView(ViewMatchers.withId(R.id.newmajor));
        newmajor2Vi.perform(ViewActions.typeText("Old Timey Radio"));

        Espresso.closeSoftKeyboard();

        ViewInteraction goVi = Espresso.onView(ViewMatchers.withId(R.id.go));
        goVi.perform(ViewActions.click());

        backVi.perform(ViewActions.click());
        usernameVi.perform(ViewActions.typeText("LarryKing"));
        passwordVi.perform(ViewActions.typeText("123"));
        loginVi.perform(ViewActions.click());
        makeVi.perform(ViewActions.scrollTo());
        makeVi.perform(ViewActions.click());

        //titleVi.perform(ViewActions.typeText("Larry kin!"));
        //contentsVi.perform(ViewActions.typeText("Meet with Rui!"));

        //ViewInteraction postVi = Espresso.onView(ViewMatchers.withId(R.id.post));
        postVi.perform(ViewActions.click());
        Espresso.closeSoftKeyboard();
        backFromCNR.perform(ViewActions.click());
        makeVi.perform(ViewActions.scrollTo());
        backVi.perform(ViewActions.click());
    }
}