package com.example.enquraandroiddeveloperchallenge.di

import com.example.enquraandroiddeveloperchallenge.data.source.BankService
import com.example.enquraandroiddeveloperchallenge.data.source.RemoteDataSourceImpl
import com.example.enquraandroiddeveloperchallenge.domain.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(bankService: BankService): RemoteDataSource =
        RemoteDataSourceImpl(bankService = bankService)
}