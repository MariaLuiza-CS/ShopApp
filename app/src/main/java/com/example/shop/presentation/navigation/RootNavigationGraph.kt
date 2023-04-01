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
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        composable(route =  Graph.HOME){
            HomeScreen()
        }
        composable(route = Graph.WELCOME) {
            WelcomeScreen(navController = navController)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val WELCOME = "welcome_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}