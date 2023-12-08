package com.example.draw_draw

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.draw_draw.ui.theme.Draw_DrawTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.draw_draw.button_navigation.MainScreen
import com.example.draw_draw.data.sub1
import com.example.draw_draw.screens.HelloScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Draw_DrawTheme {
/*                @Composable
                fun ChooseActivity (){
                    Column {
                        Button(
                            onClick = {
                                val navigate = Intent(this@MainActivity, ClientActivity::class.java)
                                startActivity(navigate)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                        ) {
                            androidx.compose.material.Text(
                                text = "Log In",
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(200.dp))

                        TextButton(
                            onClick = {
                                val navigate = Intent(this@MainActivity, AdminActivity::class.java)
                                startActivity(navigate)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            androidx.compose.material.Text(
                                text = "Log in as an admin",
                                textAlign = TextAlign.Center,
                                color = Color.Gray
                            )
                        }
                    }
                }
                ChooseActivity()
                ch(start = this@MainActivity)*/
                HelloScreen()


            }
        }
    }
}

@Composable
fun ch (start: ComponentActivity){

}

