package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.objects.Engine
import com.tc2r1.daggerdemocars.objects.PetrolEngine
import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule {

    @Provides
    fun providesPetrolEngine(petrolEngine: PetrolEngine) : Engine {
        return petrolEngine

    }
}