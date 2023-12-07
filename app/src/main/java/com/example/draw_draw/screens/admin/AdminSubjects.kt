package com.example.draw_draw.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminSubjectsScreen (){
    var color = Color.Gray
    val showAllFlag = remember {
        mutableStateOf(false)
    }
    val addNewFlag = remember {
        mutableStateOf(false)
    }
    val deleteFlag = remember {
        mutableStateOf(false)
    }
    Column {
        Row (modifier = Modifier
            .height(70.dp)
            .background(Color.DarkGray)){
            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                onClick = { color = Color.Green
                    showAllFlag.value = true
                    addNewFlag.value = false
                    deleteFlag.value = false},
                colors = ButtonDefaults.buttonColors(containerColor = color)) {
                Text(text = "Show all")
            }
            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                onClick = { color = Color.Green
                    showAllFlag.value = false
                    addNewFlag.value = true
                    deleteFlag.value = false},
                colors = ButtonDefaults.buttonColors(containerColor = color)) {
                Text(text = "Add new")
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
                Text(text = "Delete")
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

@Composable
fun ShowAllSubjects(){
    Column {
        Row (modifier = Modifier.height(70.dp)){
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .background(Color.White)
            ){
                Text(text = "Show all", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(2f)
                .height(70.dp)
            ){        }
        }
        Column {
            Text(text = "all")
        }
    }
}
@Composable
fun AddNewSubject(){
    Column {
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
                Text(text = "Add new", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier
                .weight(1f)
                .height(70.dp)
            ){}
        }
        Column {
            Text(text = "add")
        }
    }
}
@Composable
fun DeleteSubject(){
    Column {
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
                Text(text = "Delete", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
        Column {
            Text(text = "delete")
        }
    }
}