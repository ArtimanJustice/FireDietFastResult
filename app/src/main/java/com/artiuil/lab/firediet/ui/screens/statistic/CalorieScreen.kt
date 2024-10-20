package com.artiuil.lab.firediet.ui.screens.statistic

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artiuil.lab.firediet.R
import com.artiuil.lab.firediet.data.db.PreferencesManager
import com.artiuil.lab.firediet.ui.components.FireGradientBackground
import com.artiuil.lab.firediet.ui.components.GeneralScreen
import com.artiuil.lab.firediet.ui.theme.GoldenFireTheme

@Composable
fun CalorieScreen(context: Context) {
    val preferencesManager = remember { PreferencesManager(context) }
    var baseGoal by remember { mutableIntStateOf(preferencesManager.getBaseGoal()) }
    val foodConsumed by remember { mutableIntStateOf(preferencesManager.getFoodConsumed()) }

    FireGradientBackground {
            GeneralScreen(title = stringResource(id = R.string.app_name)) {
                val remainingCalories = baseGoal - foodConsumed

                CaloriesBlock(
                    remainingCalories = remainingCalories,
                    baseGoal = baseGoal,
                    foodConsumed = foodConsumed
                )

                Spacer(modifier = Modifier.height(16.dp))

                CalorieGoalBlock(
                    baseGoal = baseGoal,
                    onGoalSelected = { selectedGoal ->
                        baseGoal = selectedGoal
                        preferencesManager.saveBaseGoal(selectedGoal)
                    }
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalorieScreenPreview() {
    GoldenFireTheme {
        CalorieScreen(LocalContext.current)
    }
}