package com.example.androidassignment__1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnBMI: Button
    private lateinit var btnNumToLetter: Button
    private lateinit var btnIntTax: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBMI = findViewById(R.id.btnBMI)
        btnNumToLetter = findViewById(R.id.btnNumToLetter)
        btnIntTax = findViewById(R.id.btnIntTax)

        btnBMI.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        btnNumToLetter.setOnClickListener {
            val intent = Intent(this, NumbertowordActivity::class.java)
            startActivity(intent)
        }

        btnIntTax.setOnClickListener {
            val intent = Intent(this, TaxActivity::class.java)
            startActivity(intent)
        }


    }
}