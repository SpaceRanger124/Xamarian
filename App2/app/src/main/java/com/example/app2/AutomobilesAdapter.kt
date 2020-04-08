package com.example.app2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app2.Shared.Companion.automobiles

class AutomobilesAdapter: RecyclerView.Adapter<AutomobilesAdapter.AutomobilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AutomobilesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_automobile, parent, false)
    )

    override fun getItemCount(): Int {
        return automobiles.size
    }

    class AutomobilesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val automobileName = view.findViewById<TextView>(R.id.automobile_name)
        val automobileAuthor = view.findViewById<TextView>(R.id.automobile_author)
        val automobileImage = view.findViewById<ImageView>(R.id.automobile_image)
        val context = view.context

    }

    override fun onBindViewHolder(holder: AutomobilesViewHolder, position: Int) {
        holder.automobileName.text = automobiles[position].name
        holder.automobileAuthor.text = "Producer: " + automobiles[position].producer
        holder.automobileImage.setImageDrawable(holder.context.getDrawable(automobiles[position].imageIndex))
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
    }

}