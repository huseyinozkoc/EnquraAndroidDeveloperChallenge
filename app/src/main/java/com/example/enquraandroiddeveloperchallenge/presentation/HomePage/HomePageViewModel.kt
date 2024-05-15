package com.example.enquraandroiddeveloperchallenge.presentation.HomePage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enquraandroiddeveloperchallenge.common.Resource
import com.example.enquraandroiddeveloperchallenge.domain.usecase.GetBankDataListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val getBankDataListUseCase: GetBankDataListUseCase,
) : ViewModel() {

    private val _homePageState = mutableStateOf<HomePageState>(HomePageState())
    val homePageState: State<HomePageState> = _homePageState
    init {
        getBankList()
    }
    private fun getBankList() = viewModelScope.launch {
        getBankDataListUseCase.invoke().collect() {
            when (it) {
                is Resource.Error -> {
                    _homePageState.value = HomePageState(isLoading = false)
                    _homePageState.value = HomePageState(error = it.message ?: "BankListError")
                }
                is Resource.Loading -> {
                    _homePageState.value = HomePageState(isLoading = true)
                }
                is Resource.Success -> {
                    _homePageState.value = HomePageState(isLoading = false)
                    _homePageState.value = HomePageState(bankDataList = it.data ?: emptyList())
                }
            }
        }
    }






}