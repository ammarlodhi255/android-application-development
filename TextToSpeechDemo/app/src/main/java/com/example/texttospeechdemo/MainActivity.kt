package com.example.texttospeechdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech

class MainActivity : AppCompatActivity() {
    lateinit var tts: TextToSpeech
    var isTTSReady: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            fun onInit() {
                this.isTTSReady = true
            }
        })

        if(this.isTTSReady)
            this.tts.speak("Hello World!", TextToSpeech.QUEUE_ADD, null)
    }
}