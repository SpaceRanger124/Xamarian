package com.example.app3

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class AutomobilesViewModel @Inject constructor(var api: AutomobilesApi): BasicViewModel() {

    val automobiles = MutableLiveData<ViewModelResult<ArrayList<Automobile>>>()

    fun fetchAutomobiles() {
        automobiles.value =
            ViewModelResult(
                arrayListOf(),
                loading = true,
                error = false
            )
        disposable.add(
            Single.just(
                Shared.automobiles
            )
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<ArrayList<Automobile>>() {
                    override fun onSuccess(receivedAutomobiles: ArrayList<Automobile>) {
                        Log.i("Automobiles ViewModel", "Automobiles have been received successfully")
                        automobiles.value =
                            ViewModelResult(
                                receivedAutomobiles,
                                loading = false,
                                error = false
                            )
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Automobiles ViewModel", "Automobiles receiving error", e)
                        automobiles.value =
                            ViewModelResult(
                                arrayListOf(),
                                loading = false,
                                error = true
                            )
                    }

                })
        )
    }
}