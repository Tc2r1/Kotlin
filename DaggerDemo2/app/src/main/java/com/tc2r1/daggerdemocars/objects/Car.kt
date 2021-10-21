package com.tc2r1.daggerdemocars.objects

import android.util.Log
import com.tc2r1.daggerdemocars.objects.hood.Engine
import com.tc2r1.daggerdemocars.objects.mobility.Wheels
import com.tc2r1.daggerdemocars.objects.people.Driver
import com.tc2r1.daggerdemocars.objects.people.Passenger
import javax.inject.Inject

class Car @Inject constructor(var wheels: Wheels,var driver: Driver,var passenger: Passenger?) {

    @Inject
    lateinit var engine: Engine

    @Inject
    fun provideCarToRemote(remote: Remote) {
        remote.provideCar(this)
    }

    fun start() {
        engine.start()
        if(passenger == null) {
            println("Driver: $driver starts the engine! There are no passengers")
        } else {
            println("Driver: $driver starts the engine! ${passenger?.name} is the passenger!")
        }
    }



    companion object {
        private const val TAG = "Car"
    }
}