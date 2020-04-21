package com.example.app4.sales

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app4.R
import com.example.app4.Shared

class SalesAdapter(var sales: ArrayList<Sale>): RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SalesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_sale,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return sales.size
    }

    fun updateSales(newSales: ArrayList<Sale>) {
        this.sales.clear()
        this.sales.addAll(newSales)
        notifyDataSetChanged()
    }

    class SalesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val productId = view.findViewById<TextView>(R.id.product_id)
        val date = view.findViewById<TextView>(R.id.date)

    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.productId.text = sales[position].productId
        holder.date.text = sales[position].date
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, SaleActivity::class.java)
            Shared.selectedSale = sales[position]
            it.context.startActivity(intent)
        }
    }

}