package com.shahriar.nectar.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahriar.nectar.R
import com.shahriar.nectar.components.TopBg
import com.shahriar.nectar.components.CustomDivider
import com.shahriar.nectar.components.FloatingNextButton
import com.shahriar.nectar.route.Screens

@Composable
fun VerificationScreen(navController: NavController) {
    var otpCode by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    // Get screen dimensions
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier.fillMaxSize()
            .pointerInput(Unit) {
                // Clear focus when the screen is touched without showing visual effects
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        TopBg(navController)     // Get the reusable TopBackground Component

        // Automatically request focus when the screen loads
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.375f)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Enter your 4-digit code",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Code",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )

                BasicTextField(
                    value = otpCode,
                    maxLines = 1,
                    onValueChange = {
                        if(it.length <= 4){
                            otpCode = it
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done // Specify "Done" action
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus() // Optionally clear focus
                    })
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        repeat(4){ index ->
                            val number = when{
                                index >= otpCode.length -> "-"
                                else -> otpCode[index]
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = number.toString(),
                                    fontSize = 15.sp,
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }

                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                CustomDivider()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(end = screenWidth * 0.05f, bottom = screenHeight * 0.02f)
                .imePadding() // Automatically adjust padding when keyboard appears
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Resend Code",
                    color = colorResource(id = R.color.nectar_primary_color),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 15.dp)
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                FloatingNextButton(
                    onClick = {
                        focusManager.clearFocus()
                        navController.navigate(Screens.MapScreen.route)
                    }
                )
            }
        }
    }
}