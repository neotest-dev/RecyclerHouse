package com.uct.recyclerhouse.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.uct.recyclerhouse.ui.CentersFragment
import com.uct.recyclerhouse.ui.EducationFragment
import com.uct.recyclerhouse.ui.GuideFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GuideFragment()
            1 -> CentersFragment()
            2 -> EducationFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}