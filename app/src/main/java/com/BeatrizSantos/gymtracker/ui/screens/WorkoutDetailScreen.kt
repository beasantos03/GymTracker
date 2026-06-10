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
import com.BeatrizSantos.gymtracker.viewmodel.ExerciseViewModel

@Composable
fun WorkoutDetailScreen(
    workoutId: Long,
    viewModel: WorkoutViewModel,
    exerciseViewModel: ExerciseViewModel,
    onAddExerciseClick: (Long) -> Unit
) {

    var workoutName by remember { mutableStateOf("A carregar...") }
    var workoutDescription by remember { mutableStateOf("") }

    val exercises by exerciseViewModel
        .getExercisesForWorkout(workoutId)
        .collectAsState(initial = emptyList())

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

        if (exercises.isEmpty()) {

            Text("Ainda não existem exercícios.")

        } else {

            exercises.forEach { exercise ->

                Text(
                    text = exercise.exerciseName,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text =
                        "${exercise.sets} séries x " +
                                "${exercise.reps} reps - " +
                                "${exercise.weight}kg"
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
        }

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