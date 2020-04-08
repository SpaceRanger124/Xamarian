package com.example.app1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var automobilesAdapter: AutomobilesAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        automobiles_list_label.setOnClickListener {
            showDialog()
        }

        add_automobile.setOnClickListener {
            val fragment = AddAutomobileFragment(this)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .commit()
        }

    }

    fun showDialog() {
        // Show alert pop-up
        val dialog = AlertDialog.Builder(this, R.style.ThemeOverlay_AppCompat_Dialog)
        // Save dialog_dashboard as View in view
        val view = layoutInflater.inflate(R.layout.popup_menu, null)
        // Set dialog_dashboard as View
        dialog.setView(view)
        val show = dialog.show()
        automobilesAdapter = AutomobilesAdapter(this, show)
        view.findViewById<RecyclerView>(R.id.automobiles).apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = automobilesAdapter
        }

        dialog.setNegativeButton("cancel") { _: DialogInterface, _: Int ->
        }

        true
    }

}
