package com.example.draw_draw.screens.admin

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.RowScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.User
import com.example.draw_draw.data.newClient
import com.example.draw_draw.data.user1
import com.example.draw_draw.data.user2
import com.example.draw_draw.data.userList
import com.example.draw_draw.screens.TimetableItem

@Preview
@Composable
fun AdminClientsScreen(){
    var color = Color.Gray
    val goMenu = remember {
        mutableStateOf(false)
    }
    val showAllFlag = remember {
        mutableStateOf(false)
    }
    val addNewFlag = remember {
        mutableStateOf(false)
    }
    val deleteFlag = remember {
        mutableStateOf(false)
    }

    if(!goMenu.value){
        Column {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(start = 15.dp, end = 15.dp)
                    .clickable { goMenu.value = true },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription = "back")
                Text(text = "Клиенты студии",
                    color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold,)
                Spacer(modifier = Modifier.width(24.dp))
            }
            Row (modifier = Modifier
                .height(70.dp)
            ){
                Button(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f),
                    onClick = { color = Color.Green
                        showAllFlag.value = true
                        addNewFlag.value = false
                        deleteFlag.value = false},
                    colors = ButtonDefaults.buttonColors(containerColor = color)) {
                    Text(text = "Показать")
                }
                Button(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .weight(1f),
                    onClick = { color = Color.Green
                        showAllFlag.value = false
                        addNewFlag.value = true
                        deleteFlag.value = false},
                    colors = ButtonDefaults.buttonColors(containerColor = color)) {
                    Text(text = "Добавить")
                }
                Button(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f),
                    onClick = { color = Color.Green
                        showAllFlag.value = false
                        addNewFlag.value = false
                        deleteFlag.value = true},
                    colors = ButtonDefaults.buttonColors(containerColor = color)
                ) {
                    Text(text = "Удалить")
                }
            }
        }
        if (showAllFlag.value){
            Spacer(modifier = Modifier.height(40.dp))
            ShowAllClients()
        }
        if (addNewFlag.value){
            Spacer(modifier = Modifier.height(40.dp))
            AddNewClient()
        }
        if (deleteFlag.value){
            Spacer(modifier = Modifier.height(40.dp))
            DeleteClient()
        }
    }
    else{
        AdminMenuScreen()
    }

}

@Composable
fun HeadBackToAdmMenu(text: String) {
}

@Preview
@Composable
fun ShowAllClients(){
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Row (modifier = Modifier.height(70.dp)){
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .background(Color.White)
            ){
                Text(text = "Показать", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(2f)
                .height(70.dp)
            ){}
        }
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
            .fillMaxWidth()
        ){
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Список клиентов студии",
                color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold, )
            Spacer(modifier = Modifier.height(20.dp))
            Column ( modifier = Modifier
                .verticalScroll(rememberScrollState())
            ){
                userList.forEach{ item->
                    UserItem(item)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun UserItem(item: User){
    Card (modifier = Modifier
//        .clickable {}
    ){
        Row (modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth()
        ){
            Image(painter = painterResource(id = item.photoId),
                contentDescription = "photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column (){
                Text(
                    text = item.userName,
                    color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold, )
                Text(
                    text = item.login,
                    color = Color.DarkGray, fontSize = 20.sp, )
            }
            Spacer(modifier = Modifier.width(20.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun AddNewClient(){
    var context = LocalContext.current
    val login = remember {
        mutableStateOf(TextFieldValue())
    }
    val password = remember {
        mutableStateOf(TextFieldValue())
    }
    val name = remember {
        mutableStateOf(TextFieldValue())
    }
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Row (modifier = Modifier.height(70.dp)){
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
            ){}
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .background(Color.White)
            ){
                Text(text = "Добавить", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
            ){}
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)){
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                placeholder = { androidx.compose.material.Text(text = "Введите Имя") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = login.value,
                onValueChange = { login.value = it },
                placeholder = { androidx.compose.material.Text(text = "Логин") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { androidx.compose.material.Text(text = "Пароль") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    newClient.login=login.value.text
                    newClient.userName=name.value.text
                    newClient.password=password.value.text
                    userList.add(newClient)
                    Toast.makeText(context, "Клиент ДОБАВЛЕН", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                androidx.compose.material.Text(
                    text = "Добавить",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DeleteClient(){
    var context = LocalContext.current
    val login = remember {
        mutableStateOf(TextFieldValue())
    }
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Row (modifier = Modifier.height(70.dp)){
            Box(modifier = Modifier
                .weight(2f)
                .height(70.dp)
            ){        }
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .background(Color.White)
            ){
                Text(text = "Удалить", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray,fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)){
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = login.value,
                onValueChange = { login.value = it },
                placeholder = { androidx.compose.material.Text(text = "Логин") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    var user = userList.filter { it.login==login.value.text }.last()
//                    userList.indexOf(user)
                    userList.remove(user)
                    Toast.makeText(context, "Клиент УДАЛЕН", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                androidx.compose.material.Text(
                    text = "УДАЛИТЬ",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

