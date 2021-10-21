package com.tc2r1.daggerdemocars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tc2r1.daggerdemocars.di.DaggerCarComponent
import com.tc2r1.daggerdemocars.objects.Car
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var carComponent = DaggerCarComponent.create()
        carComponent.inject(this)

        car.start()
    }
}