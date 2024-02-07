package uz.khamroev.navigation


sealed class Screens(val route:String) {
    object Splash:Screens("splash_screen")
    object SignUp:Screens("signup_screen")
}