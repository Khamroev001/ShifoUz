package uz.khamroev.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import uz.khamroev.R


@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true){
        delay(3000)
        navController.navigate("signup_screen")
    }

    Surface(color = Color.White, modifier = Modifier.padding(0.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg), // Background from drawable
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                contentScale = ContentScale.FillBounds
            )
            Icon(
                painterResource(id = R.drawable.logo),
                contentDescription = "User Icon",
                tint = Color.White,
                modifier = Modifier.size(64.dp)
            )

        }
        }
    }