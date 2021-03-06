package com.example.app3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        automobiles_button.setOnClickListener {
            automobiles_button.setBackgroundColor(Color.parseColor("#F1AAFF"));
            selected_automobiles_button.setBackgroundColor(Color.parseColor("#F1AA22"));
            messages_button.setBackgroundColor(Color.parseColor("#F1AA22"));

            val fragment = AutomobilesFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .commit()

        }

        selected_automobiles_button.setOnClickListener {
            automobiles_button.setBackgroundColor(Color.parseColor("#F1AA22"));
            selected_automobiles_button.setBackgroundColor(Color.parseColor("#F1AAFF"));
            messages_button.setBackgroundColor(Color.parseColor("#F1AA22"));

            val fragment = SelectedAutomobilesFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .commit()
        }

        messages_button.setOnClickListener {
            automobiles_button.setBackgroundColor(Color.parseColor("#F1AA22"));
            selected_automobiles_button.setBackgroundColor(Color.parseColor("#F1AA22"));
            messages_button.setBackgroundColor(Color.parseColor("#F1AAFF"));

            val fragment = MessagesFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .commit()
        }

    }
}
