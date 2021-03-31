package vn.udn.vku.nhhai.exercise2_uedn5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.listview.CountryAdapter
import com.example.listview.R

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<CountryInfo>(
        CountryInfo("Viet Nam",96.5,R.drawable.vietnam),
        CountryInfo("Korea",96.5,R.drawable.korea),
        CountryInfo("Laos",96.5,R.drawable.laos),
        CountryInfo("Thailand",96.5,R.drawable.thailand),
        CountryInfo("Japan",96.5, R.drawable.japan)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryListView = findViewById<ListView>(R.id.countryLV)
        val countryAdapter = CountryAdapter(this,countrySource)
        countryListView.adapter = countryAdapter
    }
}