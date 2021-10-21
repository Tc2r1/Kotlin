package com.tc2r1.daggerdemocars.objects.hood

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine @Inject constructor(@Named("power")var powerCapacity: Int, @Named("engine")var engineCapacity: Int) : Engine {

    override fun start() {
        Log.e("TAG", "PETROL ENGINE STARTED... powerCapacity: $powerCapacity, Engine Capacity: $engineCapacity", )
    }
}