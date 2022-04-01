package com.example.screennavigation.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ProgressBar(progress: Float = 0.0f) {

    val percentageValue by remember {
        mutableStateOf(progress)
    }

    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFE7A6A6),
            Color(0xFFF0EDED),
        )
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(12.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color(0xFF6F6D6D),
            ) {
                Card(
                    modifier = Modifier
                        .padding(
                            end = if (percentageValue <= 100)
                                LocalConfiguration.current.screenWidthDp.dp - ((LocalConfiguration.current.screenWidthDp.dp * percentageValue) / 100)
                            else LocalConfiguration.current.screenWidthDp.dp
                        ),
                    shape = if(percentageValue < 95) RoundedCornerShape(0.dp) else RoundedCornerShape(12.dp)
                ) {
                    Box(modifier = Modifier.background(
                        gradient
                    )) {

                    }
                }
            }
        }
        Text(
            text = "%.2f".format(percentageValue) + " % ",
            fontWeight = FontWeight.SemiBold
        )
    }

}