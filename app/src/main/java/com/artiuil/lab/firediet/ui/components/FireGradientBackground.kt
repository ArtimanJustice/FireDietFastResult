package com.artiuil.lab.firediet.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.artiuil.lab.firediet.ui.theme.DeepRedOrange
import com.artiuil.lab.firediet.ui.theme.FieryPrimary

@Composable
fun FireGradientBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(FieryPrimary, DeepRedOrange)
                )
            )
    ) {
        content()
    }
}
