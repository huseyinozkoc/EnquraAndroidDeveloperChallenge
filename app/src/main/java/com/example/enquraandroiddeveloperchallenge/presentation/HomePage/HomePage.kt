package com.example.enquraandroiddeveloperchallenge.presentation.HomePage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.enquraandroiddeveloperchallenge.presentation.Screen

@Composable
fun HomePage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Home Page",
                modifier = Modifier.clickable {
                    navController.navigate(Screen.DetailPage.route)
                })
        }
    }
}
