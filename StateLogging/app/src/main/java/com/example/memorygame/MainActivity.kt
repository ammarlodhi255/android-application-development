package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Message", "Inside OnCreate Method")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Message", "Inside OnStart Method")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message", "Inside onResume Method\n")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message", "Inside onStop method")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message", "Inside pause method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message", "Inside destory method")
    }
}