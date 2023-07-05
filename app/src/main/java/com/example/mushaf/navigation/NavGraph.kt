package com.example.mushaf.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mushaf.screens.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AllScreen.SplashScreen.name
    ) {

        composable(route = AllScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
    }
}