package com.example.draw_draw.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import com.example.draw_draw.DB.DBUser
import com.example.draw_draw.data.UserModel
//import com.example.draw_draw.ui.theme.UsersActivity

@Composable
fun UsersDBScreens() {
    AddUserToDatabase(LocalContext.current)
}

@Composable
fun AddUserToDatabase(
    context: Context
) {
    val activity = context as Activity
    val userName = remember {
        mutableStateOf(TextFieldValue())
    }
    val showUsersFlag = remember {
        mutableStateOf(false)
    }
    val login = remember {
        mutableStateOf(TextFieldValue())
    }
    val password = remember {
        mutableStateOf(TextFieldValue())
    }
    val photo = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var dbUser: DBUser = DBUser(context)

        Text(
            text = "User Database in Android",
            color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = userName.value,
            onValueChange = { userName.value = it },
            placeholder = { Text(text = "Enter your USER name") },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = login.value,
            onValueChange = { login.value = it },
            placeholder = { Text(text = "Enter your LOGIN") },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text(text = "Enter your password") },
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

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            dbUser.addNewUser(
                userName.value.text,
                login.value.text,
                password.value.text,
                photo.value.text
            )
            Toast.makeText(context, "User Added to Database", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Add User to Database", color = Color.White)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            showUsersFlag.value = true
        }) {
            Text(text = "Read Users from Database", color = Color.White)
        }
    }
    //Text(text = "${showUsersFlag.value}")
    if (showUsersFlag.value){
        ReadUsersFromDatabase(context)}
}

@Composable
fun ReadUsersFromDatabase(context: Context) {
    lateinit var userList: List<UserModel>
    userList = ArrayList<UserModel>()

    val dbUser: DBUser = DBUser(context);
    userList = dbUser.readUsers()!!

    LazyColumn {
        itemsIndexed(userList) { index, item ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = userList[index].userName,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Login : " + userList[index].login,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Password : " + userList[index].password,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Photo : " + userList[index].photo,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}