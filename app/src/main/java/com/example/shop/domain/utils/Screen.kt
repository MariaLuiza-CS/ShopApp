package com.example.shop.domain.utils

sealed class Screen(val route: String){
    object Welcome: Screen(route = "welcome_screen")
    object Login: Screen(route = "login_screen")
}
