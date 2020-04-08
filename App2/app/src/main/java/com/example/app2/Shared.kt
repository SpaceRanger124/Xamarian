package com.example.app2

class Shared {

    companion object {

        var automobiles = arrayListOf(
            Automobile("Johnson", "Volvo", android.R.drawable.ic_dialog_email, false),
            Automobile("Davis", "Ferrari", android.R.drawable.ic_dialog_dialer, false),
            Automobile("Mason", "Audi", android.R.drawable.ic_dialog_info, false),
            Automobile("Clifford", "Renault", android.R.drawable.ic_dialog_map, false)
        )

        var messages = ""

        fun getSelectedAutomobiles(): List<SelectedAutomobile> {
            return automobiles.groupBy { it.producer }
                .map {
                    SelectedAutomobile(
                        it.key,
                        it.value.map {
                            it.name
                        }.reduce { acc, s ->  acc + "\n" + s }
                    )
                }
        }

    }

}