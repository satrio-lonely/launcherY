package com.satrio.launchery.ui.archive

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FolderZip
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
fun ArchiveScreenPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        EmptyState(
            title = stringResource(R.string.empty_archive),
            subtitle = stringResource(R.string.empty_archive_desc),
            icon = Icons.Outlined.FolderZip
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1A1B)
@Composable
private fun ArchiveScreenPlaceholderPreview() {
    LauncherYTheme {
        ArchiveScreenPlaceholder()
    }
}
