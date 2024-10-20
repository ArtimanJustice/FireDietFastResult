package com.artiuil.lab.firediet.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artiuil.lab.firediet.ui.theme.CharcoalBlack

@Composable
fun GeneralScreen(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(title)
        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Composable
fun ScreenHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge,
        color = CharcoalBlack,
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
}