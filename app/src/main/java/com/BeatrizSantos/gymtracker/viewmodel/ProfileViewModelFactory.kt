package com.BeatrizSantos.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.BeatrizSantos.gymtracker.data.preferences.UserPreferences

class ProfileViewModelFactory(
    private val userPreferences: UserPreferences
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return ProfileViewModel(
            userPreferences
        ) as T
    }
}