package com.tc2r1.daggerdemocars.objects

import android.util.Log
import com.tc2r1.daggerdemocars.objects.hood.Engine
import com.tc2r1.daggerdemocars.objects.mobility.Wheels
import javax.inject.Inject

class Car {
    lateinit var wheels: Wheels

    @Inject
    lateinit var engine: Engine

    @Inject
    constructor(wheels: Wheels) {
        this.wheels = wheels
    }

    @Inject
    fun provideCarToRemote(remote: Remote){
        remote.provideCar(this)
    }

    fun start(){
        engine.start()
        println("driving...")
        Log.wtf("Tc2r1", "start: DRIVING...", )

    }

    companion object {
        private const val TAG = "Car"
    }
}