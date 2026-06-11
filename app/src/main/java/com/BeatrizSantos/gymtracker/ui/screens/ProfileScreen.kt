package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    initialName: String = "",
    initialGoal: String = "Ganhar Massa Muscular",
    title: String = "Criar Perfil",
    onContinueClick: (
        name: String,
        goal: String
    ) -> Unit
) {

    var name by remember {
        mutableStateOf(initialName)
    }

    var goal by remember {
        mutableStateOf(initialGoal)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
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