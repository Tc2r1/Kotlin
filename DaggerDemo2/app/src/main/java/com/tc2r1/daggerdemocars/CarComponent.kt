package com.tc2r1.daggerdemocars

import dagger.Component

@Component
interface CarComponent {

    fun getCar(): Car
}