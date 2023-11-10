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
            startRegister()
        }

        registerViewModel = RegisterViewModel(this)

        registerViewModel.onCreate()

        registerViewModel.emptyFieldsError.observe(this) {
            Toast.makeText(this, "Ingrese datos del nuevo usuario", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.fieldsAuthenticateError.observe(this) {
            Toast.makeText(this, "Error de autenticación", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.goSuccessActivity.observe(this) {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun startRegister() {
        registerViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
}