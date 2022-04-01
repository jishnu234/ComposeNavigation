package com.example.screennavigation.screens.loginscreen.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.screennavigation.R

@Composable
fun LottieAnimationComposable() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.bot_yellow))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 1f
    )
    com.airbnb.lottie.compose.LottieAnimation(
        modifier = Modifier
            .size(180.dp),
        composition = composition,
        progress = progress
    )
}

@Composable
fun InputFieldComposable(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onTextChange: (String) -> Unit
){

    OutlinedTextField(
        value = value,
        onValueChange = onTextChange,
        label = { Text(text = label) },
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )

}