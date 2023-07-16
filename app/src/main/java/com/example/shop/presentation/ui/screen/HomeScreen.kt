package com.example.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shop.presentation.navigation.HomeNavigationGraph
import com.example.shop.presentation.ui.screen.BottomNavigation

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
        HomeNavigationGraph(navController = navController)
    }
}