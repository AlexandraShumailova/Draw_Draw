package com.example.draw_draw.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.subjectList

@Preview
@Composable
fun SubjectScreen(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.Gray)
            .verticalScroll(rememberScrollState())
    ) {
        subjectList.forEach{subject ->
            Row (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(10.dp)
                    .border(border = BorderStroke(width = 1.dp, color = Color.Black))
            ){
                Column (
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                        .fillMaxHeight()
                        .border(border = BorderStroke(width = 1.dp, color = Color.Black))
                        .background(color = Color.White)
                ){
                    Image(
                        painter = painterResource(id = subject.photoId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()

                    )
                }


                Column (
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)
                        .fillMaxHeight()
                        .border(border = BorderStroke(width = 1.dp, color = Color.Black))
                        .background(color = Color.White)
                ){
                    Text(
                        text = subject.subjectName,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp),
                        color = Color.DarkGray,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = subject.decription,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp),
                        color = Color.Gray,
                    )
                }
            }
        }
    }
}