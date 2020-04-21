package com.example.app4

import com.example.app4.automobiles.Automobile
import com.example.app4.producers.Producer
import com.example.app4.sales.Sale

interface IDatabaseHandler {

    fun getAllAutomobiles(): ArrayList<Automobile>
    fun addAutomobile(automobile: Automobile)
    fun editAutomobile(automobile: Automobile)
    fun removeAutomobile(automobile: Automobile)

    fun getAllProducers(): ArrayList<Producer>
    fun addProducer(producer: Producer)
    fun editProducer(producer: Producer)
    fun removeProducer(producer: Producer)

    fun getAllSales(): ArrayList<Sale>
    fun addSale(sale: Sale)
    fun editSale(sale: Sale)
    fun removeSale(sale: Sale)

}