package com.BeatrizSantos.gymtracker.data.local

data class WorkoutExerciseWithName(

    val exerciseId: Long,

    val exerciseName: String,

    val sets: Int,

    val reps: Int,

    val weight: Double
)