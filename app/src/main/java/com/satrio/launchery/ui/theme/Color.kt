package com.satrio.launchery.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Charcoal background palette (#1E1A1B to #2B2627)
val CharcoalDark = Color(0xFF1E1A1B)
val CharcoalSurface = Color(0xFF252021)
val CharcoalElevated = Color(0xFF2B2627)

// Accent Red
val AccentRed = Color(0xFFC2413B)
val AccentRedHover = Color(0xFFD64D47)
val AccentRedSubtle = Color(0x33C2413B)

// Glassmorphism overlays
// 6-10% opacity white surface
val GlassSurface = Color(0x14FFFFFF) // 8% white
val GlassSurfaceActive = Color(0x24FFFFFF) // 14% white
val GlassSurfaceHigh = Color(0x2EFFFFFF) // 18% white

// 10-15% opacity white border
val GlassBorder = Color(0x26FFFFFF) // 15% white
val GlassBorderSubtle = Color(0x1AFFFFFF) // 10% white
val GlassBorderFocused = Color(0x40FFFFFF) // 25% white

// Text Colors
val TextPrimary = Color(0xFFF5F5F7)
val TextSecondary = Color(0xFFA09B9D)
val TextMuted = Color(0xFF706B6D)

// Background Atmospheric Gradients
val CharcoalRadialBrush = Brush.radialGradient(
    colors = listOf(
        Color(0xFF2E2728),
        Color(0xFF231E1F),
        Color(0xFF1E1A1B)
    )
)

val DarkMeshBackgroundBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xFF2B2627),
        Color(0xFF211D1E),
        Color(0xFF1A1718)
    )
)
