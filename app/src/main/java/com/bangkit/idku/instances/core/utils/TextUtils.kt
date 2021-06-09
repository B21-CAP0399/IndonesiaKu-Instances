package com.bangkit.idku.instances.core.utils

import android.util.Patterns

fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

// A placeholder username validation check
fun isEmailAddressValid(username: String): Boolean =
    if (username.contains('@')) {
        Patterns.EMAIL_ADDRESS.matcher(username).matches()
    } else {
        username.isNotBlank()
    }

// A placeholder password validation check
fun isPasswordValid(password: String): Boolean{
    val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    return password.matches(regex)
}

fun isPhoneNumberValid(phoneNumber: String): Boolean =
    Patterns.PHONE.matcher(phoneNumber).matches()
