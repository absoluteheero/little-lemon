package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R

@Composable
fun Home(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Logo image
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .padding(top = 8.dp, bottom = 16.dp, end = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){

            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .height(85.dp)
                    .padding(top = 8.dp, bottom = 16.dp, end = 16.dp)
                    .clickable { navController.navigate(Profile.route) }

            )
        }

    }



}