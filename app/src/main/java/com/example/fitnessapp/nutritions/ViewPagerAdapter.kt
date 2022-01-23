package com.example.fitnessapp.nutritions

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    var fragmentList = mutableListOf<Fragment>()
    var fragmentTitleList = mutableListOf<String>()


    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount() = 2
    fun add(fm: Fragment, title: String) {
        fragmentList.add(fm)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }

}