package com.BeatrizSantos.gymtracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.BeatrizSantos.gymtracker.data.local.DatabaseProvider
import com.BeatrizSantos.gymtracker.data.local.WorkoutEntity
import com.BeatrizSantos.gymtracker.data.repository.ExerciseRepository
import com.BeatrizSantos.gymtracker.data.repository.WorkoutExerciseRepository
import com.BeatrizSantos.gymtracker.data.repository.WorkoutRepository
import com.BeatrizSantos.gymtracker.ui.screens.AddExerciseScreen
import com.BeatrizSantos.gymtracker.ui.screens.AddWorkoutScreen
import com.BeatrizSantos.gymtracker.ui.screens.EditWorkoutScreen
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutDetailScreen
import com.BeatrizSantos.gymtracker.ui.screens.WorkoutListScreen
import com.BeatrizSantos.gymtracker.viewmodel.ExerciseViewModel
import com.BeatrizSantos.gymtracker.viewmodel.ExerciseViewModelFactory
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModel
import com.BeatrizSantos.gymtracker.viewmodel.WorkoutViewModelFactory
import androidx.compose.runtime.collectAsState
import com.BeatrizSantos.gymtracker.data.preferences.UserPreferences
import com.BeatrizSantos.gymtracker.ui.screens.HomeScreen
import com.BeatrizSantos.gymtracker.ui.screens.ProfileScreen
import com.BeatrizSantos.gymtracker.viewmodel.ProfileViewModel
import com.BeatrizSantos.gymtracker.viewmodel.ProfileViewModelFactory
import com.BeatrizSantos.gymtracker.ui.screens.PlansScreen
import com.BeatrizSantos.gymtracker.ui.screens.PlanDetailScreen
import com.BeatrizSantos.gymtracker.data.model.Plan
import com.BeatrizSantos.gymtracker.ui.screens.UserProfileScreen

@Composable
fun NavGraph() {

    val context = LocalContext.current

    val userPreferences = UserPreferences(context)

    val profileViewModel: ProfileViewModel = viewModel(
        factory = ProfileViewModelFactory(userPreferences)
    )

    val database = DatabaseProvider.getDatabase(context)

    val workoutRepository = WorkoutRepository(
        database.workoutDao()
    )

    val workoutViewModel: WorkoutViewModel = viewModel(
        factory = WorkoutViewModelFactory(workoutRepository)
    )

    val exerciseRepository = ExerciseRepository(
        database.exerciseDao()
    )

    val workoutExerciseRepository = WorkoutExerciseRepository(
        database.workoutExerciseDao()
    )

    val exerciseViewModel: ExerciseViewModel = viewModel(
        factory = ExerciseViewModelFactory(
            exerciseRepository,
            workoutExerciseRepository
        )
    )

    val profileCreated by profileViewModel
        .profileCreated
        .collectAsState()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =
            if (profileCreated)
                "home"
            else
                "profile"
    ) {

        composable("profile") {

            ProfileScreen(

                onContinueClick = { name, goal ->

                    profileViewModel.saveProfile(
                        name = name,
                        goal = goal
                    )

                    navController.navigate("home") {
                        popUpTo("profile") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("home") {

            val userName by profileViewModel.userName.collectAsState()

            val userGoal by profileViewModel.userGoal.collectAsState()

            HomeScreen(
                userName = userName,
                userGoal = userGoal,

                onPlansClick = {
                    navController.navigate("plans")
                },

                onMyWorkoutsClick = {
                    navController.navigate("workouts")
                },

                onProfileClick = {
                    navController.navigate("userProfile")
                }
            )
        }

        composable("userProfile") {

            val userName by profileViewModel.userName.collectAsState()

            val userGoal by profileViewModel.userGoal.collectAsState()

            UserProfileScreen(
                userName = userName,
                userGoal = userGoal,

                onBackClick = {
                    navController.popBackStack()
                },

                onEditProfileClick = {

                },

                onDeleteProfileClick = {

                    profileViewModel.clearProfile()

                    navController.navigate("profile") {

                        popUpTo(0)
                    }
                }
            )
        }

        composable("plans") {

            PlansScreen(
                onPlanClick = { plan ->
                    navController.navigate("planDetail/${plan.id}")
                }
            )
        }

        composable("planDetail/{planId}") { backStackEntry ->

            val planId =
                backStackEntry.arguments
                    ?.getString("planId")
                    ?.toIntOrNull() ?: 1

            val plan = when (planId) {

                1 -> Plan(
                    1,
                    "Push Pull Legs",
                    "Plano clássico de hipertrofia."
                )

                2 -> Plan(
                    2,
                    "Upper Lower",
                    "Divisão superior e inferior."
                )

                3 -> Plan(
                    3,
                    "Peito e Tríceps",
                    "Treino focado em peito."
                )

                4 -> Plan(
                    4,
                    "Costas e Bíceps",
                    "Treino focado em costas."
                )

                else -> Plan(
                    5,
                    "Full Body",
                    "Treino de corpo inteiro."
                )
            }

            PlanDetailScreen(
                plan = plan,

                onUsePlanClick = {

                    workoutViewModel.importPlan(
                        plan.id
                    )

                    navController.navigate("workouts")
                }
            )
        }

        composable("workouts") {

            WorkoutListScreen(
                viewModel = workoutViewModel,
                onAddWorkoutClick = {
                    navController.navigate("addWorkout")
                },
                onWorkoutClick = { workoutId ->
                    navController.navigate("workout/$workoutId")
                },
                onEditWorkoutClick = { workoutId ->
                    navController.navigate("editWorkout/$workoutId")
                }
            )
        }

        composable("addWorkout") {

            AddWorkoutScreen(
                viewModel = workoutViewModel,
                onWorkoutSaved = {
                    navController.popBackStack()
                }
            )
        }

        composable("workout/{workoutId}") { backStackEntry ->

            val workoutId =
                backStackEntry.arguments
                    ?.getString("workoutId")
                    ?.toLongOrNull() ?: 0L

            WorkoutDetailScreen(
                workoutId = workoutId,
                viewModel = workoutViewModel,
                exerciseViewModel = exerciseViewModel,
                onAddExerciseClick = { id ->
                    navController.navigate("addExercise/$id")
                }
            )
        }

        composable("addExercise/{workoutId}") { backStackEntry ->

            val workoutId =
                backStackEntry.arguments
                    ?.getString("workoutId")
                    ?.toLongOrNull() ?: 0L

            AddExerciseScreen(
                workoutId = workoutId,
                exerciseViewModel = exerciseViewModel,
                onExerciseSaved = {
                    navController.popBackStack()
                }
            )
        }

        composable("editWorkout/{workoutId}") { backStackEntry ->

            val workoutId =
                backStackEntry.arguments
                    ?.getString("workoutId")
                    ?.toLongOrNull() ?: 0L

            var workout by remember {
                mutableStateOf<WorkoutEntity?>(null)
            }

            LaunchedEffect(workoutId) {
                workout = workoutViewModel.getWorkoutById(workoutId)
            }

            workout?.let {

                EditWorkoutScreen(
                    workout = it,
                    viewModel = workoutViewModel,
                    onWorkoutUpdated = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}