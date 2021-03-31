package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<String>("Viet Nam","Laos","Thailand",
            "Korea","Japan","UAE","Cambodia","China")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryListView = findViewById<ListView>(R.id.countryLV)
        val countryAdapter = ArrayAdapter<String>(this,
                R.layout.row_item_country, R.id.countryTV,countrySource)
        countryListView.adapter = countryAdapter
    }
}