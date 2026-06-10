package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel

@Composable
fun EditWorkoutScreen(
    workout: WorkoutEntity,
    viewModel: WorkoutViewModel,
    onWorkoutUpdated: () -> Unit,
    onBackClick: () -> Unit
) {

    var workoutName by remember {
        mutableStateOf(workout.name)
    }

    var workoutDescription by remember {
        mutableStateOf(workout.description)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Editar Treino",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = workoutName,
            onValueChange = {
                workoutName = it
            },
            label = {
                Text("Nome do treino")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = workoutDescription,
            onValueChange = {
                workoutDescription = it
            },
            label = {
                Text("Descrição")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = {

                viewModel.updateWorkout(
                    workout.copy(
                        name = workoutName,
                        description = workoutDescription
                    )
                )

                onWorkoutUpdated()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Alterações")
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