package com.BeatrizSantos.gymtracker.data.repository

import com.BeatrizSantos.gymtracker.data.local.WorkoutDao
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity
import kotlinx.coroutines.flow.Flow

class WorkoutRepository(
    private val workoutDao: WorkoutDao
) {

    suspend fun addWorkout(
        workout: WorkoutEntity
    ) {
        workoutDao.insertWorkout(workout)
    }

    suspend fun updateWorkout(
        workout: WorkoutEntity
    ) {
        workoutDao.updateWorkout(workout)
    }

    suspend fun deleteWorkout(
        workout: WorkoutEntity
    ) {
        workoutDao.deleteWorkout(workout)
    }

    fun getWorkouts(): Flow<List<WorkoutEntity>> {
        return workoutDao.getAllWorkouts()
    }

    suspend fun deleteAllWorkouts() {
        workoutDao.deleteAllWorkouts()
    }

    suspend fun getWorkoutById(
        workoutId: Long
    ): WorkoutEntity? {
        return workoutDao.getWorkoutById(workoutId)
    }
}