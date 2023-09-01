package com.shankarlohar.classroomquiz.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shankarlohar.classroomquiz.ui.composables.teacher.CreateQuizScreen
import com.shankarlohar.classroomquiz.ui.composables.teacher.HomeScreen
import com.shankarlohar.classroomquiz.ui.composables.teacher.LeaderboardScreen
import com.shankarlohar.classroomquiz.ui.composables.LoginScreen
import com.shankarlohar.classroomquiz.ui.composables.student.ResultScreen
import com.shankarlohar.classroomquiz.ui.composables.student.StudentQuizScreen
import com.shankarlohar.classroomquiz.ui.composables.teacher.SignupScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") {
            LoginScreen(
                onTeacherLoginClick = { navController.navigate("homeScreen") },
                onTeacherSignupClick = { navController.navigate("signupScreen") },
                onStartQuizAsStudentClick = { navController.navigate("studentQuizScreen") }
            )
        }
        composable("signupScreen") {
            SignupScreen(navController)
        }
        composable("homeScreen") {
            HomeScreen(navController)
        }
        composable("createQuizScreen") {
            CreateQuizScreen(navController)
        }
        composable("leaderboardScreen/{quizName}") { backStackEntry ->
            val quizName = backStackEntry.arguments?.getString("quizName")
            LeaderboardScreen(quizName)
        }
        composable("studentQuizScreen") {
            StudentQuizScreen(navController)
        }
        composable("resultScreen/{correctAnswers}/{questionsSize}") { backStackEntry ->
            val correctAnswers = backStackEntry.arguments?.getString("correctAnswers")?.toInt() ?: 0
            val questionsSize = backStackEntry.arguments?.getString("questionsSize")?.toInt() ?: 0
            ResultScreen(navController, correctAnswers, questionsSize)
        }


    }
}


