package com.hafidrf.mandiri.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.hafidrf.mandiri.data.repository.DataRepository
import com.hafidrf.mandiri.data.repository.Repository

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    abstract fun bindingRepository(
        dataRepository: DataRepository
    ) : Repository
}