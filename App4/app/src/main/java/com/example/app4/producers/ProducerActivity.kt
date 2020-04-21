package com.example.app4.producers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.DatabaseHandler
import com.example.app4.R
import com.example.app4.Shared
import kotlinx.android.synthetic.main.activity_producer.*

class ProducerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producer)

        id.text = Shared.selectedProducer!!.id
        name.setText(Shared.selectedProducer!!.name)
        address.setText(Shared.selectedProducer!!.address)
        phone.setText(Shared.selectedProducer!!.phone)
        email.setText(Shared.selectedProducer!!.email)

        val db = DatabaseHandler(this)

        edit_producer.setOnClickListener {
            if (name.isEnabled) {
                edit_producer.text = "Edit"
                db.editProducer(
                    Producer(
                        id.text.toString(),
                        name.text.toString(),
                        address.text.toString(),
                        phone.text.toString(),
                        email.text.toString()
                    )
                )
            } else {
                edit_producer.text = "Save changes"
            }

            name.isEnabled = !name.isEnabled
            address.isEnabled = name.isEnabled
            phone.isEnabled = name.isEnabled
            email.isEnabled = name.isEnabled
        }

        remove_producer.setOnClickListener {
            db.removeProducer(Shared.selectedProducer!!)
            finish()
        }
    }

}