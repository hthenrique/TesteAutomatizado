package com.example.testeautomatizado;

import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testLogin(){
        Espresso.onView(withId(R.id.editTextUser))
                .perform(typeText("admin@admin"));

        Espresso.onView(withId(R.id.editTextPass))
                .perform(typeText("administrador"));

        Espresso.onView(withId(R.id.btnOk))
                .perform(click());
    }

    @Test
    public void testLogin2(){
        Espresso.onView(withId(R.id.editTextUser))
                .perform(typeText("hthenrique@email.com"));

        Espresso.onView(withId(R.id.editTextPass))
                .perform(typeText("henrique"));

        Espresso.onView(withId(R.id.btnOk))
                .perform(click());
    }

    @Test
    public void testLoginFail(){
        Espresso.onView(withId(R.id.editTextUser))
                .perform(typeText("nome@teste.com"));

        Espresso.onView(withId(R.id.editTextPass))
                .perform(typeText("12"));

        Espresso.onView(withId(R.id.btnOk))
                .perform(click());
    }

    @Test
    public void testLoginFail2(){
        Espresso.onView(withId(R.id.editTextUser))
                .perform(typeText("admin@admin"));

        Espresso.onView(withId(R.id.editTextPass))
                .perform(typeText("henrique"));

        Espresso.onView(withId(R.id.btnOk))
                .perform(click());
    }

    @Test
    public void testLoginFail3(){
        Espresso.onView(withId(R.id.editTextUser))
                .perform(typeText("hthenrique@email.com"));

        Espresso.onView(withId(R.id.editTextPass))
                .perform(typeText("Administrador"));

        Espresso.onView(withId(R.id.btnOk))
                .perform(click());
    }

}