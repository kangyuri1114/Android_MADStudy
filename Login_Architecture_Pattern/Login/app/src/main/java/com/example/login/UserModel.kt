package com.example.login

class UserModel (var username: String, var password: String) {
    fun authenticate():Boolean {
        val validUsername = "yuri"
        val validPassword = "password"

        return username == validUsername && password == validPassword
    }
}