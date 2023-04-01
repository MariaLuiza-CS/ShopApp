package com.example.shop.presentation.ui.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shop.domain.utils.BottomNavItem
import com.example.shop.presentation.ui.theme.EerieBlack
import com.example.shop.presentation.ui.theme.Flax

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

        androidx.compose.material.BottomNavigation(
            backgroundColor = Flax,
            contentColor = EerieBlack
        ) {

            items.forEach { item ->
                AddItem(
                    screen = item,
                    currentDestination = currentDestination,
                    navController = navController
                )
//                BottomNavigationItem(
//                    icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
//                    label = { Text(text = item.title, fontSize = 9.sp) },
//                    selected = currentRoute == item.screen_route,
//                    selectedContentColor = Color.Black,
//                    unselectedContentColor = Color.Black.copy(0.4f),
//                    alwaysShowLabel = false,
//                    onClick = {
//                        navController.navigate(item.screen_route) {
//                            popUpTo(navController.graph.findStartDestination().id)
//                            launchSingleTop = true
//                        }
//                    }
//                )

        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(painterResource(id = screen.icon), contentDescription = screen.title)
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.screen_route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.screen_route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}