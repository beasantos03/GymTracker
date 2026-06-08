package com.BeatrizSantos.gymtracker.data.model

data class Exercise(
    val id: Int = 0,
    val workoutId: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Double
)