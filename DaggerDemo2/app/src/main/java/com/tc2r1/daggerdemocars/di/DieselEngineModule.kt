package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.objects.DieselEngine
import com.tc2r1.daggerdemocars.objects.Engine
import com.tc2r1.daggerdemocars.objects.PetrolEngine
import dagger.Module
import dagger.Provides

@Module
class DieselEngineModule {

    @Provides
    fun providesDieselEngine(dieselEngine: DieselEngine) : Engine {
        return dieselEngine

    }
}