package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.screens.CurrentWeatherScreen
import com.example.composenavigation.screens.DailyWeatherScreen
import com.example.composenavigation.screens.HourlyWeatherScreen
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationApp();
                }
            }
        }
    }
}

@Composable
fun NavigationApp() {
    // The NavHostController manages the screen navigation
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar (
                actions = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_wb_sunny_24),
                            contentDescription = "Home"
                        )
                    }
                    IconButton(onClick = { navController.navigate("hourly") }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_access_time_filled_24),
                            contentDescription = "Hourly"
                        )
                    }
                    IconButton(onClick = { navController.navigate("daily") }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_calendar_month_24),
                            contentDescription = "Daily"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = "home") {
                CurrentWeatherScreen()
            }
            composable(route = "hourly") {
                HourlyWeatherScreen()
            }
            composable(route = "daily") {
                DailyWeatherScreen()
            }
        }
    }
}

