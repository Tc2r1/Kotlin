package com.tc2r1.daggerdemocars.objects.hood

import android.util.Log

interface Engine {
    fun start() {
        Log.d(Companion.TAG, "start: Engine Started")
    }

    companion object {
        private const val TAG = "Engine"
    }


}