package com.example.parkease

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewBookedSlotsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookedSlotsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_booked_slots)

        recyclerView = findViewById(R.id.bookedSlotsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dummyData = listOf(
            BookedSlot("Apr 17", "Green Mall", "Car KA01AB1234", "2 hours", "$20", "Confirmed"),
            BookedSlot("Apr 16", "City Center", "Bike MH12XY5678", "1 hour", "$10", "Cancelled")
        )

        adapter = BookedSlotsAdapter(dummyData)
        recyclerView.adapter = adapter
    }
}
