package com.artiuil.lab.firediet.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val FieryPrimary = Color(0xFFFFA726)
val DeepRedOrange = Color(0xFFD84315)
val CharcoalBlack = Color(0xFF212121)
val DarkSurface = Color(0xFF3E2723)
val BrightGold = Color(0xFFFFD54F)

val CustomColorScheme = lightColorScheme(
    primary = FieryPrimary,
    onPrimary = BrightGold,
    background = CharcoalBlack,
    onBackground = BrightGold,
    surface = DarkSurface,
    onSurface = BrightGold,
    secondary = DeepRedOrange
)
