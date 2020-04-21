package com.example.app3

import io.reactivex.Single
import retrofit2.http.GET

interface AutomobilesApi {

    @GET("automobiles")
    fun getAutomobiles(): Single<ArrayList<Automobile>>

}