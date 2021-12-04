package com.tc2r1.daggerdemocars

import android.app.Application
import com.tc2r1.daggerdemocars.di.CarComponent
import com.tc2r1.daggerdemocars.di.DaggerCarComponent

class MyApplication : Application() {
    private lateinit var carComponent : CarComponent

    override fun onCreate() {
        super.onCreate()
        carComponent = DaggerCarComponent.builder()
            .providePowerCapacity(100)
            .provideEngineCapacity(343)
            .build()
    }

    fun carComponent() : CarComponent {
        return carComponent
    }
}