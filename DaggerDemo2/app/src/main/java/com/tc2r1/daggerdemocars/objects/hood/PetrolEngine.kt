package com.tc2r1.daggerdemocars.objects.hood

import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor(var powerCapacity: Int) : Engine {

    override fun start() {
        Log.e("TAG", "PETROL ENGINE STARTED... powerCapacity: $powerCapacity", )
    }
}