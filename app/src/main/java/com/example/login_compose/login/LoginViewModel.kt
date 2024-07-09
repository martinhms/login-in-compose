package com.example.login_compose.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    var email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    var password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    var isLoginEnable: LiveData<Boolean> = _isLoginEnable


    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = isLoginEnable(email, password)

    }

    private fun isLoginEnable(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

}