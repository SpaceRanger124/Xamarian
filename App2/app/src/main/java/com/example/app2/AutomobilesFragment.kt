package com.example.app2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_automobiles.*

class AutomobilesFragment: Fragment() {

    var automobilesAdapter: AutomobilesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_automobiles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        automobilesAdapter = AutomobilesAdapter()
        automobiles_list.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = automobilesAdapter
        }
        remove_selected_button.setOnClickListener {
            Shared.automobiles = Shared.automobiles.filter { automobile -> !automobile.isSelected } as ArrayList<Automobile>
            automobilesAdapter!!.notifyDataSetChanged()
        }
        add_new_button.setOnClickListener {
            val intent = Intent(it.context, AddAutomobileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        automobilesAdapter!!.notifyDataSetChanged()
    }

}