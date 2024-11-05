package com.shahriar.nectar.route

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shahriar.nectar.R


@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Shop,
        BottomNavItem.Explore,
        BottomNavItem.Cart,
        BottomNavItem.Favourite,
        BottomNavItem.Account
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Log.d("Route", currentRoute.toString())
    Box(
        modifier = Modifier
            .padding(start = 0.dp, end = 0.dp)
            .fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
        ) {
            NavigationBar(
                modifier = Modifier
                    .background(Color.White),
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                items.forEach { item ->
                    val selected = currentRoute == item.route

                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title,
                            )
                        },
                        label = {
                            Text(text = item.title)
                        },
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colorResource(id = R.color.nectar_primary_color),
                            selectedTextColor = colorResource(id = R.color.nectar_primary_color),
                            unselectedIconColor = colorResource(id = R.color.black),
                            unselectedTextColor = colorResource(id = R.color.black),
                            indicatorColor = Color.Transparent
                        )

                    )
                }
            }
        }
    }
}