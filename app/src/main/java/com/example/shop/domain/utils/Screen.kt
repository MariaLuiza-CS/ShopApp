package com.example.shop.domain.utils

sealed class Screen(val route: String){
    object Root: Screen(route = "root_graph")
    object Welcome: Screen(route = "welcome_screen")
    object Home: Screen(route = "home_screen")
    object List: Screen(route = "list_screen")
    object Analytics: Screen(route = "analytics_screen")
    object Profile: Screen(route = "profile_screen")
}
