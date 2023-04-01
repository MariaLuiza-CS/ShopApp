package com.example.shop

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shop.presentation.navigation.HomeNavigationGraph

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { com.example.shop.presentation.ui.screen.BottomNavigation(navController = navController) }
    ) {
        HomeNavigationGraph(navController = navController)
    }
}