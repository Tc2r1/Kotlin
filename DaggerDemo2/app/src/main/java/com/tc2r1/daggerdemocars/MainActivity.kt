package com.tc2r1.daggerdemocars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var car: Car


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var wheels = Wheels()
        var engine = Engine()
        car = Car(wheels, engine)

        car.start()
    }
}