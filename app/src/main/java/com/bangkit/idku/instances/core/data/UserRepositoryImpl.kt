package com.bangkit.idku.instances.core.data

import com.bangkit.idku.instances.core.domain.repository.UserRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import javax.inject.Singleton

class UserRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
): UserRepository {
    override val user: FirebaseUser? = auth.currentUser

    override fun login(email: String, password: String) =
        auth.signInWithEmailAndPassword(email, password)

    override fun logout() = auth.signOut()
}