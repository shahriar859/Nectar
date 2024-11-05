package com.shahriar.nectar.route

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shahriar.nectar.screens.CartScreen
import com.shahriar.nectar.screens.ExploreScreen
import com.shahriar.nectar.screens.FavouriteScreen
import com.shahriar.nectar.screens.LogInScreen
import com.shahriar.nectar.screens.MapScreen
import com.shahriar.nectar.screens.OnboardingScreen
import com.shahriar.nectar.screens.PhoneNumberInputScreen
import com.shahriar.nectar.screens.ProfileScreen
import com.shahriar.nectar.screens.ShopScreen
import com.shahriar.nectar.screens.SignInScreen
import com.shahriar.nectar.screens.SignUpScreen
import com.shahriar.nectar.screens.SplashScreen
import com.shahriar.nectar.screens.VerificationScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.OnboardingScreen.route) {
            OnboardingScreen(navController)
        }
        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navController)
        }
        composable(route = Screens.PhoneNumberInputScreen.route) {
            PhoneNumberInputScreen(navController)
        }
        composable(route = Screens.VerificationScreen.route) {
            VerificationScreen(navController)
        }
        composable(route = Screens.MapScreen.route) {
            MapScreen(navController)
        }
        composable(route = Screens.LogInScreen.route) {
            LogInScreen(navController)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            bottomBar = { BottomNavigation(navController = navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Shop.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(BottomNavItem.Shop.route) { ShopScreen() }
                composable(BottomNavItem.Explore.route) { ExploreScreen() }
                composable(BottomNavItem.Cart.route) { CartScreen() }
                composable(BottomNavItem.Favourite.route) { FavouriteScreen() }
                composable(BottomNavItem.Account.route) { ProfileScreen() }
            }
        }
    }
}
