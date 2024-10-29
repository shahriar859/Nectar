package com.shahriar.nectar.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shahriar.nectar.screens.OnboardingScreen
import com.shahriar.nectar.screens.SignInScreen
import com.shahriar.nectar.screens.SplashScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route = Screens.OnboardingScreen.route) {
            OnboardingScreen(navController)
        }
        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navController)
        }
    }
}
