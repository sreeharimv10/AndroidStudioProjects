package com.example.multisnaprv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView

class HorizontalActivity : AppCompatActivity() {

    companion object {

        private val SIMPLE_TITLES = arrayOf(
            "Zenfone 8 ", "Zenfone 8 Flip",
            "Zenfone 7 Pro ", "Zenfone 7",
            "Zenfone 6",
            "Zenfone 5z", "Zenfone 5", "Zenfone 5 Lite",
            "Zenfone 4 Pro", "Zenfone 4 Selfie Pro", "Zenfone 4"
        )

        private val SIMPLE_TITLES_2 = arrayOf(
            "Zenbook Pro Duo",
            "Zenbook Flip 13",
            "Zenbook Duo",
            "Zenbook Classic",
            "Vivobook Flip",
            "Vivobook S",
            "Vivobook Ultra",
            "Chromebook series"
        )

        private val SIMPLE_TITLES_3 = arrayOf(
            "ROG PHONE 5 ULTIMATE", "ROG PHONE 5 PRO", "ROG PHONE 5",
            "ROG PHONE 3", "ROG PHONE 3 STRIX EDITION",
            "ROG PHONE 2", "ROG PHONE 2 ULTIMATE EDITION",
            "ROG PHONE"
        )

        private val SIMPLE_TITLES_4 = arrayOf(
            "ROG MOTHERSHIP",
            "ROG ZEPHYRUS DUO",
            "ROG FLOW X13",
            "ROG ZEPHYRUS G14",
            "ROG STRIX G15",
            "ROG STRIX SCAR"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal)

        val firstAdapter = HorizontalAdapter(SIMPLE_TITLES)
        val firstRecyclerView = findViewById<MultiSnapRecyclerView>(R.id.first_recycler_view)
        val firstManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        firstRecyclerView.layoutManager = firstManager
        firstRecyclerView.adapter = firstAdapter

        val secondAdapter = HorizontalAdapter(SIMPLE_TITLES_2)
        val secondRecyclerView = findViewById<MultiSnapRecyclerView>(R.id.second_recycler_view)
        val secondManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        secondRecyclerView.layoutManager = secondManager
        secondRecyclerView.adapter = secondAdapter

        val thirdAdapter = HorizontalAdapter(SIMPLE_TITLES_3)
        val thirdRecyclerView = findViewById<MultiSnapRecyclerView>(R.id.third_recycler_view)
        val thirdManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        thirdRecyclerView.layoutManager = thirdManager
        thirdRecyclerView.adapter = thirdAdapter

        val fourthAdapter = HorizontalAdapter(SIMPLE_TITLES_4)
        val fourthRecyclerView = findViewById<MultiSnapRecyclerView>(R.id.fourth_recycler_view)
        val fourthManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fourthRecyclerView.layoutManager = fourthManager
        fourthRecyclerView.adapter = fourthAdapter
    }
}
