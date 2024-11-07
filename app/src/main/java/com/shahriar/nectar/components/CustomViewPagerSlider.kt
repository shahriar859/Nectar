package com.shahriar.nectar.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.shahriar.nectar.R
import com.shahriar.nectar.dummydata.sliderDataList
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@ExperimentalPagerApi
@Composable
fun CustomViewPagerSlider(){

    val pagerState  = rememberPagerState(
        pageCount = sliderDataList.size,
        initialPage =  0,
        infiniteLoop = true
    )

    LaunchedEffect(Unit){
        while (true){
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    HorizontalPager(state = pagerState,
        modifier = Modifier
            .height(130.dp)
            .background(Color.Transparent)
            .clip(RoundedCornerShape(10.dp)),
        itemSpacing = 1.dp
    ) { page ->
        Card(modifier = Modifier
            .fillMaxWidth(.9f)
            .background(Color.Transparent)
            .align(Alignment.Center),
            shape = RoundedCornerShape(10.dp),
        ) {

            val newDataList = sliderDataList[page]
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(
                    id = newDataList.imgUrl
                ),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
//                    Text(
//                        text = newDataList.title,
//                        fontSize = 15.sp,
//                        modifier = Modifier
//                            .padding(bottom = 18.dp)
//                            .align(Alignment.BottomCenter)
//
//                    )

                //Horizontal dot indicator
                HorizontalPagerIndicator(
                    pagerState = pagerState,modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(10.dp),
                    activeColor = colorResource(id = R.color.nectar_primary_color),
                    spacing = 7.dp,
                    indicatorWidth = 6.dp
                )
            }
        }
    }
}
