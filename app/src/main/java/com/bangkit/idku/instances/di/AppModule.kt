package com.bangkit.idku.instances.di

import com.bangkit.idku.instances.core.domain.interactor.HomeInteractor
import com.bangkit.idku.instances.core.domain.interactor.LoginInteractor
import com.bangkit.idku.instances.core.domain.usecase.HomeUseCase
import com.bangkit.idku.instances.core.domain.usecase.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsLoginUseCase(loginInteractor: LoginInteractor): LoginUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsHomeUseCase(homeInteractor: HomeInteractor): HomeUseCase
}

