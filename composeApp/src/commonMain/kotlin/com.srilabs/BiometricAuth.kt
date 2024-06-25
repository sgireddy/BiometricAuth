package com.srilabs

import androidx.compose.runtime.Composable


expect class BiometricAuth() {

    @Composable
    fun authenticate(onSuccess: () -> Unit, onError: (Exception) -> Unit)

}