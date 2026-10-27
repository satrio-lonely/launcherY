package com.satrio.launchery.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.satrio.launchery.ui.components.TopTabBar
import com.satrio.launchery.ui.navigation.LauncherNavHost
import com.satrio.launchery.ui.navigation.Screen
import com.satrio.launchery.ui.theme.DarkMeshBackgroundBrush
import com.satrio.launchery.ui.theme.LauncherYTheme

/**
 * Root Scaffold for LauncherY.
 * Renders atmospheric dark charcoal gradient background,
 * centered TopTabBar, and responsive content area.
 */
@Composable
fun LauncherMainScaffold(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentScreen = Screen.fromRoute(currentRoute)

    val isExpandedOrMedium = windowWidthSizeClass == WindowWidthSizeClass.Expanded ||
            windowWidthSizeClass == WindowWidthSizeClass.Medium

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkMeshBackgroundBrush)
            .systemBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Centered Top Tab Bar (MAIN, PLUGIN, ARCHIVE)
            TopTabBar(
                selectedScreen = currentScreen,
                onTabSelected = { targetScreen ->
                    if (targetScreen.route != currentRoute) {
                        navController.navigate(targetScreen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                modifier = Modifier.padding(horizontal = if (isExpandedOrMedium) 32.dp else 16.dp)
            )

            // Screen Area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                LauncherNavHost(
                    navController = navController,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(
    name = "Landscape / Tablet (Primary)",
    device = "spec:width=1280dp,height=800dp,dpi=240",
    showBackground = true
)
@Composable
private fun LauncherMainScaffoldLandscapePreview() {
    LauncherYTheme {
        LauncherMainScaffold(
            windowWidthSizeClass = WindowWidthSizeClass.Expanded
        )
    }
}

@Preview(
    name = "Portrait Phone",
    device = Devices.PIXEL_7,
    showBackground = true
)
@Composable
private fun LauncherMainScaffoldPortraitPreview() {
    LauncherYTheme {
        LauncherMainScaffold(
            windowWidthSizeClass = WindowWidthSizeClass.Compact
        )
    }
}
