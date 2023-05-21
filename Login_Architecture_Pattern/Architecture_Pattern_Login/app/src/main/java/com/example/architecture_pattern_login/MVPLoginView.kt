package com.example.architecture_pattern_login

interface MVPLoginView {
    fun getUsername(): String
    fun getPassword(): String
    fun showSuccessMessage()
    fun showErrorMessage()
}