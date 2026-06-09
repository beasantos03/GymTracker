package com.BeatrizSantos.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.BeatrizSantos.gymtracker.data.repository.WorkoutRepository

class WorkoutViewModelFactory(
    private val repository: WorkoutRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WorkoutViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}