package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.ui.theme.LittleLemonYellow


@Composable
fun Onboarding(navController: NavHostController) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

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
        // Title with green background
        Text(
            text = stringResource(R.string.onboarding_title),
            fontSize = 30.sp,
            fontFamily= FontFamily(Font(R.font.markazitextregular)),
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(LittleLemonGreen)
                .padding(16.dp)
                .fillMaxWidth()
                .height(85.dp)
                .wrapContentHeight()

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
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold)),
        )
        TextField(
            value = firstName,
            onValueChange = {firstName = it},
            modifier = Modifier.fillMaxWidth().padding(bottom=16.dp)
        )


        Text(
            text = "Last Name",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold)),
        )
        TextField(
            value = lastName,
            onValueChange = {lastName = it},
            modifier = Modifier.fillMaxWidth().padding(bottom=16.dp)
        )

        Text(
            text = "Email",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.karlaregular, FontWeight.Bold)),
        )
        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(bottom=16.dp)
        )

        // Button at the bottom of the page
        MyButton(text = "Register", onClick = { /*TODO*/ }, color = LittleLemonYellow)

    }


}





