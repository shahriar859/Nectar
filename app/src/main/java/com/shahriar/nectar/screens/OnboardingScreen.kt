package com.shahriar.nectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import com.shahriar.nectar.R
import com.shahriar.nectar.route.Screens

@Composable
fun OnboardingScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding),
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
                Image(
                    modifier = Modifier.padding(bottom = 16.dp),
                    painter = painterResource(id = R.drawable.logo),
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

                Button(
                    onClick = {
                        navController.navigate(Screens.SignInScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175)
                    ),
                    shape = RoundedCornerShape(19.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(65.dp)
                ) {
                    Text(text = "Get Started", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}