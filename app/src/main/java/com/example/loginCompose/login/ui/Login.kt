package com.example.loginCompose.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginCompose.login.ui.components.BodyLogin
import com.example.loginCompose.login.ui.components.FooterLogin
import com.example.loginCompose.login.ui.components.HeaderLogin


@Composable
fun Login(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)
        if (isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        } else {
            HeaderLogin(Modifier.align(Alignment.TopEnd))
            BodyLogin(Modifier.align(Alignment.Center), loginViewModel)
            FooterLogin(Modifier.align(Alignment.BottomCenter))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {

}