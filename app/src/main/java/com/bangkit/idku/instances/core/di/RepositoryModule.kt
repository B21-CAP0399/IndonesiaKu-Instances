package com.bangkit.idku.instances.core.di

import com.bangkit.idku.instances.core.data.IdentityRepositoryImpl
import com.bangkit.idku.instances.core.data.UserRepositoryImpl
import com.bangkit.idku.instances.core.domain.repository.IdentityRepository
import com.bangkit.idku.instances.core.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindsIdentityRepository(identityRepositoryImpl: IdentityRepositoryImpl): IdentityRepository
}