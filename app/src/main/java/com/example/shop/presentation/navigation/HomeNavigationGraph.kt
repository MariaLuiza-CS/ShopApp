package com.example.shop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shop.Graph
import com.example.shop.domain.utils.BottomNavItem
import com.example.shop.presentation.ui.screen.HomeContent

@Composable
fun HomeNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Home.title
    ) {
        composable(route = BottomNavItem.Home.title) {
            HomeContent(
            )
        }
        composable(route = BottomNavItem.List.title) {
            HomeContent(
            )
        }
        composable(route = BottomNavItem.Analytics.title) {
            HomeContent(
            )
        }
        composable(route = BottomNavItem.Profile.title) {
            HomeContent(
            )
        }
    }
}