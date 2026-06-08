package com.BeatrizSantos.gymtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutListScreen
import com.BeatrizSantos.gymtracker.ui.theme.GymTrackerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GymTrackerTheme {
                WorkoutListScreen()
            }
        }
    }
}