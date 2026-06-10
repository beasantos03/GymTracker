package com.BeatrizSantos.gymtracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.BeatrizSantos.gymtracker.data.model.Plan

@Composable
fun PlansScreen(
    onPlanClick: (Plan) -> Unit,
    onBackClick: () -> Unit
) {

    val plans = listOf(

        Plan(
            id = 1,
            name = "Push Pull Legs",
            description = "Plano clássico de hipertrofia."
        ),

        Plan(
            id = 2,
            name = "Upper Lower",
            description = "Divisão superior e inferior."
        ),

        Plan(
            id = 3,
            name = "Peito e Tríceps",
            description = "Treino focado em peito."
        ),

        Plan(
            id = 4,
            name = "Costas e Bíceps",
            description = "Treino focado em costas."
        ),

        Plan(
            id = 5,
            name = "Full Body",
            description = "Treino de corpo inteiro."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Planos de Treino",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(plans) { plan ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onPlanClick(plan)
                    }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = plan.name,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = plan.description
                        )
                    }
                }
            }
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