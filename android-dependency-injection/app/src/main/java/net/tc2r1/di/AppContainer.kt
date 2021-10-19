package net.tc2r1.di

import android.content.Context
import net.tc2r1.data.UserPreferences
import net.tc2r1.data.network.AuthApi
import net.tc2r1.data.network.RemoteDataSource
import net.tc2r1.data.repository.AuthRepository

public class AppContainer(context: Context) {
    private val remoteDataSource = RemoteDataSource()
    private val api = remoteDataSource.buildApi(AuthApi::class.java, context)
    private val preferences = UserPreferences(context)
    val authRepository = AuthRepository(api, preferences)
    var authContainer: AuthContainer? = null
}