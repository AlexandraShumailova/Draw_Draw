package com.example.draw_draw.button_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.draw_draw.data.sub1
import com.example.draw_draw.screens.Main
import com.example.draw_draw.screens.MenuScreen
import com.example.draw_draw.screens.SubjectCard
import com.example.draw_draw.screens.SubjectScreen
import com.example.draw_draw.screens.TeacherDB
import com.example.draw_draw.screens.TimetableScreen
import com.example.draw_draw.screens.TryDB
import com.example.draw_draw.screens.UsersDBScreens
import com.example.draw_draw.screens.admin.AdminClientsScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "screen1" ){
        composable("screen1"){
            Main()
        }
        composable("screen2"){
            TimetableScreen()
        }
        composable("screen3"){
            SubjectScreen()
        }
        composable("screen4"){
            SubjectCard(sub1)
        }
    }
}