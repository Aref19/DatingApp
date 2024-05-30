package com.example.midatingapp.viewmodel.registering

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisteringViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _secondPassword = MutableLiveData<String>()
    val secondPassword: LiveData<String> = _secondPassword
    private val _confirm = MutableLiveData<Boolean>()
    val confirmPassword: LiveData<Boolean> = _confirm
    var currentUser = _user.value ?: User("", "", "")
    fun setUser(name: String = "", email: String = "", password: String = "") {
        if (name != "") {
            currentUser = currentUser.copy(name = name)

        } else if (email != "") {
            currentUser = currentUser.copy(email = email)
        }
        _user.value = currentUser
        confirmPassword()
    }

    fun setPassword1(password: String) {
        _password.value = password
        confirmPassword()
    }

    fun setPassword2(password: String) {
        _secondPassword.value = password
        confirmPassword()
    }

    fun confirmPassword() {
            Log.i("what",_password.value.toString() )
            if ((_password.value != null &&_password.value != "")&& (_secondPassword.value != null &&_secondPassword.value != "")) {
                _confirm.value = _password.value == _secondPassword.value
                if (_confirm.value == true) {
                    _user.value = _user.value!!.copy(password = _password.value!!)
                }
            } else {
                _confirm.value = false
            }


    }
}

data class User(var name: String, var email: String, var password: String)