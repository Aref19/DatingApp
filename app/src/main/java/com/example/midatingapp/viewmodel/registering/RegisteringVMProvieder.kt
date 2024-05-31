package com.example.midatingapp.viewmodel.registering

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisteringViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user
    private val _confirm = MutableLiveData<Boolean>()
    val confirmPassword: LiveData<Boolean> = _confirm
    var currentUser = _user.value ?: User("", "", "", "")
    fun setUser(
        name: String = "",
        email: String = "",
        password: String = "",
        conforimedPassword: String=""
    ) {
        if (name != "") {
            currentUser = currentUser.copy(name = name)

        } else if (email != "") {
            currentUser = currentUser.copy(email = email)
        } else if (password != "") {

                currentUser = currentUser.copy(password = password)

        } else if (conforimedPassword != "") {
                currentUser = currentUser.copy(conforimedPassword = conforimedPassword)

        }
        _user.value = currentUser

    }

    private fun confirmPassword(password: String, secoundPassword: String) {
        _confirm.value = password == secoundPassword
    }


}

data class User(
    var name: String,
    var email: String,
    var password: String,
    var conforimedPassword: String
)