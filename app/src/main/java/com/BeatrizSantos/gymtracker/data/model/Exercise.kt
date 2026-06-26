package com.BeatrizSantos.gymtracker.data.model

data class Exercise(
    val id: Int = 0,
    val workoutId: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Double
)

val ExerciseCatalog = listOf(
    "Supino",
    "Supino Inclinado",
    "Agachamento",
    "Leg Press",
    "Extensora",
    "Puxada",
    "Remada",
    "Desenvolvimento Militar",
    "Elevação Lateral",
    "Face Pull",
    "Curl Bíceps",
    "Hammer Curl",
    "Tríceps Pulldown",
    "Gémeos"
)