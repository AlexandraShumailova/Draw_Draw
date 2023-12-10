package com.example.draw_draw.data

class Booking (
    var ttItem: TTItem,
    var user: User,
)

val b1 = Booking(tt1, user0)
val b2 = Booking(tt2, user1)
val b3 = Booking(tt3, user2)
val b4 = Booking(tt4, user0)
val b5 = Booking(tt5, user0)
val b6 = Booking(tt6, user1)
val b7 = Booking(tt7, user0)
val b8 = Booking(tt8, user0)

var bookList = mutableListOf(b1,b2,b3,b4,b5,b6,b7, b8)
