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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

import androidx.compose.material.icons.Icons
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import android.net.Uri
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon


@Composable
fun DetailPage(bankDataJson: String, navController: NavController) {
    val viewModel: DetailPageViewModel = hiltViewModel()
    val context = LocalContext.current

    //----------------------------------------------------------------------------
    // Took Data from HomePage
    val gson = Gson()
    val bankDataJson = URLDecoder.decode(bankDataJson, StandardCharsets.UTF_8.toString())
    val bankData = gson.fromJson(bankDataJson, BankData::class.java)
    //----------------------------------------------------------------------------

    //----------------------------------------------------------------------------
    // Log Event with city
    viewModel.logUserEnteredDetailPageEvent(bankData.city)
    //----------------------------------------------------------------------------


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                //https://developers.google.com/maps/documentation/urls/android-intents#kotlin_2
                val gmmIntentUri = Uri.parse("geo:0,0?q=${bankData.address}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                if (mapIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(mapIntent)
                }
            }) {
                Icon(Icons.Filled.LocationOn, contentDescription = "Navigate to address")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            BankDetailCard(bankData = bankData)
        }
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
