package com.example.moodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var hungry: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun eatCookie(view: View) {
        val imgView: ImageView = findViewById(R.id.imgView)
        val txtView: TextView = findViewById(R.id.txtView)
        var btnText: String = ""
        var imgResource: Int = 0
        var hungerStatus: String = ""

        if (!hungry) {
            btnText = "Eat a Cookie"
            imgResource = R.drawable.a
            hungerStatus = "I'm so hungry"
        } else {
            btnText = "Done"
            imgResource = R.drawable.b
            hungerStatus = "I'm so full"
        }

        findViewById<Button>(view.id).text = btnText
        imgView.setImageResource(imgResource)
        txtView.text = hungerStatus
        this.hungry = !this.hungry
    }
}