package com.example.menuexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
    private lateinit var fbSeekBar: SeekBar
    private lateinit var igSeekBar: SeekBar
    private lateinit var twSeekBar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fbSeekBar = findViewById<SeekBar>(R.id.fbBar)
        fbSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int,
                                           fromUser: Boolean) {
                val fbTV = findViewById<TextView>(R.id.fbText)
                fbTV.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        igSeekBar = findViewById<SeekBar>(R.id.igBar)
        igSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int,
                                           fromUser: Boolean) {
                val igTV = findViewById<TextView>(R.id.igText)
                igTV.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        twSeekBar = findViewById<SeekBar>(R.id.twBar)
        twSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int,
                                           fromUser: Boolean) {
                val twTV = findViewById<TextView>(R.id.twText)
                twTV.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val fullBtn = findViewById<ImageButton>(R.id.fullBtn)
        val clearBtn = findViewById<ImageButton>(R.id.clearBtn)
        fullBtn.setOnClickListener{
            fbSeekBar.progress = 100
            igSeekBar.progress = 100
            twSeekBar.progress = 100
        }
        clearBtn.setOnClickListener{
            fbSeekBar.progress = 0
            igSeekBar.progress = 0
            twSeekBar.progress = 0
        }

        val popupBtn = findViewById<Button>(R.id.popupBtn)
        registerForContextMenu(popupBtn)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option_half_item -> {
                fbSeekBar.progress = 50
                igSeekBar.progress = 50
                twSeekBar.progress = 50
            }
            R.id.option_full_item -> {
                fbSeekBar.progress = 100
                igSeekBar.progress = 100
                twSeekBar.progress = 100
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.popup_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val fullBtn = findViewById<ImageButton>(R.id.fullBtn)
        val clearBtn = findViewById<ImageButton>(R.id.clearBtn)
        when(item.itemId){
            R.id.popup_hide_others -> {
                fullBtn.isVisible = false
                clearBtn.isVisible = false
            }
            R.id.popup_show_others -> {
                fullBtn.isVisible = true
                clearBtn.isVisible = true
            }
            R.id.popup_say_bye->{
                Toast.makeText(this,"Goodbye class", Toast.LENGTH_LONG)
                        .show()
            }
        }
        return super.onContextItemSelected(item)
    }
}