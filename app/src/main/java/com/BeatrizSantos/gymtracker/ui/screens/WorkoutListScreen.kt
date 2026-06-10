package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment

@Composable
fun WorkoutListScreen(
    viewModel: WorkoutViewModel,
    onAddWorkoutClick: () -> Unit,
    onWorkoutClick: (Long) -> Unit,
    onEditWorkoutClick: (Long) -> Unit,
    onBackClick: () -> Unit
){

    val workouts by viewModel.workouts.collectAsState()

    var workoutToDelete by remember {
        mutableStateOf<WorkoutEntity?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = "Os Meus Treinos",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Total de treinos",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = workouts.size.toString(),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onAddWorkoutClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Novo Treino")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (workouts.isEmpty()) {

            Text(
                text = "Ainda não existem treinos.",
                style = MaterialTheme.typography.bodyLarge
            )

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(workouts) { workout ->

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = workout.name,
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = workout.description,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                                Button(
                                    onClick = {
                                        onWorkoutClick(workout.id)
                                    }
                                ) {
                                    Text("Abrir")
                                }

                                Button(
                                    onClick = {
                                        onEditWorkoutClick(workout.id)
                                    }
                                ) {
                                    Text("Editar")
                                }

                                Button(
                                    onClick = {
                                        workoutToDelete = workout
                                    }
                                ) {
                                    Text("Eliminar")
                                }
                            }
                        }
                    }
                }
            }
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

    if (workoutToDelete != null) {

        AlertDialog(
            onDismissRequest = {
                workoutToDelete = null
            },

            title = {
                Text("Confirmar eliminação")
            },

            text = {
                Text(
                    "Tem a certeza que pretende eliminar este treino?"
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        workoutToDelete?.let {
                            viewModel.deleteWorkout(it)
                        }

                        workoutToDelete = null
                    }
                ) {
                    Text("Eliminar")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        workoutToDelete = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}