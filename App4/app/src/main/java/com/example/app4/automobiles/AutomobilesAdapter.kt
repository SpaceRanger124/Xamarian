package com.example.app4.automobiles

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app4.R
import com.example.app4.Shared

class AutomobilesAdapter(var automobiles: ArrayList<Automobile>): RecyclerView.Adapter<AutomobilesAdapter.AutomobilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AutomobilesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_automobile,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return automobiles.size
    }

    fun updateAutomobiles(newAutomobiles: ArrayList<Automobile>) {
        this.automobiles.clear()
        this.automobiles.addAll(newAutomobiles)
        notifyDataSetChanged()
    }

    class AutomobilesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val automobileName = view.findViewById<TextView>(R.id.automobile)

    }

    override fun onBindViewHolder(holder: AutomobilesViewHolder, position: Int) {
        holder.automobileName.text = automobiles[position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, AutomobileActivity::class.java)
            Shared.selectedAutomobile = automobiles[position]
            it.context.startActivity(intent)
        }
    }

}