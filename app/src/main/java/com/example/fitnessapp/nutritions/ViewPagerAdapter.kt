package com.example.fitnessapp.nutritions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    var fragmentList = mutableListOf<Fragment>()
    var fragmentTitleList = mutableListOf<String>()


    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {return StandardDietFragment()}
            1 -> { return VegetableDietFragment()}
            else -> { return StandardDietFragment()}
        }
    }

    override fun getCount() = 2
    fun add (fm: Fragment, title :String){}
    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->{return "Standard"}
            1->{return "Vegetable"}
            else->{return null}
        }
    }

}