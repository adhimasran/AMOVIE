package com.adhi.amovia.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adhi.amovia.ui.home.HomeActivity.Companion.TAB_TITLES
import com.adhi.amovia.ui.movie.MovieFragment
import com.adhi.amovia.ui.tv.TvShowFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = TAB_TITLES.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment()
            else -> TvShowFragment()
        }
    }
}