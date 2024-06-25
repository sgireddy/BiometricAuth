package com.srilabs

import dev.icerock.moko.biometry.BiometryAuthenticator
import dev.icerock.moko.resources.desc.desc
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class IOSAuthViewModel(private val biometryAuthenticator: BiometryAuthenticator) {

    private val mainScope = MainScope()

    fun tryToAuth(onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        mainScope.launch {
            try {
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
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}
