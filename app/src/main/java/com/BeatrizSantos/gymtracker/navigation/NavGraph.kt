package com.BeatrizSantos.gymtracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.BeatrizSantos.gymtracker.ui.screens.AddWorkoutScreen
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutListScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "workouts"
    ) {

        composable("workouts") {
            WorkoutListScreen(
                onAddWorkoutClick = {
                    navController.navigate("addWorkout")
                }
            )
        }

        composable("addWorkout") {
            AddWorkoutScreen()
        }
    }
}