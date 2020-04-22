package com.example.app3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectedAutomobilesAdapter(var selectedAutomobiles: ArrayList<SelectedAutomobile>): RecyclerView.Adapter<SelectedAutomobilesAdapter.AutomobilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AutomobilesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_selected_automobile, parent, false)
    )

    override fun getItemCount(): Int {
        return selectedAutomobiles.size
    }

    fun updateAutomobiles(selectedAutomobilesNew: ArrayList<SelectedAutomobile>) {
        selectedAutomobiles.clear()
        selectedAutomobiles.addAll(selectedAutomobilesNew)
        notifyDataSetChanged()
    }

    class AutomobilesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val producer = view.findViewById<TextView>(R.id.producer)
        val automobiles = view.findViewById<TextView>(R.id.automobiles)

    }

    override fun onBindViewHolder(holder: AutomobilesViewHolder, position: Int) {
        holder.producer.text = selectedAutomobiles[position].producer
        holder.automobiles.text = selectedAutomobiles[position].automobiles
    }

}