package com.example.draw_draw.data

import com.example.draw_draw.R

class TTItem(
    var subject: Subject,
    var time: String,
    var day: String,
)

val tt1 = TTItem(sub1, "09:00", "пн")
val tt2 = TTItem(sub2, "10:00", "пн")
val tt3 = TTItem(sub1, "09:00", "вт")
val tt4 = TTItem(sub3, "11:00", "вт")
val tt5 = TTItem(sub4, "12:00", "ср")
val tt6 = TTItem(sub1, "09:00", "чт")
val tt7 = TTItem(sub5, "13:00", "чт")
val tt8 = TTItem(sub3, "14:00", "пт")
val tt9 = TTItem(sub2, "10:00", "пт")
val tt10 = TTItem(sub1, "09:00", "пт")

var ttList = mutableListOf(tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10)

//var newItemTT = TTItem("","","")
//var curItemTT = TTItem("","","")