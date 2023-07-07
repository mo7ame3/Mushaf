package com.example.mushaf.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mushaf.screens.details.DetailsScreen
import com.example.mushaf.screens.details.DetailsViewModel
import com.example.mushaf.screens.home.HomeScreen
import com.example.mushaf.screens.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AllScreen.HomeScreen.name
    ) {

        composable(route = AllScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(route = AllScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(route = AllScreen.DetailsScreen.name + "/{surahId}", arguments = listOf(
            navArgument(name = "surahId") {
                type = NavType.StringType
            }
        )) {
            val detailsViewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(
                detailsViewModel = detailsViewModel,
                surahId = it.arguments?.getString("surahId").toString()
            )
        }
    }
}