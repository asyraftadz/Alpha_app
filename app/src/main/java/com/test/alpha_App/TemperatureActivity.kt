package com.test.alpha_App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class TemperatureActivity : AppCompatActivity() {

    private lateinit var enterNumber: EditText
    private lateinit var defaultTemp: EditText
    private lateinit var resultTemperature: TextView
    private lateinit var buttonTemperature: Button

    private fun initComponents() {
        enterNumber = findViewById(R.id.enterNumber)
        defaultTemp = findViewById(R.id.defaultTemp)
        resultTemperature = findViewById(R.id.resultTemperature)
        buttonTemperature = findViewById(R.id.buttonTemperature)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)

        initComponents()

        buttonTemperature.setOnClickListener {

            val numbertemperature = enterNumber.text.toString().toDouble()
            val initialTemperature = defaultTemp.text.toString()

            val tempInCelsius: Double = when (initialTemperature.uppercase()) {
                "C" -> numbertemperature
                "F" -> (numbertemperature - 32) * 5 / 9
                "K" -> numbertemperature - 273.15
                else -> null // handle invalid input
            } ?: return@setOnClickListener // return if input is invalid

            val resultTemperatureText = when (initialTemperature.uppercase()) {
                "C" -> "Temperature in Fahrenheit: ${(tempInCelsius  * 5 / 9) + 32}\nTemperature in Kelvin: ${tempInCelsius + 273.15}"
                "F" -> "Temperature in Celsius: $tempInCelsius\nTemperature in Kelvin: ${(tempInCelsius - 32) * 9 / 5 + 273.15}"
                "K" -> "Temperature in Celsius: $tempInCelsius\nTemperature in Fahrenheit: ${(tempInCelsius - 273.15) * 9 / 5 + 32}"
                else -> "" // handle invalid input
            }

            resultTemperature.text = resultTemperatureText

        }

    }

}