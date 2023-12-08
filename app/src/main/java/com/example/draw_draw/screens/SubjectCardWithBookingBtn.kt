package com.example.draw_draw.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.data.Subject

@Composable
fun SubjectCardWithBookingBtn (item: Subject, goBack: ()->Unit){
    val goBackFlag = remember {
        mutableStateOf(false)
    }
    Column {
        Column (
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
//                .verticalScroll(rememberScrollState())
            ){
                Spacer(modifier = Modifier.height(15.dp))
                Image(painter = painterResource(id = item.photoId),
                    contentDescription = "photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = item.subjectName,
                    color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Card(
                        backgroundColor = Color.Gray,
                    ){
                        Text(text = item.day + "   " + item.time,
                            modifier = Modifier.padding(8.dp))
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Card(
                        backgroundColor = Color.LightGray,
                    ){
                        Text(text = item.duration,
                            modifier = Modifier.padding(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item.decription,
                    color = Color.Gray, fontSize = 10.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {/* add book to my booking list */},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                ) {
                    Text(
                        text = "Book!",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
}