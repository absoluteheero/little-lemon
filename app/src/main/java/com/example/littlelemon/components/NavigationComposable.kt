package com.example.littlelemon.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.data.UserSingleton

@Composable
fun MyNavigation(){

    val startDestination = if (UserSingleton.isLoggedIn){
        Home.route
    } else {
        OnBoarding.route
    }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){
        composable(OnBoarding.route){
            Onboarding(navController)
        }

        composable(Home.route){
            Home(navController)
        }

        composable(Profile.route){
            Onboarding(navController)
        }
    }
}