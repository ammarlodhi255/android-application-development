package com.example.lifecycleexploration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Ammar", "onCreate() was called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Ammar", "onStart() was called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ammar", "onResume() was called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Ammar", "onPause() was called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ammar", "onStop() was called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Ammar", "onRestart() was called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ammar", "onDestroy() was called")
    }
}