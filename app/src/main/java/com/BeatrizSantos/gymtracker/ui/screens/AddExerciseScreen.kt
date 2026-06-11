package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.viewmodel.ExerciseViewModel
import com.BeatrizSantos.gymtracker.data.model.exerciseCatalog

@Composable
fun AddExerciseScreen(
    workoutId: Long,
    exerciseViewModel: ExerciseViewModel,
    onExerciseSaved: () -> Unit,
    onBackClick: () -> Unit
) {

    var exerciseName by remember { mutableStateOf("") }

    var expanded by remember {
        mutableStateOf(false)
    }

    var sets by remember { mutableStateOf("") }
    var reps by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = "Novo Exercício",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Treino")

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "ID: $workoutId",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {
                expanded = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                if (exerciseName.isBlank())
                    "Selecionar Exercício"
                else
                    exerciseName
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {

            exerciseCatalog.forEach { exercise ->

                DropdownMenuItem(
                    text = {
                        Text(exercise)
                    },

                    onClick = {

                        exerciseName = exercise
                        expanded = false
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = sets,
            onValueChange = { sets = it },
            label = { Text("Séries") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = reps,
            onValueChange = { reps = it },
            label = { Text("Repetições") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

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
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Exercício")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}