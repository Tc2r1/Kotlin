package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.objects.hood.Engine
import com.tc2r1.daggerdemocars.objects.hood.PetrolEngine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule(val powerCapacity : Int) {


    @Provides
    fun providesPetrolEngine() : Engine {

        return PetrolEngine(powerCapacity)
    }
}