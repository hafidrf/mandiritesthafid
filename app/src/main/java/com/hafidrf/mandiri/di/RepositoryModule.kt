package com.hafidrf.mandiri.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import com.hafidrf.mandiri.data.factory.Factory
import com.hafidrf.mandiri.data.network.ApiService
import com.hafidrf.mandiri.data.repository.DataRepository
import com.hafidrf.mandiri.data.repository.remote.RemoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRemoteRepository(
        disposable: CompositeDisposable,
        apiService: ApiService,
        factory: Factory
    ) : RemoteRepository = RemoteRepository(disposable, apiService, factory)

    @Provides
    @Singleton
    fun provideDataRepository(
        remoteRepository: RemoteRepository
    ) : DataRepository = DataRepository(remoteRepository)
}