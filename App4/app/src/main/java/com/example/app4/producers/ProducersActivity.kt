package com.example.app4.producers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app4.DatabaseHandler
import com.example.app4.R
import kotlinx.android.synthetic.main.activity_producers.*

class ProducersActivity: AppCompatActivity() {

    var producersAdapter: ProducersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producers)

        val db = DatabaseHandler(this)
        val producers = db.getAllProducers()
        producersAdapter =
            ProducersAdapter(producers)
        producers_list.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = producersAdapter
        }

        add_producer.setOnClickListener {
            val intent = Intent(this, AddProducerActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (producersAdapter != null) {
            val db = DatabaseHandler(this)
            val producers = db.getAllProducers()
            producersAdapter!!.updateProducers(producers)
        }
    }

}