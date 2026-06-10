package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.data.model.Plan

@Composable
fun PlanDetailScreen(
    plan: Plan,
    onUsePlanClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = plan.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = plan.description,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Exemplo de divisão:"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text("Dia 1 - Push")
        Text("Dia 2 - Pull")
        Text("Dia 3 - Legs")

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = onUsePlanClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Utilizar Plano")
        }
    }
}