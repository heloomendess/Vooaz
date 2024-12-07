package com.vooazdomain.Vooaz.splashpage

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun addSplashPage(splashScreen: SplashScreen){

splashScreen.setKeepOnScreenCondition { true }
CoroutineScope(Dispatchers.Main).launch {
    delay(3000L)

    splashScreen.setKeepOnScreenCondition { false }
}
}