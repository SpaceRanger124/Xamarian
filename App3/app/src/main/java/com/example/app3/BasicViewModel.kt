package com.example.app3

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BasicViewModel: ViewModel() {

    val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}