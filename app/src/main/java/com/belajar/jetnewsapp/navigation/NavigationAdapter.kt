package com.belajar.jetnewsapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.belajar.jetnewsapp.screen.detailNews.DetailNewsViewModel
import com.belajar.jetnewsapp.screen.detailNews.DetailScreen
import com.belajar.jetnewsapp.screen.favoriteScreen.view.FavScreen
import com.belajar.jetnewsapp.screen.favoriteScreen.viewModel.FavViewModel
import com.belajar.jetnewsapp.screen.homeScreen.view.HomeScreen
import com.belajar.jetnewsapp.screen.homeScreen.viewModel.HomeViewModel
import com.belajar.jetnewsapp.screen.homeScreen.viewModel.MainViewModel
import com.belajar.jetnewsapp.screen.profileScreen.ProfileScreen
import com.belajar.jetnewsapp.screen.splashScreen.SplashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationAdapter() {
    val navController = rememberAnimatedNavController()
    val vm = hiltViewModel<MainViewModel>()
    val homeVm = hiltViewModel<HomeViewModel>()
    val detailVm = hiltViewModel<DetailNewsViewModel>()
    val favVm = hiltViewModel<FavViewModel>()

    AnimatedNavHost(
        navController = navController,
        startDestination = NavRoute.Splash.route
    ) {
        composable(NavRoute.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(NavRoute.Home.route) {
            HomeScreen(vm = vm, homeVm = homeVm, navController = navController)
        }

        composable(NavRoute.Favorite.route) {
            FavScreen(navController = navController, vm = favVm)
        }

        composable(NavRoute.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(
            NavRoute.DetailNews.route + "/{category}/{index}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                },
                navArgument("index") {
                    type = NavType.IntType
                }
            )
        ) {
            DetailScreen(
                navController = navController,
                category = it.arguments?.getString("category")!!,
                index = it.arguments?.getInt("index")!!,
                vm = detailVm
            )
        }
    }
}