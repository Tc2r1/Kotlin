package com.tc2r1.daggerdemocars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tc2r1.daggerdemocars.di.DaggerCarComponent
import com.tc2r1.daggerdemocars.di.PetrolEngineModule
import com.tc2r1.daggerdemocars.objects.Car
import javax.inject.Inject
import kotlin.random.Random


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