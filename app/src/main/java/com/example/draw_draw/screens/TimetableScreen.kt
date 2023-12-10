package com.example.draw_draw.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.TTItem
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.userType

@Composable
fun TimetableScreen(currentList: List<TTItem>){
    val goSubCardBook = remember {
        mutableStateOf<TTItem?>(null)
    }
    if (goSubCardBook.value==null){
        Column {
            Head("Timetable")
            Spacer(modifier = Modifier.height(10.dp))
            ChoseDay(currentList, goSubCardBook)
        }
    }
    else{
        SubjectCardWithBookingBtn(item = goSubCardBook.value!!, currentList)
    }
}

@Composable
fun ChoseDay(list: List<TTItem>, go: MutableState<TTItem?>){
    val goDayFlag = remember {
        mutableStateOf<String?>(null)
    }
    val color = remember { mutableStateOf(Color.White) }
    val days = listOf("пн","вт","ср","чт","пт","сб","вс")
    val datas = listOf("11","12","13","14","15","16","17")

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(horizontal = 10.dp)
    ){
        days.forEach{day ->
            Card(border = BorderStroke(1.dp, Color.LightGray),
                colors = CardDefaults.cardColors(
                    containerColor = color.value,
                ),
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
                    .height(60.dp)
                    .clickable { goDayFlag.value = day }

            ){
                Column (
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = day,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        color = Color.DarkGray,
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                    /*Text(
                        text = day,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(),
                        color = Color.Gray,
                        fontSize = 20.sp
                    )*/
                }
            }
        }
    }
    if (goDayFlag.value!=null){
        TimetableOfDay(goDayFlag.value!!, list, go)
    }
}

@Composable
fun TimetableOfDay (day: String, list: List<TTItem>, go: MutableState<TTItem?>){
    var listForDay = list.filter { it.day == day }
    Column ( modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
        .fillMaxWidth()
        .fillMaxHeight()
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = day,
            color = Color.DarkGray,
            fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        listForDay.forEach{ item->
            TimetableItem(item, go)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun TimetableItem(item:TTItem, goSubToBook: MutableState<TTItem?>){
        Card (modifier = Modifier
            .clickable { goSubToBook.value = item}
        ){
            Column(modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .fillMaxWidth()
            ) {
                Text(
                    text = item.time,
                    color = Color.Green,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = item.subject.subjectName,
                    color = Color.DarkGray,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = item.subject.duration!!,
                    color = Color.Gray,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
}

