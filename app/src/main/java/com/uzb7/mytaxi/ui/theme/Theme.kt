package com.uzb7.mytaxi.ui.theme

import android.app.Activity
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
import com.uzb7.mytaxi.ui.theme.app_theme.AppColorsPalette
import com.uzb7.mytaxi.ui.theme.app_theme.MainBgColorDark
import com.uzb7.mytaxi.ui.theme.app_theme.MainBgColorLight
import com.uzb7.mytaxi.ui.theme.app_theme.MainColor

val DarkColorScheme = darkColorScheme(
    primary = MainColor,
    background = MainBgColorDark,
    surface = Color(0xFF3d3d3d)
)

val LightColorScheme = lightColorScheme(
    primary = MainColor,
    background = MainBgColorLight,
    surface = Color.White
)

private val AppLightColorsPalette = AppColorsPalette(
    mainBgColor = MainBgColorLight,
    mainColor = MainColor,
)
private val AppDarkColorsPalette = AppColorsPalette(
    mainBgColor = MainBgColorDark,
    mainColor = MainColor,
)


@Composable
fun MyTaxiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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

