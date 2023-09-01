package com.shankarlohar.classroomquiz.models

data class Question(
    val quizId: String,  // Unique identifier for the quiz
    val questionText: String,
    val options: List<String>,
    val correctAnswer: Int
)
