package com.example.udemy_paulo_bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            .fillMaxSize()
    ) {
        Text(
            color = Color.Blue,
            text = "Miles P.",
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Udemy_Paulo_BizCardTheme {
        CreateBizCard()
    }
}