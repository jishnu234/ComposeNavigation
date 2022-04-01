package com.example.screennavigation.screens.onboadring

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.screennavigation.R
import com.example.screennavigation.naviagtion.Screens

@Composable
fun OnboardingScreen(navController: NavController) {

    var index by remember {
        mutableStateOf(0)
    }
    val list = remember {
        mutableStateListOf<Int>(
            R.drawable.cartton_car,
            R.drawable.toy_car,
            R.drawable.toy_jeep,
        )
    }
    val size = list.size
    Column(
        modifier = Modifier.fillMaxSize(),

        ) {
        TopSection(navController)
        Image(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .weight(1f),
            painter = painterResource(id = list[index]),
            contentDescription = "cartoon_car",
            contentScale = ContentScale.Fit
        )
        BottomSection(
            navController = navController,
            index = index,
            size = size
        ) {
            index = it
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun TopSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .align(CenterStart),
            onClick = { /*TODO*/ }) {
            Icon(
                Icons.Outlined.KeyboardArrowLeft,
                contentDescription = null,
            )
        }
        TextButton(
            onClick = {
                navController.navigate(Screens.LoginScreen.route)
            },
            modifier = Modifier
                .align(CenterEnd)
                .clip(RectangleShape)
        ) {
            Text(
                text = "SKIP",
                color = Color.Black
            )
        }
    }
}

@Composable
fun BottomSection(
    navController: NavController,
    size: Int, index: Int, updateImage: (Int) -> Unit
) {
//    val clickable by remember {
//        mutableStateOf(true)
//    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        Indicators(size = size, index = index)
        FloatingActionButton(
            onClick = {
                if (index == size - 1) navController.navigate(Screens.LoginScreen.route)
                else updateImage(index + 1)
            },
            modifier = Modifier.align(CenterEnd),
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground
        ) {
            Icon(
                Icons.Outlined.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }

}

@Composable
fun Indicator(isSelected: Boolean = true) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 8.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width = width.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFFB6DFE4) else Color(0xFF111111))
    )
}

//@Preview
@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .align(CenterStart)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}
