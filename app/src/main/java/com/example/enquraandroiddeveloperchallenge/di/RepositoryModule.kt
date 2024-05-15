package com.example.enquraandroiddeveloperchallenge.di

import com.example.enquraandroiddeveloperchallenge.data.repository.BankRepositoryImpl
import com.example.enquraandroiddeveloperchallenge.domain.repository.BankRepository
import com.example.enquraandroiddeveloperchallenge.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBankRepository(
        remoteDataSource: RemoteDataSource,
    ): BankRepository =
        BankRepositoryImpl(remoteDataSource)

}