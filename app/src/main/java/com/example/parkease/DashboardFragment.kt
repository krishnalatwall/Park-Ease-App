package com.example.parkease

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Initialize buttons
        val findParkingButton = view.findViewById<Button>(R.id.findParkingButton)
        val myVehicleButton = view.findViewById<Button>(R.id.myVehicleButton)
        val viewBookedButton = view.findViewById<Button>(R.id.viewBookedButton)

        // Find Parking Button Click
        findParkingButton.setOnClickListener {
            val nextActivity = FindParkingActivity::class.java
            startActivity(Intent(requireContext(),nextActivity))
        }

        // My Vehicle Button Click
        myVehicleButton.setOnClickListener {
            val nextActivity = MyVehicleActivity::class.java
            startActivity(Intent(requireContext(), nextActivity))
        }

        // View Booked Slots Button Click
        viewBookedButton.setOnClickListener {
            val nextActivity = ViewBookedSlotsActivity::class.java
            startActivity(Intent(requireContext(), nextActivity))
        }

        return view
    }
}
