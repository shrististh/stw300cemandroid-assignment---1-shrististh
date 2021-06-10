package com.example.androidassignment__1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class BMIActivity : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var tvTitle: TextView
    private lateinit var btnCalc: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)
        tvTitle = findViewById(R.id.tvTitle)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnCalc = findViewById(R.id.btnCalc)
        tvResult = findViewById(R.id.tvResult)
        btnCalc.setOnClickListener {
            if (TextUtils.isEmpty(etHeight.text)) {
                etHeight.error = "Enter your Height first"
                etHeight.requestFocus()
                return@setOnClickListener
            }else if(TextUtils.isEmpty(etWeight.text)) {
                etWeight.error = "Enter your Weight firstt"
                etWeight.requestFocus()
                return@setOnClickListener
            }
            calculateBmi()
        }
    }
    fun calculateBmi() {
        var height = etHeight.text.toString().toFloat()
        var weight = etWeight.text.toString().toFloat()
        var BMI = weight/(height*height)
        var section = " "
        if (BMI < 18.5)
            section = "Underweight"
        else if (BMI < 24.9)
            section = "Normal weight"
        else if (BMI < 29.9)
            section = "Overweight"
        else
            section = "Obesity"
        tvResult.text = "Your BMI is $BMI = $section"
        Toast.makeText(this@BMIActivity, "Your BMI is $BMI and you are $section", Toast.LENGTH_SHORT).show()
    }
}

