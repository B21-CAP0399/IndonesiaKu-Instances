package com.bangkit.idku.instances.login

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.bangkit.idku.instances.R
import com.bangkit.idku.instances.core.utils.hideError
import com.bangkit.idku.instances.core.utils.isEmailValid
import com.bangkit.idku.instances.core.utils.isPasswordValid
import com.bangkit.idku.instances.core.utils.showError
import com.bangkit.idku.instances.databinding.ActivityLoginBinding
import com.bangkit.idku.instances.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModels()

    private val emailState = MutableStateFlow("")
    private val passwordState = MutableStateFlow("")
    private val formIsValid = combine(
        emailState,
        passwordState
    ) { email, password -> isEmailValid(email) and isPasswordValid(password) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            edtEmail.editText?.apply {
                doOnTextChanged { email, _, _, _ ->
                    emailState.value = email.toString()
                    val emailIsValid = isEmailValid(email.toString())
                    when {
                        emailIsValid.not() -> showError(getString(R.string.error_edit_email))
                        emailIsValid -> hideError()
                    }
                }
            }

            edtPassword.editText?.apply {
                doOnTextChanged { password, _, _, _ ->
                    passwordState.value = password.toString()
                    val passwordIsValid = isPasswordValid(password.toString())
                    when {
                        passwordIsValid.not() -> showError(getString(R.string.error_edit_password))
                        passwordIsValid -> hideError()
                    }
                }
            }

            lifecycleScope.launch {
                formIsValid.collect { formIsValidState -> btnLogin.isEnabled = formIsValidState }
            }

            btnLogin.setOnClickListener(::onClick)
        }
    }

    override fun onStart() {
        super.onStart()
        if (viewModel.user != null) {
            Intent(this, HomeActivity::class.java).also {
                it.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_login) {
            viewModel.signIn(emailState.value, passwordState.value)
                .addOnCompleteListener { task ->
                    Timber.d(task.result.toString())
                    if (task.isSuccessful) {
                        Intent(this, HomeActivity::class.java).also {
                            it.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
                    } else {
                        Timber.e(task.exception)
                    }
                }
        }
    }
}