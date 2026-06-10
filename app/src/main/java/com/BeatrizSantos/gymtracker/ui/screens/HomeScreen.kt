package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    userName: String,
    userGoal: String,
    workoutCount: Int,
    onPlansClick: () -> Unit,
    onMyWorkoutsClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = "Olá, $userName ",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Objetivo: $userGoal",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Treinos criados: $workoutCount",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Button(
            onClick = onPlansClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Planos de Treino")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onMyWorkoutsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Os Meus Treinos")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onProfileClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Perfil")
        }
    }
}
