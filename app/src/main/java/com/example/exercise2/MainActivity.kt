package com.example.exercise2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            val textWeight = findViewById<EditText>(R.id.editTextWeight)
            val textHeight = findViewById<EditText>(R.id.editTextHeight)
            val imageProfile : ImageView = findViewById(R.id.imageViewProfile)
            val viewBMI = findViewById<TextView>(R.id.textViewBMI)

            val weight = textWeight.text.toString().toDouble()
            val height = textHeight.text.toString().toDouble() * 0.01
            val bmi = weight/(height*height)

            if(bmi < 18.5){
                imageProfile.setImageResource(R.drawable.under)
                viewBMI.setText(String.format("BMI : %.2f", bmi))
            }else if(bmi >= 18.5 && bmi <= 24.9){
                imageProfile.setImageResource(R.drawable.normal)
                viewBMI.setText(String.format("BMI : %.2f", bmi))
            }else{
                imageProfile.setImageResource(R.drawable.over)
                viewBMI.setText(String.format("BMI : %.2f", bmi))
            }

        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            val imageProfile : ImageView = findViewById(R.id.imageViewProfile)
            val viewBMI = findViewById<TextView>(R.id.textViewBMI)
            val textWeight = findViewById<EditText>(R.id.editTextWeight)
            val textHeight = findViewById<EditText>(R.id.editTextHeight)

            textWeight.setText("")
            textHeight.setText("")
            imageProfile.setImageResource(R.drawable.empty)
            viewBMI.setText(String.format("BMI : "))
        }
    }


}
