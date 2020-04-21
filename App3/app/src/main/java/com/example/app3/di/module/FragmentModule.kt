package com.example.app3.di.module

import com.example.app3.AutomobilesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeAutomobilesFragment(): AutomobilesFragment

}