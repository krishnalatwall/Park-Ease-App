package com.example.parkease

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val etFeedback = findViewById<EditText>(R.id.et_feedback)
        val btnSubmit = findViewById<Button>(R.id.btn_submit_feedback)

        btnSubmit.setOnClickListener {
            val feedback = etFeedback.text.toString().trim()
            if (feedback.isNotEmpty()) {
                // You can send this to a server or save it locally
                Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show()
                etFeedback.text.clear()
            } else {
                Toast.makeText(this, "Please enter feedback", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
