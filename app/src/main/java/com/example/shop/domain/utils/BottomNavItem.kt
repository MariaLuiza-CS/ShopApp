package com.example.shop.domain.utils

import com.example.shop.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home :
        BottomNavItem("Home", R.drawable.ic_baseline_home_24, "HOME")

    object List :
        BottomNavItem("List", R.drawable.ic_baseline_format_list_bulleted_24, "LIST")

    object Analytics :
        BottomNavItem("Analytics", R.drawable.ic_baseline_timeline_24, "ANALYTICS")

    object Profile :
        BottomNavItem("Profile", R.drawable.ic_baseline_person_24, "PROFILE")
}
