package com.example.shop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shop.HomeScreen
import com.example.shop.domain.utils.BottomNavItem
import com.example.shop.domain.utils.NavGraph
import com.example.shop.presentation.ui.screen.AnalyticsScreen
import com.example.shop.presentation.ui.screen.ListScreen
import com.example.shop.presentation.ui.screen.ProfileScreen

@Composable
fun HomeNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.title,
        route = NavGraph.Home.routeGraph
    ) {
        composable(route = BottomNavItem.Home.title){
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavItem.List.title){
            ListScreen()
        }
        composable(route = BottomNavItem.Analytics.title){
            AnalyticsScreen()
        }
        composable(route = BottomNavItem.Profile.title){
            ProfileScreen()
        }
    }
}