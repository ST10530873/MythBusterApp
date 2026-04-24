package com.myth.buster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.myth.buster.R

class QuizActivity : AppCompatActivity() {
    private var score = 0
    private var currentQuestionIndex = 0

    private val questions = arrayOf(
        "Is the sky blue because of the ocean?",
        "Do bulls hate the color red?",
        "Can gold fish remember things for only 3 seconds?"
    )
    private val answers = arrayOf(false, false, false) // All these are myths!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)

        txtQuestion.text = questions[currentQuestionIndex]

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestionIndex]) {
            score++
        }
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            findViewById<TextView>(R.id.txtQuestion).text = questions[currentQuestionIndex]
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            finish()
        }
    }
}
