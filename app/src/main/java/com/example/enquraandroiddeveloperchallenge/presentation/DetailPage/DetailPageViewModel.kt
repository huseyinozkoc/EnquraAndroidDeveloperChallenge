package com.example.enquraandroiddeveloperchallenge.presentation.DetailPage

import androidx.lifecycle.ViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics
) : ViewModel() {
    fun logUserEnteredDetailPageEvent(city: String) {
        firebaseAnalytics.logEvent("user_entered_detail_page") {
            param("city", city)
        }
    }
}

