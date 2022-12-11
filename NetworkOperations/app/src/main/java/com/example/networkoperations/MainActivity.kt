package com.example.networkoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(Runnable {
            try {
                val url_str = "https://www.tutorialspoint.com/json/data.json"
                val url = URL(url_str)

                val con: HttpURLConnection = url.openConnection() as HttpURLConnection
                con.connect()

                val reader: BufferedReader = BufferedReader(InputStreamReader(con.inputStream))

                var line: String? = reader.readLine()
                var data = ""

                while (line != null) {
                    data += line
                    line = reader.readLine()
                }

                Log.d("NetworkMsg", data)
            } catch (ex : Exception) {}
        }).start()
    }
}