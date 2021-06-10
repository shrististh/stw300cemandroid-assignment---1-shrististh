package com.example.androidassignment__1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NumbertowordActivity : AppCompatActivity() {
    private lateinit var etFill: EditText
    private lateinit var tvHeading: TextView
    private lateinit var btnConvert: Button
    private lateinit var tvAnswer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbertoword)

        etFill = findViewById(R.id.etFill)
        tvHeading = findViewById(R.id.tvHeading)
        btnConvert = findViewById(R.id.btnConvert)
        tvAnswer = findViewById(R.id.tvAnswer)


        btnConvert.setOnClickListener {

            if (TextUtils.isEmpty(etFill.text)) {
                etFill.error = "Enter number"
                etFill.requestFocus()
                return@setOnClickListener
            }
            val number = etFill.text.toString().toInt()
            convertNum(number)
        }
    }
    fun convertNum(number: Int) {
        val list1 = listOf<String>(
            "Zero", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        )
        val list2 = listOf<String>(
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
        )
        val list3 = listOf<String>(
            "",
            "One Hundred",
            "Two Hundred",
            "Three Hundred",
            "Four Hundred",
            "Five Hundred",
            "Six Hundred",
            "Seven Hundred",
            "Eight Hundred",
            "Nine Hundred"
        )
        if (number < 20) {
            val result = (list1[number])
            tvAnswer.text = result.toString()
        } else if (number >= 20 && number < 100) {
            if (number % 10 == 0) {
                val result = list2[number / 10]
                tvAnswer.text = result.toString()
            } else {
                val result = (list2[number / 10] + " " + list1[number % 10])
                tvAnswer.text = result.toString()
            }
        } else if (number >= 100 && number < 1000) {
            if (number % 10 == 0) {
                val result = (list3[number / 100])
                tvAnswer.text = result.toString()
            } else if ((number % 100) / 10 == 0) {
                val result = (list3[number / 100] + " and " + list1[number % 10])
                tvAnswer.text = result.toString()
            } else {
                val result =
                    (list3[number / 100] + " and " + list2[(number % 100) / 10] + " " + list1[number % 10])
                tvAnswer.text = result.toString()
            }
        } else if (number >= 1000) {
            Toast.makeText(this, "Number is too large, try again!!", Toast.LENGTH_SHORT).show()
        }
    }
}