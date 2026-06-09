package com.BeatrizSantos.gymtracker.data.repository

import com.BeatrizSantos.gymtracker.data.local.WorkoutExerciseDao
import com.BeatrizSantos.gymtracker.data.local.WorkoutExerciseEntity

class WorkoutExerciseRepository(
    private val workoutExerciseDao: WorkoutExerciseDao
) {

    suspend fun addWorkoutExercise(
        workoutExercise: WorkoutExerciseEntity
    ) {
        workoutExerciseDao.insertWorkoutExercise(
            workoutExercise
        )
    }
}