package uz.khamroev.screens

import android.widget.ImageView.ScaleType
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.khamroev.R
import uz.khamroev.navigation.Screens
import uz.khamroev.ui.theme.Gray
import uz.khamroev.ui.theme.Gray_Text
import uz.khamroev.ui.theme.Green_Primary
import uz.khamroev.ui.theme.White

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
    var passwordVisibility = remember { mutableStateOf(false) }


    Surface(color = Color.White, modifier = Modifier.padding(0.dp)) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)) {

            Image(modifier = Modifier
                .fillMaxSize()
                .padding(0.dp), contentScale = ContentScale.FillBounds, painter = painterResource(id = R.drawable.bg), contentDescription = "")

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(text = "Find your doctor", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(30.dp))

            TextField(value = "", onValueChange = {name.value=it}, modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(12.dp)), placeholder = {Text(text = "Name")},
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Gray_Text,
                    disabledTextColor = Color.Transparent,
                    containerColor = Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ))

            TextField(
                value = if (email_phone_status.value) phonenumber.value else email.value,
                onValueChange = {
                    if (email_phone_status.value) phonenumber.value = it else email.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = {
                    Text(text = if (email_phone_status.value) "Phonenumber" else "Email")
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Gray_Text,
                    disabledTextColor = Color.Transparent,
                    containerColor = Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                visualTransformation = if (email_phone_status.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = if (email_phone_status.value) KeyboardType.Phone else KeyboardType.Email
                ),
                singleLine = true
            )

            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(14.dp)),
                placeholder = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Gray_Text,
                    disabledTextColor = Color.Transparent,
                    containerColor = Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                        val icon =
                            if (passwordVisibility.value) painterResource(R.drawable.ic_visible)
                            else painterResource(R.drawable.ic_invisible)
                        Icon(
                            painter = icon,
                            contentDescription = if (passwordVisibility.value) "Hide password" else "Show password")
                    }
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "Another way", fontSize = 20.sp,  color = Green_Primary, modifier = Modifier.clickable {
                email_phone_status.value=!email_phone_status.value
            })

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp)),
              colors= ButtonDefaults.buttonColors(containerColor = Green_Primary)) {

                Text("Sign Up", color = White, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(120.dp))

            Text(text = "Have an account? Log in", fontSize = 20.sp, color = Green_Primary, modifier = Modifier.clickable {

                    navController.navigate(Screens.SignIn.route)

            })

        }
    }
}


