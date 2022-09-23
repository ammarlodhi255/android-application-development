package com.example.coffeeorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val COFFEE_PRICE: Double = 4.00
    val CHOC_PRICE: Double = 1.00
    val CREAM_PRICE: Double = 0.50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun processOrder(view: View) {
        val summaryText: TextView = findViewById(R.id.summaryTxt)
        val summaryTxtView: TextView = findViewById(R.id.summary)
        val addCream: Boolean = findViewById<CheckBox>(R.id.checkCream).isChecked
        val addChoc: Boolean = findViewById<CheckBox>(R.id.checkChoc).isChecked
        val quantity: Int = findViewById<TextView>(R.id.quantity).text.toString().toInt()

        var totalPrice = quantity * this.COFFEE_PRICE
        if (totalPrice > 0) {
            if (addCream) totalPrice += CREAM_PRICE
            if (addChoc) totalPrice += CHOC_PRICE
        }

        val summary: String = "Add Whipped Cream? ${(if (addCream) "Yes" else "No")} " +
                "\nAdd Chocolate? ${(if (addChoc) "Yes" else "No")} \nQuantity: " +
                "$quantity\n\nPrice: $" +
                "${totalPrice}\nTHANK YOU!"

        summaryTxtView.text = summary
        summaryText.text = "ORDER SUMMARY"
    }

    fun increaseQuantity(view: View) {
        val quantityTxtView: TextView = findViewById(R.id.quantity)
        var quantity = quantityTxtView.text.toString().toInt()
        quantity += 1
        quantityTxtView.text = quantity.toString()
    }

    fun decreaseQuantity(view: View) {
        val quantityTxtView: TextView = findViewById(R.id.quantity)
        var quantity = quantityTxtView.text.toString().toInt()
        quantity -= 1
        quantityTxtView.text = quantity.toString()
    }
}