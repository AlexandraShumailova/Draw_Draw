package com.example.draw_draw.data

import java.net.PasswordAuthentication

data class CourseModel(
    // on below line we are creating variables for name and job
    var courseName: String,
    var courseDuration: String,
    var courseTracks: String,
    var courseDescription: String
)

data class UserModel(
    var userName: String,
    var login: String,
    var password: String,
    var photo: String
)

data class TeacherModel(
    // on below line we are creating variables for name and job
    var name: String,
    var description: String,
    var photo: String
)
