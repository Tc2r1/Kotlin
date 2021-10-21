package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.MainActivity
import com.tc2r1.daggerdemocars.objects.Car
import dagger.Component

@Component(modules = [PetrolEngineModule::class, WheelsModule::class])
interface CarComponent {

    fun getCar(): Car

    fun inject(mainActivity: MainActivity)
}