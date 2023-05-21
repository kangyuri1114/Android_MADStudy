package com.example.architecture_pattern_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.architecture_pattern_login.databinding.ActivityMvploginBinding

class MVPLoginActivity : AppCompatActivity(), MVPLoginView {
    private lateinit var binding: ActivityMvploginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMvploginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val presenter = MVPLoginPresenter(this)

        binding.loginButton.setOnClickListener {
            presenter.onLoginClicked()
        }
    }

    override fun getUsername(): String {
        return binding.usernameEditText.text.toString()
    }

    override fun getPassword(): String {
        return binding.passwordEditText.text.toString()
    }

    override fun showSuccessMessage() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessage() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
    }
}