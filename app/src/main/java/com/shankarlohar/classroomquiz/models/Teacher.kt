package com.shankarlohar.classroomquiz.models

data class Teacher(
    val teacherId: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val school: String,
    val department: String,
    val quizzesCreated: List<String> // List of quiz IDs that this teacher has created

)
