package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<CountryInfo>(
            CountryInfo("Viet Nam",96.5,R.drawable.vietnam),
            CountryInfo("Korea",96.5,R.drawable.korea),
            CountryInfo("Laos",96.5,R.drawable.laos),
            CountryInfo("Thailand",96.5,R.drawable.thailand),
            CountryInfo("Japan",96.5,R.drawable.japan)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryRV = findViewById<RecyclerView>(R.id.countryRV)
        val countryRecyclerAdapter = CountryRecyclerAdapter(this,countrySource)
        countryRV.layoutManager = GridLayoutManager(this,2)
        countryRV.adapter = countryRecyclerAdapter
    }
}
