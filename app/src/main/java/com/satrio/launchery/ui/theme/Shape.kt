package com.satrio.launchery.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Sudut membulat besar 24-32dp sesuai panduan tema Glassmorphism
val GlassShapeSmall = RoundedCornerShape(16.dp)
val GlassShapeMedium = RoundedCornerShape(24.dp)
val GlassShapeLarge = RoundedCornerShape(28.dp)
val GlassShapeExtraLarge = RoundedCornerShape(32.dp)
val GlassShapePill = RoundedCornerShape(percent = 50)

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(16.dp),
    medium = RoundedCornerShape(24.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(32.dp)
)
