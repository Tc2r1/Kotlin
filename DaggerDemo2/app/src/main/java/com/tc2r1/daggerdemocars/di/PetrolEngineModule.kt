package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.objects.hood.Engine
import com.tc2r1.daggerdemocars.objects.hood.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {


    @Binds
    abstract fun providesPetrolEngine(petrolEngine: PetrolEngine) : Engine
}