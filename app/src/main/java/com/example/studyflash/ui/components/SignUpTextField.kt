package com.example.studyflash.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.ui.theme.focusedTextFieldText
import com.example.studyflash.ui.theme.textFieldContainer
import com.example.studyflash.ui.theme.unfocusedTextFieldText

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String,
    value: String,  // Add value to hold the current text
    onValueChange: (String) -> Unit  // Add onValueChange callback to update the text
) {
    val uniColor: Color = if (isSystemInDarkTheme()) Color.White else Color.Black

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        value = value,  // Bind the current value to the TextField
        onValueChange = onValueChange,  // Update the state when the user types
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 15.sp,
                color = uniColor
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),
        trailingIcon = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uniColor
                )
            }
        }
    )
}
