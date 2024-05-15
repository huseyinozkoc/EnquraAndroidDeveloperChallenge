package com.example.enquraandroiddeveloperchallenge.data.source

import com.example.enquraandroiddeveloperchallenge.domain.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val bankService: BankService
) : RemoteDataSource {
    override suspend fun getBankDataList() = bankService.getBankDataList()
}