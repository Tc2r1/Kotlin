package com.tc2r1.daggerdemocars.objects

import javax.inject.Inject

class Remote @Inject constructor() {

    lateinit var car: Car

    fun provideCar(car: Car) {
        println("Providing Car to remote")
        this.car = car
    }
}