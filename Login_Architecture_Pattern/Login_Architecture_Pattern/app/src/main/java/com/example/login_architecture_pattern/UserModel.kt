package com.example.login_architecture_pattern

class UserModel (var username: String, var password: String) {
    fun authenticate():Boolean {
        val validUsername = "yuri"
        val validPassword = "password"

        return username == validUsername && password == validPassword
    }
}