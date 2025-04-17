package com.example.parkease

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyVehicleActivity : AppCompatActivity() {

    private lateinit var vehicleMake: EditText
    private lateinit var vehicleModel: EditText
    private lateinit var vehicleRegistration: EditText
    private lateinit var saveButton: Button
    private lateinit var savedVehicleInfo: TextView

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("user_vehicle", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_vehicle)

        vehicleMake = findViewById(R.id.vehicleMake)
        vehicleModel = findViewById(R.id.vehicleModel)
        vehicleRegistration = findViewById(R.id.vehicleRegistration)
        saveButton = findViewById(R.id.saveButton)
        savedVehicleInfo = findViewById(R.id.savedVehicleInfo)

        // Load saved vehicle data
        loadVehicleData()

        saveButton.setOnClickListener {
            saveVehicleData()
            loadVehicleData()  // Update the displayed info after saving
        }
    }

    private fun saveVehicleData() {
        val editor = sharedPreferences.edit()
        editor.putString("vehicle_make", vehicleMake.text.toString())
        editor.putString("vehicle_model", vehicleModel.text.toString())
        editor.putString("vehicle_registration", vehicleRegistration.text.toString())
        editor.apply()
    }

    private fun loadVehicleData() {
        val make = sharedPreferences.getString("vehicle_make", "No vehicle saved yet")
        val model = sharedPreferences.getString("vehicle_model", "")
        val registration = sharedPreferences.getString("vehicle_registration", "")

        if (make != "No vehicle saved yet") {
            savedVehicleInfo.text = "Vehicle Make: $make\nVehicle Model: $model\nRegistration: $registration"
        } else {
            savedVehicleInfo.text = make
        }
    }
}
