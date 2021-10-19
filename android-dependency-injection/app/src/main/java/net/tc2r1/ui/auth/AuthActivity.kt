package net.tc2r1.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.tc2r1.MyApplication
import net.tc2r1.R
import net.tc2r1.di.AppContainer
import net.tc2r1.di.AuthContainer

class AuthActivity : AppCompatActivity() {

    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (application as MyApplication).appContainer
        appContainer.authContainer = AuthContainer(appContainer.authRepository)
        setContentView(R.layout.activity_auth)
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.authContainer = null
    }
}