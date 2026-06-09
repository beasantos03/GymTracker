package com.BeatrizSantos.gymtracker.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Insert
    suspend fun insertWorkout(
        workout: WorkoutEntity
    )

    @Update
    suspend fun updateWorkout(
        workout: WorkoutEntity
    )

    @Delete
    suspend fun deleteWorkout(
        workout: WorkoutEntity
    )

    @Query("SELECT * FROM workouts")
    fun getAllWorkouts(): Flow<List<WorkoutEntity>>

    @Query("SELECT * FROM workouts WHERE id = :workoutId")
    suspend fun getWorkoutById(
        workoutId: Long
    ): WorkoutEntity?
}