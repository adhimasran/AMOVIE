package com.adhi.amovia.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.adhi.amovia.R
import com.adhi.amovia.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun swipeViewPager() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.view_pager)).perform(swipeRight())
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyMovies[0].rating.toString())))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(dummyMovies[0].release)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText("Duration: ${dummyMovies[0].duration}")))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovies[0].overview)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )

    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyTvShow[0].rating.toString())))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(dummyTvShow[0].release)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText("Duration: ${dummyTvShow[0].duration}")))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShow[0].overview)))
    }
}