package com.srilabs

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(): ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error.asStateFlow()

//    fun authenticate() {
//        viewModelScope.launch {
//            val auth = BiometricAuth()
//            auth.authenticate(
//                onSuccess = {
//                    _isLoggedIn.value = true
//                },
//                onError = { err ->
//                    _error.value = err.message.toString()
//                }
//            )
//        }
//    }

}