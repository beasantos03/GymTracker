package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutDetailScreen(
    workoutId: Long
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Detalhes do Treino",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("ID do treino: $workoutId")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // adicionar exercício mais tarde
            }
        ) {
            Text("Adicionar Exercício")
        }
    }
}