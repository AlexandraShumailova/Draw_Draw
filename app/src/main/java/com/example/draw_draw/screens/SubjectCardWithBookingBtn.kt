package com.example.draw_draw.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.Booking
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.TTItem
import com.example.draw_draw.data.bookList
import com.example.draw_draw.data.currentUser
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.userType
import com.example.draw_draw.screens.admin.AdminBookings
import com.example.draw_draw.screens.admin.AdminMenuScreen
import com.example.draw_draw.screens.admin.ShowBookings

@Composable
fun SubjectCardWithBookingBtn (item: TTItem, currentList: List<TTItem>){
    var context = LocalContext.current
    val goBack = remember {
        mutableStateOf(false)
    }
    val goBookings = remember {
        mutableStateOf(false)
    }
    if(!goBack.value and !goBookings.value){
        Column {
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(start = 15.dp, end = 15.dp)
                    .clickable { goBack.value = true },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription = "back")
                Spacer(modifier = Modifier.width(24.dp))
            }
            Column (
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
                    .verticalScroll(rememberScrollState())
            ){
                Spacer(modifier = Modifier.height(15.dp))
                Image(painter = painterResource(id = item.subject.photoId!!),
                    contentDescription = "photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = item.subject.subjectName,
                    color = Color.Green, fontSize = 25.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Card(
                        backgroundColor = Color.Blue,
                    ){
                        Text(text = item.day + "   " + item.time,
                            modifier = Modifier.padding(8.dp),
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Card(
                        backgroundColor = Color.LightGray,
                    ){
                        Text(text = item.subject.duration!!,
                            modifier = Modifier.padding(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item.subject.decription!!,
                    color = Color.DarkGray, fontSize = 15.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))


                //book
                if(userType!="Admin"){
                    Button(
                        onClick = {/* add book to my booking list */
                            var newBook = Booking(item, currentUser)
                            currentUser.books.add(newBook.ttItem)
                            bookList.add(newBook)
                            Toast.makeText(context, "Вы успешно записались!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                    ) {
                        Text(
                            text = "Записаться!",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
                else{
                    Button(
                        onClick = {
                            goBookings.value=true
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                    ) {
                        Text(
                            text = "Посмотреть записи",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
            }
        }

    }
    else{
        if (goBack.value){
            TimetableScreen(currentList)
        }
        else{
            var books = bookList.filter { it.ttItem == item }
            ShowBookingsForThis(books, item, currentList)
        }

    }
}

@Composable
fun ShowBookingsForThis(books: List<Booking>, item: TTItem, currentList: List<TTItem>){
    val goBack = remember {
        mutableStateOf(false)
    }
    if (!goBack.value){
        Column {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(start = 15.dp, end = 15.dp)
                    .clickable { goBack.value = true },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(painter = painterResource(id = R.drawable.back_icon), contentDescription = "back")
                androidx.compose.material3.Text(
                    text = "Записи на это занятие",
                    color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(24.dp))
            }
            var sublist = subjectList.filter { it==item.subject }
            ShowBookings(books, sublist)
        }
    }
    else{
        SubjectCardWithBookingBtn(item, currentList)
    }
}