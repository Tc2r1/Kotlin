package com.tc2r1.daggerdemocars.objects

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor() : Engine {
    override fun start() {
        Log.e("TAG", "Diesel ENGINE STARTED...", )
    }
}