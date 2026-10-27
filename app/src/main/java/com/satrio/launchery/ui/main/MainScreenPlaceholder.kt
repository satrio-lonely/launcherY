package com.satrio.launchery.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satrio.launchery.ui.components.GlassCard
import com.satrio.launchery.ui.theme.LauncherYTheme
import com.satrio.launchery.ui.theme.TextMuted
import com.satrio.launchery.ui.theme.TextPrimary

@Composable
fun MainScreenPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        GlassCard(
            contentPadding = 32.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "MAIN SCREEN",
                    color = TextPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tahap 1: Setup dasar berhasil.\nTahap 2 akan melengkapi UI Launcher, Profile slide panel, Notes, dan Per-App Language.",
                    color = TextMuted,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1A1B)
@Composable
private fun MainScreenPlaceholderPreview() {
    LauncherYTheme {
        MainScreenPlaceholder()
    }
}
