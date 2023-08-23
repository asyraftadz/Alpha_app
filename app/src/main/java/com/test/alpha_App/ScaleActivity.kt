package com.test.alpha_App

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScaleActivity : AppCompatActivity() {

    private lateinit var enterWeight : EditText
    private lateinit var buttonEnterScale : Button
    private lateinit var textViewResultScale : TextView
    private lateinit var radioParent : RadioGroup
    private lateinit var tonRadio : RadioButton
    private lateinit var kgRadio : RadioButton
    private lateinit var lbnRadio : RadioButton

    private fun initComponents() {
        enterWeight = findViewById(R.id.enterWeight)
        buttonEnterScale = findViewById(R.id.buttonEnterScale)
        textViewResultScale = findViewById(R.id.textViewResultScale)
        radioParent = findViewById(R.id.radioParent)
        tonRadio = findViewById(R.id.tonRadio)
        kgRadio = findViewById(R.id.kgRadio)
        lbnRadio = findViewById(R.id.lbRadio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale)

        initComponents()

        buttonEnterScale.setOnClickListener {
            Log.d("Button succes","Succes")

            // change color button beside in layout using setBackgroundColor
            // buttonEnterScale.setBackgroundColor(resources.getColor(R.color.so_orange, theme))

            val numberWeight = enterWeight.text.toString().toDouble()
            val initialWeight = radioParent.checkedRadioButtonId

            val weightInTon: Number
            val resultWeight: String

            if (initialWeight == R.id.tonRadio) {
                weightInTon = numberWeight
                resultWeight = "Weight in kilogram: ${weightInTon / 1000}\nWeight in pound: ${weightInTon / 2205}"
            } else if (initialWeight == R.id.kgRadio) {
                weightInTon = numberWeight
                resultWeight = "Weight in ton: ${weightInTon}\nWeight in pound: ${weightInTon * 2.205}"
            } else if (initialWeight == R.id.lbRadio) {
                weightInTon = numberWeight
                resultWeight = "Weight in ton: ${weightInTon}\nWeight in kilogram: ${weightInTon * 2.205}"
            } else {
                resultWeight = ""
            }

            textViewResultScale.text = resultWeight
        }

        radioParent.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(applicationContext, "Select weight: ${radio.text}", Toast.LENGTH_SHORT)
                .show()
        }

    }

}