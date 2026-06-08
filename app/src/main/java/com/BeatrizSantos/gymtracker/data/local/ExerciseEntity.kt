package com.BeatrizSantos.gymtracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(

    @PrimaryKey(autoGenerate = true)
    val exerciseId: Long = 0,

    val name: String,

    val muscleGroup: String,

    val description: String = ""
)