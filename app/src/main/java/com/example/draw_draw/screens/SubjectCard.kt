package com.example.draw_draw.screens

import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.curSubject
import com.example.draw_draw.data.newSubject
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.ttList
import com.example.draw_draw.data.userType

@Composable
fun SubjectCard(item: Subject, from: String){
    val goBack = remember {
        mutableStateOf(false)
    }
    val go = remember {
        mutableStateOf<Subject?>(null)
    } //to TT

    if(!goBack.value){
        if (go.value==null){
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
//                .verticalScroll(rememberScrollState())
                ){
                    Spacer(modifier = Modifier.height(15.dp))
                    Image(painter = painterResource(id = item.photoId!!),
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
                    Card(
                        backgroundColor = Color.Gray,
                    ){
                        Text(text = item.duration!!,
                            modifier = Modifier.padding(8.dp),
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = item.decription!!,
                        color = Color.Gray, fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    androidx.compose.material3.Button(
                        onClick = { go.value = item},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                    ) {
                        androidx.compose.material.Text(
                            text = if (userType=="Admin"){"Изменить"} else {"Перейти к расписанию чтобы записаться"},
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
            }
        }
        else{
            if (userType=="Admin"){
                ChangeSub(sub = go.value!!, item, from)
            }
            else{
                TimetableScreen(currentList = ttList.filter { it.subject.subjectName==go.value!!.subjectName })
            }
        }
    }
    else{
        when(from){
            "main"->Main()
            "subjects"->SubjectScreen()
        }
    }

}

@Composable
fun ChangeSub(sub:Subject, item: Subject, from: String){
    var context = LocalContext.current
    val subName = remember {
        mutableStateOf(TextFieldValue())
    }
    val duration = remember {
        mutableStateOf(TextFieldValue())
    }
    val description = remember {
        mutableStateOf(TextFieldValue())
    }
    val photo = remember {
        mutableStateOf(TextFieldValue())
    }
    val goBack = remember {
        mutableStateOf(false)
    }
    if (!goBack.value){
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
            Column (modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
                .verticalScroll(rememberScrollState())
            ){
                androidx.compose.material3.Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    androidx.compose.material3.Text(
                        text = "photo", textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                }
//            Spacer(modifier = Modifier.height(15.dp))
//            Text(text = "add")
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = subName.value,
                    onValueChange = { subName.value = it },
                    placeholder = { Text(text = sub.subjectName) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = description.value,
                    onValueChange = { description.value = it },
                    placeholder = { Text(text = sub.decription!!) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = duration.value,
                    onValueChange = { duration.value = it },
                    placeholder = { Text(text = sub.duration!!) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(20.dp))

                androidx.compose.material3.Button(
                    onClick = {
                        var subs = subjectList.filter { it.subjectName==subName.value.text }
                        if (subs.isNotEmpty()){
                            var sub = subjectList.filter { it.subjectName==subName.value.text }.last()
                            subjectList.remove(sub)
                            curSubject.subjectName=subName.value.text
                            curSubject.decription=description.value.text
                            curSubject.duration=duration.value.text
                            subjectList.add(curSubject)
                            Toast.makeText(context, "ИЗМЕНЕНО", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            Toast.makeText(context, "Неверные данные для изменения. Попробуйте еще раз!", Toast.LENGTH_SHORT).show()
                        }

                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                ) {
                    androidx.compose.material.Text(
                        text = "Изменить",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
    else{
        SubjectCard(item, from)
    }


}

/*
@Composable
fun BackHeader(function: () -> Unit) {
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
}*/
