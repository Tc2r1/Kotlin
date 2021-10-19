package net.tc2r1.ui.auth

interface Factory<T> {
    fun create() : T
}