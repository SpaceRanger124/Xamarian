package com.example.app3.di

import com.example.app3.ApplicationContext
import com.example.app3.di.module.ActivityModule
import com.example.app3.di.module.ApiModule
import com.example.app3.di.module.FragmentModule
import com.example.app3.di.module.NetworkModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ApiModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(spaceDiscoveryApp: ApplicationContext)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}