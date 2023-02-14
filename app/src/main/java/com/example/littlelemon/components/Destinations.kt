package com.example.littlelemon.components

interface Destinations{
    val route: String
}

object OnBoarding: Destinations {
    override val route = "Onboarding"
}

object Home: Destinations {
    override val route = "Home"
}

object Profile: Destinations {
    override val route = "Profile"
}