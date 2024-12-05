package com.vooazdomain.Vooaz.navigationflow

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable

import com.vooazdomain.Vooaz.R

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import com.google.gson.Gson
import com.vooazdomain.Vooaz.modelsData.datas.User
import java.net.URLEncoder


@Composable
fun LoadingScreen(navController: NavHostController, screen: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loadingscreen))
    val progress by animateLottieCompositionAsState(composition = composition, speed = 15f)

    LaunchedEffect(progress) {
        if (progress == 1f) {
            navController.navigate(screen)
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
            modifier = Modifier.size(250.dp)
        )
    }
}
