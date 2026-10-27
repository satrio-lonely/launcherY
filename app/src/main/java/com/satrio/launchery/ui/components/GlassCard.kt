package com.satrio.launchery.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.satrio.launchery.ui.theme.GlassBorder
import com.satrio.launchery.ui.theme.GlassShapeLarge
import com.satrio.launchery.ui.theme.GlassSurface
import com.satrio.launchery.ui.theme.LauncherYTheme

/**
 * Reusable Glassmorphism Card for LauncherY.
 * Translucent frosted glass effect with thin subtle border and rounded corners.
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    shape: Shape = GlassShapeLarge,
    backgroundColor: Color = GlassSurface,
    borderColor: Color = GlassBorder,
    borderWidth: Dp = 1.dp,
    blurRadius: Dp = 16.dp,
    contentPadding: Dp = 16.dp,
    content: @Composable BoxScope.() -> Unit
) {
    val effectiveBg = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        backgroundColor
    } else {
        // Fallback for older Android versions
        backgroundColor.copy(alpha = (backgroundColor.alpha * 1.8f).coerceAtMost(0.35f))
    }

    Box(
        modifier = modifier
            .clip(shape)
            .then(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && blurRadius > 0.dp) {
                    Modifier.blur(blurRadius)
                } else {
                    Modifier
                }
            )
            .background(effectiveBg, shape)
            .border(borderWidth, borderColor, shape)
            .padding(contentPadding),
        content = content
    )
}

/**
 * Clickable variant of GlassCard with ripple and accessibility role.
 */
@Composable
fun ClickableGlassCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = GlassShapeLarge,
    backgroundColor: Color = GlassSurface,
    borderColor: Color = GlassBorder,
    borderWidth: Dp = 1.dp,
    blurRadius: Dp = 16.dp,
    contentPadding: Dp = 16.dp,
    enabled: Boolean = true,
    content: @Composable BoxScope.() -> Unit
) {
    val effectiveBg = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        backgroundColor
    } else {
        backgroundColor.copy(alpha = (backgroundColor.alpha * 1.8f).coerceAtMost(0.35f))
    }

    Box(
        modifier = modifier
            .clip(shape)
            .then(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && blurRadius > 0.dp) {
                    Modifier.blur(blurRadius)
                } else {
                    Modifier
                }
            )
            .background(effectiveBg, shape)
            .border(borderWidth, borderColor, shape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = Color.White),
                enabled = enabled,
                role = Role.Button,
                onClick = onClick
            )
            .padding(contentPadding),
        content = content
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1A1B)
@Composable
private fun GlassCardPreview() {
    LauncherYTheme {
        GlassCard(
            modifier = Modifier.padding(16.dp),
            contentPadding = 24.dp
        ) {
            Text("Glassmorphism Card Preview", color = Color.White)
        }
    }
}
