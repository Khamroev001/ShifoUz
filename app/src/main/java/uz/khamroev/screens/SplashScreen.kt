package uz.khamroev.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import uz.khamroev.R


@Composable
fun SplashScreen(navController: NavHostController){
    LaunchedEffect(key1 = true){
        delay(3000)
        navController.navigate("intro_screen")
    }
    Row(modifier = Modifier
        .fillMaxSize()
        .paint(painter = painterResource(id = R.drawable.bg))) {

        Icon(painter = painterResource(id = R.drawable.logo), contentDescription ="logo", Modifier.align(Alignment.CenterVertically) )

    }
}