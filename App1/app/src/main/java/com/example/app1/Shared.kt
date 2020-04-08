package com.example.app1

class Shared {

    companion object {

        var selectedAutomobile: Automobile? = null

        var automobiles = arrayListOf(
            Automobile("Johnson", "Volvo", "100"),
            Automobile("Davis", "Ferrari", "200"),
            Automobile("Mason", "Audi", "50"),
            Automobile("Clifford", "Renault", "600")
        )

    }

}