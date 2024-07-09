package com.example.loginCompose.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginCompose.login.domain.LoginUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    var email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    var password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    var isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading


    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = isLoginEnable(email, password)

    }

    private fun isLoginEnable(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                //Navegar a otra pantalla
                Log.i("logiResult", "OK")
            } else {
                Log.i("LoginResult", "Fail")
            }
            delay(2000)
            _isLoading.value = false
        }
    }

}