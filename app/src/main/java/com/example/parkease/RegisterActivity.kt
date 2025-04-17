package com.example.parkease

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    // Declare variables for the input fields and buttons
    private lateinit var nameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var phoneInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var registerButton: Button
    private lateinit var loginLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize input fields and buttons
        val nameLayout = findViewById<TextInputLayout>(R.id.nameLayout)
        val emailLayout = findViewById<TextInputLayout>(R.id.emailLayout)
        val phoneLayout = findViewById<TextInputLayout>(R.id.phoneLayout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordLayout)

        nameInput = nameLayout.editText as TextInputEditText
        emailInput = emailLayout.editText as TextInputEditText
        phoneInput = phoneLayout.editText as TextInputEditText
        passwordInput = passwordLayout.editText as TextInputEditText

        registerButton = findViewById(R.id.registerButton)
        loginLink = findViewById(R.id.loginLink)

        // Register button click listener
        registerButton.setOnClickListener {
            // Get input data from the fields
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validation: Check if any of the fields are empty
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Registration logic (you can add your database or API call here)
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()

                // For now, just show a success toast
                // You can navigate to the next screen after successful registration
            }
        }

        // Login link click listener (to redirect to login activity)
        loginLink.setOnClickListener {
            // Redirect to login activity (You can replace this with actual navigation logic)
            // For now, show a toast indicating login redirection
            Toast.makeText(this, "Redirect to Login", Toast.LENGTH_SHORT).show()
        }
    }
}
