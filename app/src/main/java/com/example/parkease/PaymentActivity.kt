package com.example.parkease


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    private lateinit var rbCod: RadioButton
    private lateinit var rbOnline: RadioButton
    private lateinit var spinnerPaymentMethods: Spinner
    private lateinit var btnPlaceOrder: Button
    private lateinit var tvTotalPrice: TextView

    private var totalPrice = 284 // Default price, replace with actual calculation from previous activity
    private var discount = 11 // Discount amount (this can change dynamically)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        rbCod = findViewById(R.id.rb_cod)
        rbOnline = findViewById(R.id.rb_online)
        spinnerPaymentMethods = findViewById(R.id.spinner_payment_methods)
        btnPlaceOrder = findViewById(R.id.btn_place_order)
        tvTotalPrice = findViewById(R.id.tv_total_price)

        // Initially set total price
        tvTotalPrice.text = "₹$totalPrice"

        // Change price dynamically based on selection
        rbCod.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) tvTotalPrice.text = "₹$totalPrice"
        }

        rbOnline.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val discountedPrice = totalPrice - discount
                tvTotalPrice.text = "₹$discountedPrice"
            }
        }

        btnPlaceOrder.setOnClickListener {
            if (rbCod.isChecked || rbOnline.isChecked || spinnerPaymentMethods.selectedItemPosition != 0) {
                Toast.makeText(this, "Payment Successful! Booking Confirmed", Toast.LENGTH_LONG).show()

                // Navigate back to Home Page
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Select a Payment Method", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
