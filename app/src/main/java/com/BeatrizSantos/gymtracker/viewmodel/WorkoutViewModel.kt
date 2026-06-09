package com.BeatrizSantos.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity
import com.BeatrizSantos.gymtracker.data.repository.WorkoutRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WorkoutViewModel(
    private val repository: WorkoutRepository
) : ViewModel() {

    val workouts: StateFlow<List<WorkoutEntity>> =
        repository.getWorkouts()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun addWorkout(
        name: String,
        description: String
    ) {
        viewModelScope.launch {
            repository.addWorkout(
                WorkoutEntity(
                    name = name,
                    description = description
                )
            )
        }
    }
    suspend fun getWorkoutById(
        workoutId: Long
    ): WorkoutEntity? {
        return repository.getWorkoutById(workoutId)
    }
    fun deleteWorkout(
        workout: WorkoutEntity
    ) {
        viewModelScope.launch {
            repository.deleteWorkout(workout)
        }
    }
}