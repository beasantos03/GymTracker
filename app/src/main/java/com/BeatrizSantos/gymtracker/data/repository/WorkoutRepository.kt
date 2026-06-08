package com.BeatrizSantos.gymtracker.data.repository

import com.BeatrizSantos.gymtracker.data.local.WorkoutDao
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity

class WorkoutRepository(
    private val workoutDao: WorkoutDao
) {

    suspend fun addWorkout(workout: WorkoutEntity) {
        workoutDao.insertWorkout(workout)
    }

    suspend fun getWorkouts(): List<WorkoutEntity> {
        return workoutDao.getAllWorkouts()
    }
}