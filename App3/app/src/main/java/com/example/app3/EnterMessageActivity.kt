package com.example.app3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enter_message.*

class EnterMessageActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_message)

        back_button.setOnClickListener {
            if (message.text.isNotEmpty()) {
                Shared.messages += "\n" + message.text
            }
            onBackPressed()
        }
    }

}