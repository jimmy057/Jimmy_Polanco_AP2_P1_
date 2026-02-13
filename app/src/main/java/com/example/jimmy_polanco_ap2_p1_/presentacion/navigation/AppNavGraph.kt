package com.example.jimmy_polanco_ap2_p1_.presentacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.jimmy_polanco_ap2_p1_.presentacion.Edit.EditCervezaScreen
import com.example.jimmy_polanco_ap2_p1_.presentacion.List.ListCervezaScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.List.route
    ) {

        composable(Routes.List.route) {

            ListCervezaScreen(
                onEditClick = { id ->
                    navController.navigate(
                        Routes.Edit.createRoute(id)
                    )
                }
            )
        }

        composable(
            route = Routes.Edit.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 0

            EditCervezaScreen(
                id = id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}