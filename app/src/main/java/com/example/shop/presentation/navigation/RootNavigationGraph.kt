package com.example.shop

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shop.domain.utils.NavGraph
import com.example.shop.domain.utils.Screen
import com.example.shop.presentation.ui.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        route = NavGraph.Root.routeGraph,
        startDestination = startDestination
    ) {

        composable(route =  NavGraph.Home.routeGraph){
            HomeScreen()
        }

        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

    }
}