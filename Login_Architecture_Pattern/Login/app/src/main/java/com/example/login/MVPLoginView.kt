package com.example.login

interface MVPLoginView {
    fun getUsername(): String
    fun getPassword(): String
    fun showSuccessMessage()
    fun showErrorMessage()
}