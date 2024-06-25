package com.srilabs

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.srilabs.MainActivity.Companion.appContext
import dev.icerock.moko.biometry.BiometryAuthenticator
import dev.icerock.moko.biometry.compose.BindBiometryAuthenticatorEffect
import dev.icerock.moko.biometry.compose.BiometryAuthenticatorFactory
import dev.icerock.moko.biometry.compose.rememberBiometryAuthenticatorFactory
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.desc.desc

actual class BiometricAuth actual constructor() {

    @Composable
    actual fun authenticate(onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        val biometryAuthenticator = BiometryAuthenticator(appContext)

        val viewModel: AndroidAuthViewModel = getViewModel(
            key = "biometry-screen",
            factory = viewModelFactory { AndroidAuthViewModel(biometryAuthenticator)
        })

        Column() {
            BindBiometryAuthenticatorEffect(viewModel.biometryAuthenticator)
            viewModel.tryToAuth(onSuccess, onError)
        }
    }
}


//actual class BiometricAuth {
//
//    @Composable
//    actual fun authenticate(
//        onSuccess: () -> Unit,
//        onError: (Exception) -> Unit
//    ) {
//        val biometryAuthenticatorFactory: BiometryAuthenticatorFactory = rememberBiometryAuthenticatorFactory()
//
//        val viewModel: AndroidAuthViewModel = getViewModel(
//            key = "biometry-screen",
//            factory = viewModelFactory { AndroidAuthViewModel(biometryAuthenticatorFactory.createBiometryAuthenticator())
//            })
//
//        Column() {
//            BindBiometryAuthenticatorEffect(viewModel.biometryAuthenticator)
//            viewModel.tryToAuth(onSuccess, onError)
//        }
//    }
//}
