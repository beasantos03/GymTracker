package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel

@Composable
fun AddWorkoutScreen(
    viewModel: WorkoutViewModel,
    onWorkoutSaved: () -> Unit,
    onBackClick: () -> Unit
) {

    var workoutName by remember { mutableStateOf("") }
    var workoutDescription by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = "Novo Treino",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = workoutName,
            onValueChange = { workoutName = it },
            label = { Text("Nome do treino") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = workoutDescription,
            onValueChange = { workoutDescription = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = {

                if (workoutName.isNotBlank()) {

                    viewModel.addWorkout(
                        name = workoutName,
                        description = workoutDescription
                    )

                    onWorkoutSaved()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
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