package net.tc2r1

import android.app.Application
import net.tc2r1.di.AppContainer

class MyApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)

    }
}


