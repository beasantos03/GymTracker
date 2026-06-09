package com.BeatrizSantos.gymtracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutExerciseDao {

    @Insert
    suspend fun insertWorkoutExercise(
        workoutExercise: WorkoutExerciseEntity
    )

    @Query(
        "SELECT * FROM workout_exercises WHERE workoutId = :workoutId"
    )
    fun getExercisesForWorkout(
        workoutId: Long
    ): Flow<List<WorkoutExerciseEntity>>
}