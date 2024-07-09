package com.example.loginCompose.login.domain

import com.example.loginCompose.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}