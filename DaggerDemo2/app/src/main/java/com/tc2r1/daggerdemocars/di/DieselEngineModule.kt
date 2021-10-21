package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.objects.hood.DieselEngine
import com.tc2r1.daggerdemocars.objects.hood.Engine
import dagger.Module
import dagger.Provides

@Module
class DieselEngineModule {

    @Provides
    fun providesDieselEngine(dieselEngine: DieselEngine) : Engine {
        return dieselEngine

    }
}