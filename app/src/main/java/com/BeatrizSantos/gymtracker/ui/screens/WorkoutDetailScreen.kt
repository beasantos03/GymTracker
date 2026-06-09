package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel
import kotlinx.coroutines.launch

@Composable
fun WorkoutDetailScreen(
    workoutId: Long,
    viewModel: WorkoutViewModel,
    onAddExerciseClick: (Long) -> Unit
) {

    var workoutName by remember { mutableStateOf("A carregar...") }
    var workoutDescription by remember { mutableStateOf("") }

    LaunchedEffect(workoutId) {

        val workout = viewModel.getWorkoutById(workoutId)

        workout?.let {
            workoutName = it.name
            workoutDescription = it.description
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = workoutName,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = workoutDescription,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Exercícios",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Supino")
        Text("4 séries x 10 reps - 60kg")

        Spacer(modifier = Modifier.height(12.dp))

        Text("Crucifixo")
        Text("3 séries x 12 reps - 15kg")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onAddExerciseClick(workoutId)
            }
        ) {
            Text("Adicionar Exercício")
        }
    }
}