package com.satrio.launchery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.satrio.launchery.ui.theme.AccentRed
import com.satrio.launchery.ui.theme.LauncherYTheme

/**
 * Main Accent Round Button (#C2413B) as seen in visual reference.
 * Meets accessibility requirement (min 48dp touch target) and mandatory contentDescription.
 */
@Composable
fun AccentRoundButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
    iconSize: Dp = 28.dp,
    containerColor: Color = AccentRed,
    contentColor: Color = Color.White,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize() // Ensures min 48x48dp interactive target
            .size(size)
            .shadow(elevation = 8.dp, shape = CircleShape, ambientColor = AccentRed, spotColor = AccentRed)
            .clip(CircleShape)
            .background(containerColor, CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = Color.White),
                enabled = enabled,
                role = Role.Button,
                onClickLabel = contentDescription,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = contentColor,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Preview
@Composable
private fun AccentRoundButtonPreview() {
    LauncherYTheme {
        AccentRoundButton(
            icon = Icons.Default.KeyboardArrowDown,
            contentDescription = "Open Plugins Sheet",
            onClick = {}
        )
    }
}
