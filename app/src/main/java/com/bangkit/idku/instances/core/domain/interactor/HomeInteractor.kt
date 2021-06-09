package com.bangkit.idku.instances.core.domain.interactor

import com.bangkit.idku.instances.core.domain.repository.IdentityRepository
import com.bangkit.idku.instances.core.domain.repository.UserRepository
import com.bangkit.idku.instances.core.domain.usecase.HomeUseCase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import timber.log.Timber
import javax.inject.Inject


class HomeInteractor @Inject constructor(
    private val identityRepository: IdentityRepository,
    private val userRepository: UserRepository
): HomeUseCase{
    override val user: FirebaseUser?
        get() = userRepository.user

    override fun addRequest(requestedData: List<String>) = identityRepository.addRequest(requestedData)

    override fun getAuthorizedAccesss() = identityRepository.getAuthorizedAccess()

    override fun getRequests() = identityRepository.getOngoingRequests()

    override fun logout() = userRepository.logout()
}