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
        """
        SELECT
            e.exerciseId AS exerciseId,
            e.name AS exerciseName,
            we.sets AS sets,
            we.reps AS reps,
            we.weight AS weight
        FROM workout_exercises we
        INNER JOIN exercises e
            ON we.exerciseId = e.exerciseId
        WHERE we.workoutId = :workoutId
        """
    )
    fun getExercisesForWorkout(
        workoutId: Long
    ): Flow<List<WorkoutExerciseWithName>>
}