package com.tc2r1.daggerdemocars.objects

import android.util.Log
import com.tc2r1.daggerdemocars.objects.hood.Engine
import com.tc2r1.daggerdemocars.objects.mobility.Wheels
import javax.inject.Inject

class Car {
    lateinit var wheels: Wheels
    lateinit var engine: Engine

    @Inject
    constructor(wheels: Wheels, engine: Engine) {
        this.wheels = wheels
        this.engine = engine
    }

    fun start(){
        engine.start()
        println("driving...")
        Log.wtf("Tc2r1", "start: DRIVING...", )

    }
}