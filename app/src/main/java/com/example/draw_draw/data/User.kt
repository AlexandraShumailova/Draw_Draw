package com.example.draw_draw.data

import com.example.draw_draw.R

class User (
    var userName: String,
    var login: String,
    var password: String,
    var photoId: Int,
    var books: MutableList<TTItem>
)


val admin = User("Администратор", "admin", "1234", R.drawable.admin, ttList)

val user0 = User("Александра", "a_shumailova", "1234", R.drawable.alexandra, mutableListOf(tt1, tt2,tt3,tt4,tt5,tt6))
val user1 = User("user1", "user1", "123", R.drawable.avatar, mutableListOf(tt1, tt2,tt3,tt4,tt5,tt6))
val user2 = User("user2", "user2", "123", R.drawable.avatar, mutableListOf(tt1, tt2,tt3,tt4,tt5,tt6))

//var currentUser = User("", "", "", R.drawable.avatar, mutableListOf())
var currentUser = user0
var newClient = User("", "", "", R.drawable.avatar, mutableListOf())

var userType = " "

var userList = mutableListOf(user0, user1, user2)