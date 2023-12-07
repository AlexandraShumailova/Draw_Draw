package com.example.draw_draw.screens.admin

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AdminMenuScreen(){
    val adminMenuScreenIs = remember {
        mutableStateOf(true)
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
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                onClick = { adminClientsFlag.value = true }) {
                Text(text = "Clients")
            }
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                onClick = { adminSubFlag.value = true }) {
                Text(text = "Subjects")
            }
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                onClick = { adminTTFlag.value = true }) {
                Text(text = "Timetable")
            }
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                onClick = { adminBookingsFlag.value = true }) {
                Text(text = "bookings")
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
}