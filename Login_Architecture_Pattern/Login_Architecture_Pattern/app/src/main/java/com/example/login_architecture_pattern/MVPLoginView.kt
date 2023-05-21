package com.example.login_architecture_pattern

interface MVPLoginView {
    fun getUsername(): String
    fun getPassword(): String
    fun showSuccessMessage()
    fun showErrorMessage()
}