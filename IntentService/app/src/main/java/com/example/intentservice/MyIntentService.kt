package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var serviceIsRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is stopping")
            serviceIsRunning = false
            instance.stopSelf()
        }
    }

    // Used to process intents that we pass to the service
    override fun onHandleIntent(p0: Intent?) {
        try {
            serviceIsRunning = true
            while(serviceIsRunning) {
                Log.d("MyIntentService", "Service is running")
                Thread.sleep(1000)
            }
        } catch(e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}