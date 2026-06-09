package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel

@Composable
fun WorkoutListScreen(
    viewModel: WorkoutViewModel,
    onAddWorkoutClick: () -> Unit,
    onWorkoutClick: (Long) -> Unit
) {

    val workouts by viewModel.workouts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Gym Tracker",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAddWorkoutClick
        ) {
            Text("Novo Treino")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(workouts) { workout ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {

                    Text(
                        text = workout.name,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = workout.description
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            onWorkoutClick(workout.id)
                        }
                    ) {
                        Text("Abrir Treino")
                    }
                }
            }
        }
    }
}