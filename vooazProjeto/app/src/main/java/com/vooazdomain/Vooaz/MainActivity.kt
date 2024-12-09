package com.vooazdomain.Vooaz

import android.graphics.Color
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.vooazdomain.Vooaz.navigationflow.NavigationFlowSettings
import com.vooazdomain.Vooaz.ui.theme.VooazTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color as ComposeColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura o modo Edge-to-Edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Configura a aparência das barras
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightNavigationBars = true // Ícones claros na Navigation Bar
            isAppearanceLightStatusBars =true
        }


        window.insetsController?.apply {
            hide(WindowInsets.Type.systemBars())
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        }

        // Configura o conteúdo da aplicação
        setContent {
            VooazTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ) {
                    NavigationFlowSettings()
                }
            }
        }
    }
}
