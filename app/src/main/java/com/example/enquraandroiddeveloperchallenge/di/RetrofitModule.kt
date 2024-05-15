package com.example.enquraandroiddeveloperchallenge.di

import com.example.enquraandroiddeveloperchallenge.common.Constants.BASE_URL
import com.example.enquraandroiddeveloperchallenge.data.source.BankService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideBankService(): BankService =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(BankService::class.java)
}