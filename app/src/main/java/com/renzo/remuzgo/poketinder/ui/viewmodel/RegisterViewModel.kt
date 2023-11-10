package com.renzo.remuzgo.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renzo.remuzgo.poketinder.data.model.User
import com.renzo.remuzgo.poketinder.util.SharedPreferenceUtil
import java.util.regex.Pattern


class RegisterViewModel(private val context: Context) : ViewModel() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsAuthenticateError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            emptyFieldsError.postValue(true)
        } else {
            val user: User? = sharedPreferenceUtil.getUser()
            if (user != null && email == user.email && password == user.password) {
                goSuccessActivity.postValue(true)
            } else {
                fieldsAuthenticateError.postValue(true)
            }
        }
    }
}