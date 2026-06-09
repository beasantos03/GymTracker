package com.BeatrizSantos.gymtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.BeatrizSantos.gymtracker.navigation.NavGraph
import com.BeatrizSantos.gymtracker.ui.screens.AddWorkoutScreen
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutListScreen
import com.BeatrizSantos.gymtracker.ui.theme.GymTrackerTheme
import com.BeatrizSantos.gymtracker.ui.screens.AddWorkoutScreen
import com.BeatrizSantos.gymtracker.navigation.NavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GymTrackerTheme {
                NavGraph()

            }
        }
    }
}