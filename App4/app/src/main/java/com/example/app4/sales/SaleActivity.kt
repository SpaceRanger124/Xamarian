package com.example.app4.sales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.DatabaseHandler
import com.example.app4.R
import com.example.app4.Shared
import kotlinx.android.synthetic.main.activity_sale.*

class SaleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale)

        id.text = Shared.selectedSale!!.id
        product_id.setText(Shared.selectedSale!!.productId)
        quantity.setText(Shared.selectedSale!!.quantity.toString())
        release_price.setText(Shared.selectedSale!!.releasePrice.toString())
        release_date.setText(Shared.selectedSale!!.date)

        val db = DatabaseHandler(this)

        edit_sale.setOnClickListener {
            if (product_id.isEnabled) {
                edit_sale.text = "Edit"
                db.editSale(
                    Sale(
                        id.text.toString(),
                        product_id.text.toString(),
                        quantity.text.toString().toInt(),
                        release_price.text.toString().toInt(),
                        release_date.text.toString()
                    )
                )
            } else {
                edit_sale.text = "Save changes"
            }

            product_id.isEnabled = !product_id.isEnabled
            quantity.isEnabled = product_id.isEnabled
            release_price.isEnabled = product_id.isEnabled
            release_date.isEnabled = product_id.isEnabled
        }

        remove_sale.setOnClickListener {
            db.removeSale(Shared.selectedSale!!)
            finish()
        }
    }

}