package com.example.app4.producers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app4.R
import com.example.app4.Shared

class ProducersAdapter(var producers: ArrayList<Producer>): RecyclerView.Adapter<ProducersAdapter.ProducersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProducersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_producer,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return producers.size
    }

    fun updateProducers(newProducers: ArrayList<Producer>) {
        this.producers.clear()
        this.producers.addAll(newProducers)
        notifyDataSetChanged()
    }

    class ProducersViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val producerName = view.findViewById<TextView>(R.id.producer)

    }

    override fun onBindViewHolder(holder: ProducersViewHolder, position: Int) {
        holder.producerName.text = producers[position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, ProducerActivity::class.java)
            Shared.selectedProducer = producers[position]
            it.context.startActivity(intent)
        }
    }

}