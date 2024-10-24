package com.example.studyflash.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.studyflash.R
import com.example.studyflash.viewmodels.CategoryCardViewModel

//@Preview
@Composable
fun CategoriesList(navController: NavHostController) {
    val viewModel:CategoryCardViewModel = hiltViewModel()
    viewModel.loadCategories()
    val items by viewModel.Categories.collectAsState()
    LazyColumn {
        items(items){
                item ->
            Card (
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(100.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                // Handle normal tap to navigate to Cards List
                                navController.navigate("Cards List/${item.id}")
                            },
                            onLongPress = {
                                // Handle long press to navigate to Edit Category
                                navController.navigate("editCategory/${item.id}")
                            }
                        )
                    }
            ){


                Row(modifier = Modifier.padding(15.dp)) {
                    Column (
//                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ){
                        Row {
                            Text(text = item.name, fontSize = 20.sp)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row {
                            Icon(painter = painterResource(id = R.drawable.cards),
                                contentDescription = "Layers",
                                modifier = Modifier.size(15.dp)
                            )
                            Text(text = "${1}", fontSize = 12.sp, modifier = Modifier
                                .padding(start = 1.dp))
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    CustomCircularProgressIndicator(
                        progress = item.progress.toFloat() / 10.toFloat(),
                        size = 40.dp, // Size of the progress indicator
                        strokeWidth = 6.dp, // Thickness of the progress indicator
                        backgroundColor = Color.LightGray, // Background color for the unfinished progress
                        progressColor = Color(0xFFFF873D) // Optional: Change the color of the progress arc
                    )
                }
            }




            //            Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp) // Adjust padding as needed
//        ) {
//            Text(text = "Category: ${item.name}", fontSize = 20.sp)
//            Text(text = "Number of Cards: ${item.numberOfCards}", fontSize = 16.sp)
//            Text(text = "Number Completed: ${item.numberOfCompleted}", fontSize = 16.sp)
//            Spacer(modifier = Modifier.height(8.dp)) // Space between items
//        }
        }
    }
}


@Composable
fun CustomCircularProgressIndicator(
    progress: Float,
    size: Dp,
    strokeWidth: Dp,
    backgroundColor: androidx.compose.ui.graphics.Color = Color(0xEDF5FFFF), // Background color for the unfinished progress
    progressColor: androidx.compose.ui.graphics.Color = Color(0xFFFF873D) // Color for the progress arc
) {
    Canvas(modifier = Modifier.size(size)) {
        val diameter = size.toPx()
        val radius = diameter / 2

        // Draw background circle (unfinished progress)
        drawCircle(
            color = backgroundColor,
            radius = radius,
            style = Stroke(width = strokeWidth.toPx())
        )

        // Draw the arc for the progress
        drawArc(
            color = progressColor,
            startAngle = -90f,
            sweepAngle = 360 * progress,
            useCenter = false,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round) // Rounded ends
        )
    }
}