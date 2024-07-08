package com.example.login_compose.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_compose.login.login.BodyLogin
import com.example.login_compose.login.login.FooterLogin
import com.example.login_compose.login.login.HeaderLogin


@Composable
fun Login(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        HeaderLogin(Modifier.align(Alignment.TopEnd))
        BodyLogin(Modifier.align(Alignment.Center), loginViewModel)
        FooterLogin(Modifier.align(Alignment.BottomCenter))
    }

}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {

}