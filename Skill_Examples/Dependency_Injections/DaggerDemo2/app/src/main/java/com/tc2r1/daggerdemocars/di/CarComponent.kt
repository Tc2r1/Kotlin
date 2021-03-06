package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.MainActivity
import com.tc2r1.daggerdemocars.objects.Car
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [PetrolEngineModule::class, WheelsModule::class])
interface CarComponent {

    fun getCar(): Car

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface MyBuilder {

        @BindsInstance
        fun providePowerCapacity(@Named("power") powerCapacity: Int): MyBuilder

        @BindsInstance
        fun provideEngineCapacity(@Named("engine") engineCapacity: Int): MyBuilder

        @BindsInstance
        fun providePassengerName(name: String): MyBuilder

        fun build(): CarComponent
    }
}