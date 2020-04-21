package com.example.app4.automobiles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.DatabaseHandler
import com.example.app4.R
import com.example.app4.Shared
import kotlinx.android.synthetic.main.activity_automobile.*

class AutomobileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_automobile)

        id.text = Shared.selectedAutomobile!!.id
        name.setText(Shared.selectedAutomobile!!.name)
        producer_id.setText(Shared.selectedAutomobile!!.producerId)
        price.setText(Shared.selectedAutomobile!!.price.toString())
        year.setText(Shared.selectedAutomobile!!.year.toString())

        val db = DatabaseHandler(this)

        edit_automobile.setOnClickListener {
            if (name.isEnabled) {
                edit_automobile.text = "Edit"
                db.editAutomobile(
                    Automobile(
                        id.text.toString(),
                        name.text.toString(),
                        producer_id.text.toString(),
                        price.text.toString().toInt(),
                        year.text.toString().toInt()
                    )
                )
            } else {
                edit_automobile.text = "Save changes"
            }

            name.isEnabled = !name.isEnabled
            producer_id.isEnabled = name.isEnabled
            price.isEnabled = name.isEnabled
            year.isEnabled = name.isEnabled
        }

        remove_automobile.setOnClickListener {
            db.removeAutomobile(Shared.selectedAutomobile!!)
            finish()
        }
    }

}