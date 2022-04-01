package com.example.screennavigation.screens.loginscreen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.screennavigation.naviagtion.Screens
import com.example.screennavigation.screens.loginscreen.composable.InputFieldComposable
import com.example.screennavigation.screens.loginscreen.composable.LottieAnimationComposable


//@Preview(showBackground = true)
@Composable
fun LoginScreenApp(navController: NavController) {
    var textInputValue by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        LottieAnimationComposable()
        Spacer(modifier = Modifier.height(48.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InputFieldComposable(
                label = "Enter the Data",
                value = textInputValue,
                onTextChange = {
                    textInputValue = it
                })
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 64.dp),
                onClick = {
                    if (textInputValue.isEmpty())
                        navController.navigate(Screens.DetailScreen.withArgs("Sample Data"))
                    else
                        navController.navigate(Screens.DetailScreen.withArgs(textInputValue))
//                    navController.navigate(Screens.DetailScreen.route + "/$textInputValue")
                    Toast.makeText(context, "Your data send", Toast.LENGTH_LONG).show()
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF282A36),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Send Data")
            }
        }
    }
}

