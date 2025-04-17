package com.example.parkease

data class BookedSlot(
    val date: String,
    val location: String,
    val vehicle: String,
    val slotNumber: String,
    val fare: String,
    val status: String
)

