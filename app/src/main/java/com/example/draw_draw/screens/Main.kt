package com.example.draw_draw.screens

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.icu.util.Calendar
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.R
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.subjectList
import com.example.draw_draw.data.ttList
import com.example.draw_draw.data.userType
import com.example.draw_draw.screens.admin.AdminMenuScreen

@Composable
fun Main(){
    var go = remember {
        mutableStateOf<String?>(null)
    }
    var goSubCard = remember {
        mutableStateOf<Subject?>(null)
    }

    if (userType=="Admin"){
        AdminMenuScreen()
    }
    else{
        if(goSubCard.value==null){
            when (go.value) {
                "TT" -> TimetableScreen(ttList)
                "Group lessons" -> SubjectScreen()
                "Profile" -> print("x == 1")
                else -> {
                    Column {
                        Head("Draw Draw")
                        Column ( modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
                        ){
                            if (userType!="Admin"){
                                Spacer(modifier = Modifier.height(10.dp))
                                TimetableOnMain("Ближайшее занятие")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            GroupLessons(go, goSubCard)
                            Spacer(modifier = Modifier.height(10.dp))
                            BookButton(go)
                        }
                    }
                }
            }
        }
        else{
            SubjectCard(item = goSubCard.value!!, "main")
        }
    }
}

@Composable
fun Head(text: String) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(start = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = text,
            color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold,)
    }
}

@Composable
fun TimetableOnMain(text: String) {
    Text(
        text = text,
        color = Color(0, 108, 30), fontSize = 20.sp, fontWeight = FontWeight.Bold,
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
                text = "Масляная живопись",
                modifier = Modifier.padding(4.dp),
                color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "09:00" + " " + "пн",
                modifier = Modifier.padding(4.dp),
                color = Color.Black, textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@Composable
fun GroupLessons(go: MutableState<String?>, goSubCard: MutableState<Subject?>){
    Row (modifier = Modifier
        .fillMaxWidth()
        .clickable { go.value = "Group lessons" }
    ){
        Text(
            text = "Групповые занятия",
            color = Color(0, 108, 30), fontSize = 20.sp, fontWeight = FontWeight.Bold, )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        subjectList.forEach{subject ->
            Card (modifier = Modifier.clickable { goSubCard.value = subject }){
                Column (modifier = Modifier
                    .padding(10.dp)
                ){
                    Image(painter = painterResource(id = subject.photoId!!),
                        contentDescription = "photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .height(160.dp)
                            .width(240.dp))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = subject.subjectName,
                        color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun BookButton(go: MutableState<String?>){
    Button(onClick = { go.value = "TT" },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
        Text(text = "Перейти к расписанию и записаться!",
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun AddPicture(){
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        imageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            bitmap.value?.let { btm ->
                Image(
                    bitmap = btm.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .padding(20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { launcher.launch("image/*") }) {
            Text(text = "Pick Image")
        }
    }
}