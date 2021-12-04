package net.tc2r1.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import net.tc2r1.R
import net.tc2r1.data.UserPreferences
import net.tc2r1.data.network.RemoteDataSource
import net.tc2r1.data.network.UserApi
import net.tc2r1.data.repository.UserRepository
import net.tc2r1.ui.auth.AuthActivity
import net.tc2r1.ui.startNewActivity

class HomeActivity : AppCompatActivity() {

    lateinit var userPreferences: UserPreferences
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userPreferences = UserPreferences(this)
        val remoteDataSource = RemoteDataSource()
        val api = remoteDataSource.buildApi(UserApi::class.java, this)
        val authRepository = UserRepository(api)
        viewModel = HomeViewModel(authRepository)
    }

    fun performLogout() = lifecycleScope.launch {
        viewModel.logout()
        userPreferences.clear()
        startNewActivity(AuthActivity::class.java)
    }
}