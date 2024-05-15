package com.example.enquraandroiddeveloperchallenge.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.enquraandroiddeveloperchallenge.R

@Composable
fun EnquraErrorImage() {
    val errorPainter: Painter = painterResource(id = R.drawable.error)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = errorPainter,
            contentDescription = "Error Image",
            modifier = Modifier.fillMaxSize()
        )
    }
}