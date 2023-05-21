package com.example.login_architecture_pattern

class MVPLoginPresenter(private val view: MVPLoginView) {
    private val userModel = UserModel("", "")

    fun onLoginClicked() {
        val username = view.getUsername()
        val password = view.getPassword()

        userModel.username = username
        userModel.password = password

        val isAuthenticated = userModel.authenticate()

        if (isAuthenticated) {
            view.showSuccessMessage()
        } else {
            view.showErrorMessage()
        }
    }
}