package uz.khamroev.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import uz.khamroev.R
import uz.khamroev.navigation.Screens
import uz.khamroev.ui.theme.Green_Primary

data class OnboardingPage(
    val title: String,
    val description: String,
    val image:Int
)



private val onboardingPages = listOf(
    OnboardingPage("Easy Appointments", "Find and book appointments with ease!", R.drawable.logo),
    OnboardingPage("Manage Your Schedule", "Keep track of all your appointments in one place.", R.drawable.logo),
    OnboardingPage("Get Reminders", "Never miss an appointment again with reminders and notifications.", R.drawable.logo),
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingViewPager(navController: NavHostController) {
    val pagerState = rememberPagerState(onboardingPages.size)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Optional background color
    ) {
        HorizontalPager(pagerState) { index ->
            OnboardingPageContent(onboardingPages[index])
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp).align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            onboardingPages.indices.forEach { index ->
                Indicator(
                    color = if (pagerState.currentPage == index) Green_Primary else Color.Gray,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(20.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                )
            }
        }

        if (pagerState.currentPage == onboardingPages.lastIndex) {
            Button(
                onClick = {
                          navController.navigate(Screens.SignUp.route)
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(containerColor = Green_Primary)
            ) {
                Text(text = "Get Started", color = Color.White)
            }
        }

    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id =page.image), // Update with your image resource
            contentDescription = "",
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(150.dp))
        )

        Text(
            text = page.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        )

        Text(
            text = page.description,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        )
    }
}