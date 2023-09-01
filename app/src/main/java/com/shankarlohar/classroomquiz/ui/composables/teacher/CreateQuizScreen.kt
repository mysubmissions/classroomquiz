package com.shankarlohar.classroomquiz.ui.composables.teacher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shankarlohar.classroomquiz.models.Question
import java.util.*

@Composable
fun CreateQuizScreen(navController: NavController) {
    val quizId by remember { mutableStateOf(UUID.randomUUID().toString()) }
    val questions = remember { mutableStateListOf<Question>() }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create a New Quiz",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Quiz ID: $quizId",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        questions.forEachIndexed { index, question ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.Gray.copy(alpha = 0.2f)
            ) {
                Text(
                    text = "Q${index + 1}: ${question.questionText}",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // For demonstration, adding a dummy question to the list
            questions.add(
                Question(
                    quizId = quizId,
                    questionText = "Sample Question ${questions.size + 1}",
                    options = listOf("Option 1", "Option 2"),
                    correctAnswer = 1
                )
            )
        }) {
            Text("Add New Question")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Save the Quiz and its Questions (implement this)
            // Show a toast or dialog that the quiz has been created (implement this)
            // Navigate back to the home screen
            navController.navigate("homeScreen")
        }) {
            Text("Finalize Quiz")
        }
    }
}
