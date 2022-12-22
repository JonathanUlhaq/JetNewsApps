package com.belajar.jetnewsapp.navigation

sealed class NavRoute(val route:String) {
    object Home:NavRoute("home")
    object DetailNews:NavRoute("detail")
    object Favorite:NavRoute("favorite")
    object Profile:NavRoute("profile")
    object Splash:NavRoute("splash_screen")
}
