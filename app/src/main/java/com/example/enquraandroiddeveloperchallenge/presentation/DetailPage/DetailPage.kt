package com.example.enquraandroiddeveloperchallenge.presentation.DetailPage

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun DetailPage(bankDataJson: String, navController: NavController) {
    val gson = Gson()
    val bankDataJson = URLDecoder.decode(bankDataJson, StandardCharsets.UTF_8.toString())
    val bankData = gson.fromJson(bankDataJson, BankData::class.java)


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BankDetailCard(bankData = bankData)
    }
}


@Composable
fun BankDetailCard(bankData: BankData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
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
