package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<TextView>(R.id.textView).text = "Welcome, ${intent.getStringExtra("message").toString()}"
    }

    fun handleDone(view: View) {
        val secondActivityIntent: Intent = Intent()
        secondActivityIntent.putExtra("response", "Shut UP")
        setResult(RESULT_OK, secondActivityIntent)
        finish()
    }
}