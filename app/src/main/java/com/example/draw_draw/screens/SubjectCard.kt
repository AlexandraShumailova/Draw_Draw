package com.example.draw_draw.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.subjectList


@Composable
fun SubjectCard(item: Subject){
    val goBackFlag = remember {
        mutableStateOf(false)
    }
    Column {
        BackHeader()
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
            Text(
                text = item.decription,
                color = Color.Gray, fontSize = 10.sp,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                backgroundColor = Color.Gray,
            ){
                Text(text = item.duration,
                    modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = "Booking",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
    if (goBackFlag.value){
        //back
    }
}

@Composable
fun BackHeader() {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(color = Color.Gray),
    ) {
        Text(
            text = "back",
            color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
        )
    }
}