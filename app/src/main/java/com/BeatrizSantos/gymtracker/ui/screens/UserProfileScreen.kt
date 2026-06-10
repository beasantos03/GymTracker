package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun UserProfileScreen(
    userName: String,
    userGoal: String,
    onBackClick: () -> Unit,
    onEditProfileClick: () -> Unit,
    onDeleteProfileClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Perfil",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Nome: $userName"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Objetivo: $userGoal"
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = onEditProfileClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar Perfil")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onDeleteProfileClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Apagar Perfil")
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}