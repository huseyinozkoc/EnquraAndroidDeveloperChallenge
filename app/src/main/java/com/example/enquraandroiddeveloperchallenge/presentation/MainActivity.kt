package com.example.enquraandroiddeveloperchallenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.enquraandroiddeveloperchallenge.designsystem.EnquraNoInternetDialog
import com.example.enquraandroiddeveloperchallenge.presentation.DetailPage.DetailPage
import com.example.enquraandroiddeveloperchallenge.presentation.HomePage.HomePage
import com.example.enquraandroiddeveloperchallenge.presentation.SplashPage.SplashPage
import com.example.enquraandroiddeveloperchallenge.ui.theme.EnquraAndroidDeveloperChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Internet connection check
            // -----------------------------------------------------------------------------------------------------------
            val context = LocalContext.current
            val internetConnectionFlow = NetworkStatusChecker.internetConnectionFlow(context)
            EnquraNoInternetDialog(internetConnectionFlow = internetConnectionFlow)
            //------------------------------------------------------------------------------------------------------------

            EnquraAndroidDeveloperChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SplashPage.route
                    ) {
                        composable(route = Screen.SplashPage.route) {
                            SplashPage(navController = navController)
                        }
                        composable(route = Screen.HomePage.route) {
                            HomePage(navController = navController)
                        }
                        composable(
                            "${Screen.DetailPage.route}/{bankDataJson}",
                            arguments = listOf(navArgument("bankDataJson") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val bankDataJson = backStackEntry.arguments?.getString("bankDataJson")
                            if (bankDataJson != null) {
                                DetailPage(bankDataJson, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnquraAndroidDeveloperChallengeTheme {
        Greeting("Android")
    }
}