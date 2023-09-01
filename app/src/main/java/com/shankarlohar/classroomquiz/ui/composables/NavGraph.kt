package com.shankarlohar.classroomquiz.ui.composables

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") {
            LoginScreen(
                onTeacherLoginClick = { navController.navigate("homeScreen") },
                onTeacherSignupClick = { navController.navigate("signupScreen") },
                onStartQuizAsStudentClick = { /* TODO: Navigate to student quiz screen */ }
            )
        }
        composable("signupScreen") {
            SignupScreen(navController)
        }
        composable("homeScreen") {
            HomeScreen(navController)
        }
        composable("createQuizScreen") {
            // Your CreateQuizScreen composable here
        }
        composable("leaderboardScreen/{quizName}") { backStackEntry ->
            val quizName = backStackEntry.arguments?.getString("quizName")
            LeaderboardScreen(quizName)
        }
    }
}


