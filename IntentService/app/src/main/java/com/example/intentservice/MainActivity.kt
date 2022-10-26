package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /*
        An intent service continues to execute even if our app is minimized. These
        services run in the background of our app. It works on a different thread,
        so we don't have to worry about it blocking our main UI thread.

        For every new service we create, we need to define its class to define its behaviour.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.start_btn)
        val stopBtn: Button = findViewById(R.id.stop_btn)
        val serviceInfo: TextView = findViewById(R.id.service_info)

        startBtn.setOnClickListener {
            val intent: Intent = Intent(this, MyIntentService::class.java)
            startService(intent)
            serviceInfo.text = "Service is running"
        }

        stopBtn.setOnClickListener {
            MyIntentService.stopService()
            serviceInfo.text = "Service stopped"
        }

        // The final step is to add the service to your manifest file
    }
}