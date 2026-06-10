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
            text = "Estrutura do plano",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        when (plan.id) {

            1 -> {

                Text("Push")
                Text("• Supino")
                Text("• Desenvolvimento Militar")
                Text("• Elevação Lateral")
                Text("• Tríceps Pulldown")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Pull")
                Text("• Puxada")
                Text("• Remada")
                Text("• Face Pull")
                Text("• Curl Bíceps")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Legs")
                Text("• Agachamento")
                Text("• Leg Press")
                Text("• Extensora")
                Text("• Gémeos")
            }

            2 -> {

                Text("Upper")
                Text("• Supino")
                Text("• Remada")
                Text("• Desenvolvimento Militar")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Lower")
                Text("• Agachamento")
                Text("• Leg Press")
                Text("• Gémeos")
            }

            3 -> {

                Text("Peito e Tríceps")
                Text("• Supino")
                Text("• Supino Inclinado")
                Text("• Crucifixo")
                Text("• Tríceps Pulldown")
            }

            4 -> {

                Text("Costas e Bíceps")
                Text("• Puxada")
                Text("• Remada")
                Text("• Curl Bíceps")
                Text("• Hammer Curl")
            }

            5 -> {

                Text("Full Body")
                Text("• Agachamento")
                Text("• Supino")
                Text("• Remada")
                Text("• Desenvolvimento Militar")
            }
        }

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