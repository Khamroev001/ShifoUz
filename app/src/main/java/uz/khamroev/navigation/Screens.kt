package uz.khamroev.navigation


sealed class Screens(val route:String) {
    object Splash:Screens("splash_screen")
    object Intro:Screens("intro_screen")
}