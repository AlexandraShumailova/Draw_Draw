package com.example.draw_draw.data

import com.example.draw_draw.R

class User (
    var userName: String,
    var login: String,
    var password: String,
    var photoId: Int,
)

val user0 = User("Alexandra", "user.login", "123", R.drawable.avatar)
val user1 = User("user1", "user1.login", "123", R.drawable.avatar)
val user2 = User("user2", "user2.login", "123", R.drawable.avatar)

var currentUser = User("", "", "", R.drawable.avatar)
var newClient = User("", "", "", R.drawable.avatar)

var userType = " "

var userList = mutableListOf(user0, user1, user2)