package com.example.draw_draw.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.MainActivity
import com.example.draw_draw.button_navigation.MainScreen
import com.example.draw_draw.data.userType
//import com.example.draw_draw.button_navigation.MainScreenA
import com.example.draw_draw.screens.admin.AdminMenuScreen

@Composable
fun HelloScreen(){
    val login = remember {
        mutableStateOf(TextFieldValue())
    }
    val password = remember {
        mutableStateOf(TextFieldValue())
    }
    val goClientFlag = remember {
        mutableStateOf(false)
    }
    val goAdminFlag = remember {
        mutableStateOf(false)
    }
    if (!goClientFlag.value and !goAdminFlag.value) {
        Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp, bottom = 60.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Welcome to Draw_Draw!",
                    color = Color.Green, fontSize = 40.sp, fontWeight = FontWeight.Bold,)
            }
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = login.value,
                onValueChange = { login.value = it },
                placeholder = { Text(text = "Enter Login") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = { goClientFlag.value = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = "Log In",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }

            TextButton(
                onClick = { goAdminFlag.value = true },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Log in as an admin",
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
        }
    }
    if (goClientFlag.value){
        goAdminFlag.value = false
        userType="Client"
        MainScreen()

    }

    if (goAdminFlag.value){
        goClientFlag.value = false
        userType="Admin"
        MainScreen()
    }
}
