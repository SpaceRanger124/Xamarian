package com.example.app3

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AutomobilesAdapter(var automobiles: ArrayList<Automobile>): RecyclerView.Adapter<AutomobilesAdapter.AutomobilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AutomobilesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_automobile, parent, false)
    )

    fun updateAutomobiles(newAutomobiles: ArrayList<Automobile>) {
        this.automobiles.clear()
        this.automobiles.addAll(newAutomobiles)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return automobiles.size
    }

    class AutomobilesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val automobileName = view.findViewById<TextView>(R.id.automobile_name)
        val automobileAuthor = view.findViewById<TextView>(R.id.automobile_author)
        val automobileImage = view.findViewById<ImageView>(R.id.automobile_image)
        val automobilePhone = view.findViewById<TextView>(R.id.phone_number)
        val automobileEmail = view.findViewById<TextView>(R.id.email)
        val context = view.context
    }

    override fun onBindViewHolder(holder: AutomobilesViewHolder, position: Int) {
        holder.automobileName.text = automobiles[position].name
        holder.automobileAuthor.text = "Producer: " + automobiles[position].producer
        holder.automobileImage.setImageDrawable(holder.context.getDrawable(automobiles[position].imageIndex))
        holder.automobilePhone.text = automobiles[position].phoneNumber
        holder.automobileEmail.text = automobiles[position].email

        holder.itemView.setBackgroundColor(Color.parseColor("#ff33b5e5"))
        holder.itemView.setOnClickListener {
            if (automobiles[position].isSelected) {
                automobiles[position].isSelected = false
                it.setBackgroundColor(Color.parseColor("#ff33b5e5"))
            } else {
                automobiles[position].isSelected = true
                it.setBackgroundColor(Color.parseColor("#1130AA"))
            }
        }

        holder.automobileImage.setOnClickListener {
            val intent = Intent(it.context, EditAutomobileActivity::class.java)
            intent.putExtra("index", position)
            intent.putExtra("producer", automobiles[position].producer)
            intent.putExtra("name", automobiles[position].name)
            intent.putExtra("phone_number", automobiles[position].phoneNumber)
            intent.putExtra("email", automobiles[position].email)
            it.context.startActivity(intent)
        }
    }

}