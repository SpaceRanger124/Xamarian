package com.example.app4.automobiles

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.DatabaseHandler
import com.example.app4.R
import kotlinx.android.synthetic.main.activity_add_automobile.*

class AddAutomobileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_automobile)

        val db = DatabaseHandler(this)

        val automobiles = db.getAllAutomobiles()
        val producers = db.getAllProducers()

        id.text = (automobiles.map { it.id }.last().toInt() + 1).toString()

        submit_automobile.setOnClickListener {
            if (producers.none { it.id == producer_id.text.toString() }) {
                Toast.makeText(this, "There is no such producer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            db.addAutomobile(
                Automobile(
                    id.text.toString(),
                    name.text.toString(),
                    producer_id.text.toString(),
                    price.text.toString().toInt(),
                    year.text.toString().toInt()
                )
            )
            finish()
        }

        cancel_automobile.setOnClickListener {
            finish()
        }

    }

}