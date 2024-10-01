import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.ui.theme.StudyFlashTheme
import com.example.studyflash.ui.theme.TopBarBg
import com.example.studyflash.ui.theme.Wording
import com.example.studyflash.ui.theme.YrsaFamily

// will be taken from fatma
@Composable
fun TopNavBar() {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(116.dp)
        .clip(
            RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 16.dp,
                bottomEnd = 16.dp
            )
        )
        .background(TopBarBg),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top=30.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "StudyFlash",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = YrsaFamily, fontWeight = FontWeight.Bold,
                    color = Wording,
                )
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    StudyFlashTheme {
        TopNavBar()
    }
}

