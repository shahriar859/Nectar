package com.shahriar.nectar.dummydata

import com.shahriar.nectar.R

data class SliderData(
   val title : String,
    val rating : Float,
    val desc : String,
    val imgUrl: Int
)


val sliderDataList = listOf(
    SliderData(
       "Discount groceries",
        4.0f,
        "These all Groceries are discounted 50%",
        R.drawable.groceries
    ),
    SliderData(
        "All fruits",
        5.0f,
        "These all Groceries are discounted 30%",
        R.drawable.topbgtwo
    ),
    SliderData(
        "All groceries",
        3.0f,
        "These all Groceries are discounted 20%",
        R.drawable.groceries
    ),
)