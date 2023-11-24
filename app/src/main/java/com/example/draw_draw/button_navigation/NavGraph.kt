package com.example.draw_draw.button_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "screen1" ){
        composable("screen1"){
            Screen1()
        }
        composable("screen2"){
            Screen2()
        }
        composable("screen3"){
            Screen3()
        }
        composable("screen4"){
            Screen4()
        }
    }
}