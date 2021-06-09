package com.bangkit.idku.instances.core.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface IdentityRepository {
    fun getAuthorizedAccess(): Task<QuerySnapshot>
    fun getIdentity(id: String): Task<DocumentSnapshot>
    fun getOngoingRequests(): Task<QuerySnapshot>
    fun getOngoingRequest(id: String): Task<DocumentSnapshot>
    fun addRequest(requestedData: List<String>): Task<Unit>
}