package com.example.draw_draw.screens.admin

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.Booking
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.User
import com.example.draw_draw.data.bookList
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.userList

@Preview
@Composable
fun AdminBookings (){
    var color = Color.Gray
    val showAllFlag = remember {
        mutableStateOf(true)
    }
    val goMenu = remember {
        mutableStateOf(false)
    }
    if (!goMenu.value){
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
                Text(text = "Все записи на занятия",
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold,)
                Spacer(modifier = Modifier.width(24.dp))
            }
            ShowBookings(bookList, subjectList)
        }
    }
    else{
        AdminMenuScreen()
    }

}

@Composable
fun ShowBookings(list: List<Booking>, sublist: List<Subject>){
    Column (modifier = Modifier
        .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
        .fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Column ( modifier = Modifier
            .verticalScroll(rememberScrollState())
        ){
            sublist.forEach{sub->
                Text(
                    text = sub.subjectName,
                    color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold, )
                Spacer(modifier = Modifier.height(15.dp))
                list.filter { it.ttItem.subject==sub }.sortedWith(compareBy{ it.ttItem.time }).forEach{ item->
                    BookItem(item)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun BookItem(item: Booking){
    Card (modifier = Modifier
    ){
        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .fillMaxWidth()
        ){
            Text(
                text = item.ttItem.day+"   "+item.ttItem.time,
                color = Color.DarkGray, fontSize = 20.sp, )
            Text(
                text = item.user.login,
                color = Color.Gray, fontSize = 20.sp )
        }
        Spacer(modifier = Modifier.width(20.dp))

    }
    Spacer(modifier = Modifier.height(10.dp))
}