package com.example.draw_draw.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw_draw.data.Subject
import com.example.draw_draw.data.subjectList

@Preview
@Composable
fun SubjectScreen(){
    var thisScreen = remember {
        mutableStateOf(true)
    }
    var go = remember {
        mutableStateOf<Subject?>(null)
    }
    if (thisScreen.value){
        if (go.value==null) {
            Column {
                Head(text = "Групповые занятия")
                //SearchField()
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(start = 15.dp, end = 15.dp, bottom = 60.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    SubjectList(go)
                }
            }
        }
        else{
            SubjectCard(item = go.value!!, "subjects")
        }
    }

}

@Composable
fun SubjectList(go: MutableState<Subject?>){
    Column ( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ){
        Spacer(modifier = Modifier.height(10.dp))
        subjectList.forEach{ item->
            SubjectItem(item, go)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun SubjectItem(item: Subject, go: MutableState<Subject?>){
    if (go.value==null) {
        Card(modifier = Modifier.clickable { go.value = item }) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = item.photoId!!),
                    contentDescription = "photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item.subjectName,
                    color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier,
                    colors = CardDefaults.cardColors(Color.DarkGray)
                ) {
                    Text(
                        text = item.duration!!,
                        modifier = Modifier.padding(
                            start = 10.dp,
                            end = 10.dp,
                            top = 3.dp,
                            bottom = 3.dp
                        ),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item.shortDesc!!,
                    color = Color.Gray, fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}