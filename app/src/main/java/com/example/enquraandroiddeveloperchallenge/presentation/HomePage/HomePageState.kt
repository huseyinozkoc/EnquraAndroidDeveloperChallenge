package com.example.enquraandroiddeveloperchallenge.presentation.HomePage

import com.example.enquraandroiddeveloperchallenge.data.model.BankData

data class HomePageState(
    val isLoading: Boolean = false,
    val bankDataList: List<BankData> = emptyList(),
    val error: String = ""
)