package com.shahriar.nectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shahriar.nectar.R
import com.shahriar.nectar.components.BottomBg
import com.shahriar.nectar.components.CustomDropDown
import com.shahriar.nectar.components.TopBg
import com.shahriar.nectar.route.Screens

@Composable
fun MapScreen(navController: NavController) {
    val zoneList = listOf("Types of your zone", "Bashundhara R/A", "Gulshan", "Baridhara")
    val zoneCurrentValue = remember { mutableStateOf(zoneList[0]) }
    val areaList = listOf("Types of your area", "Block A", "Block B", "Block C")
    val areaCurrentValue = remember { mutableStateOf(areaList[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            TopBg(navController)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter), // Align the content in the bottom half
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_map),
                        contentDescription = "Map Icon",
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = "Select Your Location",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Switch on your location to stay in tune with\n what’s happening in your area",
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.nectar_gray_text_color),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(80.dp))
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment =  Alignment.BottomCenter
        ) {
            BottomBg()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                CustomDropDown(
                    label = "Your Zone",
                    itemList = zoneList,
                    selectedItem = zoneCurrentValue
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomDropDown(
                    label = "Your Area",
                    itemList = areaList,
                    selectedItem = areaCurrentValue
                )
            }

            Box(
                modifier = Modifier
                    .padding(bottom = 65.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screens.HomeScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175)
                    ),
                    shape = RoundedCornerShape(19.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f) // Make the button 80% of the width
                        .height(65.dp)
                ) {
                    Text(text = "Submit", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }


}