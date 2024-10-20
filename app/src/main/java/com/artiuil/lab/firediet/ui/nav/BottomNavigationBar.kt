package com.artiuil.lab.firediet.ui.nav

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import com.artiuil.lab.firediet.R
import com.artiuil.lab.firediet.ui.nav.state.UiState

@Composable
fun BottomNavigationBar(
    currentScreen: UiState,
    onScreenSelected: (UiState) -> Unit
) {
    val navigationItems = listOf(
        NavigationItemData(
            screen = UiState.CALORIES_SCREEN,
            iconResId = R.drawable.fire_home_icon,
            contentDescriptionResId = R.string.calories_cd
        ),
        NavigationItemData(
            screen = UiState.ADD_CALORIES_SCREEN,
            iconResId = R.drawable.fire_add_icon,
            contentDescriptionResId = R.string.add_calories_cd
        ),
        NavigationItemData(
            screen = UiState.RECIPES_SCREEN,
            iconResId = R.drawable.fire_recipies_icon,
            contentDescriptionResId = R.string.recipes_cd
        )
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        navigationItems.forEach { item ->
            val selected = currentScreen == item.screen
            NavigationBarItem(
                icon = {
                    NavigationItemIcon(item = item, selected = selected, isRail = false)
                },
                selected = selected,
                onClick = { onScreenSelected(item.screen) }
            )
        }
    }
}