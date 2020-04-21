package com.example.app3.di.module

import com.example.app3.AutomobilesApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
object ApiModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideAutomobilesApi(retrofit: Retrofit): AutomobilesApi {
        return retrofit.create(AutomobilesApi::class.java)
    }

}