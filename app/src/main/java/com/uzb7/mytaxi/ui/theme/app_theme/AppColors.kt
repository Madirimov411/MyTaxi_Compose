package com.uzb7.mytaxi.ui.theme.app_theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val MainColor = Color(0xFF80ED99)
val MainBgColorLight = Color(0xFFFFFFFF)
val MainBgColorDark = Color(0xFF121212)

// Text and Icon colors
val MainTextColorLight = Color(0xFF121212)
val MainTextColorDark = Color(0xFFFFFFFF)

// Light Theme colors
val AppLightColorsPalette = AppColorsPalette(
    mainBgColor = MainBgColorLight,
    mainColor = MainColor,
    mainTextColor = MainTextColorLight,
    busyButtonBackground = Color(0xFFE05656),
    busyBtnTextColor = Color(0xFF121212),
    activeBtnTextColor = Color(0xFF121212),
    leftIconBack = Color(0xFFF5F6F9),
    leftIconTint = Color(0xFF818AB0),
    rightIconTint = Color(0xFFBBC2D5),
    lineColor = Color(0xFFE8EAF1)
)


// Dark Theme colors
val AppDarkColorsPalette = AppColorsPalette(
    mainBgColor = MainBgColorDark,
    mainColor = MainColor,
    mainTextColor = MainTextColorDark,
    busyButtonBackground = Color(0xFFE05656),
    busyBtnTextColor = Color(0xFFFFFFFF),
    activeBtnTextColor = Color(0xFF121212),
    leftIconBack = Color(0xFF242424),
    leftIconTint = Color(0xFF999999),
    rightIconTint = Color(0xFF666666),
    lineColor = Color(0xFF3E3E3E)
)

