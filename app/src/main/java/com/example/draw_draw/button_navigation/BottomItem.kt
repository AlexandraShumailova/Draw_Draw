package com.example.draw_draw.button_navigation

import com.example.draw_draw.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object Screen1: BottomItem("Home", R.drawable.icon1, "screen1")
    object Screen2: BottomItem("TimeTable", R.drawable.icon1, "screen2")
    object Screen3: BottomItem("Subjects", R.drawable.icon1, "screen3")
    object Screen4: BottomItem("Profile", R.drawable.icon1, "screen4")

    object Screen1a: BottomItem("aHome", R.drawable.icon1, "screen1a")
    object Screen2a: BottomItem("aTimeTable", R.drawable.icon1, "screen2a")
    object Screen3a: BottomItem("aSubjects", R.drawable.icon1, "screen3a")
    object Screen4a: BottomItem("aProfile", R.drawable.icon1, "screen4a")
}
