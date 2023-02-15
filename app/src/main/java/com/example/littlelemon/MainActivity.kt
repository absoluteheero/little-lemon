package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.components.Home
import com.example.littlelemon.components.OnBoarding
import com.example.littlelemon.components.Onboarding
import com.example.littlelemon.components.Profile
import com.example.littlelemon.data.UserSingleton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UserSingleton.loadFromPreferences(this)

        setContent {
            MyNavigation()
        }
    }
}

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