package com.tc2r1.daggerdemocars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tc2r1.daggerdemocars.di.DaggerCarComponent
import com.tc2r1.daggerdemocars.objects.Car
import com.tc2r1.daggerdemocars.objects.people.Passenger
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car
    @Inject
    lateinit var car1: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var carComponent = (application as MyApplication).carComponent()
        carComponent.inject(this)
        car.passenger = Passenger("Jill")
        car.start()
        car1.start()
    }
}