package com.example.enquraandroiddeveloperchallenge.domain.source

import com.example.enquraandroiddeveloperchallenge.data.model.BankData

interface RemoteDataSource {
    suspend fun getBankDataList(): List<BankData>
}