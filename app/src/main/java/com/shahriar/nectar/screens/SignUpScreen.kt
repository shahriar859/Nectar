package com.shahriar.nectar.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahriar.nectar.R
import com.shahriar.nectar.components.CustomButton
import com.shahriar.nectar.components.CustomDivider
import com.shahriar.nectar.components.CustomPasswordView
import com.shahriar.nectar.components.rememberImeState
import com.shahriar.nectar.route.Screens

@Composable
fun SignUpScreen(navController: NavController) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current    // Initialize FocusManager for managing focus and keyboard dismissal

    var userNameText by remember { mutableStateOf(TextFieldValue("")) }
    var userEmailText by remember { mutableStateOf(TextFieldValue("")) }
    var userPasswordText by remember { mutableStateOf(TextFieldValue("")) }
    val isImeVisible by rememberImeState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        //Background image
        Image(
            painter = painterResource(id = R.drawable.topbgtwo),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth().height(if (isImeVisible) 0.dp else 250.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bottombg),
            contentScale = ContentScale.Crop,
            contentDescription = "Bottom Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .align(Alignment.Center),
        ) {
            // Top spacing
            Spacer(modifier = Modifier.height(if (isImeVisible) 30.dp else 250.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Enter your credentials to continue",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(20.dp))

//          Get UserName
                Text(
                    text = "Username",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(15.dp))

                BasicTextField(
                    value = userNameText,
                    singleLine = true,
                    onValueChange = { newUserText ->
                        if (newUserText.text.length <= 30) {
                            userNameText = newUserText
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next // Specify "Done" action
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomDivider()
                Spacer(modifier = Modifier.height(20.dp))

//          Get Email
                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_gray_text_color)
                )
                Spacer(modifier = Modifier.height(15.dp))

                BasicTextField(
                    value = userEmailText,
                    singleLine = true,
                    onValueChange = { newEmailText ->
                        if (newEmailText.text.length <= 25) {
                            userEmailText = newEmailText
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                innerTextField() // This renders the actual text input field
                            }

                            // Only show the verified icon if the email is valid
                            if (android.util.Patterns.EMAIL_ADDRESS.matcher(userEmailText.text)
                                    .matches()
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.verifiedmark), // Verified email icon
                                    contentDescription = "Email Verified",
                                    modifier = Modifier.size(20.dp),
                                    tint = Color.Unspecified // Ensure the icon retains its original color
                                )
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
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
                    Spacer(modifier = Modifier.height(10.dp))

//                Annotated string
                    TermsAndPolicyText(
                        onTermsClicked = {
                            // Handle Terms of Service click
                            Log.d("Terms", "Terms of Service clicked")
                        },
                        onPrivacyClicked = {
                            // Handle Privacy Policy click
                            Log.d("Privacy", "Privacy Policy clicked")
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    CustomButton(
                        text = "Sign Up",
                        onClick = {
                            when {
                                userNameText.text.isEmpty() && userEmailText.text.isEmpty() && userPasswordText.text.isEmpty() -> {
                                    Toast.makeText(
                                        context,
                                        "Please enter a valid user name, email and password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                !android.util.Patterns.EMAIL_ADDRESS.matcher(userEmailText.text)
                                    .matches() -> {
                                    Toast.makeText(context, "Email is invalid.", Toast.LENGTH_SHORT)
                                        .show()
                                }

                                userPasswordText.text.length < 8 -> {
                                    Toast.makeText(
                                        context,
                                        "User Password must be at least 8 characters",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    navController.navigate(Screens.MapScreen.route)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        Text(
                            text = "Already have an account? ",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Login",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.nectar_primary_color),
                            modifier = Modifier.clickable {
                                focusManager.clearFocus()
                                navController.navigate(Screens.LogInScreen.route)

                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TermsAndPolicyText(onTermsClicked: () -> Unit, onPrivacyClicked: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_gray_text_color))) {
            append("By continuing you agree to our ")
        }

        // Annotate the "Terms of Service" text
        pushStringAnnotation(tag = "TERMS", annotation = "Terms of Service")
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_primary_color))) {
            append("Terms of Service")
        }
        pop()

        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_gray_text_color))) {
            append(" and ")
        }

        // Annotate the "Privacy Policy" text
        pushStringAnnotation(tag = "PRIVACY", annotation = "Privacy Policy")
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_primary_color))) {
            append("Privacy Policy")
        }
        pop()
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_gray_text_color))) {
            append(".")
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
                .firstOrNull()?.let {
                    onTermsClicked()
                }
            annotatedString.getStringAnnotations(tag = "PRIVACY", start = offset, end = offset)
                .firstOrNull()?.let {
                    onPrivacyClicked()
                }
        },
        modifier = Modifier.padding(8.dp)
    )
}