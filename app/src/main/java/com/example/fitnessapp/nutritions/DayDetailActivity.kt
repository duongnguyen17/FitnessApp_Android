package com.example.fitnessapp.nutritions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.fitnessapp.R
import com.example.fitnessapp.model.DayData
import com.google.android.material.tabs.TabLayout

class DayDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_detail_activity)
        val itemData = intent.getSerializableExtra("item")
//        Log.e("item", itemData.name  )
        val tabLayout = findViewById<TabLayout>(R.id.tabDayDetail)
        val viewPager = findViewById<ViewPager>(R.id.vpDayDetail)

        // create adapter
        val viewPagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        //create standardDietFragment
        val standardDietFragment = StandardDietFragment()
        // create bundle in order to send to fragment
        val bundle = Bundle()
        bundle.putSerializable("itemData", itemData)
        standardDietFragment.arguments = bundle
        //create vegetableDietFragment
        val vegetableDietFragment = VegetableDietFragment()
        vegetableDietFragment.arguments = bundle

        viewPagerAdapter.add(standardDietFragment, "Standard")
        viewPagerAdapter.add(vegetableDietFragment, "Vegetable")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}