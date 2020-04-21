package com.example.app3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_selected_automobiles.*

class SelectedAutomobilesFragment: Fragment() {

    var selectedAutomobilesAdapter: SelectedAutomobilesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selected_automobiles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedAutomobilesAdapter = SelectedAutomobilesAdapter()
        selected_automobiles_list.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = selectedAutomobilesAdapter
        }
    }

}