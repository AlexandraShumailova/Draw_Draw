package com.example.draw_draw.screens

//import com.example.draw_draw.button_navigation.MainScreenA
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.button_navigation.MainScreen
import com.example.draw_draw.data.admin
import com.example.draw_draw.data.currentUser
import com.example.draw_draw.data.user0
import com.example.draw_draw.data.userList
import com.example.draw_draw.data.userType

var darkGreen = Color(0, 108, 30)

@Composable
fun HelloScreen(){
    var context = LocalContext.current
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
                Text(
                    text = "Добро пожаловать в Draw_Draw!",
                    color = darkGreen, fontSize = 30.sp, fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = login.value,
                onValueChange = { login.value = it },
                placeholder = { Text(text = "Введите логин") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text(text = "Пароль") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    var users = userList.filter { it.login==login.value.text }
                    if (users.isNotEmpty()){
                        var user = users.last()
                        if (password.value.text==user.password) {
                            goClientFlag.value = true
                            currentUser=user
                        }
                        else {
                            Toast.makeText(context, "Данные неверны. Попробуйте еще раз!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        Toast.makeText(context, "Данные неверны. Попробуйте еще раз!", Toast.LENGTH_SHORT).show()
                    }
                    /*goClientFlag.value = true
                    currentUser=user0*/
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = "Войти",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }

            TextButton(
                onClick = {
                    if (login.value.text=="admin") {
                        if (password.value.text== admin.password){
                            goAdminFlag.value = true
                            currentUser= admin
                        }
                        else {
                            Toast.makeText(context, "Данные неверны. Попробуйте еще раз!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else {
                        Toast.makeText(context, "Данные неверны. Попробуйте еще раз!", Toast.LENGTH_SHORT).show()
                    }
                    /*goAdminFlag.value = true
                    currentUser= admin*/
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Войти как администратор",
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
