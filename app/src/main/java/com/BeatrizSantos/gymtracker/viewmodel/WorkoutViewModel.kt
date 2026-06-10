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

    fun updateWorkout(
        workout: WorkoutEntity
    ) {
        viewModelScope.launch {
            repository.updateWorkout(workout)
        }
    }

    fun deleteWorkout(
        workout: WorkoutEntity
    ) {
        viewModelScope.launch {
            repository.deleteWorkout(workout)
        }
    }

    suspend fun getWorkoutById(
        workoutId: Long
    ): WorkoutEntity? {
        return repository.getWorkoutById(workoutId)
    }

    fun importPlan(
        planId: Int
    ) {

        when (planId) {

            1 -> {

                addWorkout(
                    "Push",
                    "Peito, Ombros e Tríceps"
                )

                addWorkout(
                    "Pull",
                    "Costas e Bíceps"
                )

                addWorkout(
                    "Legs",
                    "Pernas"
                )
            }

            2 -> {

                addWorkout(
                    "Upper",
                    "Parte superior"
                )

                addWorkout(
                    "Lower",
                    "Parte inferior"
                )
            }

            3 -> {

                addWorkout(
                    "Peito e Tríceps",
                    "Plano focado em peito"
                )
            }

            4 -> {

                addWorkout(
                    "Costas e Bíceps",
                    "Plano focado em costas"
                )
            }

            5 -> {

                addWorkout(
                    "Full Body",
                    "Treino de corpo inteiro"
                )
            }
        }
    }



}