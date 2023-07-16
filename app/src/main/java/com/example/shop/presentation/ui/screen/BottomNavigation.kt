package com.example.shop.presentation.ui.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shop.domain.utils.BottomNavItem
import com.example.shop.presentation.ui.theme.EerieBlack
import com.example.shop.presentation.ui.theme.Flax
import com.example.shop.presentation.ui.theme.FlaxDark

@Composable
fun BottomNavigation(navController: NavHostController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.List,
        BottomNavItem.Analytics,
        BottomNavItem.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Flax,
        contentColor = Color.Green,
        tonalElevation = 10.dp
    ) {
        items.forEach { item ->
            AddItem(
                screen = item,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title, style = MaterialTheme.typography.h3)
        },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.screen_route
        } == true,
        alwaysShowLabel = false,
        onClick = {
            navController.navigate(screen.screen_route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
