package com.BeatrizSantos.gymtracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val workoutId: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Double
)