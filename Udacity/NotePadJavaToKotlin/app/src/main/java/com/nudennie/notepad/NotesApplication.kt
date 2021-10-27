package com.nudennie.notepad

import android.app.Application
import com.nudennie.notepad.data.DataStore.init

class NotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        init(this)
    }
}