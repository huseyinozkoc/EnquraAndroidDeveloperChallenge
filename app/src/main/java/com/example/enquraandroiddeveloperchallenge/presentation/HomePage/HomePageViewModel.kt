package com.example.enquraandroiddeveloperchallenge.presentation.HomePage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enquraandroiddeveloperchallenge.common.Resource
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.example.enquraandroiddeveloperchallenge.domain.usecase.GetBankDataListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val getBankDataListUseCase: GetBankDataListUseCase,
) : ViewModel() {

    private val _homePageState = mutableStateOf<HomePageState>(HomePageState())
    val homePageState: State<HomePageState> = _homePageState

    private val _filteredBankDataList = mutableStateOf<List<BankData>>(emptyList())
    val filteredBankDataList: State<List<BankData>> = _filteredBankDataList

    init {
        getBankList()
    }

    private fun getBankList() = viewModelScope.launch {
        getBankDataListUseCase.invoke().collect() {
            when (it) {
                is Resource.Error -> {
                    _homePageState.value = HomePageState(isLoading = false)
                    _homePageState.value = HomePageState(error = "BankListError")
                }

                is Resource.Loading -> {
                    _homePageState.value = HomePageState(isLoading = true)
                }

                is Resource.Success -> {
                    delay(1250)
                    _homePageState.value = HomePageState(isLoading = false)
                    _homePageState.value = HomePageState(bankDataList = it.data ?: emptyList())
                    _filteredBankDataList.value = it.data ?: emptyList()
                }
            }
        }
    }

    fun filterBankDataList(query: String) {
        _filteredBankDataList.value =
            _homePageState.value.bankDataList.filter { it.city.contains(query, ignoreCase = true) }
    }


}