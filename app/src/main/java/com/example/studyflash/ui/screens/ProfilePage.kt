package com.example.studyflash.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardDoubleArrowLeft
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.R
import com.example.studyflash.classes.Category
import com.example.studyflash.ui.colors.Colors
import com.example.studyflash.ui.components.TopBar
import com.example.studyflash.ui.theme.GradientColor
import com.example.studyflash.ui.theme.LightBlue
import com.example.studyflash.ui.theme.LightGreen
import com.example.studyflash.ui.theme.LightOrange
import com.example.studyflash.ui.theme.PurpleCircle
import com.example.studyflash.ui.theme.RedHatFamily
import com.example.studyflash.ui.theme.RedRoseFamily
import com.example.studyflash.ui.theme.RoseCircle
import com.example.studyflash.ui.theme.StudyFlashTheme
import com.example.studyflash.ui.theme.TopBarBg
import com.example.studyflash.ui.theme.Wording
import com.example.studyflash.ui.theme.WordingBtn
import com.example.studyflash.viewmodels.CategoryCardViewModel
import com.example.studyflash.viewmodels.UserViewModel
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ProfilePage(navController: NavHostController) {

    val viewModel: CategoryCardViewModel = hiltViewModel()
    val userViewModel: UserViewModel = hiltViewModel()
    userViewModel.fetchCurrentUserDetails()
    // Collect the category list from the ViewModel
    val categoryList by viewModel.Categories.collectAsState()
    val currentUser = FirebaseAuth.getInstance().currentUser

    val userName by userViewModel.username
    val userScore by userViewModel.userScore

    // Load the categories when the composable is first composed
    LaunchedEffect(Unit) {
        viewModel.loadCategories()
    }

    var isDarkMode by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Wording)
    ) {
        TopBar(navController)


        Spacer(modifier = Modifier.height(6.dp))
        ProfileItem(
            icon = Icons.Filled.Person,
            label = userName
        )

        ProfileItem(
            icon = Icons.Filled.Email,
            label = currentUser?.email?:"Email"
        )

        ProfileItem(
            icon = Icons.Filled.Lock,
            label = "********"
        )

        ScoreDisplay(userScore)

        BarChartWithPagination(categoryList)

        Button(
            onClick = {
                navController.navigate("landPage")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp,end = 40.dp, top = 30.dp)
                .background(
                    brush = GradientColor,
                    shape = RoundedCornerShape(50)
                )
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(50),
                    clip = false
                ),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {

            Image(
                painter = painterResource(id = R.drawable.sign_out_squre),
                contentDescription = "Logout Icon",
                modifier = Modifier.size(40.dp),
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Logout",
                fontSize = 20.sp,
                color = WordingBtn,
            )
        }
    }
}


@Composable
fun ThemeToggleButton(
    isDarkMode: Boolean,
    onToggle: (Boolean) -> Unit
) {
    IconToggleButton(
        checked = isDarkMode,
        onCheckedChange = { onToggle(!isDarkMode) },
        modifier = Modifier
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(50)
            )
            .border(
                BorderStroke(2.dp, TopBarBg),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
            .size(40.dp,20.dp)
    ) {
        Icon(
            imageVector = if (isDarkMode) Icons.Filled.DarkMode else Icons.Filled.LightMode,
            contentDescription = "Toggle Dark/Light Mode",
            tint = TopBarBg
        )
    }
}

@Composable
fun ProfileItem(icon: ImageVector, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start=26.dp, end=26.dp,bottom=8.dp, top=10.dp)
            .background(Color.White,shape = RoundedCornerShape(10.dp))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = TopBarBg
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = label,
            fontSize = 20.sp,
            fontFamily = RedHatFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF121212),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Composable
fun ScoreDisplay(score: Int) {

    Box(
        modifier = Modifier
           .padding(start=50.dp, end=50.dp,top=16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(62.dp)
                .border(
                    BorderStroke(4.dp, TopBarBg),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Score: $score",
                fontSize = 30.sp,
                fontFamily = RedRoseFamily,
                fontWeight = FontWeight.Bold,
                color = TopBarBg
            )

            Image(
                painter = painterResource(id = R.drawable.score_thunder),
                contentDescription = "Lightning Icon",
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun BarChartWithPagination(subjects: List<Category>) {
    var currentPage by remember { mutableIntStateOf(0) }
    val itemsPerPage = 5
    val totalPages = (subjects.size + itemsPerPage - 1) / itemsPerPage // Total number of pages

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start=10.dp,end=20.dp,top=20.dp)
        .background(Color.White,shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
            IconButton(
                onClick = {
                    if (currentPage > 0) currentPage--
                },
                enabled = currentPage > 0,
            ) {
                if(currentPage>0) ArrowIcon(isLeft = true)
            }

            BarChart(subjects.drop(currentPage * itemsPerPage).take(itemsPerPage))

            Legend(subjects.drop(currentPage * itemsPerPage).take(itemsPerPage))

            IconButton(
                onClick = {
                    if (currentPage < totalPages - 1) currentPage++
                },
                enabled = currentPage < totalPages - 1
            ) {
                if(currentPage<totalPages-1) ArrowIcon(isLeft = false)
            }
        }
}

@Composable
fun BarChart(subjects: List<Category>) {

    val barWidth = 70f
    val spacing = 10f

    Canvas(modifier = Modifier.size(150.dp,200.dp).padding(top=4.dp)) {
        subjects.forEachIndexed { index, subject ->
            val offsetX = index * (barWidth + spacing)
            drawBar(subject.progress.toFloat()/100,// assume total score 100
                Colors.getColorById(subject.colorID).strokeColor,
                offsetX)
        }
    }
}

fun DrawScope.drawBar(percentage: Float, color: Color, offsetX: Float) {
    val barWidth = 70f
    val barHeight = size.height * percentage
    val cornerRadius = 16f

    // Draw a rounded rectangle with rounded top corners and flat bottom corners
    drawRoundRect(
        color = color,
        topLeft = Offset(offsetX, size.height - barHeight),
        size = Size(barWidth, barHeight),
        cornerRadius = CornerRadius(cornerRadius, cornerRadius)
    )
}

@Composable
fun Legend(subjects: List<Category>) {
    Column(modifier = Modifier.height(200.dp), verticalArrangement = Arrangement.Top) {
        subjects.forEach{subject ->
            LegendItem(color = Colors.getColorById(subject.colorID).strokeColor, text = subject.name)
        }
    }
}

@Composable
fun LegendItem(color: Color, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(16.dp)) {
            drawCircle(color = color)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontFamily = RedRoseFamily, fontWeight = FontWeight.Bold, fontSize = 12.sp)
    }
}

@Composable
fun ArrowIcon(isLeft: Boolean) {
    Icon(
        imageVector = if (isLeft) Icons.Filled.KeyboardDoubleArrowLeft else Icons.Filled.KeyboardDoubleArrowRight,
        contentDescription = null,
        modifier = Modifier.size(35.dp),
        tint = TopBarBg
    )
}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    StudyFlashTheme {
        ProfilePage(navController = rememberNavController())
    }
}
