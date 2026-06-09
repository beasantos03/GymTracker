package com.BeatrizSantos.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.BeatrizSantos.gymtracker.data.repository.ExerciseRepository
import com.BeatrizSantos.gymtracker.data.repository.WorkoutExerciseRepository

class ExerciseViewModelFactory(
    private val exerciseRepository: ExerciseRepository,
    private val workoutExerciseRepository: WorkoutExerciseRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return ExerciseViewModel(
            exerciseRepository,
            workoutExerciseRepository
        ) as T
    }
}