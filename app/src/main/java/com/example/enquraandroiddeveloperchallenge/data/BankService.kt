package com.example.enquraandroiddeveloperchallenge.data

import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import retrofit2.http.GET

interface BankService {
    @GET(".")
    suspend fun getBankDataList(): List<BankData>
}