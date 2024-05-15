package com.example.enquraandroiddeveloperchallenge.data.repository

import com.example.enquraandroiddeveloperchallenge.common.Resource
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.example.enquraandroiddeveloperchallenge.domain.repository.BankRepository
import com.example.enquraandroiddeveloperchallenge.domain.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BankRepositoryImpl constructor(
    private val remoteDataSource: RemoteDataSource,
) : BankRepository {
    override fun getBankDataList(): Flow<Resource<List<BankData>>> = flow {
        emit(Resource.Loading())
        val response = try {
            remoteDataSource.getBankDataList()
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable.message ?: "Error!"))
            null
        }
        response?.let { data ->
            emit(Resource.Success(data))
        }
    }
}