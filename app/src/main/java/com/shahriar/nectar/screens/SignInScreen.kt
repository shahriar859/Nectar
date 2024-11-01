package com.shahriar.nectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shahriar.nectar.R
import com.shahriar.nectar.components.BottomBg
import com.shahriar.nectar.route.Screens

@Composable
fun SignInScreen(navController: NavHostController) {
    var text by remember { mutableStateOf(TextFieldValue("+880")) }
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val topImage = painterResource(id = R.drawable.groceries)
        Image(
            painter = topImage,
            contentDescription = "top bar image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(374.15.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Get your groceries\nwith nectar",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp),
                textAlign = TextAlign.Start,
                lineHeight = 30.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.flag),
                    contentDescription = "Flag",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))

                // Navigate to screen when focused
                BasicTextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState ->
                            if (focusState.isFocused && !isFocused) {
                                isFocused = true
                                navController.navigate(Screens.PhoneNumberInputScreen.route)
                            }
                        },
                    textStyle = TextStyle(color = Color.Black),
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            HorizontalDivider(
                color = colorResource(id = R.color.nectar_gray_color),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 0.dp)
            )

//            Social media buttons
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                BottomBg()

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Or connect with social media",
                        color = colorResource(id = R.color.nectar_gray_text_color)
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    SocialMediaButton(
                        text = "Continue with Google",
                        backgroundColor = colorResource(id = R.color.google_btn_background_color), // Google blue color
                        icon = R.drawable.google // replace with a Google icon
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    SocialMediaButton(
                        text = "Continue with Facebook",
                        backgroundColor = colorResource(id = R.color.fb_btn_background_color), // Facebook blue color
                        icon = R.drawable.facebook // replace with a Facebook icon
                    )
                }
            }
        }
    }
}

// Social Media Buttons handling
@Composable
fun SocialMediaButton(text: String, backgroundColor: Color, icon: Int) {
    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(backgroundColor),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(67.dp),
        shape = RoundedCornerShape(19.dp)
    ) {

        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}