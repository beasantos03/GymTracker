package com.BeatrizSantos.gymtracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.BeatrizSantos.gymtracker.data.local.DatabaseProvider
import com.BeatrizSantos.gymtracker.data.repository.WorkoutRepository
import com.BeatrizSantos.gymtracker.ui.screens.AddWorkoutScreen
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
    }
}