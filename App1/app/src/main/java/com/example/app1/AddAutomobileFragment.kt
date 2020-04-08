package com.example.app1

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_automobile.*

class AddAutomobileFragment(activity: MainActivity): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_automobile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_automobile.setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("Title")
                .setMessage("Add automobile?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("yes") { _: DialogInterface, _: Int ->
                    Shared.automobiles.add(Automobile(producer.text.toString(), name.text.toString(), price.text.toString()))
                    this.activity!!.supportFragmentManager.beginTransaction()
                        .remove(this).commit()
                }
                .setNegativeButton("no") { _: DialogInterface, _: Int ->
                    this.activity!!.supportFragmentManager.beginTransaction()
                        .remove(this).commit()
                }.show()

        }
    }

}