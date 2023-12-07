package com.example.draw_draw.data

import com.example.draw_draw.R

class Teacher (
    var teacherName: String,
    var photoId: Int,
    var decription: String,
)

val teach1 = Teacher("Teacher 1",  R.drawable.avatar, "bla bla bla")
val teach2 = Teacher("Teacher 2",  R.drawable.avatar, "bla bla bla")
val teach3 = Teacher("Teacher 3",  R.drawable.avatar, "bla bla bla")
val teach4 = Teacher("Teacher 4",  R.drawable.avatar, "bla bla bla")
val teach5 = Teacher("Teacher 5",  R.drawable.avatar, "bla bla bla")
val teach6 = Teacher("Teacher 6",  R.drawable.avatar, "bla bla bla")

var teacherList = listOf(teach1, teach2, teach3, teach4, teach5, teach6)