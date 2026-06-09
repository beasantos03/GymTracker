package com.BeatrizSantos.gymtracker.data.repository

import com.BeatrizSantos.gymtracker.data.local.WorkoutDao
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity
import kotlinx.coroutines.flow.Flow

class WorkoutRepository(
    private val workoutDao: WorkoutDao
) {

    suspend fun addWorkout(workout: WorkoutEntity) {
        workoutDao.insertWorkout(workout)
    }

    fun getWorkouts(): Flow<List<WorkoutEntity>> {
        return workoutDao.getAllWorkouts()
    }
}