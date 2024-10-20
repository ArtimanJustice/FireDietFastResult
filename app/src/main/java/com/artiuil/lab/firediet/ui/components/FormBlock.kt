package com.artiuil.lab.firediet.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artiuil.lab.firediet.ui.screens.settings.CustomSurface
import com.artiuil.lab.firediet.ui.screens.settings.FormTitle
import com.artiuil.lab.firediet.ui.theme.GoldenFireTheme

@Composable
fun FormBlock(
    title: String,
    inputLabel: String,
    inputValue: String,
    onInputChange: (String) -> Unit,
    buttonText: String,
    onButtonClick: () -> Unit,
    extraContent: (@Composable () -> Unit)? = null
) {
    CustomSurface {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FormTitle(title = title)

            Spacer(modifier = Modifier.height(16.dp))

            CustomOutlinedTextField(
                value = inputValue,
                onValueChange = onInputChange,
                label = inputLabel
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = buttonText, color = MaterialTheme.colorScheme.onPrimary)
            }

            extraContent?.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormBlockPreview() {
    var inputValue by remember { mutableStateOf("") }
    GoldenFireTheme {
        FormBlock(
            title = "Preview Form",
            inputLabel = "Input",
            inputValue = inputValue,
            onInputChange = { inputValue = it },
            buttonText = "Submit",
            onButtonClick = {},
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Extra content goes here",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        )
    }
}