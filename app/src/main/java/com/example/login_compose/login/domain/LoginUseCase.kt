package com.example.login_compose.login.domain

import com.example.login_compose.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}