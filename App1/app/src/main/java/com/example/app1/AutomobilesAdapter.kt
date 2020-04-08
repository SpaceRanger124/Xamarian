package com.example.app1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.app1.Shared.Companion.automobiles
import kotlinx.android.synthetic.main.activity_main.*

class AutomobilesAdapter(var activity: MainActivity, var alert: AlertDialog?): RecyclerView.Adapter<AutomobilesAdapter.AutomobilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = AutomobilesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_automobile, parent, false)
    )

    override fun getItemCount(): Int {
        return automobiles.size
    }

    override fun onBindViewHolder(holder: AutomobilesViewHolder, position: Int) {
        holder.automobileName.text = automobiles[position].name
        holder.automobileName.setOnClickListener {
            alert?.cancel()
            Shared.selectedAutomobile = automobiles[position]
            activity.findViewById<FrameLayout>(R.id.frame_layout).visibility = View.VISIBLE
            val fragment = AutomobileFragment()
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .commit()
        }
    }

    class AutomobilesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val automobileName = view.findViewById<TextView>(R.id.automobile_name)

    }

}