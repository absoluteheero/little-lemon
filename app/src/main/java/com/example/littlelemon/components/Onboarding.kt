package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

@Composable
fun Onboarding() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Logo image
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth()
                .height(85.dp)
                .padding(top= 8.dp, bottom = 16.dp)
        )
        // Title with green background
        Text(
            text = stringResource(R.string.onboarding_title),
            fontSize = 30.sp,
            fontFamily= FontFamily(Font(R.font.markazitextregular)),
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(colorResource(id = R.color.green))
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
        OutlinedTextField(
            value = "",
            onValueChange = { /* TODO */ },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* TODO */ },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* TODO */ },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button at the bottom of the page
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview(){
    Onboarding();
}




