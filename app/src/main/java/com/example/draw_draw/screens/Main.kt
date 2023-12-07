package com.example.draw_draw.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.teacherList

@Preview
@Composable
fun Main(){
    Column {
        Head("Draw Draw")
        Column ( modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
        ){
            Spacer(modifier = Modifier.height(10.dp))
            TimetableOnMain()
            Spacer(modifier = Modifier.height(10.dp))
            GroupLessons()
            Spacer(modifier = Modifier.height(10.dp))
            //Teachers()
            BookButton()
        }
    }

}

@Composable
fun Head(text: String) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(color = Color.Gray)
    ) {
        Text(text = text,
            color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold,)
    }
}

@Composable
fun Space(){
    Row(
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(color = Color.DarkGray)
    ) {    }
}

@Composable
fun TimetableOnMain() {
    Text(
        text = "Next lesson",
        color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.height(10.dp))
    Card {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Subject 1",
                modifier = Modifier.padding(4.dp),
                color = Color.Black, textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "09:00" + " " + "Monday",
                modifier = Modifier.padding(4.dp),
                color = Color.Black, textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@Composable
fun GroupLessons(){
    Text(
        text = "Group lesson",
        color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        //Text("Group Lessons", modifier = Modifier.weight(1f))
        subjectList.forEach{subject ->
            Card (modifier = Modifier.clickable {  }){
                Column (modifier = Modifier
                    .padding(10.dp)
                ){
                    Image(painter = painterResource(id = subject.photoId),
                        contentDescription = "photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .height(160.dp)
                            .width(240.dp))

                    Text(
                        text = "Subject 1",
                        color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "bla bla bla",
                        color = Color.Gray, fontSize = 10.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun Teachers(){
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.Gray)
            .horizontalScroll(rememberScrollState())
    ) {
        teacherList.forEach{teacher ->
            Column ( modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                    )
                )
                .padding(5.dp)
                .width(150.dp)
                .fillMaxHeight()
                .border(border = BorderStroke(width = 1.dp, color = Color.Black))
                .background(color = Color.White)
            ){
                Image(painter = painterResource(id = teacher.photoId),
                    contentDescription = "photo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp))
                Text(
                    text = teacher.teacherName,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp),
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BookButton(){
    Button(onClick = { },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
        Text(text = "Booking",
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}