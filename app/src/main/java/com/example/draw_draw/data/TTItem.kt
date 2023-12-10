package com.example.draw_draw.data

import com.example.draw_draw.R

class TTItem(
    var subject: Subject,
    var time: String,
    var day: String,
)
val tt1 = TTItem(sub1, "09:00", "пн")
val tt2 = TTItem(sub1, "09:00", "ср")
val tt3 = TTItem(sub1, "09:00", "пт")

val tt4 = TTItem(sub2, "12:00", "пн")
val tt5 = TTItem(sub2, "12:00", "ср")
val tt6 = TTItem(sub2, "12:00", "пт")

val tt7 = TTItem(sub3, "16:00", "пн")
val tt8 = TTItem(sub3, "16:00", "чт")
val tt9 = TTItem(sub3, "16:00", "сб")

val tt10 = TTItem(sub9, "19:00", "пн")
val tt11 = TTItem(sub9, "19:00", "вт")
val tt12 = TTItem(sub9, "19:00", "ср")
val tt13 = TTItem(sub9, "19:00", "чт")
val tt14 = TTItem(sub9, "19:00", "пт")
val tt15 = TTItem(sub9, "12:00", "вс")

val tt16 = TTItem(sub4, "12:00", "вт")
val tt17 = TTItem(sub4, "12:00", "чт")
val tt18 = TTItem(sub4, "10:00", "сб")

val tt19 = TTItem(sub5, "16:00", "вт")
val tt20 = TTItem(sub5, "17:00", "чт")
val tt21 = TTItem(sub5, "12:00", "сб")

val tt22 = TTItem(sub6, "10:00", "вт")
val tt23 = TTItem(sub6, "10:00", "чт")
val tt24 = TTItem(sub6, "10:00", "сб")

val tt25 = TTItem(sub8, "18:00", "вт")
val tt26 = TTItem(sub8, "18:00", "чт")
val tt27 = TTItem(sub8, "18:00", "сб")

val tt28 = TTItem(sub7, "12:00", "сб")
val tt29 = TTItem(sub7, "17:00", "вс")
val tt30 = TTItem(sub7, "12:00", "вс")


var ttList = mutableListOf(tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,
    tt11,tt12,tt13,tt14,tt15,tt16,tt17,tt18,tt19,tt20,
    tt21,tt22,tt23,tt24,tt25,tt26,tt27,tt28,tt29,tt30)

//var newItemTT = TTItem("","","")
//var curItemTT = TTItem("","","")