package uz.khamroev.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.khamroev.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {

    var name= remember {
        mutableStateOf("")
    }
    var password=remember {
        mutableStateOf("")
    }
    var email=remember {
        mutableStateOf("")
    }
    var phonenumber=remember {
        mutableStateOf("")
    }
    var email_phone_status= remember {
        mutableStateOf(true) // true=phonenumber false=email
    }


    Surface(color = Color.White, modifier = Modifier.padding(0.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(text = "Find your doctor", fontSize = 24.sp, fontFamily = FontFamily.Serif)

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = "", onValueChange = {name.value=it}, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), label = {Text(text = "Name")})

            TextField(value = "", onValueChange = {phonenumber.value=it}, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), label = {
                if (email_phone_status.value){Text(text = "Phonenumber")}else{
                    Text(text = "Phonenumber")
                }}
                )

            TextField(value = "", onValueChange = {password.value=it}, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), label = {Text(text = "Password")})



            Text(text = "Another way", fontSize = 20.sp, fontFamily = FontFamily.Serif, modifier = Modifier.clickable {
                email_phone_status.value=!email_phone_status.value
            })

           
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).background(
                Color(R.color.green))) {

                Text("Sign Up", color = Color( R.color.white), fontSize = 28.sp)
            }

            Text(text = "Have an account? Log in", fontSize = 20.sp, fontFamily = FontFamily.Serif, color = Color(R.color.green), modifier = Modifier.clickable {
                email_phone_status.value=!email_phone_status.value
            })

        }
    }
}

