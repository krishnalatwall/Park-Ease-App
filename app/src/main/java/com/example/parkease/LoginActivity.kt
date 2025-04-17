package com.example.parkease

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var registerLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize the UI components
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        loginButton = findViewById(R.id.loginButton)
        registerLink = findViewById(R.id.registerLink)

        // Set up the login button click listener
        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Simple validation
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                performLogin(email, password)
            }
        }

        // Set up the register link click listener
        registerLink.setOnClickListener {
            // Navigate to the registration page (this needs to be implemented)
            Toast.makeText(this, "Redirect to Register Page", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // A mock function that would typically check credentials (for now, it's a mock check)
    private fun performLogin(email: String, password: String) {
        // Mock check - replace with real logic, such as checking against a database or API
        if (email == "user@example.com" && password == "password123") {
            // Successful login
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            val nextActivity = MainActivity::class.java
            startActivity(Intent(this, nextActivity))
            finish()
            // Navigate to the next screen, for example, Dashboard
            // startActivity(Intent(this, DashboardActivity::class.java))
            // finish() // To finish the login activity so that it's not in the back stack
        } else {
            // Failed login
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}
