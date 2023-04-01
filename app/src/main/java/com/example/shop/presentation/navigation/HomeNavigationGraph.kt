package com.example.shop.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shop.Graph
import com.example.shop.domain.utils.BottomNavItem
import com.example.shop.presentation.ui.screen.ScreenContent

@Composable
fun HomeNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Home.title
    ) {
        composable(route = BottomNavItem.Home.title) {
            ScreenContent(
            )
        }
        composable(route = BottomNavItem.List.title) {
            ScreenContent(
            )
        }
        composable(route = BottomNavItem.Analytics.title) {
            ScreenContent(
            )
        }
        composable(route = BottomNavItem.Profile.title) {
            ScreenContent(
            )
        }
    }
}