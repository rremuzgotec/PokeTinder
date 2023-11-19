package com.renzo.remuzgo.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renzo.remuzgo.poketinder.data.model.User
import com.renzo.remuzgo.poketinder.util.SharedPreferenceUtil
import java.util.regex.Pattern


class RegisterViewModel(private val context: Context): ViewModel() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    val registrationSuccess = MutableLiveData<Boolean>()
    val emptyFieldsError = MutableLiveData<Boolean>()
    val invalidEmailError = MutableLiveData<Boolean>()

    fun onCreate(){
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun registerUser(userId: String, userName: String, email: String, password: String) {
        if (userName.isEmpty() || email.isEmpty() || password.isEmpty()){
            emptyFieldsError.postValue(true)
            return
        }
        if (!isEmailValid(email)){
            invalidEmailError.postValue(true)
            return
        }
        val user = User(userId,userName,email,password)
        sharedPreferenceUtil.saveUser(user)
        registrationSuccess.postValue(true)
    }

    private fun isEmailValid(email: String): Boolean{
        val pattern = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"+
                    "([a-zA-Z]{1}|[\\w-]{2,})(\\.[a-zA-Z]{2,})+$"
        )
        return pattern.matcher(email).matches()
    }
}