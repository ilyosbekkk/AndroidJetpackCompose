package com.example.androidjetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScrollableColumn(modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()) {

                Image(
                    bitmap = imageFromResource(res = resources, R.drawable.image),
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Happy  Meal", style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(26),
                            color = Color.Red
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(
                        text = "800 Colories", style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(16),
                            color = Color.Green
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "$5.99")
                }
            }
        }

    }
}
