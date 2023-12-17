package com.example.draw_draw.screens.admin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.draw_draw.data.newClient
import com.example.draw_draw.data.newSubject
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.userList
import com.example.draw_draw.screens.SubjectScreen

@Preview
@Composable
fun AdminSubjectsScreen (){
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
                Text(text = "Групповые занятия",
                    color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold,)
                Spacer(modifier = Modifier.width(24.dp))
            }
            Row (modifier = Modifier
                .height(70.dp)
//                .background(Color.DarkGray)
            ){
                Button(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f),
                    onClick = { color = Color(0, 108, 30)
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
                    onClick = { color = Color(0, 108, 30)
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
                    onClick = { color = Color(0, 108, 30)
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
            ShowAllSubjects()
        }
        if (addNewFlag.value){
            AddNewSubject()
        }
        if (deleteFlag.value){
            DeleteSubject()
        }
    }
    else{
        AdminMenuScreen()
    }
}

@Composable
fun ShowAllSubjects(){
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
            ){  }
        }
        Column {
            SubjectScreen()
        }
    }
}

@Preview
@Composable
fun AddNewSubject(){
    var context = LocalContext.current
    val subName = remember {
        mutableStateOf(TextFieldValue())
    }
    val duration = remember {
        mutableStateOf(TextFieldValue())
    }
    val description = remember {
        mutableStateOf(TextFieldValue())
    }
    val photo = remember {
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
                        .padding(vertical = 20.dp, horizontal = 10.dp),
                    color = Color.DarkGray,  fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
            ){}
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
            .verticalScroll(rememberScrollState())
        ){
            Card ( modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(10.dp))
            ){
                Text(text = "Фото", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = subName.value,
                onValueChange = { subName.value = it },
                placeholder = { androidx.compose.material.Text(text = "Название предмета") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = description.value,
                onValueChange = { description.value = it },
                placeholder = { androidx.compose.material.Text(text = "Описание") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = duration.value,
                onValueChange = { duration.value = it },
                placeholder = { androidx.compose.material.Text(text = "Длительность") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    newSubject.subjectName=subName.value.text
                    newSubject.decription=description.value.text
                    newSubject.duration=duration.value.text
                    subjectList.add(newSubject)
                    Toast.makeText(context, "ДОБАВЛЕН!", Toast.LENGTH_SHORT).show()
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
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun DeleteSubject(){
    var context = LocalContext.current
    val subName = remember {
        mutableStateOf(TextFieldValue())
    }
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Row (modifier = Modifier.height(70.dp)){
            Box(modifier = Modifier
                .weight(2f)
                .height(70.dp)
            ){  }
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .background(Color.White)
            ){
                Text(text = "Удалить", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)){
            Text(text = "Удалить")
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = subName.value,
                onValueChange = { subName.value = it },
                placeholder = { androidx.compose.material.Text(text = "Название предмета") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    var sub = subjectList.filter { it.subjectName==subName.value.text }.last()
//                    userList.indexOf(user)
                    subjectList.remove(sub)
                    Toast.makeText(context, "УДАЛЕН", Toast.LENGTH_SHORT).show()
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