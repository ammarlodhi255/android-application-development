package com.example.memorygame

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var timesClicked = 0
    private var lastIndex = -1
    private var twoButtons = arrayOf(-1, -1)
    private var minute = 0
    private var seconds = 0

    private val imgs = arrayOf(
        R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
        R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
        R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l
    )

    private val btns = arrayOf(
        R.id.q1, R.id.q2, R.id.q3, R.id.q4, R.id.q5, R.id.q6,
        R.id.q7, R.id.q8, R.id.q9, R.id.q10, R.id.q11, R.id.q12,
        R.id.q13, R.id.q14, R.id.q15, R.id.q16, R.id.q17, R.id.q18,
        R.id.q19, R.id.q20, R.id.q21, R.id.q22, R.id.q23, R.id.q24
    )

    private var randLocations: Array<Int> = emptyArray()

    // For countdown timer:
    val timer = object: CountDownTimer(2000000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val txtView = findViewById<TextView>(R.id.textView)
            if (seconds == 60) {
                minute += 1
                seconds = 0
                txtView.text = "${minute} : 00"
            } else {
                seconds += 1
                txtView.text = "${minute} : ${seconds}"
            }
        }

        override fun onFinish() {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateRandomImages()
        timer.start()
    }

    fun showImage(view: android.view.View) {
        val index1 = this.btns.indexOf(view.id)
        var index2 = this.randLocations.indexOf(index1)
        var idx = calcIndex(index2)
        val imgBtn = findViewById<ImageButton>(view.id)
        imgBtn.setImageResource(this.imgs[idx])

        if(this.timesClicked == 1) {
            if (calcIndex(this.lastIndex) == idx) {
                Toast.makeText(this, "Got it", Toast.LENGTH_LONG).show()
                findViewById<ImageButton>(this.btns[this.randLocations[this.lastIndex]]).setOnClickListener(null)
                imgBtn.setOnClickListener(null)
                this.lastIndex = -1
            }
            else {
                this.twoButtons[0] = imgBtn.id
                this.twoButtons[1] = this.btns[this.randLocations[this.lastIndex]]
                this.lastIndex = index2
            }
        } else if (this.timesClicked == 2) {
            findViewById<ImageButton>(this.twoButtons[0]).setImageResource(R.drawable.question)
            findViewById<ImageButton>(this.twoButtons[1]).setImageResource(R.drawable.question)
            this.timesClicked = 0
            this.lastIndex = index2
        } else {
            this.lastIndex = index2
        }

        this.timesClicked += 1
    }

    private fun calcIndex(index: Int) : Int {
        var idx = 0
        var index2 = index

        if(index2 % 2 != 0)
            index2 -= 1

        idx = index2 - (index2 / 2)
        return idx
    }

    fun generateRandomImages() {
        for (i in 0 .. 23) {
            var rand_num = Random().nextInt(24)
            while (this.randLocations.indexOf(rand_num) != -1)
                rand_num = Random().nextInt(24)

            randLocations += rand_num
        }
    }
}