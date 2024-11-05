package com.shahriar.nectar.route

import com.shahriar.nectar.R

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash_screen")
    data object OnboardingScreen : Screens("onboarding_screen")
    data object SignInScreen : Screens("sign_in_screen")
    data object PhoneNumberInputScreen : Screens("phone_number_input_screen")
    data object VerificationScreen : Screens("verification_screen")
    data object MapScreen : Screens("map_screen")
    data object LogInScreen : Screens("log_in_screen")
    data object SignUpScreen : Screens("sign_up_screen")
    data object HomeScreen : Screens("home_screen")
}

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Shop : BottomNavItem("shop", "Shop", R.drawable.ic_shop)
    object Explore : BottomNavItem("explore", "Explore", R.drawable.ic_explore)
    object Cart : BottomNavItem("cart", "Cart", R.drawable.ic_cart)
    object Favourite : BottomNavItem("favourite", "Favourite", R.drawable.ic_favourite)
    object Account : BottomNavItem("account", "Account", R.drawable.ic_profile)
}