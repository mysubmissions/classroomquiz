package com.shankarlohar.classroomquiz.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onTeacherLoginClick: () -> Unit,
    onTeacherSignupClick: () -> Unit,
    onStartQuizAsStudentClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Classroom Quiz",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp) // Optional, if you want rounded corners
                )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CustomStyledTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = "Teacher Email",
                )

                CustomStyledTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Teacher Password",
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                Button(
                    onClick = { onTeacherLoginClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Login as Teacher")
                }
            }
        }



        var quizId by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp) // Optional, if you want rounded corners
                )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomStyledTextField(
                    value = quizId,
                    onValueChange = { quizId = it },
                    label = "Enter the quiz id given by your teacher"
                )

                Button(
                    onClick = { onStartQuizAsStudentClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(text = "Start Quiz as Student")
                }
            }
        }

        Divider(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        )

        Button(
            onClick = { onTeacherSignupClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Signup as Teacher")
        }
    }
}
