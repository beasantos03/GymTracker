package com.BeatrizSantos.gymtracker.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "user_preferences"
)

class UserPreferences(
    private val context: Context
) {

    companion object {

        private val USER_NAME =
            stringPreferencesKey("user_name")

        private val USER_GOAL =
            stringPreferencesKey("user_goal")

        private val PROFILE_CREATED =
            booleanPreferencesKey("profile_created")
    }

    suspend fun saveProfile(
        name: String,
        goal: String
    ) {

        context.dataStore.edit { preferences ->

            preferences[USER_NAME] = name

            preferences[USER_GOAL] = goal

            preferences[PROFILE_CREATED] = true
        }
    }

    val userName: Flow<String> =
        context.dataStore.data.map { preferences ->

            preferences[USER_NAME] ?: ""
        }

    val userGoal: Flow<String> =
        context.dataStore.data.map { preferences ->

            preferences[USER_GOAL] ?: ""
        }

    val profileCreated: Flow<Boolean> =
        context.dataStore.data.map { preferences ->

            preferences[PROFILE_CREATED] ?: false
        }

    suspend fun clearProfile() {

        context.dataStore.edit { preferences ->

            preferences[USER_NAME] = ""

            preferences[USER_GOAL] = ""

            preferences[PROFILE_CREATED] = false
        }
    }
}