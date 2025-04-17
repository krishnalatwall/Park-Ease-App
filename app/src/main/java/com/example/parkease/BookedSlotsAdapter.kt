package com.example.parkease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookedSlotsAdapter(private val slotsList: List<BookedSlot>) : RecyclerView.Adapter<BookedSlotsAdapter.BookedSlotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookedSlotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_booked_slot, parent, false)
        return BookedSlotViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookedSlotViewHolder, position: Int) {
        val bookedSlot = slotsList[position]
        holder.dateTextView.text = bookedSlot.date
        holder.locationTextView.text = bookedSlot.location
        holder.vehicleTextView.text = bookedSlot.vehicle
        holder.fareTextView.text = bookedSlot.fare
        holder.statusTextView.text = bookedSlot.status
    }

    override fun getItemCount(): Int = slotsList.size

    class BookedSlotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.bookingDate)
        val locationTextView: TextView = itemView.findViewById(R.id.bookingLocation)
        val vehicleTextView: TextView = itemView.findViewById(R.id.bookingVehicle)
        val durationTextView: TextView = itemView.findViewById(R.id.bookingDuration)
        val fareTextView: TextView = itemView.findViewById(R.id.bookingFare)
        val statusTextView: TextView = itemView.findViewById(R.id.bookingStatus)
    }
}
