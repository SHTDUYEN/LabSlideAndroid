package com.example.ninjaturtle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hideSwitch = findViewById<Switch>(R.id.hideImageSwitch)
        val turtleImage = findViewById<ImageView>(R.id.imageView)
        hideSwitch.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked){
                turtleImage.visibility = View.INVISIBLE
            }
            else{
                turtleImage.visibility = View.VISIBLE
            }
        }
    }

    fun chooseButton(view: View) {
        val description = findViewById<TextView>(R.id.descTextView)
        val turtleImage = findViewById<ImageView>(R.id.imageView)
        when(view.id){
            R.id.donBtn -> {
                description.text = "This is Don"
                turtleImage.setImageResource(R.drawable.don)
            }
            R.id.leoBtn ->{
                description.text = "This is Leo"
                turtleImage.setImageResource(R.drawable.leo)
            }
            R.id.mikeBtn ->{
                description.text = "This is Mike"
                turtleImage.setImageResource(R.drawable.mike)
            }
            R.id.raphBtn ->{
                description.text = "This is Raph"
                turtleImage.setImageResource(R.drawable.raph)
            }
        }
    }
}