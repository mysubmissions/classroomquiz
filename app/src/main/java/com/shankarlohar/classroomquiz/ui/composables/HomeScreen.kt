package com.shankarlohar.classroomquiz.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                navController.navigate("createQuizScreen")
            }
        ) {
            Text("Create a Quiz")
        }

        Divider(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Replace this with your data
            val pastQuizzes = listOf("Quiz 1", "Quiz 2", "Quiz 3")
            items(pastQuizzes) { quiz ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            // Navigate to the leaderboard screen of that quiz
                            navController.navigate("leaderboardScreen/$quiz")
                        }
                        .border(1.dp, Color.White, CircleShape)
                        .clip(CircleShape),
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(CircleShape),
                        color = Color.Black
                    ) {
                        Text(
                            text = quiz,
                            modifier = Modifier.padding(16.dp),
                        )
                    }
                }
            }
        }
    }
}
