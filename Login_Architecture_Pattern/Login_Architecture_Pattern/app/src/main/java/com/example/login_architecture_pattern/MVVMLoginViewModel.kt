package com.example.login_architecture_pattern

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMLoginViewModel : ViewModel() {
    private val userModel = UserModel("", "")
    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun onLoginClicked() {

        val enteredUsername = username.value
        val enteredPassword = password.value

        userModel.username = enteredUsername!!
        userModel.password = enteredPassword!!

        val isAuthenticated = userModel.authenticate()

        if (isAuthenticated) {
        }
    }
}