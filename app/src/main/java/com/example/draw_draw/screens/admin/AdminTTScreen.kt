package com.example.draw_draw.screens.admin

import android.widget.Toast
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
import com.example.draw_draw.data.TTItem
import com.example.draw_draw.data.newSubject
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.ttList
import com.example.draw_draw.screens.TimetableScreen

@Preview
@Composable
fun AdminTTScreen (){
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
    val goMenu = remember {
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
                Text(text = "TT",
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold,)
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
            ShowAllTT()
        }
        if (addNewFlag.value){
            AddNewTT()
        }
        if (deleteFlag.value){
            DeleteTT()
        }
    }
    else{
        AdminMenuScreen()
    }


}
@Preview
@Composable
fun ShowAllTT(){
    Column {
        Spacer(modifier = Modifier.height(40.dp))
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
        TimetableScreen(currentList = ttList)
    }
}

@Composable
fun AddNewTT(){
    var context = LocalContext.current
    val subName = remember {
        mutableStateOf(TextFieldValue())
    }
    val day = remember {
        mutableStateOf(TextFieldValue())
    }
    val time = remember {
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
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
            .verticalScroll(rememberScrollState())
        ){
            TextField(
                value = subName.value,
                onValueChange = { subName.value = it },
                placeholder = { androidx.compose.material.Text(text = "Enter Sub Name") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = day.value,
                onValueChange = { day.value = it },
                placeholder = { androidx.compose.material.Text(text = "Description") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = time.value,
                onValueChange = { time.value = it },
                placeholder = { androidx.compose.material.Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    var sub = subjectList.filter { it.subjectName==subName.value.text}.last()
                    var newItemTT = TTItem(sub,day.value.text,time.value.text)
                    ttList.add(newItemTT)
                    Toast.makeText(context, "TT Added to Database", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                androidx.compose.material.Text(
                    text = "Add",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
@Composable
fun DeleteTT(){
    var context = LocalContext.current
    val subName = remember {
        mutableStateOf(TextFieldValue())
    }
    val day = remember {
        mutableStateOf(TextFieldValue())
    }
    val time = remember {
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
                Text(text = "Delete", textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
            .verticalScroll(rememberScrollState())
        ){
            TextField(
                value = subName.value,
                onValueChange = { subName.value = it },
                placeholder = { androidx.compose.material.Text(text = "Enter Sub Name") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = day.value,
                onValueChange = { day.value = it },
                placeholder = { androidx.compose.material.Text(text = "Description") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = time.value,
                onValueChange = { time.value = it },
                placeholder = { androidx.compose.material.Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                onClick = {
                    var sub = subjectList.filter { it.subjectName==subName.value.text}.last()
                    var item = TTItem(sub,day.value.text,time.value.text)
                    ttList.remove(item)
                    Toast.makeText(context, "TT DELETED", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                androidx.compose.material.Text(
                    text = "delete",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}