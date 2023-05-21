package com.example.login_architecture_pattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.login_architecture_pattern.databinding.ActivityMvvmloginBinding

class MVVMLoginActivity : AppCompatActivity() {

    private lateinit var databinding: ActivityMvvmloginBinding
    private lateinit var viewModel: MVVMLoginViewModel
    private lateinit var viewbinding: ActivityMvvmloginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmlogin)
        viewbinding = ActivityMvvmloginBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        viewModel = ViewModelProvider(this).get(MVVMLoginViewModel::class.java)
        databinding.viewModel = viewModel
        databinding.lifecycleOwner = this

    }
}