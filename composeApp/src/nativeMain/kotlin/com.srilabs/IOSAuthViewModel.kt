package com.srilabs

// iosMain
import dev.icerock.moko.biometry.BiometryAuthenticator
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class IOSAuthViewModel(private val biometryAuthenticator: BiometryAuthenticator) {

    private val mainScope = MainScope()

    fun tryToAuth(onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        mainScope.launch {
            try {
                val isSuccess = biometryAuthenticator.checkBiometryAuthentication(
                    requestTitle = "Biometry",
                    requestReason = "Invisible App needs your authentication",
                    failureButtonText = "Oops",
                    allowDeviceCredentials = true
                )
                if (isSuccess) {
                    onSuccess()
                } else {
                    onError(RuntimeException("An error occurred"))
                }
            } catch (e: NSError) {
                onError(Exception(e.localizedDescription))
            }
        }
    }
}
