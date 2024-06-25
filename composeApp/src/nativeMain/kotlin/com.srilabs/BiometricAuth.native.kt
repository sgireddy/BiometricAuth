package com.srilabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.icerock.moko.biometry.BiometryAuthenticator

actual class BiometricAuth actual constructor() {

    @Composable
    actual fun authenticate(onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        val biometryAuthenticator = BiometryAuthenticator()

        val viewModel: IOSAuthViewModel = remember { IOSAuthViewModel(biometryAuthenticator) }

        viewModel.tryToAuth(onSuccess, onError)
    }
}