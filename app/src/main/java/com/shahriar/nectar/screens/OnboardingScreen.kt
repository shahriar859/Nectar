package com.shahriar.nectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shahriar.nectar.R
import com.shahriar.nectar.components.GlobalButton
import com.shahriar.nectar.route.Screens

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val painter = painterResource(id = R.drawable.onboarding)
        Image(
            painter = painter,
            contentDescription = "OnBoarding Screen background picture",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp)

            ) {
                val logoPainter = painterResource(id = R.drawable.logo)
                Image(
                    modifier = Modifier.padding(bottom = 16.dp),
                    painter = logoPainter,
                    contentDescription = "Nectar Logo"
                )
                Text(
                    text = "Welcome\n to our store",
                    color = Color.White,
                    fontSize = 47.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    lineHeight = 52.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "Ger your groceries in as fast as one hour",
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                )

                GlobalButton(
                    text = "Get Started",
                    onClick = {
                        navController.navigate(Screens.SignInScreen.route)
                    }
                )
            }
        }
    }
}