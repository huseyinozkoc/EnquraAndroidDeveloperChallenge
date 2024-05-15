package com.example.enquraandroiddeveloperchallenge.presentation.HomePage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.example.enquraandroiddeveloperchallenge.presentation.Screen
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomePage(navController: NavController) {

    val viewModel: HomePageViewModel = hiltViewModel()
    val state = viewModel.homePageState.value
    val gson = Gson()

    LazyColumn {
        if (state.isLoading) {
            item {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Loading...")
                }
            }
        } else if (state.error.isNotEmpty()) {
            item {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Error: ${state.error}")
                }
            }
        } else {
            items(state.bankDataList) { bankData ->
                BankDataCard(bankData = bankData) {
                    val bankDataJson = gson.toJson(bankData)
                    val encodedBankDataJson = URLEncoder.encode(bankDataJson, StandardCharsets.UTF_8.toString())
                    navController.navigate("${Screen.DetailPage.route}/$encodedBankDataJson")
                }
            }
        }
    }
}


@Composable
fun BankDataCard(bankData: BankData,onClickToCard: () -> Unit) {
    Card(modifier = Modifier.padding(32.dp).clickable(onClick = onClickToCard)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${bankData.id}")
            Text(text = "City: ${bankData.city}")
            Text(text = "District: ${bankData.district}")
            Text(text = "Bank Branch: ${bankData.bankBranch}")
            Text(text = "Bank Type: ${bankData.bankType}")
            Text(text = "Bank Code: ${bankData.bankCode}")
            Text(text = "Address Name: ${bankData.addressName}")
            Text(text = "Address: ${bankData.address}")
            Text(text = "Postal Code: ${bankData.postalCode}")
            Text(text = "On/Off Line: ${bankData.onOffLine}")
            Text(text = "On/Off Site: ${bankData.onOffSite}")
            Text(text = "Region Coordinator: ${bankData.regionCoordinator}")
            Text(text = "Nearest ATM: ${bankData.nearestAtm}")
        }
    }
}