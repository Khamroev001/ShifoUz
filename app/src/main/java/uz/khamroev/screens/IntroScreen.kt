package uz.khamroev.navigation
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Screen"
        )

        Spacer(modifier = Modifier.height(height = 8.dp))

        // name text field
        var name by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = name,
            onValueChange = { newValue ->
                name = newValue
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") }
        )

        Spacer(modifier = Modifier.height(height = 8.dp))

        // age text field
        var age by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = age,
            onValueChange = { newValue ->
                age = newValue
            },
            label = { Text(text = "Age") },
            placeholder = { Text(text = "Enter your age") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(height = 8.dp))

        // submit button
        Button(
            onClick = {
//                navController.navigate(route = Screens.Home.getFullRoute(name = name, age = age))
            }
        ) {
            Text(text = "Submit")
        }
    }
}