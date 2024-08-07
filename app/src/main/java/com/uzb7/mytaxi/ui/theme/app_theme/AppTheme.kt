package com.uzb7.mytaxi.ui.theme.app_theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.uzb7.mytaxi.ui.theme.DarkColorScheme
import com.uzb7.mytaxi.ui.theme.LightColorScheme


@Composable
fun AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val maydonColorScheme = if (darkTheme) {
        AppDarkColorsPalette
    } else {
        AppLightColorsPalette
    }

    CompositionLocalProvider(
        LocalAppColorsPalette provides maydonColorScheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }

}

val MaterialTheme.appColors: AppColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColorsPalette.current
