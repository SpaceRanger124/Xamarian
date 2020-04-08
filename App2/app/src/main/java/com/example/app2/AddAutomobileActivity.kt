package com.example.app2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_automobile.*

class AddAutomobileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_automobile)

        submit.setOnClickListener {
            Shared.automobiles.add(
                Automobile(producer.text.toString(), name.text.toString(), android.R.drawable.ic_dialog_map, false)
            )
            this.onBackPressed()
        }

        cancel.setOnClickListener {
            this.onBackPressed()
        }
    }

}