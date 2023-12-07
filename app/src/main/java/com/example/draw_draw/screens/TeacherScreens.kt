package com.example.draw_draw.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.DB.DBHandler
//import com.example.draw_draw.DB.DBTeacher
import com.example.draw_draw.data.CourseModel
import com.example.draw_draw.data.TeacherModel

//import com.example.draw_draw.ui.theme.ViewCourses

@Composable
fun TeacherDB(){
    AddTeacherToDatabase(LocalContext.current)
}

// on below line we are creating battery status function.
@Composable
fun AddTeacherToDatabase(
    context: Context
) {
    val showDataFlag = remember {
        mutableStateOf(false)
    }
    val activity = context as Activity
    val name = remember {
        mutableStateOf(TextFieldValue())
    }
    val photo = remember {
        mutableStateOf(TextFieldValue())
    }
    val description = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var dbHandler: DBHandler = DBHandler(context)

        Text(
            text = "SQlite Database in Android",
            color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            placeholder = { Text(text = "Enter name") },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = photo.value,
            onValueChange = { photo.value = it },
            placeholder = { Text(text = "Enter photo") },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = description.value,
            onValueChange = { description.value = it },
            placeholder = { Text(text = "Enter  description") },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            dbHandler.addNewTeacher(
                name.value.text,
                description.value.text,
                photo.value.text
            )
            Toast.makeText(context, "Teacher Added to Database", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Add Teacher to Database", color = Color.White)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
//            val i = Intent(context, ViewCourses::class.java)
//            context.startActivity(i)
            showDataFlag.value = true
        }) {
            Text(text = "Read Teachers from Database", color = Color.White)
        }
    }
    if (showDataFlag.value){
        ReadTeachersFromDatabase(context)
    }
}

@Composable
fun ReadTeachersFromDatabase(context: Context) {
    lateinit var teacherList: List<TeacherModel>
    teacherList = ArrayList<TeacherModel>()

    val dbHandler: DBHandler = DBHandler(context);
    teacherList = dbHandler.readTeachers()!!

    LazyColumn {
        itemsIndexed(teacherList) { index, item ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 6.dp
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = teacherList[index].name,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Photo : " + teacherList[index].photo,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Description : " + teacherList[index].description,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
