package com.example.enquraandroiddeveloperchallenge.presentation.HomePage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.enquraandroiddeveloperchallenge.R
import com.example.enquraandroiddeveloperchallenge.data.model.BankData
import com.example.enquraandroiddeveloperchallenge.presentation.Screen
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.enquraandroiddeveloperchallenge.designsystem.EnquraLoadingAnimation
import java.util.Locale

@Composable
fun HomePage(navController: NavController) {

    val viewModel: HomePageViewModel = hiltViewModel()
    val context = LocalContext.current


    val state = viewModel.homePageState.value
    val filteredBankDataList = viewModel.filteredBankDataList.value
    val searchQuery = remember { mutableStateOf("") }
    val gson = Gson()
    val currentNavController = rememberUpdatedState(navController)

    val flagPainter: Painter = painterResource(id = R.drawable.flag)
    val flagEngPainter: Painter = painterResource(id = R.drawable.flageng)

    fun changeLanguage(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Force UI recreation
        val currentDestination = currentNavController.value.currentDestination?.id
        currentNavController.value.popBackStack()
        currentDestination?.let { currentNavController.value.navigate(it) }
    }

    Scaffold(
        topBar = {
            Column {
                TextField(
                    value = searchQuery.value,
                    onValueChange = { newValue ->
                        searchQuery.value = newValue
                        viewModel.filterBankDataList(newValue)
                    },
                    label = { Text(stringResource(R.string.search_by_city)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, start = 8.dp, end = 8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = flagEngPainter,
                        contentDescription = "Change language to English",
                        modifier = Modifier
                            .clickable { changeLanguage("en") }
                            .size(100.dp)

                    )
                    Image(
                        painter = flagPainter,
                        contentDescription = "Change language to Turkish",
                        modifier = Modifier
                            .clickable { changeLanguage("tr") }
                            .size(100.dp)
                    )
                }
            }
        },
        content = { paddingValue ->

            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    EnquraLoadingAnimation()
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue)
            ) {
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
                } else if (filteredBankDataList.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = stringResource(R.string.no_search_data_found))
                            }
                        }
                    }
                } else {
                    items(filteredBankDataList) { bankData ->
                        BankDataCard(bankData = bankData) {
                            val bankDataJson = gson.toJson(bankData)
                            val encodedBankDataJson =
                                URLEncoder.encode(bankDataJson, StandardCharsets.UTF_8.toString())
                            navController.navigate("${Screen.DetailPage.route}/$encodedBankDataJson")
                        }
                    }
                }
            }
        }
    )

}


@Composable
fun BankDataCard(bankData: BankData, onClickToCard: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(32.dp)
            .clickable(onClick = onClickToCard)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.city) + " ${bankData.city}")
            Text(text = stringResource(R.string.district) + " ${bankData.district}")
            Text(text = stringResource(R.string.bank_branch) + " ${bankData.bankBranch}")
            Text(text = stringResource(R.string.bank_type) + " ${bankData.bankType}")
            Text(text = stringResource(R.string.bank_code) + " ${bankData.bankCode}")
            Text(text = stringResource(R.string.address_name) + " ${bankData.addressName}")
            Text(text = stringResource(R.string.address) + " ${bankData.address}")
            Text(text = stringResource(R.string.postal_code) + " ${bankData.postalCode}")
            Text(text = stringResource(R.string.on_off_line) + " ${bankData.onOffLine}")
            Text(text = stringResource(R.string.on_off_site) + " ${bankData.onOffSite}")
            Text(text = stringResource(R.string.region_coordinator) + " ${bankData.regionCoordinator}")
            Text(text = stringResource(R.string.nearest_atm) + " ${bankData.nearestAtm}")
        }
    }
}