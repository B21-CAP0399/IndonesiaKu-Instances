package com.bangkit.idku.instances.core.data

import com.bangkit.idku.instances.core.domain.repository.IdentityRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import timber.log.Timber
import javax.inject.Inject

class IdentityRepositoryImpl @Inject constructor(
    private val functions: FirebaseFunctions,
    private val db: FirebaseFirestore,
    private val auth: FirebaseAuth,
) : IdentityRepository {
    override fun addRequest(requestedData: List<String>): Task<Unit> {
        val data = hashMapOf(
            "requested_data" to requestedData
        )

        return functions
            .getHttpsCallable("requestAccessPermission")
            .call(data)
            .continueWith { task ->
                val result = task.result?.data
                Timber.d(result.toString())
            }
    }

    override fun getAuthorizedAccess() =
        db.collection(accessPermission)
            .whereEqualTo("instance", auth.currentUser?.uid)
            .whereEqualTo("authorized", true)
            .get()


    override fun getIdentity(id: String) =
        db.collection(citizenID)
            .document(id)
            .get()

    override fun getOngoingRequests() =
        db.collection(accessPermission)
            .whereEqualTo("instance", auth.currentUser?.uid)
            .whereEqualTo("authorized", false)
            .get()

    override fun getOngoingRequest(id: String) =
        db.collection(accessPermission)
            .document(id)
            .get()

    companion object {
        private const val accessPermission = "access_permission"
        private const val citizenID = "citizen_identity"
    }
}