package com.renzo.remuzgo.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.renzo.remuzgo.poketinder.databinding.ActivityLoginBinding
import com.renzo.remuzgo.poketinder.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = LoginViewModel(this)

        loginViewModel.onCreate()

        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Ingrese los datos del usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldAuthenticateError.observe(this){
            Toast.makeText(this, "Error Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccesActivity.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun startLogin() {
        loginViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
}