package com.example.studyflash.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.R
import com.example.studyflash.classes.Category
import com.example.studyflash.ui.colors.Colors
import com.example.studyflash.ui.composables.ChooseColor
import com.example.studyflash.ui.theme.AlexandriaFamily
import com.example.studyflash.ui.theme.BackgroundColor
import com.example.studyflash.ui.theme.Blue
import com.example.studyflash.ui.theme.BlueStroke
import com.example.studyflash.ui.theme.Brown
import com.example.studyflash.ui.theme.BrownStroke
import com.example.studyflash.ui.theme.GreenStroke
import com.example.studyflash.ui.theme.Green
import com.example.studyflash.ui.theme.Pink
import com.example.studyflash.ui.theme.PinkStroke
import com.example.studyflash.ui.theme.PrimaryColor
import com.example.studyflash.ui.theme.Purple
import com.example.studyflash.ui.theme.PurpleStroke
import com.example.studyflash.ui.theme.Yellow
import com.example.studyflash.ui.theme.YellowStroke
import com.example.studyflash.ui.theme.add_edit_bck
import com.example.studyflash.ui.theme.add_edit_border
import com.example.studyflash.ui.theme.add_edit_txtField_bck
import com.example.studyflash.viewmodels.CategoryCardViewModel


@Composable
fun Add_Edit_Category(navController: NavController, catID:Int?) {
    val viewModel:CategoryCardViewModel = hiltViewModel()
    viewModel.loadCategories()
    val categories by viewModel.Categories.collectAsState()
    var category: Category? = null
    if(catID!=null){
        category = categories.find { it.id==catID }

    }
    var catName = "Category Name"

    if(category!=null){
        catName=category.name
    }

    var CategoryName by remember {
        mutableStateOf(catName)
    }
    Image(
        painter = painterResource(id = R.drawable.add_edit_bck),
        contentDescription = "background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color.Black,
                shape = RectangleShape,
                clip = false
            )
            .padding(5.dp)  ) {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .height(500.dp)
                    .background(color = add_edit_bck)
                    .border(3.dp, color = add_edit_border),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = "Category",
                    modifier = Modifier.fillMaxWidth(),
                    color = PrimaryColor,
                    fontSize = 20.sp,
                    fontFamily = AlexandriaFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(70.dp))
                BasicTextField(
                    value = CategoryName, onValueChange = { CategoryName = it }, modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .width(250.dp)
                        .background(color = add_edit_txtField_bck)
                        .padding(8.dp), textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = AlexandriaFamily,
                        fontWeight = FontWeight.Normal,
                    )
                )
                Spacer(modifier = Modifier.height(60.dp))

                var selectedColor by remember {
                    mutableStateOf(1)
                }

                val colors = listOf(Colors.GreenColor, Colors.YellowColor, Colors.BlueColor, Colors.PinkColor, Colors.PurpleColor, Colors.BrownColor)

                Row(
                    horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp)
                ) {
                    for (i in 0..2) {
                        ChooseColor(color = colors[i].color, colors[i].id, colors[i].id == selectedColor) {
                            selectedColor = colors[i].id
                        }
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp)
                ) {
                    for (i in 3..5) {
                        ChooseColor(color = colors[i].color, colors[i].id, colors[i].id == selectedColor) {
                            selectedColor = colors[i].id
                        }
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = {
                        // add/edit category using Category Viewmodel
                  if(category!=null){
                      val newCategory = category.copy(name = CategoryName, colorID = selectedColor)
                      viewModel.updateCategory(newCategory)
                  }else{
                      val newCategory = Category(2,CategoryName, selectedColor, mutableListOf(), 0)
                      viewModel.addCategory(newCategory)

                  }
                        //back to categories list page
//                      navController.popBackStack("", false)
                        navController.navigate("addCard/${1}")
                    },
                    Modifier
                        .width(200.dp)
                        .shadow(5.dp, spotColor = Color.Black, shape = RoundedCornerShape(20.dp)),
                    colors = ButtonDefaults.buttonColors().copy(containerColor = PrimaryColor), shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Save", fontSize = 16.sp, color = BackgroundColor)

                }
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun prev(){
    Add_Edit_Category(navController = rememberNavController(), catID =null )
}