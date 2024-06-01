package com.example.midatingapp.viewmodel.registering

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisteringViewModel : MeanVM() {

    private val _user = MutableLiveData<User>().apply { value = User() }
    val user: LiveData<User> = _user

    private val _errorField =
        MutableLiveData<MutableList<Error>>().apply { value = emptyList<Error>().toMutableList() }
    val errorField: LiveData<MutableList<Error>> = _errorField

    fun setName(name: String) {
        val updatedUser = _user.value?.copy(name = name)
        _user.value = updatedUser
    }

    fun setEmail(email: String) {
        val updatedUser = _user.value?.copy(email = email)
        _user.value = updatedUser
    }

    fun setPassword(password: String) {
        val updatedUser = _user.value?.copy(password = password)
        _user.value = updatedUser
    }

    fun setConfirmedPassword(confirmedPassword: String) {
        val updatedUser = _user.value?.copy(confirmedPassword = confirmedPassword)
        _user.value = updatedUser
    }

    fun setError(error: MutableList<Error>) {
        _errorField.value = error
    }

    fun checkError(): Boolean {

        val check = _user.value!!.emptyFields().isEmpty()
        val passwordMatch = _user.value!!.matchPassword()
        val mutableListOfError: MutableList<Error> = emptyList<Error>().toMutableList()
        if (!check) {
            _user.value!!.emptyFields().forEach {
                findErrorTextAndRemove(mutableListOfError, it)
                mutableListOfError.add(Error(errorType = it, error = true))
            }
            setError(mutableListOfError)
            return false
        } else {
            if (!_user.value!!.matchPassword()) {
                setError(mutableListOf(Error(errorType = "passowrd not match", error = true)))
                return false
            } else {
                setError(
                    emptyList<Error>().toMutableList()
                )

            }
            return true
        }


    }

    private fun findErrorTextAndRemove(mutableList: MutableList<Error>, error: String) {
        mutableList.remove(mutableList.find {
            it.errorType == error
        })
    }


}


data class User(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var confirmedPassword: String = ""
) {
    fun emptyFields(): List<String> {
        val emptyFields = mutableListOf<String>()
        if (name.isEmpty()) {
            emptyFields.add("name")
        }
        if (email.isEmpty()) {
            emptyFields.add("email")
        }
        if (password.isEmpty()) {
            emptyFields.add("password")
        }
        if (confirmedPassword.isEmpty()) {
            emptyFields.add("confirmedPassword")
        }
        return emptyFields
    }

    fun matchPassword(): Boolean {
        return password == confirmedPassword
    }


}

data class Error(
    var errorType: String = "",
    var error: Boolean
)