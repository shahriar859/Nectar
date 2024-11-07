package com.shahriar.nectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.shahriar.nectar.R
import com.shahriar.nectar.components.CustomProductList
import com.shahriar.nectar.components.CustomRandomColoredItem
import com.shahriar.nectar.components.CustomViewPagerSlider
import com.shahriar.nectar.components.DebouncedSearchBar

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShopScreen(rootNavController: NavController, bottomNavController: NavController) {
    val shopNavController = rememberNavController()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier.padding(top = 20.dp),
            painter = painterResource(id = R.drawable.logo_colored),
            contentDescription = "nectar logo"
        )

        //  Set top logo and location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = "location logo")
            Spacer(modifier= Modifier.width(10.dp))
            Text(
                text = "Dhaka",      // From Location Screen
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Called the DebouncedSearchBar Composable and provide the onSearch callback
        DebouncedSearchBar { query ->
//            searchResult = "You searched for: $query"
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            CustomViewPagerSlider()     // Image Slider Composable

            Spacer(modifier = Modifier.height(35.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    text = "Exclusive Offer",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "See all",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_primary_color),
                    fontWeight = FontWeight.Bold,
                )
            }
            CustomProductList(shopNavController)

//        Best Selling component part
            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    text = "Best Selling",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "See all",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_primary_color),
                    fontWeight = FontWeight.Bold,
                )
            }
            CustomProductList(shopNavController)

//        Groceries Product list component
            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    text = "Groceries",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "See all",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.nectar_primary_color),
                    fontWeight = FontWeight.Bold,
                )
            }

//       Groceries Random Background Colored Row
            CustomRandomColoredItem(shopNavController)
            CustomProductList(shopNavController)
        }
    }
}