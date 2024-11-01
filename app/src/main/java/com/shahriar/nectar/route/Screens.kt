package com.shahriar.nectar.route

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash_screen")
    data object OnboardingScreen : Screens("onboarding_screen")
    data object SignInScreen : Screens("sign_in_screen")
    data object PhoneNumberInputScreen : Screens("phone_number_input_screen")
    data object VerificationScreen : Screens("verification_screen")
    data object MapScreen : Screens("map_screen")
    data object LogInScreen : Screens("log_in_screen")
    data object SignUpScreen : Screens("sign_up_screen")
}