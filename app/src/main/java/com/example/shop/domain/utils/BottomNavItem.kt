package com.example.shop.domain.utils

import com.example.shop.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home :
        BottomNavItem("Home", R.drawable.ic_baseline_home_24, Screen.Home.route)

    object List :
        BottomNavItem("List", R.drawable.ic_baseline_format_list_bulleted_24, Screen.List.route)

    object Analytics :
        BottomNavItem("Analytics", R.drawable.ic_baseline_timeline_24, Screen.Analytics.route)

    object Profile :
        BottomNavItem("Profile", R.drawable.ic_baseline_person_24, Screen.Profile.route)
}
