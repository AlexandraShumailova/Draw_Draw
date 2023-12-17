package com.example.draw_draw.data

import androidx.compose.ui.graphics.Color
import com.example.draw_draw.R

class User (
    var userName: String,
    var login: String,
    var password: String,
    var photoId: Int,
    var books: MutableList<TTItem>
)


val admin = User("Администратор", "admin", "1234", R.drawable.admin, ttList)

val user0 = User("Александра", "a_shumailova", "1234", R.drawable.alexandra, mutableListOf())
val user1 = User("user1", "user1", "1234", R.drawable.avatar, mutableListOf())
val user2 = User("user2", "user2", "1234", R.drawable.avatar, mutableListOf())

var currentUser = user0
var newClient = User("", "", "", R.drawable.avatar, mutableListOf())

var userType = " "

var userList = mutableListOf(user0, user1, user2)