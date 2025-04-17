package com.example.parkease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleAdapter(private val vehicleList: List<Vehicle>) :
    RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicleList[position]
        holder.registrationNumber.text = vehicle.registrationNumber
        holder.type.text = vehicle.type
        holder.color.text = vehicle.color
    }

    override fun getItemCount(): Int = vehicleList.size

    inner class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val registrationNumber: TextView = itemView.findViewById(R.id.registrationNumber)
        val type: TextView = itemView.findViewById(R.id.type)
        val color: TextView = itemView.findViewById(R.id.color)
    }
}
