package com.example.shop.domain.utils

sealed class NavGraph(var routeGraph: String){
    object Root : NavGraph(routeGraph = "root_graph")
    object Home : NavGraph(routeGraph = "home_graph")
}
