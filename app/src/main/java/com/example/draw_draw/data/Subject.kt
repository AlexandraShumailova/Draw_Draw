package com.example.draw_draw.data

import com.example.draw_draw.R
import java.time.Duration

class Subject (
    var subjectName: String,
    var duration: String?,
    var teacher: String,
    var numberOfPeople: Int,
    var time: String,
    var day: String,
    var photoId: Int?,
    var decription: String?,
)

val sub1 = Subject("Sub1", "1 hour", "teacher name",
    30, "09:00","пн", R.drawable.subphoto, "bla bla bla")
val sub2 = Subject("Sub2", "1 hour", "teacher name",
    30, "10:00", "пн", R.drawable.subphoto, "bla bla bla")
val sub3 = Subject("Sub3", "1 hour", "teacher name",
    30, "09:00", "вт", R.drawable.subphoto, "bla bla bla")
val sub4 = Subject("Sub4", "1 hour", "teacher name",
    30, "09:00","ср", R.drawable.photo, "bla bla bla")
val sub5 = Subject("Sub5", "1 hour", "teacher name",
    30, "09:00","чт", R.drawable.photo, "bla bla bla")

var newSubject = Subject("","","", 30, "","", R.drawable.subphoto, "")

var curSubject = Subject("","","", 30, "","", R.drawable.subphoto, "")

var subjectList = mutableListOf(sub1, sub2, sub3, sub4, sub5)