package com.example.studyflash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyflash.R


//@Preview(showBackground = true)
//@Composable
//fun TopNavBarPreview() { // Create a separate function for preview
//    TopNavBar()
//}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
//unit means a function that returns void
fun TopNavBar(
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
){
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.spacedBy(16.dp) // Distribute columns evenly
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            IconButton(onClick = onHomeClick,
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0XFF6A31F7), RectangleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home_light),   // Use Icon inside IconButton
                    contentDescription = "Home Icon",
                    tint = Color(0xEDF5FFFF),
//                    modifier = Modifier.size(400.dp)
                )
            }
        }
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            IconButton(onClick = onCategoriesClick,
                modifier = Modifier
                    .size(35.dp)
                    .background(Color(0XFF6A31F7), RectangleShape)

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.categories),   // Use Icon inside IconButton
                    contentDescription = "Home Icon",
                    tint = Color(0xEDF5FFFF),
//                    modifier = Modifier.background(Color(0XFF6A31F7), RectangleShape
                )
            }
        }
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            IconButton(onClick = onProfileClick,
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0XFF6A31F7), RectangleShape)
                ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_light),  // Use Icon inside IconButton
                    contentDescription = "Home Icon",
                    tint = Color(0xEDF5FFFF)
                )
            }
        }
    }
}

