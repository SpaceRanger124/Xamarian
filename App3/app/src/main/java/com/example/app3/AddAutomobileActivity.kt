package com.example.app3

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_automobile.*

class AddAutomobileActivity: AppCompatActivity() {

    var isPhoneValid = false
    var isEmailValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_automobile)

        submit.isEnabled = false

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

        submit.setOnClickListener {
            Shared.automobiles.add(
                Automobile(
                    producer.text.toString(),
                    name.text.toString(),
                    android.R.drawable.ic_dialog_map,
                    false,
                    phone_number.text.toString(),
                    email.text.toString()
                )
            )
            this.onBackPressed()
        }

        cancel.setOnClickListener {
            this.onBackPressed()
        }
    }

}