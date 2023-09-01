package com.shankarlohar.classroomquiz.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class StudentScore(val name: String, val score: Int)

@Composable
fun LeaderboardScreen(quizName: String?) {
    // Dummy data, replace with real data
    val scores = listOf(
        StudentScore("Alice", 95),
        StudentScore("Bob", 90),
        StudentScore("Catherine", 85),
        StudentScore("David", 80)
    ).sortedByDescending { it.score }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Leaderboard for $quizName",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(scores) { studentScore ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.Gray.copy(alpha = 0.2f)),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = studentScore.name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = studentScore.score.toString(),
                        color = Color.Green,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
