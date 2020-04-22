package com.example.app3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app3.di.Injectable
import kotlinx.android.synthetic.main.fragment_automobiles.*
import javax.inject.Inject

class AutomobilesFragment: Fragment(), Injectable {

    var automobilesAdapter: AutomobilesAdapter? = null

    @Inject
    lateinit var viewModel: AutomobilesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_automobiles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        automobilesAdapter = AutomobilesAdapter(arrayListOf())
        automobiles_list.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = automobilesAdapter
        }
        remove_selected_button.setOnClickListener {
            Shared.automobiles = Shared.automobiles.filter { automobile -> !automobile.isSelected } as ArrayList<Automobile>
            viewModel.fetchAutomobiles()
            observeAutomobiles()
        }
        add_new_button.setOnClickListener {
            val intent = Intent(it.context, AddAutomobileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeAutomobiles() {
        viewModel.automobiles.removeObservers(this)
        viewModel.automobiles.observe(this, Observer { automobiles ->
            when {
                automobiles.loading -> {
                    Toast.makeText(this.context, "automobiles are being loaded", Toast.LENGTH_SHORT).show()
                }
                automobiles.error -> {
                    Toast.makeText(this.context, "could not load automobiles", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    automobilesAdapter!!.updateAutomobiles(automobiles.data)
                    Toast.makeText(this.context, "automobiles has been loaded", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchAutomobiles()
        observeAutomobiles()

    }

}