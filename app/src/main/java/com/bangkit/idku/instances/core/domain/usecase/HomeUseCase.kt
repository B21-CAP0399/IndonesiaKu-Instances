package com.bangkit.idku.instances.core.domain.usecase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.QuerySnapshot

interface HomeUseCase {
    val user: FirebaseUser?
    fun getAuthorizedAccesss(): Task<QuerySnapshot>
    fun getRequests(): Task<QuerySnapshot>
    fun logout()
    fun addRequest(requestedData: List<String>): Task<Unit>
}