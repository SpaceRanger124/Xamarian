package com.example.app4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_request.*
import java.lang.Exception

class RequestActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)

        val db = DatabaseHandler(this@RequestActivity)
        val automobiles = db.getAllAutomobiles()
        val producers = db.getAllProducers()
        val sales = db.getAllSales()

        val requestName = intent.getStringExtra("request_name")
        when (requestName) {
            "request auto by producer" -> {
                request_label.text = "Request auto by producer:"
                param_label.text = "(enter the producer name)"
                submit_request.setOnClickListener {
                    val producer = producers.find { it.name == param.text.toString() }
                    if (producer == null) {
                        request_result.text = "could not find"
                    } else {
                        val selectedAutomobiles = automobiles.filter { it.producerId == producer.id }
                        request_result.text = "Results:"
                        selectedAutomobiles.forEach {
                            request_result.text = request_result.text.toString() + "\n" + it.name
                        }
                    }
                }
            }
            "request auto with price less" -> {
                request_label.text = "Request auto with price less ..."
                param_label.text = "(enter the price)"
                submit_request.setOnClickListener {
                    try {
                        val selectedAutomobiles = automobiles.filter { it.price < param.text.toString().toInt() }
                        request_result.text = "Results:"
                        selectedAutomobiles.forEach {
                            request_result.text = request_result.text.toString() + "\n" + it.name
                        }
                    } catch (e: Exception) {
                        request_result.text = "could not find"
                    }
                }
            }
            "request auto sold in year" -> {
                request_label.text = "Request auto sold in year ..."
                param_label.text = "(enter the year)"
                submit_request.setOnClickListener {
                    val selectedSales = sales.filter { it.date == param.toString() }
                    var totalPrice = 0
                    request_result.text = "Results:"
                    selectedSales.forEach {
                        val automobile = automobiles.find { it1 -> it1.id == it.productId }
                        if (automobile != null) {
                            request_result.text = request_result.text.toString() + "\n" + automobile.name + " (" + it.quantity + ")"
                            totalPrice += automobile.price
                        }
                    }
                    request_result.text = request_result.text.toString() + "\n" + "total price: " + totalPrice
                }
            }
            "request producers with auto more" -> {
                request_label.text = "Request producers with more auto than ..."
                param_label.text = "(enter the auto number)"
                submit_request.setOnClickListener {

                    try {
                        val selectedProducers = producers.filter {
                            val selectedAutomobiles = automobiles.filter { auto -> auto.producerId == it.id }
                            selectedAutomobiles.size > param.text.toString().toInt()
                        }
                        request_result.text = "Results:"
                        selectedProducers.forEach {
                            request_result.text = request_result.text.toString() + "\n" + it.name
                        }
                    } catch (e: Exception) {
                        request_result.text = "Invalid param"
                    }


                }
            }
            else -> {
                request_label.text = "Request unsold auto:"
                param_label.text = "(no need any parameters)"
                submit_request.setOnClickListener {
                    val selectedAutomobiles = automobiles.filter {
                        sales.none { sale -> sale.productId == it.id }
                    }
                    if (selectedAutomobiles.isEmpty()) {
                        request_result.text = "No unsold auto"
                        return@setOnClickListener
                    }
                    request_result.text = "Results:"
                    selectedAutomobiles.forEach {
                        request_result.text = request_result.text.toString() + "\n" + it.name
                    }
                }
            }
        }
    }

}