package com.example.musicmenubar

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {

    val mediaPlayer = MediaPlayer()
    lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.tts = TextToSpeech(applicationContext)
        { status -> if (status != TextToSpeech.ERROR) { this.tts.language = Locale.UK } }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.music_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.play -> {
                if (item.title == "Play") {
                    item.setIcon(R.drawable.pause_launcher_foreground)
                    playSong()
                    item.title = "Pause"
                } else {
                    item.setIcon(R.drawable.play_launcher_foreground)
                    pauseSong()
                    item.title = "Play"
                }
                return true
            }
            R.id.speak -> {
                this.convertTTS()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun playSong() {
        Toast.makeText(this, "The song is being loaded..", Toast.LENGTH_SHORT).show()
        val randomNumber : Int = (1..15).random()
        val url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-${randomNumber}.mp3"
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer.setDataSource(url)
            this.mediaPlayer.prepare()
            this.mediaPlayer.start()
        } catch (e: IOException) {
            Toast.makeText(this, "Internet connection lost", Toast.LENGTH_SHORT).show()
        }
    }

    fun pauseSong() {
        if(this.mediaPlayer.isPlaying)
            this.mediaPlayer.stop()
    }

    fun convertTTS() {
        val text: String = findViewById<EditText>(R.id.editText).text.toString()
        if(text.length == 0) return ;
        this.tts.speak(text, TextToSpeech.QUEUE_FLUSH, null)
    }
}