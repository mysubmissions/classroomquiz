package com.shankarlohar.classroomquiz.models

data class Result(
    val quizId: String,  // Unique identifier for the quiz
    val studentId: String,
    val score: Int
)
