package com.satrio.launchery.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satrio.launchery.R
import com.satrio.launchery.ui.navigation.Screen
import com.satrio.launchery.ui.theme.AccentRed
import com.satrio.launchery.ui.theme.GlassBorder
import com.satrio.launchery.ui.theme.GlassSurface
import com.satrio.launchery.ui.theme.GlassSurfaceActive
import com.satrio.launchery.ui.theme.LauncherYTheme
import com.satrio.launchery.ui.theme.TextMuted
import com.satrio.launchery.ui.theme.TextPrimary

/**
 * Top Tab Bar positioned at the top center, matching the visual reference design.
 * Features tabs: MAIN, PLUGIN, ARCHIVE.
 */
@Composable
fun TopTabBar(
    selectedScreen: Screen,
    onTabSelected: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf(Screen.Main, Screen.Plugin, Screen.Archive)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        // Center Glass Pill Container
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(GlassSurface, RoundedCornerShape(24.dp))
                .border(1.dp, GlassBorder, RoundedCornerShape(24.dp))
                .padding(horizontal = 6.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { screen ->
                val isSelected = screen == selectedScreen
                val tabText = when (screen) {
                    Screen.Main -> stringResource(R.string.tab_main)
                    Screen.Plugin -> stringResource(R.string.tab_plugin)
                    Screen.Archive -> stringResource(R.string.tab_archive)
                }

                TopTabItem(
                    title = tabText,
                    isSelected = isSelected,
                    onClick = { onTabSelected(screen) }
                )
            }
        }
    }
}

@Composable
private fun TopTabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val animatedBg by animateColorAsState(
        targetValue = if (isSelected) GlassSurfaceActive else Color.Transparent,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label = "tabBgAnimation"
    )

    val animatedTextColor by animateColorAsState(
        targetValue = if (isSelected) TextPrimary else TextMuted,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label = "tabTextColorAnimation"
    )

    val itemShape = RoundedCornerShape(18.dp)

    Box(
        modifier = Modifier
            .minimumInteractiveComponentSize() // Ensures min 48dp touch target
            .height(40.dp)
            .clip(itemShape)
            .background(animatedBg, itemShape)
            .then(
                if (isSelected) {
                    Modifier.border(1.dp, GlassBorder, itemShape)
                } else {
                    Modifier
                }
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = Color.White),
                role = Role.Tab,
                onClickLabel = title,
                onClick = onClick
            )
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                color = animatedTextColor,
                fontSize = 13.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                letterSpacing = 1.2.sp
            )

            if (isSelected) {
                // Subtle accent pill indicator
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(AccentRed, CircleShape)
                        .padding(3.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1A1B)
@Composable
private fun TopTabBarPreview() {
    LauncherYTheme {
        TopTabBar(
            selectedScreen = Screen.Main,
            onTabSelected = {}
        )
    }
}
