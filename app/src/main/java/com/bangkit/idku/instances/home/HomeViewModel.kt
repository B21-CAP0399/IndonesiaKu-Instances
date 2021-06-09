package com.bangkit.idku.instances.home

import androidx.lifecycle.ViewModel
import com.bangkit.idku.instances.core.domain.usecase.HomeUseCase
import com.bangkit.idku.instances.core.domain.usecase.LoginUseCase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
): ViewModel() {
    val user = homeUseCase.user

    fun addRequest(requestedData: List<String>): Task<Unit> = homeUseCase.addRequest(requestedData)

    fun getAuthorizedAccess() = homeUseCase.getAuthorizedAccesss()

    fun getRequests() = homeUseCase.getRequests()
}