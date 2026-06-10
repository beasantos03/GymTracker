package com.BeatrizSantos.gymtracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BeatrizSantos.gymtracker.data.preferences.UserPreferences
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userPreferences: UserPreferences
) : ViewModel() {

    val userName =
        userPreferences.userName
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                ""
            )

    val userGoal =
        userPreferences.userGoal
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                ""
            )

    val profileCreated =
        userPreferences.profileCreated
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                false
            )

    fun saveProfile(
        name: String,
        goal: String
    ) {

        viewModelScope.launch {

            userPreferences.saveProfile(
                name,
                goal
            )
        }
    }
}