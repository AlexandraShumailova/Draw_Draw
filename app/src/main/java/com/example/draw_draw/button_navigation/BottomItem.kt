package com.example.draw_draw.button_navigation

import com.example.draw_draw.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object Screen1: BottomItem("Главная", R.drawable.home, "screen1")
    object Screen2: BottomItem("Расписание", R.drawable.tt, "screen2")
    object Screen3: BottomItem("Предметы", R.drawable.subs, "screen3")
    object Screen4: BottomItem("Профиль", R.drawable.account, "screen4")

    object Screen1a: BottomItem("aHome", R.drawable.icon1, "screen1a")
    object Screen2a: BottomItem("aTimeTable", R.drawable.icon1, "screen2a")
    object Screen3a: BottomItem("aSubjects", R.drawable.icon1, "screen3a")
    object Screen4a: BottomItem("aProfile", R.drawable.icon1, "screen4a")
}
