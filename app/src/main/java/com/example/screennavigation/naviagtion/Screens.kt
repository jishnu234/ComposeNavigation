package com.example.screennavigation.naviagtion

sealed class Screens(val route: String) {
    object LoginScreen : Screens("main_screen")
    object DetailScreen : Screens("detail_screen")
    object OnBoardingScreen: Screens("on_boarding_screen")

    fun withArgs(vararg args: String): String =
        buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
}
