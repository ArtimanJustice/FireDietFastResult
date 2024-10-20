package com.artiuil.lab.firediet.ui.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.artiuil.lab.firediet.ui.nav.state.UiState

class MainViewModel : ViewModel() {
    var uiState by mutableStateOf(UiState.CALORIES_SCREEN)
}
