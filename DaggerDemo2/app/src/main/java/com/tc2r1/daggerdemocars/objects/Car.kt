package com.tc2r1.daggerdemocars.objects

import android.util.Log
import com.tc2r1.daggerdemocars.objects.hood.Engine
import com.tc2r1.daggerdemocars.objects.mobility.Wheels
import javax.inject.Inject

class Car @Inject constructor(var wheels: Wheels, driver: Driver) {

    @Inject
    lateinit var engine: Engine

    @Inject
    fun provideCarToRemote(remote: Remote) {
        remote.provideCar(this)
    }

    fun start() {
        engine.start()
        println("driving...")
        Log.wtf("Tc2r1", "start: DRIVING...")

    }

    companion object {
        private const val TAG = "Car"
    }
}