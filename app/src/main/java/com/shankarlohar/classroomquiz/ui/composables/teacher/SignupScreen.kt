package com.shankarlohar.classroomquiz.ui.composables.teacher

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shankarlohar.classroomquiz.models.Teacher
import com.shankarlohar.classroomquiz.ui.custom.CustomStyledTextField

@Composable
fun SignupScreen(navController: NavHostController) {

    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current


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
                if (password == confirmPassword) {
                    val teacher = Teacher(
                        teacherId = "", // This will be updated later in the ViewModel
                        email = email,
                        firstName = firstName,
                        lastName = lastName,
                        school = school,
                        department = department,
                        quizzesCreated = listOf()
                    )
                    authViewModel.createTeacherAccount(email, password, teacher) { success, errorMsg ->
                        if (success) {
                            navController.navigate("homeScreen")
                        } else {
                            Toast.makeText(context, "Failed to create account: $errorMsg", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Password and Confirm Password must match", Toast.LENGTH_LONG).show()
                }
            }) {
                Text("Signup")
            }


        }
    }


}

