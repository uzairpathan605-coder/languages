package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DuolingoGreen,
    onPrimary = Color.White,
    primaryContainer = DuolingoGreenShadow,
    onPrimaryContainer = DuolingoGreenLight,
    secondary = DuolingoBlue,
    onSecondary = Color.White,
    secondaryContainer = DuolingoBlueShadow,
    onSecondaryContainer = DuolingoBlueLight,
    tertiary = DuolingoOrange,
    onTertiary = Color.White,
    background = BgDark,
    onBackground = TextPrimaryDark,
    surface = CardSurfaceDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = BorderDark,
    onSurfaceVariant = TextSecondaryDark,
    outline = BorderDark
)

private val LightColorScheme = lightColorScheme(
    primary = DuolingoGreen,
    onPrimary = Color.White,
    primaryContainer = DuolingoGreenLight,
    onPrimaryContainer = DuolingoGreenShadow,
    secondary = DuolingoBlue,
    onSecondary = Color.White,
    secondaryContainer = DuolingoBlueLight,
    onSecondaryContainer = DuolingoBlueShadow,
    tertiary = DuolingoOrange,
    onTertiary = Color.White,
    background = BgLight,
    onBackground = TextPrimaryLight,
    surface = CardSurfaceLight,
    onSurface = TextPrimaryLight,
    surfaceVariant = BorderLight,
    onSurfaceVariant = TextSecondaryLight,
    outline = BorderLight
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep handcrafted playful palette
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
