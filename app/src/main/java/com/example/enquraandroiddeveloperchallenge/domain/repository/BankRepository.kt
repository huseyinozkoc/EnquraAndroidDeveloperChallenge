package com.example.enquraandroiddeveloperchallenge.domain.repository

import com.example.enquraandroiddeveloperchallenge.common.Resource
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import kotlinx.coroutines.flow.Flow

interface BankRepository {
    fun getBankDataList(): Flow<Resource<List<BankData>>>

}