package com.artiuil.lab.firediet.ui.screens.settings

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artiuil.lab.firediet.R
import com.artiuil.lab.firediet.data.db.PreferencesManager
import com.artiuil.lab.firediet.ui.components.FireGradientBackground
import com.artiuil.lab.firediet.ui.components.FormBlock
import com.artiuil.lab.firediet.ui.components.GeneralScreen
import com.artiuil.lab.firediet.ui.theme.GoldenFireTheme

@Composable
fun AddCaloriesScreen(context: Context) {
    val preferencesManager = remember { PreferencesManager(context) }
    var foodConsumed by remember { mutableIntStateOf(preferencesManager.getFoodConsumed()) }
    var caloriesInput by remember { mutableStateOf("") }
    var foodInput by remember { mutableStateOf(foodConsumed.toString()) }

    FireGradientBackground {
        GeneralScreen(title = stringResource(R.string.app_name)) {
            FormBlock(
                title = stringResource(R.string.add_calories),
                inputLabel = stringResource(R.string.calories),
                inputValue = caloriesInput,
                onInputChange = { caloriesInput = it },
                buttonText = stringResource(R.string.add),
                onButtonClick = {
                    val calories = caloriesInput.toIntOrNull() ?: 0
                    if (calories > 0) {
                        foodConsumed += calories
                        preferencesManager.saveFoodConsumed(foodConsumed)
                        caloriesInput = ""
                    }
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            FormBlock(
                title = stringResource(R.string.reset_or_change_food),
                inputLabel = stringResource(R.string.enter_new_food_value),
                inputValue = foodInput,
                onInputChange = { foodInput = it },
                buttonText = stringResource(R.string.change),
                onButtonClick = {
                    foodConsumed = foodInput.toIntOrNull() ?: foodConsumed
                    preferencesManager.saveFoodConsumed(foodConsumed)
                },
                extraContent = {
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            foodConsumed = 0
                            preferencesManager.saveFoodConsumed(foodConsumed)
                            foodInput = "0"
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = stringResource(R.string.reset),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddCaloriesScreenPreview() {
    GoldenFireTheme {
        AddCaloriesScreen(LocalContext.current)
    }
}
