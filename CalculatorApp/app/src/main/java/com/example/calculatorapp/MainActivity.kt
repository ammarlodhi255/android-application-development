package com.example.calculatorapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Error
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var numberCounter = 0
    private var expShown: Boolean = false
    private var number1: Int = 0
    private var number2: Int = 0
    private var currentOperator: String = ""
    private var currentOperatorID: Int = 0
    private var hashMap : HashMap<String, Int> = HashMap<String, Int> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberClick(view: View) {
        if(this.expShown) return;
        val calcField: TextView = findViewById(R.id.calcField)

        try {
            if ((++this.numberCounter) == 8) {
                throw Exception("Number limit exceeded")
                this.expShown = true
            }
        } catch(err: Exception) {
            calcField.text = err.message
        }

        val btnClicked: Button = view as Button
        val num = btnClicked.text.toString()
        var currentValue = calcField.text.toString()

        val newValue: String = currentValue + num
        calcField.text = newValue
    }

    fun clear(view: View) {
        val calcField: TextView = findViewById(R.id.calcField)
        this.numberCounter = 0
        this.expShown = false
        this.number1 = 0
        this.number2 = 0
        this.currentOperator = ""
        this.currentOperatorID = 0
        hashMap.clear()
        calcField.text = ""
    }

    fun opClicked(view: View) {
        if(this.expShown) return;
        val calcField: TextView = findViewById(R.id.calcField)
        val btnClicked = view as Button

        btnClicked.setBackgroundColor(Color.parseColor("#FFBB86FC"))
        this.number1 = calcField.text.toString().toInt()
        calcField.text = ""
        this.currentOperator = btnClicked.text.toString()
        this.currentOperatorID = view.id
    }

    fun equal(view: View) {
        if (this.expShown) return ;

        findViewById<Button>(this.currentOperatorID).setBackgroundColor(Color.parseColor("#d6d7d7"))
        val calcField: TextView = findViewById(R.id.calcField)
        this.number2 = calcField.text.toString().toInt()

        if (this.currentOperator == "/" && this.number2 == 0) {
            calcField.text = "Error: Div by 0"
            this.expShown = true
            return ;
        }
        calcField.text = performOperation(this.currentOperator).toString()
    }

    private fun performOperation(op: String): Int {
        val calcField: TextView = findViewById(R.id.calcField)
        this.reCompute()
        return this.hashMap.get(op)!!.toInt()
    }

    fun reCompute() {
        this.hashMap["%"] = this.number1 % this.number2
        this.hashMap["-"] = this.number1 - this.number2
        this.hashMap["+"] = this.number1 + this.number2
        this.hashMap["x"] = this.number1 * this.number2
        this.hashMap["/"] = this.number1 / this.number2
    }
}