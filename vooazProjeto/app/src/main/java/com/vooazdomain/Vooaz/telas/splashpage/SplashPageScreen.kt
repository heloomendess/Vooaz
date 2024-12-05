package com.vooazdomain.Vooaz.telas.splashpage

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import kotlinx.coroutines.delay
import com.vooazdomain.Vooaz.R

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*


@Composable
fun addSplashPage(navController: NavHostController, destination:String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splashanimation))
    val progress by animateLottieCompositionAsState(composition = composition, speed = 3f)

    LaunchedEffect(progress) {
        if (progress == 1f) { // Animação concluída
            delay(3000)
            navController.navigate(destination) {
                popUpTo("addSplashPage") { inclusive = true }
            }
        }
    }

    // Exibição da animação na tela inteira
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.fillMaxSize()
        )
    }
}
