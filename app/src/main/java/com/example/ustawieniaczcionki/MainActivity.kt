package com.example.ustawieniaczcionki

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val listaCytatow = arrayOf("Dzień dobry", "Good morning", "Buenos Dias")
    var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rozmiarCzcionki: TextView = findViewById(R.id.rozmiarCzcionki)
        val cytatTextView: TextView = findViewById(R.id.cytat)
        val przycisk: Button = findViewById(R.id.przycisk)

        val seekBar: SeekBar = findViewById(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rozmiarCzcionki.text = "Rozmiar: $progress"
                cytatTextView.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        cytatTextView.text = listaCytatow[currentIndex]

        przycisk.setOnClickListener{
            currentIndex++
            if (currentIndex >= listaCytatow.size){
                currentIndex = 0
            }
            cytatTextView.text = listaCytatow[currentIndex]
        }
    }
}