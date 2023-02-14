package com.example.littlelemon.components

interface Destinations{
    val route: String
}

object Home: Destinations {
    override val route = "Home"
}