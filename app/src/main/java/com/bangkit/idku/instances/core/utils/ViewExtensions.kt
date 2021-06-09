package com.bangkit.idku.instances.core.utils

import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

fun EditText.showError(message: String) {
    error = message
}

fun EditText.hideError() {
    error = null
}

fun View.showSnackbar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}