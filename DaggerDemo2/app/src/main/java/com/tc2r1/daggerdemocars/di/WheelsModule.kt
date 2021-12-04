package com.tc2r1.daggerdemocars.di

import com.tc2r1.daggerdemocars.objects.mobility.Rims
import com.tc2r1.daggerdemocars.objects.mobility.Tires
import com.tc2r1.daggerdemocars.objects.mobility.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    @Provides
    fun providesTires(): Tires {
        println("Tires Created")
        return Tires()
    }

    @Provides
    fun providesRims(): Rims {
        println("Rims Created")
        return Rims()
    }

    @Provides
    fun providesWheels(rims: Rims, tires: Tires): Wheels {
        println("Wheels Created")
        return Wheels(rims, tires)
    }
}