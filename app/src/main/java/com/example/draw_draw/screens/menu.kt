package com.example.draw_draw.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
//import com.example.draw_draw.ui.theme.ViewCourses
import androidx.compose.ui.platform.LocalContext
//import com.example.draw_draw.ui.theme.UsersActivity

@SuppressLint("UnrememberedMutableState")
@Composable
fun MenuScreen(
    context: Context
){
    var showUsers = mutableStateOf(false)
    Column {
        Button(onClick = { showUsers.value = true }) {
            // on below line adding a text for our button.
            Text(text = "Read Users", color = Color.White)
        }
    }
    tryReadDataFromDatabase(context)

}