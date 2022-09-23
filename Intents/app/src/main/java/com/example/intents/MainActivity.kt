package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityBtn: Button = findViewById(R.id.button)
        activityBtn.setOnClickListener(View.OnClickListener { launchActivity(activityBtn) })
    }

    fun launchActivity(view: View) {
        val myIntent: Intent = Intent(this, SecondActivity::class.java)
        myIntent.putExtra("message", findViewById<EditText>(R.id.nameText).text.toString())
//        startActivity(myIntent)
//        myIntent.putExtra("message", findViewById<EditText>(R.id.nameText).text.toString())
        startActivityForResult(myIntent, 123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 123) {
            val message: String = data?.getStringExtra("response").toString()
            val editName: EditText = findViewById(R.id.nameText)
            editName.text = message as Editable
        }
    }
}