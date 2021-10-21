package com.tc2r1.daggerdemocars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tc2r1.daggerdemocars.di.DaggerCarComponent
import com.tc2r1.daggerdemocars.objects.Car
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var carComponent = DaggerCarComponent.builder()
            .providePowerCapacity(100)
            .provideEngineCapacity(33)
            .build()
        carComponent.inject(this)

        car.start()
    }
}