package com.example.parkease

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FindParkingActivity : AppCompatActivity() {

    private lateinit var locationSearchBar: EditText
    private lateinit var searchButton: Button
    private lateinit var parkingGrid: GridLayout
    private lateinit var slotInfoLayout: LinearLayout
    private lateinit var slotDetails: TextView
    private lateinit var fareDetails: TextView
    private lateinit var hourSpinner: Spinner
    private lateinit var totalFare: TextView
    private lateinit var bookNowBtn: Button

    private val farePerHour = 50
    private var selectedSlot: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_parking)

        // Views
        locationSearchBar = findViewById(R.id.locationSearchBar)
        searchButton = findViewById(R.id.searchButton)
        parkingGrid = findViewById(R.id.parkingGrid)
        slotInfoLayout = findViewById(R.id.slotInfoLayout)
        slotDetails = findViewById(R.id.slotDetails)
        fareDetails = findViewById(R.id.fareDetails)
        hourSpinner = findViewById(R.id.hourSpinner)
        totalFare = findViewById(R.id.totalFare)
        bookNowBtn = findViewById(R.id.bookNowBtn)

        // Spinner for hours
        val hours = (1..10).map { "$it hour(s)" }
        hourSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, hours)
        hourSpinner.setSelection(0)

        hourSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                updateTotalFare()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        searchButton.setOnClickListener {
            val location = locationSearchBar.text.toString().trim()
            if (location.isNotEmpty()) {
                showMockParkingSlots(location)
            } else {
                Toast.makeText(this, "Enter a location", Toast.LENGTH_SHORT).show()
            }
        }

        bookNowBtn.setOnClickListener {
            Toast.makeText(this, "Slot '$selectedSlot' booked successfully!", Toast.LENGTH_LONG).show()
        }
    }

    private fun showMockParkingSlots(location: String) {
        parkingGrid.removeAllViews()
        slotInfoLayout.visibility = View.GONE

        val mockSlots = listOf("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")
        for (slot in mockSlots) {
            val slotView = TextView(this).apply {
                text = slot
                textSize = 16f
                setPadding(32, 32, 32, 32)
                background = getDrawable(R.drawable.slot_bg)
                setOnClickListener {
                    onSlotSelected(slot)
                }
            }
            parkingGrid.addView(slotView)
        }
    }

    private fun onSlotSelected(slot: String) {
        selectedSlot = slot
        slotInfoLayout.visibility = View.VISIBLE
        slotDetails.text = "Selected Slot: $slot"
        fareDetails.text = "Fare per hour: ₹$farePerHour"
        updateTotalFare()
    }

    private fun updateTotalFare() {
        val selectedHours = hourSpinner.selectedItemPosition + 1
        val total = selectedHours * farePerHour
        totalFare.text = "Total: ₹$total"
    }
}
