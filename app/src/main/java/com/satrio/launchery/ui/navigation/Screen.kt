package com.satrio.launchery.ui.navigation

sealed class Screen(val route: String) {
    data object Main : Screen("main")
    data object Plugin : Screen("plugin")
    data object Archive : Screen("archive")

    companion object {
        fun fromRoute(route: String?): Screen = when (route) {
            Plugin.route -> Plugin
            Archive.route -> Archive
            else -> Main
        }
    }
}
