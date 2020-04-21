package com.example.app4.producers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.DatabaseHandler
import com.example.app4.R
import kotlinx.android.synthetic.main.activity_add_producer.*

class AddProducerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_producer)

        val db = DatabaseHandler(this)

        val producers = db.getAllProducers()

        id.text = (producers.map { it.id }.last().toInt() + 1).toString()

        submit_producer.setOnClickListener {
            db.addProducer(
                Producer(
                    id.text.toString(),
                    name.text.toString(),
                    address.text.toString(),
                    phone.text.toString(),
                    email.text.toString()
                )
            )
            finish()
        }

        cancel_producer.setOnClickListener {
            finish()
        }

    }

}