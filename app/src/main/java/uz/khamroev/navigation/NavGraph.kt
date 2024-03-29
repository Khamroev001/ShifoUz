package uz.khamroev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.khamroev.screens.OnboardingViewPager
import uz.khamroev.screens.SignInScreen
import uz.khamroev.screens.SignUpScreen
import uz.khamroev.screens.SplashScreen

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route)
    {
        composable(route = Screens.Splash.route){
            SplashScreen(navController)
        }

        composable(route = Screens.SignUp.route){
            SignUpScreen(navController)
        }
        composable(route = Screens.SignIn.route){
            SignInScreen(navController)
        }

        composable(route = Screens.Pager.route){
            OnboardingViewPager(navController)
        }


    }
}