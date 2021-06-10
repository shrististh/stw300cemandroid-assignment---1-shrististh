package com.example.androidassignment__1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TaxActivity : AppCompatActivity() {
    private lateinit var tvTopic: TextView
    private lateinit var etSalary: EditText
    private lateinit var btnResult: Button
    private lateinit var tvLine: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tax)

        tvTopic = findViewById(R.id.tvTopic)
        etSalary = findViewById(R.id.etSalary)
        btnResult = findViewById(R.id.btnResult)
        tvLine = findViewById(R.id.tvLine)

        btnResult.setOnClickListener {

            if (TextUtils.isEmpty(etSalary.text)) {
                etSalary.error = "Enter your Salary"
                etSalary.requestFocus()
                return@setOnClickListener
            }
            val number = etSalary.text.toString().toInt()
            salaryCalc(number)
        }
    }
    fun salaryCalc(salaryYearly: Int) {
        if (salaryYearly >= 1 && salaryYearly <= 200000) {
            val tax = salaryYearly / 100
            tvLine.text = "Your yearly salary is Rs.$salaryYearly and the tax is Rs.$tax"
        } else if (salaryYearly > 200000 && salaryYearly <= 350000) {
            val tax1 = (200000 * 0.01) + ((salaryYearly - 200000) * 0.15)
            tvLine.text = "Your yearly salary is Rs.$salaryYearly and the tax is Rs.$tax1"
        } else {
            val tax2 = (200000 / 100) + (150000 * 0.15) + ((salaryYearly - 350000) * 0.25)
            tvLine.text = "Your yearly salary is Rs.$salaryYearly and the tax is Rs.$tax2"
            Toast.makeText(
                this, "Your yearly tax has been calculated ",
                Toast.LENGTH_SHORT
            ).show()
        }



        Toast.makeText(
            this@TaxActivity,
            "Your yearly tax has been calculated ",
            Toast.LENGTH_SHORT
        ).show()
    }

    }


