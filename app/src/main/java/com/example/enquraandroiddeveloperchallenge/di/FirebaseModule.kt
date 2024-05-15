package com.example.enquraandroiddeveloperchallenge.di

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirebaseAnalytics(application: Application): FirebaseAnalytics =
        FirebaseAnalytics.getInstance(application)
}