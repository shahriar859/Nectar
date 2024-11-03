package com.shahriar.nectar.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahriar.nectar.R
import com.shahriar.nectar.components.CustomButton
import com.shahriar.nectar.components.CustomDivider
import com.shahriar.nectar.components.CustomEmailView
import com.shahriar.nectar.components.CustomPasswordView
import com.shahriar.nectar.route.Screens

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LogInScreen(navController: NavController) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var userEmailText by remember { mutableStateOf(TextFieldValue("")) }
    var userPasswordText by remember { mutableStateOf(TextFieldValue("")) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        // Fixed Background Images
        Image(
            painter = painterResource(id = R.drawable.topbgtwo),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.bottombg),
            contentScale = ContentScale.Crop,
            contentDescription = "Bottom Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        // Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .align(Alignment.Center),
        ) {
            // Top spacing
            Spacer(modifier = Modifier.height(250.dp))

            // Main content
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Login",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Enter your emails and password",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomEmailView(
                    emailText = userEmailText,
                    onTextChanged = { newText ->
                        userEmailText = newText
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomDivider()

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Password",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                CustomPasswordView(
                    passwordText = userPasswordText,
                    onTextChanged = { newText ->
                        userPasswordText = newText
                    }
                )
                CustomDivider()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 15.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Forgot Password?",
                            fontSize = 13.sp,
                        )
                    }

                    CustomButton(
                        text = "Login",
                        onClick = {
                            when {
                                userEmailText.text.isEmpty() && userPasswordText.text.isEmpty() -> {
                                    Toast.makeText(
                                        context,
                                        "Please enter a valid email and password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                !android.util.Patterns.EMAIL_ADDRESS.matcher(userEmailText.text).matches() -> {
                                    Toast.makeText(context, "Email is invalid.", Toast.LENGTH_SHORT).show()
                                }
                                userPasswordText.text.length < 8 -> {
                                    Toast.makeText(context, "User Password must be at least 8 character", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    //navController.navigate(Screens.HomeScreen.route)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Row {
                        Text(
                            text = "Don't have an account? ",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Signup",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.nectar_primary_color),
                            modifier = Modifier.clickable {
                                navController.navigate(Screens.SignUpScreen.route)
                            }
                        )
                    }
                }
            }

            // Bottom spacing
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}