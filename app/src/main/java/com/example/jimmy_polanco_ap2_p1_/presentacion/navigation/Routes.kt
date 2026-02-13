package com.example.jimmy_polanco_ap2_p1_.presentacion.navigation

sealed class Routes(val route: String) {

    object List : Routes("list")

    object Edit : Routes("edit/{id}") {
        fun createRoute(id: Int) = "edit/$id"
    }
}