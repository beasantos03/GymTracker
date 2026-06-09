package com.BeatrizSantos.gymtracker.data.repository

import com.BeatrizSantos.gymtracker.data.local.ExerciseDao
import com.BeatrizSantos.gymtracker.data.local.ExerciseEntity

class ExerciseRepository(
    private val exerciseDao: ExerciseDao
) {

    suspend fun addExercise(
        exercise: ExerciseEntity
    ): Long {
        return exerciseDao.insertExercise(exercise)
    }

    suspend fun getExercises(): List<ExerciseEntity> {
        return exerciseDao.getAllExercises()
    }
}