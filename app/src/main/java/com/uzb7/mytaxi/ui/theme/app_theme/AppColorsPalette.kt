package com.uzb7.mytaxi.ui.theme.app_theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColorsPalette(
    val mainBgColor: Color = Color.Unspecified,
    val mainColor: Color = Color.Unspecified,
    val mainTextColor: Color = Color.Unspecified,
    val busyButtonBackground:Color = Color.Unspecified,
    val busyBtnTextColor: Color = Color.Unspecified,
    val activeBtnTextColor:Color = Color.Unspecified,
    val leftIconBack:Color = Color.Unspecified,
    val leftIconTint: Color = Color.Unspecified,
    val rightIconTint: Color = Color.Unspecified,
    val lineColor:Color = Color.Unspecified,
)

val LocalAppColorsPalette = staticCompositionLocalOf { AppColorsPalette() }