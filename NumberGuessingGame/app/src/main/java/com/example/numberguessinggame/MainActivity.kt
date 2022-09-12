package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var numberByCPU : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.numberByCPU= (1..1000).random()
    }

    public fun validate(view: View) {
        val numByUser: Int = (findViewById<EditText>(R.id.numText).text).toString().toInt()
        val text: TextView = findViewById(R.id.textView)

        if (numByUser < numberByCPU) {
            text.text = "Too LOW"
        } else if (numByUser > numberByCPU) {
            text.text = "Too Large"
        } else {
            text.text = "You Guessed It!"
        }
    }
}