package com.example.layoutdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var points: Int = 0
    private var plays: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateRandomNums()
    }

    fun buttonClicked(v : View) {
        val leftBtn = findViewById<Button>(R.id.button)
        val rightBtn = findViewById<Button>(R.id.button2)
        val pointsField = findViewById<TextView>(R.id.textView3)
        val leftNum = leftBtn.text.toString().toInt()
        val rightNum = rightBtn.text.toString().toInt()

        if (v.id == rightBtn.id) {
            if (rightNum > leftNum) {
                pointsField.text = "Points: ${++this.points}"
            } else {
                pointsField.text = "Points: ${--this.points}"
            }
        } else {
            if (leftNum > rightNum) {
                pointsField.text = "Points: ${++this.points}"
            } else {
                pointsField.text = "Points: ${--this.points}"
            }
        }

        generateRandomNums()
    }

    fun generateRandomNums() {
        val rand = java.util.Random()
        val num1 = rand.nextInt(20)
        var num2 = num1

        while(num1 == num2)
            num2 = rand.nextInt(20)

        val leftBtn = findViewById<Button>(R.id.button)
        val rightBtn = findViewById<Button>(R.id.button2)
        leftBtn.text = "${num1}"
        rightBtn.text = "${num2}"
        Toast.makeText(this, "${++this.plays} plays in total", Toast.LENGTH_LONG).show()
    }
}