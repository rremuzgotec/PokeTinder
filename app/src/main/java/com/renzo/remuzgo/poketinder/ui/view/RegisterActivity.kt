package com.renzo.remuzgo.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.renzo.remuzgo.poketinder.databinding.ActivityRegisterBinding
import com.renzo.remuzgo.poketinder.ui.viewmodel.RegisterViewModel


class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnRegister.setOnClickListener {
            startRegistration()
        }
        binding.btnGoLogin.setOnClickListener {
            navigateLogin()
        }

        registerViewModel = RegisterViewModel(this)

        registerViewModel.onCreate()

        registerViewModel.registrationSuccess.observe(this){
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            navigateLogin()
        }

        registerViewModel.emptyFieldsError.observe(this){
            showEmptyFieldsAlert()
        }

        registerViewModel.invalidEmailError.observe(this){
            showInvalidEmail()
        }
    }

    fun startRegistration(){
        val userId = "1"
        val userName = binding.edtUserName.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()

        registerViewModel.registerUser(userId,userName,email,password)
    }

    fun navigateLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun showEmptyFieldsAlert(){
        Toast.makeText(this, "Ingrese los datos", Toast.LENGTH_SHORT).show()
    }

    fun showInvalidEmail(){
        Toast.makeText(this, "Ingresa un correo valido", Toast.LENGTH_SHORT).show()
    }
}