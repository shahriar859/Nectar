package com.shahriar.nectar.route

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash_screen")
    data object OnboardingScreen : Screens("onboarding_screen")
    data object SignInScreen : Screens("sign_in_screen")
}