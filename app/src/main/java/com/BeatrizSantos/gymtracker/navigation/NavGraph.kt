package com.BeatrizSantos.gymtracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.BeatrizSantos.gymtracker.data.local.DatabaseProvider
import com.BeatrizSantos.gymtracker.data.repository.WorkoutRepository
import com.BeatrizSantos.gymtracker.ui.screens.AddExerciseScreen
import com.BeatrizSantos.gymtracker.ui.screens.AddWorkoutScreen
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutDetailScreen
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutListScreen
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModelFactory


@Composable
fun NavGraph() {

    val context = LocalContext.current

    val database = DatabaseProvider.getDatabase(context)

    val repository = WorkoutRepository(
        database.workoutDao()
    )

    val workoutViewModel: WorkoutViewModel = viewModel(
        factory = WorkoutViewModelFactory(repository)
    )

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "workouts"
    ) {

        composable("workouts") {

            WorkoutListScreen(
                viewModel = workoutViewModel,
                onAddWorkoutClick = {
                    navController.navigate("addWorkout")
                },
                onWorkoutClick = { workoutId ->
                    navController.navigate("workout/$workoutId")
                }
            )
        }

        composable("addWorkout") {

            AddWorkoutScreen(
                viewModel = workoutViewModel,
                onWorkoutSaved = {
                    navController.popBackStack()
                }
            )
        }

        composable("workout/{workoutId}") { backStackEntry ->

            val workoutId =
                backStackEntry.arguments
                    ?.getString("workoutId")
                    ?.toLongOrNull() ?: 0L

            WorkoutDetailScreen(
                workoutId = workoutId,
                viewModel = workoutViewModel,
                onAddExerciseClick = { id ->
                    navController.navigate("addExercise/$id")
                }
            )
        }

        composable("addExercise/{workoutId}") { backStackEntry ->

            val workoutId =
                backStackEntry.arguments
                    ?.getString("workoutId")
                    ?.toLongOrNull() ?: 0L

            AddExerciseScreen(
                workoutId = workoutId
            )
        }

    }
}