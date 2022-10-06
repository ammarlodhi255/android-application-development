package com.example.mediaplayerdemo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.darkknight)
    }

    fun playOrPause(view: View) {
        val btnPlay: Button = findViewById(R.id.btnPlay)
        if(!mediaPlayer.isPlaying) {
            mediaPlayer.start()
            btnPlay.text = "Pause"
        } else {
            mediaPlayer.pause()
            btnPlay.text = "Play"
        }
    }
}