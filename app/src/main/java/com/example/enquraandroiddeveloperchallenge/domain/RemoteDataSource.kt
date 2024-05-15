package com.example.enquraandroiddeveloperchallenge.domain

import com.example.enquraandroiddeveloperchallenge.data.model.BankData

interface RemoteDataSource {
    suspend fun getBankDataList(): List<BankData>
}