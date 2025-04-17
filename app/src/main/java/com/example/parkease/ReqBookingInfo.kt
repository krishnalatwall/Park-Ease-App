package com.example.parkease



import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ReqBookingInfo : AppCompatActivity() {

    private lateinit var tvLocationInfo: TextView
    private lateinit var btnSelectLocation: Button
    private lateinit var etVehicleModel: EditText
    private lateinit var etVehicleNumber: EditText
    private lateinit var etVehicleType: EditText
    private lateinit var btnSelectDateTime: Button
    private lateinit var tvTotalCost: TextView
    private lateinit var btnNext: Button

    private var selectedHours: Int = 0
    private val pricePerHour = 50 // Fixed price per hour

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.req_booking_info)

        tvLocationInfo = findViewById(R.id.tv_location_info)
        btnSelectLocation = findViewById(R.id.btn_select_location)
        etVehicleModel = findViewById(R.id.et_vehicle_model)
        etVehicleNumber = findViewById(R.id.et_vehicle_number)
        etVehicleType = findViewById(R.id.et_vehicle_type)
        btnSelectDateTime = findViewById(R.id.btn_select_datetime)
        tvTotalCost = findViewById(R.id.tv_total_cost)
        btnNext = findViewById(R.id.btn_next)

        // Select Location (Placeholder for Google Maps)
        btnSelectLocation.setOnClickListener {
            Toast.makeText(this, "Open Google Maps for location selection", Toast.LENGTH_SHORT).show()
        }

        // Select Date and Time
        btnSelectDateTime.setOnClickListener {
            selectDateTime()
        }

        // Proceed to Next Step
        btnNext.setOnClickListener {
            if (validateInputs()) {
                Toast.makeText(this, "Proceeding to Payment", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, PaymentActivity::class.java))
            }
        }
    }

    private fun selectDateTime() {
        val calendar = Calendar.getInstance()

        // Select Date
        val datePicker = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"

            // Select Time
            val timePicker = TimePickerDialog(this, { _, hourOfDay, _ ->
                selectedHours = 2 // Example: Assume 2 hours booking
                updateTotalCost()
                Toast.makeText(this, "Selected: $selectedDate at $hourOfDay:00", Toast.LENGTH_SHORT).show()
            }, calendar.get(Calendar.HOUR_OF_DAY), 0, true)

            timePicker.show()
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

        datePicker.show()
    }

    private fun updateTotalCost() {
        val totalCost = selectedHours * pricePerHour
        tvTotalCost.text = "Total Cost: ₹$totalCost"
    }

    private fun validateInputs(): Boolean {
        return when {
            etVehicleModel.text.isEmpty() -> {
                etVehicleModel.error = "Enter Vehicle Model"
                false
            }
            etVehicleNumber.text.isEmpty() -> {
                etVehicleNumber.error = "Enter Vehicle Number"
                false
            }
            etVehicleType.text.isEmpty() -> {
                etVehicleType.error = "Enter Vehicle Type"
                false
            }
            selectedHours == 0 -> {
                Toast.makeText(this, "Select Date & Time", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }
}
