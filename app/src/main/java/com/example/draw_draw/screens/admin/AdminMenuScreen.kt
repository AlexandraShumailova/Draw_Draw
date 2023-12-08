package com.example.draw_draw.screens.admin

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.draw_draw.screens.Head

@Preview
@Composable
fun AdminMenuScreen(){
    val thisScreen = remember {
        mutableStateOf(true)
    }
    val AdmClientsFun = remember {
        mutableStateOf(false)
    }
    val adminClientsFlag = remember {
        mutableStateOf(false)
    }
    val adminSubFlag = remember {
        mutableStateOf(false)
    }
    val adminTTFlag = remember {
        mutableStateOf(false)
    }
    val adminBookingsFlag = remember {
        mutableStateOf(false)
    }
    if (!adminClientsFlag.value and !adminTTFlag.value and
        !adminSubFlag.value and !adminBookingsFlag.value) {
        Column {
            Head("Draw Draw")
            Spacer(modifier = Modifier.height(10.dp))
            Column (modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)){
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { adminClientsFlag.value = true
                                }
                ) {
                    Text(text = "Clients")
                }
                Spacer(modifier = Modifier.height(10.dp))
/*                Card (modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { }
                ){
                    Text(text = "Subjects")
                }*/
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { adminSubFlag.value = true }) {
                    Text(text = "Subjects")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { adminTTFlag.value = true }) {
                    Text(text = "Timetable")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { adminBookingsFlag.value = true }) {
                    Text(text = "bookings")
                }
            }

        }
    }
    if (adminClientsFlag.value){
//        AdminClientsScreen({adminMenuScreenIs=false})
        AdminClientsScreen()
    }
    if (adminSubFlag.value){
        AdminSubjectsScreen()
    }
    if (adminTTFlag.value){
//        AdminClientsScreen({adminMenuScreenIs=false})
        AdminTTScreen()
    }
    if (adminBookingsFlag.value){
        ShowAllBookings()
    }
}