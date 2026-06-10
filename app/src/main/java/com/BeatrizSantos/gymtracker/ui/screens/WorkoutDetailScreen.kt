package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.viewmodel.ExerciseViewModel
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel

@Composable
fun WorkoutDetailScreen(
    workoutId: Long,
    viewModel: WorkoutViewModel,
    exerciseViewModel: ExerciseViewModel,
    onAddExerciseClick: (Long) -> Unit,
    onBackClick: () -> Unit
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

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = workoutName,
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

                Text(
                    text = "Descrição"
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = workoutDescription,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Exercícios",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        if (exercises.isEmpty()) {

            Text(
                text = "Ainda não existem exercícios.",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        } else {

            exercises.forEach { exercise ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = exercise.exerciseName,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "${exercise.sets} séries x ${exercise.reps} reps - ${exercise.weight}kg"
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = {
                onAddExerciseClick(workoutId)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Exercício")
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