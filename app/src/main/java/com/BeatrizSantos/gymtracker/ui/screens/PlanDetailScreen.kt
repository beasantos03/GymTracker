package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.data.model.Plan

@Composable
fun PlanDetailScreen(
    plan: Plan,
    onUsePlanClick: () -> Unit,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(
            modifier = Modifier.height(48.dp)
        )

        Text(
            text = plan.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Descrição")

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = plan.description,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Estrutura do Plano",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        when (plan.id) {

            1 -> {

                PlanSectionCard(
                    title = "Push",
                    exercises = listOf(
                        "Supino",
                        "Desenvolvimento Militar",
                        "Elevação Lateral",
                        "Tríceps Pulldown"
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                PlanSectionCard(
                    title = "Pull",
                    exercises = listOf(
                        "Puxada",
                        "Remada",
                        "Face Pull",
                        "Curl Bíceps"
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                PlanSectionCard(
                    title = "Legs",
                    exercises = listOf(
                        "Agachamento",
                        "Leg Press",
                        "Extensora",
                        "Gémeos"
                    )
                )
            }

            2 -> {

                PlanSectionCard(
                    title = "Upper",
                    exercises = listOf(
                        "Supino",
                        "Remada",
                        "Desenvolvimento Militar"
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                PlanSectionCard(
                    title = "Lower",
                    exercises = listOf(
                        "Agachamento",
                        "Leg Press",
                        "Gémeos"
                    )
                )
            }

            3 -> {

                PlanSectionCard(
                    title = "Peito e Tríceps",
                    exercises = listOf(
                        "Supino",
                        "Supino Inclinado",
                        "Crucifixo",
                        "Tríceps Pulldown"
                    )
                )
            }

            4 -> {

                PlanSectionCard(
                    title = "Costas e Bíceps",
                    exercises = listOf(
                        "Puxada",
                        "Remada",
                        "Curl Bíceps",
                        "Hammer Curl"
                    )
                )
            }

            5 -> {

                PlanSectionCard(
                    title = "Full Body",
                    exercises = listOf(
                        "Agachamento",
                        "Supino",
                        "Remada",
                        "Desenvolvimento Militar"
                    )
                )
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = onUsePlanClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Utilizar Plano")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}

@Composable
private fun PlanSectionCard(
    title: String,
    exercises: List<String>
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            exercises.forEach { exercise ->

                Text("• $exercise")
            }
        }
    }
}