package com.example.app4.automobiles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app4.DatabaseHandler
import com.example.app4.R
import kotlinx.android.synthetic.main.activity_automobiles.*

class AutomobilesActivity: AppCompatActivity () {

    var automobilesAdapter: AutomobilesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_automobiles)

        val db = DatabaseHandler(this)
        val automobiles = db.getAllAutomobiles()
        automobilesAdapter =
            AutomobilesAdapter(automobiles)
        automobiles_list.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = automobilesAdapter
        }

        add_automobile.setOnClickListener {
            val intent = Intent(this, AddAutomobileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (automobilesAdapter != null) {
            val db = DatabaseHandler(this)
            val automobiles = db.getAllAutomobiles()
            automobilesAdapter!!.updateAutomobiles(automobiles)
        }
    }

}