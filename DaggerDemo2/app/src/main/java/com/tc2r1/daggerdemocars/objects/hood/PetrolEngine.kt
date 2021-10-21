package com.tc2r1.daggerdemocars.objects

import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor() : Engine {
    override fun start() {
        Log.e("TAG", "PETROL ENGINE STARTED...", )
    }
}