package com.example.parkease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewBookedSlotsFragment : Fragment() {

    private lateinit var bookedSlotsRecyclerView: RecyclerView
    private lateinit var bookedSlotsAdapter: BookedSlotsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_booked_slots, container, false)

        // Initialize RecyclerView
        bookedSlotsRecyclerView = view.findViewById(R.id.bookedSlotsRecyclerView)
        bookedSlotsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Load and set the adapter
        val bookedSlotsList = getBookedSlotsData() // Replace with your actual data source
        bookedSlotsAdapter = BookedSlotsAdapter(bookedSlotsList)
        bookedSlotsRecyclerView.adapter = bookedSlotsAdapter

        return view
    }

    private fun getBookedSlotsData(): List<BookedSlot> {
        // Replace this with actual data, e.g., from a database or SharedPreferences
        return listOf(
            BookedSlot("Apr 17", "Green Mall", "Car KA01AB1234", "2 hours", "$20", "Confirmed"),
            BookedSlot("Apr 16", "City Center", "Bike MH12XY5678", "1 hour", "$10", "Cancelled")
        )
    }
}
