package com.example.app3

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_automobile.*

class EditAutomobileActivity: AppCompatActivity() {

    var isPhoneValid = true
    var isEmailValid = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_automobile)

        submit.isEnabled = true

        phone_number.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                submit.isEnabled = false
                isPhoneValid = Regex("^[0-9]{9,15}$").matches(s as CharSequence)
                if (isPhoneValid) {
                    phone_number.setBackgroundColor(resources.getColor(android.R.color.white,
                        Resources.getSystem().newTheme()
                    ))
                    if (isEmailValid) {
                        submit.isEnabled = true
                    }
                } else {
                    phone_number.setBackgroundColor(resources.getColor(android.R.color.holo_red_light,
                        Resources.getSystem().newTheme()
                    ))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        email.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                submit.isEnabled = false
                isEmailValid = Regex("\\S+@\\S+\\.\\S+").matches(s!!)
                if (isEmailValid) {
                    email.setBackgroundColor(resources.getColor(android.R.color.white,
                        Resources.getSystem().newTheme()
                    ))
                    if (isPhoneValid) {
                        submit.isEnabled = true
                    }
                } else {
                    email.setBackgroundColor(resources.getColor(android.R.color.holo_red_light,
                        Resources.getSystem().newTheme()
                    ))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        producer.setText(intent.getStringExtra("producer"))
        name.setText(intent.getStringExtra("name"))
        phone_number.setText(intent.getStringExtra("phone_number"))
        email.setText(intent.getStringExtra("email"))

        submit.setOnClickListener {
            val index = intent.getIntExtra("index", 0)
            Shared.automobiles[index].producer =  producer.text.toString()
            Shared.automobiles[index].name =  name.text.toString()
            Shared.automobiles[index].phoneNumber =  phone_number.text.toString()
            Shared.automobiles[index].email =  email.text.toString()

            this.onBackPressed()
        }

        cancel.setOnClickListener {
            this.onBackPressed()
        }
    }

}