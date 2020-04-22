package com.example.app3

class Shared {

    companion object {

        var automobiles = arrayListOf(
            Automobile("Johnson", "Volvo", android.R.drawable.ic_dialog_email, false, "375334477289", "asd@a.ru"),
            Automobile("Davis", "Ferrari", android.R.drawable.ic_dialog_dialer, false, "375334477289", "asd@a.ru"),
            Automobile("Mason", "Audi", android.R.drawable.ic_dialog_info, false, "375334477289", "asd@a.ru"),
            Automobile("Clifford", "Renault", android.R.drawable.ic_dialog_map, false, "375334477289", "asd@a.ru")
        )

        var messages = ""

        fun getSelectedAutomobiles(): ArrayList<SelectedAutomobile> {
            return ArrayList(automobiles.groupBy { it.producer }
                .map {
                    SelectedAutomobile(
                        it.key,
                        it.value.map {
                            it.name
                        }.reduce { acc, s ->  acc + "\n" + s }
                    )
                })
        }

    }

}