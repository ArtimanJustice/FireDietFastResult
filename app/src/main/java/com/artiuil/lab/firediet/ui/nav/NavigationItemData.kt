package com.artiuil.lab.firediet.ui.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.artiuil.lab.firediet.ui.nav.state.UiState

data class NavigationItemData(
    val screen: UiState,
    @DrawableRes val iconResId: Int,
    @StringRes val contentDescriptionResId: Int
)