package com.bangkit.idku.instances.core.domain.interactor

import com.bangkit.idku.instances.core.domain.repository.UserRepository
import com.bangkit.idku.instances.core.domain.usecase.LoginUseCase
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginInteractor @Inject constructor(
    private val repository: UserRepository
): LoginUseCase{
    override val user: FirebaseUser?
        get() = repository.user

    override fun login(email: String, password: String) = repository.login(email, password)
}