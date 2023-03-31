package com.example.shop.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.shop.RootNavigationGraph
import com.example.shop.domain.utils.NavGraph
import com.example.shop.presentation.ui.viewmodel.WelcomeViewModel
import com.example.shop.domain.utils.Screen
import com.example.shop.presentation.ui.theme.ShopTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getWelcomeCompletedFlow()

        installSplashScreen().setKeepOnScreenCondition {
            !viewModel.state.isLoading
        }

        setContent {
            ShopTheme {

                var screen = if (viewModel.state.isCompleted) {
                    NavGraph.Home.routeGraph
                } else {
                    Screen.Welcome.route
                }

                val navController = rememberNavController()
                RootNavigationGraph(navController = navController, startDestination = screen)
            }
        }
    }
}
