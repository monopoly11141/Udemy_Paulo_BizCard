package com.example.udemy_paulo_bizcard

import android.content.ContentValues.TAG
import android.graphics.Paint.Align
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.udemy_paulo_bizcard.ui.theme.Udemy_Paulo_BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Udemy_Paulo_BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBizCard() {

    var buttonClickedState by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 30.dp
            ),
            shape = RoundedCornerShape(
                corner = CornerSize(15.dp)
            ),
            modifier = Modifier
                .width(200.dp)
                .height(400.dp)
                .padding(12.dp)
        ) {

        }

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(300.dp)
                .padding(12.dp)
        ) {
            CreateImageProfile()

            Divider()

            CreateProfileInfo()

            Button(
                onClick = {
                    buttonClickedState = !buttonClickedState
                }
            ) {
                Text(
                    text = "Portfolio"
                )
            }

            if(buttonClickedState) {
                Content()
            } else {
                Box(

                ) {

                }
            }

        }


    }

}


@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(
            alpha = 0.5f
        ),
        modifier = modifier
            .size(150.dp)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.profile_image
            ),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(150.dp)
        )
    }
}

@Composable
fun CreateProfileInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(5.dp)
    ) {
        Text(
            text = "Miles P.",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Android Compose Professional",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "@MilesTwitter",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
        ) {
            PortFolio(data = listOf("Project1", "Project2", "Project3"))

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortFolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                shape = RectangleShape,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    CreateImageProfile(
                        modifier = Modifier
                            .size(100.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(
                                alignment = Alignment.CenterVertically
                            )
                    ) {
                        Text(
                            text = item,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text ="A Great Project",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }



                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Udemy_Paulo_BizCardTheme {
        CreateBizCard()
    }
}