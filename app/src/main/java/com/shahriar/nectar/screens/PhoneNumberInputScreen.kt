package com.shahriar.nectar.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahriar.nectar.components.TopBg
import com.shahriar.nectar.components.FloatingNextButton
import com.shahriar.nectar.R
import com.shahriar.nectar.components.CustomDivider
import com.shahriar.nectar.route.Screens

@Composable
fun PhoneNumberInputScreen(navController: NavController) {
    var phoneNumberText by remember { mutableStateOf(TextFieldValue("+880")) }
    val focusManager = LocalFocusManager.current    // Initialize FocusManager for managing focus and keyboard dismissal
    val focusRequester = remember { FocusRequester() }     // Initialize FocusRequester

    // Get screen dimensions
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()     // Request focus when the screen opens
        phoneNumberText = phoneNumberText.copy(selection = TextRange(phoneNumberText.text.length))     // Set cursor at end
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .pointerInput(Unit) {
                // Clear focus when the screen is touched without showing visual effects
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        TopBg(navController)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.36f)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Enter your mobile number",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Mobile Number",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.flag),
                        contentDescription = "Bangladesh Flag",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    BasicTextField(
                        value = phoneNumberText,
                        maxLines = 1,
                        minLines = 1,
                        onValueChange = { newPhoneNoText ->
                            if (newPhoneNoText.text.length <= 14) {
                                phoneNumberText = newPhoneNoText.copy(
                                    //selection = TextRange(newPhoneNoText.text.length) // Cursor at end
                                )
                            }// Only update the text if it's within the limit
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester), // Apply the focusRequester
                        textStyle = TextStyle(color = Color.Black),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done // Specify "Done" action
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                CustomDivider()
            }
        }

        Box(
            modifier = Modifier
                .padding(end = screenWidth * 0.05f, bottom = screenHeight * 0.02f)
                .align(Alignment.BottomEnd)
                .imePadding() // Automatically adjust padding when keyboard appears
        ) {
            FloatingNextButton(
                onClick = {
                    when {
                        phoneNumberText.text.isEmpty() || phoneNumberText.text.length != 14 || !phoneNumberText.text.startsWith("+8801") -> {
                            Toast.makeText(
                                navController.context,
                                "Please enter a valid mobile number",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        android.util.Patterns.PHONE.matcher(phoneNumberText.text).matches() -> {
                            focusManager.clearFocus()
                            navController.navigate(Screens.VerificationScreen.route)
                        }

                        else -> {
                            Toast.makeText(
                                navController.context,
                                "Phone Number is invalid.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            )
        }
    }
}
