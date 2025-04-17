package com.example.parkease

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingConfirmedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val vehicleName = intent.getStringExtra("vehicle_name")
        findViewById<TextView>(R.id.selected_vehicle_text).text = "Selected Vehicle: $vehicleName"

        NotificationHelper.sendNotification(this, "Booking Confirmed", "Your vehicle has been successfully booked.")

    }
}