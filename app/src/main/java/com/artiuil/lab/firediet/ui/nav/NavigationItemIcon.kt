package com.artiuil.lab.firediet.ui.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigationItemIcon(
    item: NavigationItemData,
    selected: Boolean,
    isRail: Boolean
) {
    val iconTint = if (selected) {
        Color.Unspecified
    } else {
        MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
    }
    val iconModifier = Modifier
        .size(60.dp)
        .then(if (isRail) Modifier.padding(8.dp) else Modifier)

    Icon(
        painter = painterResource(id = item.iconResId),
        contentDescription = stringResource(id = item.contentDescriptionResId),
        tint = iconTint,
        modifier = iconModifier
    )
}