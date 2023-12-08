package com.example.draw_draw.button_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.draw_draw.data.sub1
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.userType
import com.example.draw_draw.screens.Main
import com.example.draw_draw.screens.MenuScreen
import com.example.draw_draw.screens.ProfileScreen
import com.example.draw_draw.screens.SubjectCard
import com.example.draw_draw.screens.SubjectScreen
import com.example.draw_draw.screens.TeacherDB
import com.example.draw_draw.screens.TimetableScreen
import com.example.draw_draw.screens.TryDB
import com.example.draw_draw.screens.UsersDBScreens
import com.example.draw_draw.screens.admin.AdminClientsScreen
import com.example.draw_draw.screens.admin.AdminMenuScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "screen1" ){
        composable("screen1"){
            Main()
        }
        composable("screen2"){
            TimetableScreen(subjectList, userType)
        }
        composable("screen3"){
            SubjectScreen()
        }
        composable("screen4"){
            ProfileScreen()
        }
    }
}

/*
@Composable
fun NavGraphA(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "screen1a" ){
        composable("screen1a"){
            AdminMenuScreen()
        }
        composable("screen2a"){
            TimetableScreen(subjectList)
        }
        composable("screen3a"){
            SubjectScreen()
        }
        composable("screen4a"){
            ProfileScreen()
        }
    }
}*/
