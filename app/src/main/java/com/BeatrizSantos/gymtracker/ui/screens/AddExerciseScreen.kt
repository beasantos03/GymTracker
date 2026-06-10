package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.viewmodel.ExerciseViewModel

@Composable
fun AddExerciseScreen(
    workoutId: Long,
    exerciseViewModel: ExerciseViewModel,
    onExerciseSaved: () -> Unit
) {

    var exerciseName by remember { mutableStateOf("") }
    var sets by remember { mutableStateOf("") }
    var reps by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Novo Exercício",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Treino ID: $workoutId")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = exerciseName,
            onValueChange = { exerciseName = it },
            label = { Text("Nome do exercício") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = sets,
            onValueChange = { sets = it },
            label = { Text("Séries") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = reps,
            onValueChange = { reps = it },
            label = { Text("Repetições") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                if (
                    exerciseName.isNotBlank() &&
                    sets.isNotBlank() &&
                    reps.isNotBlank()
                ) {

                    exerciseViewModel.saveExercise(
                        workoutId = workoutId,
                        name = exerciseName,
                        sets = sets.toIntOrNull() ?: 0,
                        reps = reps.toIntOrNull() ?: 0,
                        weight = weight.toDoubleOrNull() ?: 0.0
                    )

                    onExerciseSaved()
                }
            }
        ){
            Text("Guardar Exercício")
        }
    }
}