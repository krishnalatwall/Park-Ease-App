package com.example.parkease

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profilePicture = findViewById<ImageView>(R.id.profilePicture)
        val profileName = findViewById<TextView>(R.id.profileName)
        val profileEmail = findViewById<TextView>(R.id.profileEmail)
        val editProfileButton = findViewById<Button>(R.id.editProfileButton)

        // You can replace this with user data from a database or API
        profileName.text = "John Doe"
        profileEmail.text = "johndoe@example.com"

        // Handle edit profile button click (example)
        editProfileButton.setOnClickListener {
            // Navigate to EditProfileActivity (for example)
            // startActivity(Intent(this, EditProfileActivity::class.java))
        }
    }
}
