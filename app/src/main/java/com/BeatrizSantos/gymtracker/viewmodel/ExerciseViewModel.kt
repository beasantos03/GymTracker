package com.BeatrizSantos.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BeatrizSantos.gymtracker.data.local.ExerciseEntity
import com.BeatrizSantos.gymtracker.data.local.WorkoutExerciseEntity
import com.BeatrizSantos.gymtracker.data.repository.ExerciseRepository
import com.BeatrizSantos.gymtracker.data.repository.WorkoutExerciseRepository
import kotlinx.coroutines.launch

class ExerciseViewModel(
    private val exerciseRepository: ExerciseRepository,
    private val workoutExerciseRepository: WorkoutExerciseRepository
) : ViewModel() {

    fun saveExercise(
        workoutId: Long,
        name: String,
        sets: Int,
        reps: Int,
        weight: Double
    ) {

        viewModelScope.launch {

            val exerciseId = exerciseRepository.addExercise(
                ExerciseEntity(
                    name = name,
                    muscleGroup = "Não definido"
                )
            )

            workoutExerciseRepository.addWorkoutExercise(
                WorkoutExerciseEntity(
                    workoutId = workoutId,
                    exerciseId = exerciseId,
                    sets = sets,
                    reps = reps,
                    weight = weight
                )
            )
        }
    }

    fun getExercisesForWorkout(
        workoutId: Long
    ) =
        workoutExerciseRepository.getExercisesForWorkout(
            workoutId
        )
}