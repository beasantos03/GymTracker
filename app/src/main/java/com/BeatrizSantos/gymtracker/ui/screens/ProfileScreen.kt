package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    onContinueClick: (
        name: String,
        goal: String
    ) -> Unit
) {

    var name by remember {
        mutableStateOf("")
    }

    var goal by remember {
        mutableStateOf("Ganhar Massa Muscular")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Criar Perfil",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Nome")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Objetivo"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        RadioButtonRow(
            text = "Ganhar Massa Muscular",
            selected = goal == "Ganhar Massa Muscular",
            onClick = {
                goal = "Ganhar Massa Muscular"
            }
        )

        RadioButtonRow(
            text = "Perder Peso",
            selected = goal == "Perder Peso",
            onClick = {
                goal = "Perder Peso"
            }
        )

        RadioButtonRow(
            text = "Manter Forma",
            selected = goal == "Manter Forma",
            onClick = {
                goal = "Manter Forma"
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                if (name.isNotBlank()) {

                    onContinueClick(
                        name,
                        goal
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}

@Composable
private fun RadioButtonRow(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row {

        RadioButton(
            selected = selected,
            onClick = onClick
        )

        Text(
            text = text,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}