package com.example.enquraandroiddeveloperchallenge.domain.usecase

import com.example.enquraandroiddeveloperchallenge.domain.repository.BankRepository
import javax.inject.Inject

class GetBankDataListUseCase @Inject constructor(
    private val bankRepository: BankRepository
) {
    operator fun invoke() = bankRepository.getBankDataList()
}