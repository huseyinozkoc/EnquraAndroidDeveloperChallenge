package com.example.enquraandroiddeveloperchallenge.data.source

import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import retrofit2.http.GET

interface BankService {
    @GET("bankdata")
    suspend fun getBankDataList(): List<BankData>
}