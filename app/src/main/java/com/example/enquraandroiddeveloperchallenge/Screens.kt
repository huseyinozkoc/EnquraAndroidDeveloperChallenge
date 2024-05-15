package com.example.enquraandroiddeveloperchallenge

sealed class Screen(val route: String) {
    object SplashPage : Screen("splash_page")
    object HomePage : Screen("home_page")
    object DetailPage: Screen("detail_page")

}