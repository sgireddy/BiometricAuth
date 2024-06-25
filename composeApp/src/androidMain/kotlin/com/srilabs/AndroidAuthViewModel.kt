package com.srilabs

import dev.icerock.moko.biometry.BiometryAuthenticator
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.resources.desc.desc
import kotlinx.coroutines.launch

class AndroidAuthViewModel(val biometryAuthenticator: BiometryAuthenticator): ViewModel() {

    fun tryToAuth(onSuccess: () -> Unit, onError: (Exception) -> Unit) = viewModelScope.launch {

        val isSuccess = biometryAuthenticator.checkBiometryAuthentication(
            requestTitle = "Biometry".desc(),
            requestReason = "Invisible App needs your authentication".desc(),
            failureButtonText = "Oops".desc(),
            allowDeviceCredentials = true
        )
        if (isSuccess) {
            onSuccess()
        } else {
            onError(RuntimeException("An error occurred"))
        }
    }
}