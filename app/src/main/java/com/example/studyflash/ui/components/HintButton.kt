package com.example.studyflash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R
import com.example.studyflash.viewmodels.Hint

val Hints = listOf(
    Hint(id = 1, text = "connecting devices to internet without using wires connecting devices to internet without using wires "),
    Hint(id = 2, text = "Hint 2"),
    Hint(id = 3, text = "Hint 3"),
)

//@Preview(showBackground = true)
@Composable
fun HintButton(hints: List<Hint>, onRevealHint: () -> Unit){
    Column {
        Button(
            onClick = {
                onRevealHint()
            },
            enabled = hints.isNotEmpty(),
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            contentPadding = PaddingValues(0.dp)
        ){
            Column {
                Row (
                    modifier = Modifier
                        .background(
                            color = Color(0xFFFF873D), // Orange color
                            shape = RoundedCornerShape(20.dp) // Rounded corners
                        )
                        .padding(horizontal = 4.dp, vertical = 1.dp)
                ){
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.bulb),   // Use Icon directly
                            contentDescription = "Energy Icon",
                            tint = Color(0xFFFFF1D6),
                            modifier = Modifier
                                .size(25.dp)
                                .padding(start = 0.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)

                    ) {
                        Text(
                            text = "30",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            letterSpacing = 1.sp,
                            color = Color(0xFFFFF1D6),
//                modifier = Modifier.weight(1f)
                            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                        )
                    }
                }
            }
        }
}
}

@Composable
fun HintList(revealedHint: Int) {
    LazyColumn (
//        reverseLayout = true
    ){
        items(revealedHint) { index ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
//                    .border(BorderStroke(1.dp, Color(0xFFCCCCCC)), RoundedCornerShape(20.dp))
//                    .background(Color(0xFF33B4FF), shape = RoundedCornerShape(20.dp))
                    .graphicsLayer {
                        // Adjust shadow properties
//                        shadowElevation = 4.dp.toPx()
                        shape = RoundedCornerShape(20.dp) // Set shadow shape
                        clip = true // Clip the shadow to the shape
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xAA33B4FF)
                ),
//                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.bulb),   // Use Icon directly
                        contentDescription = "Energy Icon",
                        tint = Color(0xFFFFF1D6),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = Hints[index].text,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                }
            }


        }
    }
}

@Preview
@Composable
fun PreviewHintButton() {
    Column {
        HintButton(hints = Hints, onRevealHint = {})
        HintList(revealedHint = 1)
    }
}