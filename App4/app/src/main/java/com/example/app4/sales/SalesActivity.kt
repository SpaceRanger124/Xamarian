package com.example.app4.sales

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app4.DatabaseHandler
import com.example.app4.R
import kotlinx.android.synthetic.main.activity_sales.*

class SalesActivity: AppCompatActivity() {

    var salesAdapter: SalesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)

        val db = DatabaseHandler(this)
        val sales = db.getAllSales()
        salesAdapter =
            SalesAdapter(sales)
        sales_list.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = salesAdapter
        }

        add_sale.setOnClickListener {
            val intent = Intent(this, AddSaleActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (salesAdapter != null) {
            val db = DatabaseHandler(this)
            val sales = db.getAllSales()
            salesAdapter!!.updateSales(sales)
        }
    }

}