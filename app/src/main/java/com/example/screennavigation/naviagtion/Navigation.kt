package com.example.screennavigation.naviagtion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.screennavigation.screens.detailscreen.DetailScreen
import com.example.screennavigation.screens.loginscreen.LoginScreenApp
import com.example.screennavigation.screens.onboadring.OnboardingScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.OnBoardingScreen.route) {
        composable(
            route = Screens.OnBoardingScreen.route
        ){
            OnboardingScreen(navController)
        }

        composable(route = Screens.LoginScreen.route) {
            LoginScreenApp(navController = navController)
        }
        composable(
            route = Screens.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument(
                    name  = "name"
                ){
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "Jishnu"
                }
            )
//                    + "/{name}",
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                    nullable = true
//                    defaultValue = "Jishnu"
//                }
//            )
        ) {
            DetailScreen(data = it.arguments?.getString("name"))
        }
    }
}