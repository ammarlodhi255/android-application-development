package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val textView: TextView = findViewById(R.id.textView)

        return when (item.itemId) {
            R.id.item1 -> {
                textView.text = "Item 1 Selected"
                Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item2 -> {
                textView.text = "Item 2 Selected"
                Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_LONG).show()
                true
            } else -> return super.onOptionsItemSelected(item)
        }
    }
}