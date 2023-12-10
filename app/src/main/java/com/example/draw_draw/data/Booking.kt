package com.example.draw_draw.data

class Booking (
    var ttItem: TTItem,
    var user: User,
)

//Alexandra
// maslo
val b1 = Booking(tt1, user0)
val b2 = Booking(tt2, user0)
val b3 = Booking(tt3, user0)
//tvorch
val b4 = Booking(tt11, user0)
val b5 = Booking(tt13, user0)
val b6 = Booking(tt15, user0)
//abstr
val b7 = Booking(tt9, user0)
val b8 = Booking(tt8, user0)

//user1
// maslo
val b11 = Booking(tt1, user1)
val b12 = Booking(tt2, user1)
val b13 = Booking(tt3, user1)
//landsc
val b14 = Booking(tt4, user1)
val b15 = Booking(tt5, user1)
//abstr
val b17 = Booking(tt16, user1)
val b18 = Booking(tt17, user1)
val b16 = Booking(tt18, user1)

//user2
// maslo
val b21 = Booking(tt1, user2)
//nat
val b22 = Booking(tt19, user2)
val b23 = Booking(tt20, user2)
//scul
val b24 = Booking(tt22, user2)
val b25 = Booking(tt23, user2)
//det
val b26 = Booking(tt28, user2)
val b27 = Booking(tt29, user2)
//tvorch
val b28 = Booking(tt15, user2)


var bookList = mutableListOf(b1,b2,b3,b4,b5,b6,b7,b8,
    b11,b12,b13,b14,b15,b16,b17,b18,
    b21,b22,b23,b24,b25,b26,b27,b28)
