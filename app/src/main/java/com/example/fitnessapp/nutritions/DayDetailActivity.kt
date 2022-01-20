package com.example.fitnessapp.nutritions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.fitnessapp.R
import com.google.android.material.tabs.TabLayout

class DayDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_detail_activity)
        var itemData = intent.getSerializableExtra("item")
        Log.e("item", itemData.toString())
        val tabLayout = findViewById<TabLayout>(R.id.tabDayDetail)
        val viewPager = findViewById<ViewPager>(R.id.vpDayDetail)
        var bundle = Bundle()
        bundle.putSerializable("itemaData",itemData)
        var standardDietFragment = StandardDietFragment()
        standardDietFragment.arguments = bundle
        var vegetableDietFragment = VegetableDietFragment()

        // create adapter
        val adapter = ViewPagerAdapter(this.supportFragmentManager)
        adapter.add(standardDietFragment, "Standard")
        adapter.add(vegetableDietFragment,"vegetable")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}