package com.satrio.launchery.ui.plugin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Extension
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satrio.launchery.R
import com.satrio.launchery.ui.components.EmptyState
import com.satrio.launchery.ui.theme.LauncherYTheme

@Composable
fun PluginScreenPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        EmptyState(
            title = stringResource(R.string.add_plugin),
            subtitle = stringResource(R.string.select_absplugin_file),
            icon = Icons.Outlined.Extension
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1A1B)
@Composable
private fun PluginScreenPlaceholderPreview() {
    LauncherYTheme {
        PluginScreenPlaceholder()
    }
}
