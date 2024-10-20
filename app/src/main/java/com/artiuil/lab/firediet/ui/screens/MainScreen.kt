package com.artiuil.lab.firediet.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artiuil.lab.firediet.data.db.PreferencesManager
import com.artiuil.lab.firediet.ui.nav.BottomNavigationBar
import com.artiuil.lab.firediet.ui.nav.state.UiState
import com.artiuil.lab.firediet.ui.screens.recipes.DishSearchScreen
import com.artiuil.lab.firediet.ui.screens.settings.AddCaloriesScreen
import com.artiuil.lab.firediet.ui.screens.statistic.CalorieScreen
import com.artiuil.lab.firediet.ui.theme.GoldenFireTheme
import com.artiuil.lab.firediet.ui.vm.MainViewModel

@Composable
fun MainScreen(context: Context, viewModel: MainViewModel = viewModel()) {
    val uiState = viewModel.uiState
    val preferencesManager = remember { PreferencesManager(context) }
    var foodConsumed by remember { mutableIntStateOf(preferencesManager.getFoodConsumed()) }

    GoldenFireTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        when (uiState) {
                            UiState.CALORIES_SCREEN -> CalorieScreen(
                                context = context
                            )

                            UiState.ADD_CALORIES_SCREEN -> AddCaloriesScreen(context)
                            UiState.RECIPES_SCREEN -> DishSearchScreen(onDishSelected = { recipe ->
                                val newConsumed = foodConsumed + recipe.calories.toInt()
                                foodConsumed = newConsumed
                                preferencesManager.saveFoodConsumed(newConsumed)
                                viewModel.uiState = UiState.CALORIES_SCREEN
                            })
                        }
                    }

                    BottomNavigationBar(
                        currentScreen = uiState,
                        onScreenSelected = { selectedScreen -> viewModel.uiState = selectedScreen }
                    )
                }

        }
    }
}

