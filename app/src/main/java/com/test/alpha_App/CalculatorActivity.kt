package com.test.alpha_App

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {

    private lateinit var exQuestion : TextView
    private lateinit var exResult: TextView
    private lateinit var numOne : Button
    private lateinit var numTwo : Button
    private lateinit var numThree : Button
    private lateinit var numFour : Button
    private lateinit var numFive : Button
    private lateinit var numSix : Button
    private lateinit var numSeven : Button
    private lateinit var numEight : Button
    private lateinit var numNine : Button
    private lateinit var numZero : Button
    private lateinit var exDot : Button
    private lateinit var exDel : Button
    private lateinit var exEquals : Button
    private lateinit var exPlus : Button
    private lateinit var exMin : Button
    private lateinit var exMul : Button
    private lateinit var exClear : Button
    private lateinit var exDivide : Button


    private fun initComponents() {
        exQuestion = findViewById(R.id.exQuestion)
        exResult = findViewById(R.id.exResult)
        numOne = findViewById(R.id.numOne)
        numTwo = findViewById(R.id.numTwo)
        numThree = findViewById(R.id.numThree)
        numFour = findViewById(R.id.numFour)
        numFive = findViewById(R.id.numFive)
        numSix = findViewById(R.id.numSix)
        numSeven = findViewById(R.id.numSeven)
        numEight = findViewById(R.id.numEight)
        numNine = findViewById(R.id.numNine)
        numZero = findViewById(R.id.numZero)
        exDot = findViewById(R.id.exDot)
        exDel = findViewById(R.id.exDel)
        exEquals = findViewById(R.id.exEquals)
        exPlus = findViewById(R.id.exPlus)
        exMin = findViewById(R.id.exMin)
        exMul = findViewById(R.id.exMul)
        exClear = findViewById(R.id.exClear)
        exDivide = findViewById(R.id.exDivide)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initComponents()

        fun evaluateExpression(string: String, clear: Boolean) {
            if (clear) {
                exResult.text = ""
                exQuestion.append(string)
            } else {
                exQuestion.append(exResult.text)
                exQuestion.append(string)
                exResult.text = ""
            }
        }


        numOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }
        numTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        numThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        numFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }
        numFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }
        numSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }
        numSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }
        numEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }
        numNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }
        numZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }
        exDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }
        exPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }
        exMin.setOnClickListener {
            evaluateExpression("-", clear = true)
        }
        exMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        exDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }
        exClear.setOnClickListener {
            exQuestion.text = ""
            exResult.text = ""
        }

        exEquals.setOnClickListener {
            val text = exQuestion.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()

            if (result == longResult.toDouble()) {
                exResult.text = longResult.toString()
            } else {
                exResult.text = result.toString()
            }

            exQuestion.text = longResult.toString()
            exResult.text = longResult.toString()


            exQuestion.movementMethod = ScrollingMovementMethod()
            exResult.movementMethod = ScrollingMovementMethod()
        }

        exDel.setOnClickListener {
            val text = exQuestion.text.toString()
            if (text.isNotEmpty()) {
                exQuestion.text = text.dropLast(0)
            }
            exQuestion.text = ""
        }
    }
}