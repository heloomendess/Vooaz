package com.vooazdomain.Vooaz.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext





private val DarkColorScheme = darkColorScheme(
    primary = BlueGreen80,
    secondary = Green40,
    onSecondaryContainer = white,
    tertiary = Gray40,
    onTertiary = Yellow40,
    background= StrongBlue80,
    onBackground = Blue80,
    onSecondary = Black,
    onPrimaryContainer = offWhite,
    primaryContainer = blue60,
    surfaceBright = cinza,
    surfaceTint = white40,
    surfaceContainer = cinza40,
    onTertiaryContainer = white60,
    scrim = blue40,
    onPrimary = blue20,
    onSurfaceVariant = yellow60,
    outline = white80,
    surfaceContainerLow = white100,
    secondaryContainer = cinza20,
    tertiaryContainer = blue100,
    surfaceContainerHigh = white120,
    outlineVariant = white140,
    onSurface = blue120,
    surfaceContainerHighest = white160,
    surfaceContainerLowest = yellow80,
    surface = white10,
    inverseOnSurface = white110

)

private val LightColorScheme = lightColorScheme(
    primary = BlueGreen80,
    secondary = Green40,
    onSecondaryContainer = white,
    tertiary = Gray40,
    onTertiary = Yellow40,
    background= StrongBlue80,
    onBackground = Blue80,
    onSecondary = Black,
    onPrimaryContainer = offWhite,
    primaryContainer = blue60,
    surfaceBright = cinza,
    surfaceTint = white40,
    surfaceContainer = cinza40,
    onTertiaryContainer = white60,
    onPrimary = blue20,
    onSurfaceVariant = yellow60,
    outline = white80,
    secondaryContainer = cinza20,
    tertiaryContainer = blue100,
    surfaceContainerLow = white100,
    scrim = blue40,
    surfaceContainerHigh = white120,
    outlineVariant = white140,
    onSurface = blue120,
    surfaceContainerHighest = white160,
    surfaceContainerLowest = yellow80,
    surface = white10,
    inverseOnSurface = white110









    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun VooazTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    var colors = if (darkTheme){
        DarkColorScheme
    } else {
        LightColorScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}