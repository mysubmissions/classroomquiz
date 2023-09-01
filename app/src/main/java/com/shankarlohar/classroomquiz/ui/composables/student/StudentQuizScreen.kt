package com.shankarlohar.classroomquiz.ui.composables.student


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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shankarlohar.classroomquiz.models.Question
import java.util.*

@Composable
fun StudentQuizScreen(navController: NavController) {
    val questions = listOf(
        Question("quiz1", "What is 2 + 2?", listOf("3", "4", "5"), 1),
        Question("quiz1", "What is the capital of France?", listOf("Berlin", "Madrid", "Paris"), 2),
        // ... more questions
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var correctAnswers by remember { mutableStateOf(0) }
    var showResults by remember { mutableStateOf(false) }

    LaunchedEffect(showResults) {
        if (showResults) {
            navController.navigate("resultScreen/$correctAnswers/${questions.size}")
        }
    }


    // Show Question Answering Screen
    val question = questions[currentQuestionIndex]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Question ${currentQuestionIndex + 1}: ${question.questionText}",
            modifier = Modifier.padding(16.dp)
        )

        question.options.forEachIndexed { index, option ->
            Button(onClick = {
                // Check answer and increment correct answer count
                if (index == question.correctAnswer) correctAnswers++

                // Move to next question or show results
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                } else {
                    showResults = true
                }
            }) {
                Text(option)
            }
        }
    }
}
