package com.satrio.launchery.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.satrio.launchery.ui.archive.ArchiveScreenPlaceholder
import com.satrio.launchery.ui.main.MainScreenPlaceholder
import com.satrio.launchery.ui.plugin.PluginScreenPlaceholder

@Composable
fun LauncherNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        modifier = modifier,
        enterTransition = {
            fadeIn(animationSpec = tween(280))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(240))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(280))
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(240))
        }
    ) {
        composable(Screen.Main.route) {
            MainScreenPlaceholder()
        }
        composable(Screen.Plugin.route) {
            PluginScreenPlaceholder()
        }
        composable(Screen.Archive.route) {
            ArchiveScreenPlaceholder()
        }
    }
}
