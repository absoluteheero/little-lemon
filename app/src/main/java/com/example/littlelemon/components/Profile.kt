package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.data.UserSingleton
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.ui.theme.LittleLemonYellow

@Composable
fun Profile(navController: NavHostController) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Logo image
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .padding(top = 8.dp, bottom = 16.dp)
        )

        // Personnal info subtitle
        Text(
            text = "Personal information",
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold)),
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        // Input text fields for first name, last name, and email
        Text(
            text = "First Name",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold))
        )
        Text(
            text = UserSingleton.firstName.toString(),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom=16.dp),
            fontFamily = FontFamily(Font(R.font.markazitextregular)),
            fontSize = 24.sp
        )


        Text(
            text = "Last Name",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold))
        )

        Text(
            text = UserSingleton.lastName.toString(),
            modifier = Modifier.fillMaxWidth().padding(bottom=16.dp),
            fontFamily = FontFamily(Font(R.font.markazitextregular)),
            fontSize = 24.sp
        )

        Text(
            text = "Email",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold)),
        )
        Text(
            text = UserSingleton.email.toString(),
            modifier = Modifier.fillMaxWidth().padding(bottom=16.dp),
            fontFamily = FontFamily(Font(R.font.markazitextregular)),
            fontSize = 24.sp
        )

        // Button at the bottom of the page
        MyButton(text = "Logout", onClick = {
            UserSingleton.logout(context)
            navController.navigate(OnBoarding.route)
        },
            color = LittleLemonYellow
        )

    }

}