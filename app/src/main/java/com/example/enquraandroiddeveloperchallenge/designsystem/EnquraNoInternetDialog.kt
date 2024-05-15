package com.example.enquraandroiddeveloperchallenge.designsystem


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.enquraandroiddeveloperchallenge.common.isNetworkAvailable
import kotlinx.coroutines.flow.Flow

@Composable
fun EnquraNoInternetDialog(internetConnectionFlow: Flow<Boolean>) {
    val context = LocalContext.current
    val isConnected by internetConnectionFlow.collectAsState(initial = isNetworkAvailable(context))
    val showDialog = remember { mutableStateOf(!isConnected) }

    if (!isConnected) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("İnternet Bağlantısı Yok") },
            text = { Text("Lütfen internet bağlantınızı kontrol edin ve tekrar deneyin.") },
            confirmButton = {
                TextButton(onClick = {
                    if (isNetworkAvailable(context)) {
                        showDialog.value = false
                    }
                }) {
                    Text("Tekrar Deneyin")
                }
            }
        )
    }
}