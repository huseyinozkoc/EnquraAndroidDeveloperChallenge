package com.example.enquraandroiddeveloperchallenge.data.source

import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.example.enquraandroiddeveloperchallenge.domain.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {
    override suspend fun getBankDataList(): List<BankData> {
        TODO("Not yet implemented")
    }
}