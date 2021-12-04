package net.tc2r1.ui.auth

import net.tc2r1.data.repository.AuthRepository

class AuthViewModelFactory(
    private val authRepository: AuthRepository
) : Factory<AuthViewModel> {
    override fun create(): AuthViewModel {
        return AuthViewModel(authRepository)
    }
}