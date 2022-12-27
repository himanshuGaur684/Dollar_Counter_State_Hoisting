package gaur.himanshu.dollarcounter

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gaur.himanshu.dollarcounter.ui.theme.DollarCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DollarCounterTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        DollarCounter()
    }
}

@Composable
fun DollarCounter() {

    val counter = remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "$${counter.value * 100}", style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(180.dp))

        CustomButton { counter.value++ }
    }
}


@Composable
fun CustomButton(onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable {
                onClick.invoke()
            }, shape = CircleShape, backgroundColor = Color.Yellow
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Tap",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }

}

// without state hoisting

@Composable
fun CustomButtonWithoutStateHoisting(counter: MutableState<Int>, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable {
                counter.value++
            }, shape = CircleShape, backgroundColor = Color.Yellow
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Tap",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }

}

