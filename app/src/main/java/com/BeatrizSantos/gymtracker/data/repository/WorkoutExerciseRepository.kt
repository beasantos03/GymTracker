package com.BeatrizSantos.gymtracker.data.repository

import com.BeatrizSantos.gymtracker.data.local.WorkoutExerciseDao
import com.BeatrizSantos.gymtracker.data.local.WorkoutExerciseEntity
import com.BeatrizSantos.gymtracker.data.local.WorkoutExerciseWithName
import kotlinx.coroutines.flow.Flow

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

    fun getExercisesForWorkout(
        workoutId: Long
    ): Flow<List<WorkoutExerciseWithName>> {

        return workoutExerciseDao.getExercisesForWorkout(
            workoutId
        )
    }
}