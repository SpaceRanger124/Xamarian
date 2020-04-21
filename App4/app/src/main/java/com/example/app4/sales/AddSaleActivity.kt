package com.example.app4.sales

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.DatabaseHandler
import com.example.app4.R
import kotlinx.android.synthetic.main.activity_add_sale.*

class AddSaleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sale)

        val db = DatabaseHandler(this)

        val automobiles = db.getAllAutomobiles()

        id.text = (automobiles.map { it.id }.last().toInt() + 1).toString()

        submit_sale.setOnClickListener {
            if (automobiles.none { it.id == product_id.text.toString() }) {
                Toast.makeText(this, "There is no such product", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            db.addSale(
                Sale(
                    id.text.toString(),
                    product_id.text.toString(),
                    quantity.text.toString().toInt(),
                    release_price.text.toString().toInt(),
                    release_date.text.toString()
                )
            )
            finish()
        }

        cancel_sale.setOnClickListener {
            finish()
        }

    }

}