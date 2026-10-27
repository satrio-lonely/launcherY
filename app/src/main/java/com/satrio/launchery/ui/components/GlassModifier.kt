package com.satrio.launchery.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.satrio.launchery.ui.theme.GlassBorder
import com.satrio.launchery.ui.theme.GlassShapeLarge
import com.satrio.launchery.ui.theme.GlassSurface

/**
 * Modifier helper to apply Dark Glassmorphism aesthetics:
 * - Rounded corners (24-32dp)
 * - Semi-transparent white surface (6-10% opacity, fallback higher opacity on older devices)
 * - Subtle thin white border (10-15% opacity)
 * - Hardware blur on Android 12+ (SDK >= 31)
 */
fun Modifier.glassmorphism(
    shape: Shape = GlassShapeLarge,
    backgroundColor: Color = GlassSurface,
    borderColor: Color = GlassBorder,
    borderWidth: Dp = 1.dp,
    blurRadius: Dp = 20.dp
): Modifier {
    val effectiveBg = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        backgroundColor
    } else {
        // Fallback tint with slightly deeper opacity on Android < 12 to maintain legibility without blur
        backgroundColor.copy(alpha = (backgroundColor.alpha * 1.8f).coerceAtMost(0.35f))
    }

    return this
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
}
