package com.example.regisform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var obtainedName = ""
        var obtainedGender = ""
        var obtainedDept = ""

        obtainedName = intent.getStringExtra("Refername")
        obtainedGender = intent.getStringExtra("Refergender")
        obtainedDept = intent.getStringExtra("Referdept")

        welcomeTextView.text =
            "Welcome " + obtainedName + "\nGender : " + obtainedGender + "\nDepartment : " + obtainedDept
    }
}