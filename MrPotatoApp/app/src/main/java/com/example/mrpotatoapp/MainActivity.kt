package com.example.mrpotatoapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private val views = arrayOf(
        R.id.hat, R.id.eyebrows, R.id.nose, R.id.moustache,
        R.id.arms, R.id.eyes, R.id.glasses, R.id.mouth,
        R.id.ears, R.id.shoes
    )

    private val checkboxes = arrayOf(
        R.id.hatCheck, R.id.eyebrowCheck, R.id.noseCheck, R.id.moustacheCheck,
        R.id.armsCheck, R.id.eyesCheck, R.id.glassesCheck, R.id.mouthCheck,
        R.id.earsCheck, R.id.shoesCheck
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun handleChecked(view: View) {
        val index = this.checkboxes.indexOf(view.id)
        val partID = this.views[index]
        val isVis = findViewById<ImageView>(partID).isVisible
        findViewById<ImageView>(partID).isVisible = !isVis
    }
}