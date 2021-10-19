package net.tc2r1.di

import net.tc2r1.data.repository.AuthRepository
import net.tc2r1.ui.auth.AuthViewModelFactory

class AuthContainer(
    authRepository: AuthRepository
) {
    val authViewModelFactory = AuthViewModelFactory(authRepository)
}