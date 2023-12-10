package com.example.draw_draw.data

class Day (
    var name: String,
    var id: Int,
)

val d1 = Day("пн", 1)
val d2 = Day("вт", 2)
val d3 = Day("ср", 3)
val d4 = Day("чт", 4)
val d5 = Day("пт", 5)
val d6 = Day("сб", 6)
val d7 = Day("вс", 7)

val days = listOf(d1,d2,d3,d4,d5,d6,d7)