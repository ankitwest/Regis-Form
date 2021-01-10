package com.example.regisform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import com.example.spoken.registerform.R.id.mySendButton
import com.example.spoken.registerform.R.id.nameTextBox
import kotlinx.android.synthetic.main.activity_first.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = " "
        var gender = " "
        var dept = " "

        name = nameTextBox.text.toString()
        var deptlist =
            arrayListOf("Computer Science", "Information Technology", "Others")

        deptSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, deptlist)
        deptSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(arg0: AdapterView<*>) {
            }

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                dept = deptlist[position]
            }
        }

        // handle button click//
        mySendButton.setOnClickListener {
            name = nameTextBox.text.toString()
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
            var genderId = genderRadioGroup.checkedRadioButtonId
            if (genderId != -1) {

                val selected_gender: RadioButton = findViewById(genderId)


                gender = selected_gender.text.toString()
            }


            var intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("Refername", name)
                putExtra("Refergender", gender)
                putExtra("Referdept", dept)
            }
            startActivity(intent)
        }
    }
}