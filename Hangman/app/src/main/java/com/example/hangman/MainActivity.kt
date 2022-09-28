package com.example.hangman

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var generatedWord: String = ""
    private var strToShow: String = ""
    private var numberOfGuesses: Int = 3
    private var initPosToShow1: Int = 0
    private var initPosToShow2: Int = 0
    private var isGameOver = false

    private val wordsList: Array<String> = arrayOf(
        "ability", "believe", "campaign", "growth",
        "significant", "weight", "traditional", "themselves",
        "surface", "southern", "performance", "member"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.init()
    }

    fun newClicked(view: View) {
        this.isGameOver = false
        this.numberOfGuesses = 3
        findViewById<TextView>(R.id.guessTrack).text = "You have guessed: ${3} (${this.numberOfGuesses} guesses left)"
        findViewById<TextView>(R.id.word).setTextColor(Color.parseColor("#FF000000"));
        init()
    }

    fun guessClicked(view: View) {
        if(this.isGameOver) return ;

        val inputText: String = findViewById<EditText>(R.id.inputField).text.toString()
        if (!isValid(inputText)) return;

        val guessTrack: TextView = findViewById(R.id.guessTrack)

        if (!this.hasLetter(inputText)) {
            --this.numberOfGuesses
            setGameStatus()
        } else {
            val index = this.findIndex(inputText)
            this.reCreateStr(index)

            if (checkWin(guessTrack)) return;
        }

        guessTrack.text = "You have guessed: ${inputText} (${this.numberOfGuesses} guesses left)"
    }

    private fun checkWin(guessTrack: TextView): Boolean {
        if (this.strToShow == this.generatedWord) {
            guessTrack.text = "YOU WON!"
            this.isGameOver = true
            return true;
        }
        return false
    }

    private fun setGameStatus() {
        val hangmanPic: ImageView = findViewById(R.id.hangmanPic)
        val wordField: TextView = findViewById(R.id.word)

        if (this.numberOfGuesses == 2)
            hangmanPic.setImageResource(R.drawable.hang1)
        else if (this.numberOfGuesses == 1)
            hangmanPic.setImageResource(R.drawable.hang2)
        else if (this.numberOfGuesses == 0) {
            hangmanPic.setImageResource(R.drawable.hang3)
            Toast.makeText(this, "Number of Guesses Exhausted", Toast.LENGTH_LONG).show()
            wordField.text = "GAME OVER!"
            wordField.setTextColor(Color.parseColor("#FF0000"));
            this.isGameOver = true
        }
    }

    private fun isValid(inputText: String): Boolean {
        if (inputText.length > 1) {
            Toast.makeText(this, "Guess a single letter at a time", Toast.LENGTH_LONG).show()
            return false;
        } else if (!this.isLetter(inputText)) {
            Toast.makeText(this, "Write a letter please!", Toast.LENGTH_LONG).show()
            return false;
        }
        return true
    }

    private fun hasLetter(char: String): Boolean {
        for (i in 0 until this.generatedWord.length) {
            if (this.generatedWord[i] == char[0]) {
                if (i == this.initPosToShow1 || i == this.initPosToShow2) return false
                return true
            }
        }
        return false
    }

    private fun findIndex(char: String): Int {
        for (i in 0 until this.generatedWord.length) {
            if (this.generatedWord[i] == char[0]) {
                if (this.strToShow[i] == '?') return i
                else continue
            }
        }
        return this.generatedWord.indexOf(char)
    }

    private fun isLetter(string: String): Boolean {
        return string.matches("^[a-zA-Z]*$".toRegex())
    }

    private fun init() {
        val randIdx = Random().nextInt(this.wordsList.size)
        this.generatedWord = this.wordsList[randIdx]
        val wordField: TextView = findViewById(R.id.word)

        this.initPosToShow1 = Random().nextInt(this.generatedWord.length)
        this.initPosToShow2 = initPosToShow1
        while (this.initPosToShow2 == this.initPosToShow1)
            this.initPosToShow2 = Random().nextInt(this.generatedWord.length)

        this.createStr()
        wordField.text = this.strToShow
    }

    private fun createStr() {
        this.strToShow = ""

        for (i in 0 until this.generatedWord.length) {
            if (i == this.initPosToShow1)
                this.strToShow += this.generatedWord[this.initPosToShow1]
            else if (i == initPosToShow2)
                this.strToShow += this.generatedWord[this.initPosToShow2]
            else
                this.strToShow += "?"
        }
    }

    private fun reCreateStr(index: Int) {
        val tempStr: String = this.strToShow
        this.strToShow = ""

        for (i in 0 until tempStr.length) {
            if (i == index)
                this.strToShow += this.generatedWord[index]
            else
                this.strToShow += tempStr[i]
        }

        val wordField: TextView = findViewById(R.id.word)
        wordField.text = this.strToShow
    }
}