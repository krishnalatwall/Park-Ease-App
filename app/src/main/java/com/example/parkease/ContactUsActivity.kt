package com.example.parkease

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ContactUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        val emailButton: Button = findViewById(R.id.button_email)
        val phoneText: TextView = findViewById(R.id.text_phone)
        val whatsappButton: Button = findViewById(R.id.button_whatsapp)
        val feedbackInput: EditText = findViewById(R.id.edit_feedback)
        val submitButton: Button = findViewById(R.id.button_send_feedback)

        // Call on phone
        phoneText.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:+911234567890")
            startActivity(dialIntent)
        }

        // Send email
        emailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:parkease.support@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "Support - ParkEase")
                putExtra(Intent.EXTRA_TEXT, "Hi ParkEase team,\n\n")
            }
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        // Open WhatsApp chat
        whatsappButton.setOnClickListener {
            val number = "+911234567890"
            val url = "https://wa.me/${number.replace("+", "")}?text=Hi%20ParkEase%20Support!"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        // Submit feedback
        submitButton.setOnClickListener {
            val feedback = feedbackInput.text.toString()
            if (feedback.isNotBlank()) {
                Toast.makeText(this, "Feedback submitted. Thank you!", Toast.LENGTH_SHORT).show()
                feedbackInput.text.clear()
            } else {
                Toast.makeText(this, "Please enter feedback.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
