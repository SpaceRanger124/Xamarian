package com.example.app4

import com.example.app4.automobiles.Automobile
import com.example.app4.producers.Producer
import com.example.app4.sales.Sale

class Shared {
    companion object {
        var selectedAutomobile: Automobile? = null
        var selectedProducer: Producer? = null
        var selectedSale: Sale? = null
    }
}