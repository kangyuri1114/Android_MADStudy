package com.example.login_architecture_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login_architecture_pattern.databinding.ActivityMvcloginBinding

class MVCLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvcloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userModel = UserModel("", "")

        binding.loginButton.setOnClickListener {
            binding.usernameEditText.text.toString()
            binding.passwordEditText.text.toString()

        }
        val isAuthenticated = userModel.authenticate()
        if (isAuthenticated) {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()

    }
}