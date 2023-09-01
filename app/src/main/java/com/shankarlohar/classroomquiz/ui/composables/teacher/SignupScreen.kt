package com.shankarlohar.classroomquiz.ui.composables.teacher

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.shankarlohar.classroomquiz.ui.custom.CustomStyledTextField

@Composable
fun SignupScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var school by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp) // Optional, if you want rounded corners
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hey! Let's get you started.",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            CustomStyledTextField(
                value = email,
                onValueChange = { email = it },
                label = "Your Email",

                )

            CustomStyledTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                visualTransformation = PasswordVisualTransformation(),

                )

            CustomStyledTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirm Password",
                visualTransformation = PasswordVisualTransformation(),

                )

            CustomStyledTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = "First Name",

                )

            CustomStyledTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = "Last Name",

                )

            CustomStyledTextField(
                value = school,
                onValueChange = { school = it },
                label = "School",

                )

            CustomStyledTextField(
                value = department,
                onValueChange = { department = it },
                label = "Department",

                )

            Button(onClick = {
                // Validate the entered details
                // Create an instance of the Teacher data class
                // Navigate to home screen
                navController.navigate("homeScreen")
            }) {
                Text("Signup")
            }
        }
    }


}

