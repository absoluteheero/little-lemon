package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.littlelemon.R

@Composable
fun Home(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(150.dp, 150.dp)
                    )
                }
            },
            actions = {
                Box(modifier = Modifier.size(48.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(end = 8.dp)
                            .clickable { navController.navigate(Profile.route) }

                    )
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 4.dp
        )


    }


}

