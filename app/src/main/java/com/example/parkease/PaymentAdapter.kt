package com.example.parkease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaymentAdapter(private val payments: List<Payment>) :
    RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    inner class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.payment_date)
        val method: TextView = itemView.findViewById(R.id.payment_method)
        val amount: TextView = itemView.findViewById(R.id.payment_amount)
        val status: TextView = itemView.findViewById(R.id.payment_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = payments[position]
        holder.date.text = payment.date
        holder.method.text = payment.method
        holder.amount.text = payment.amount
        holder.status.text = payment.status
    }

    override fun getItemCount(): Int = payments.size
}
