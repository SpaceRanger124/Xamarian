package com.example.app1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_automobile.*
import kotlinx.android.synthetic.main.fragment_automobile.*
import kotlinx.android.synthetic.main.fragment_automobile.name
import kotlinx.android.synthetic.main.fragment_automobile.price
import kotlinx.android.synthetic.main.fragment_automobile.producer

class AutomobileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_automobile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        producer.text = Shared.selectedAutomobile?.producer
        name.text = Shared.selectedAutomobile?.name
        price.text = Shared.selectedAutomobile?.price

        back.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().remove(this).commit()
        }

    }

}