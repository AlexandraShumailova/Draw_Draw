package com.example.draw_draw.screens

import android.app.Activity
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.draw_draw.data.Booking
import com.example.draw_draw.data.bookList
import com.example.draw_draw.data.currentUser
import com.example.draw_draw.data.days
import com.example.draw_draw.data.subjectList
//import com.example.draw_draw.ClientActivity
import com.example.draw_draw.data.user1
import com.example.draw_draw.data.userType
import com.example.draw_draw.screens.admin.ShowBookings

@Preview
@Composable
fun ProfileScreen() {
    var text = remember {
        mutableStateOf("Next lesson")
    }
    val go = remember {
        mutableStateOf(false)
    }
    val seeBookings = remember {
        mutableStateOf(false)
    }
    if(!go.value){
        Column {
            Head("Your profile")
            Spacer(modifier = Modifier.height(20.dp))
            Column ( modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
            ){


                if (userType!="Admin"){
                    Row {
                        Image(painter = painterResource(id = user1.photoId),
                            contentDescription = "photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(40.dp))
                        Column (){
                            Text(
                                text = user1.userName,
                                color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold, )
                            Text(
                                text = /*"Login:"+"  "+ */user1.login,
                                color = Color.DarkGray, fontSize = 20.sp, )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    text.value = if (!seeBookings.value){
                        "Next lesson"
                    } else{
                        "My TT"
                    }
                    TimetableOnMain(text.value)

                    if(!seeBookings.value){
                        Column (modifier = Modifier
                            .height(250.dp)
                        ){
                            Spacer(modifier = Modifier.height(10.dp))
                            androidx.compose.material3.Button(
                                onClick = { seeBookings.value=true },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                            ) {
                                androidx.compose.material.Text(
                                    text = "See my bookings",
                                    textAlign = TextAlign.Center,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    else{
                        ShowMyBookings(list = bookList.filter { it.user== currentUser })
                        TextButton(
                            onClick = { seeBookings.value=false },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            androidx.compose.material.Text(
                                text = "close",
                                textAlign = TextAlign.Center,
                                color = Color.Gray
                            )
                        }
                    }
                }
                else{
                    ShowAdminStatus()
                }

                Spacer(modifier = Modifier.height(10.dp))
                androidx.compose.material3.Button(
                    onClick = { go.value = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    androidx.compose.material.Text(
                        text = "Log out",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
    else{
        HelloScreen()
    }

}

@Composable
fun ShowMyBookings(list: List<Booking>){
    Spacer(modifier = Modifier.height(10.dp))
    Column ( modifier = Modifier
        .height(210.dp)
        .verticalScroll(rememberScrollState())
        .fillMaxWidth()
    ){
        days.forEach{day->
            list.filter { it.ttItem.day==day.name }.sortedWith(compareBy{ it.ttItem.time }).forEach{item->
                MyBookItem(item)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun MyBookItem(item: Booking){
    Card (modifier = Modifier
    ){
        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .fillMaxWidth()
        ){
            Text(
                text = item.ttItem.subject.subjectName,
                color = Color.Black, fontSize = 20.sp )
            Text(
                text = item.ttItem.day+"   "+item.ttItem.time,
                color = Color.DarkGray, fontSize = 20.sp, )
        }
        Spacer(modifier = Modifier.width(20.dp))
    }
}

@Composable
fun ShowAdminStatus(){
    Card (modifier = Modifier
    ){
        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "Режим АДМИНИСТРАТОР",
                color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold,)
            Text(
                text = "Вам доступны специальные функции - меню на главном экране",
                color = Color.DarkGray, fontSize = 15.sp, )
        }
        Spacer(modifier = Modifier.width(20.dp))
    }
}

