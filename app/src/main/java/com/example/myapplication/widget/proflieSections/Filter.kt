package com.example.myapplication.widget.proflieSections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileFilters(
    text: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = if (isSelected) {
        ButtonDefaults.filledTonalButtonColors( // Seçili ise farklı renk
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    } else {
        ButtonDefaults.outlinedButtonColors( // Seçili değilse outlined
            contentColor = MaterialTheme.colorScheme.primary
        )
    }
    val border = if (isSelected) null else BorderStroke(1.dp, MaterialTheme.colorScheme.outline)

    Button( // TextButton yerine Button kullandım, daha belirgin olabilir
        onClick = onClick,
        colors = colors,
        border = border,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Icon(icon, contentDescription = text,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 13.sp) // Yazı boyutunu biraz küçülttüm
    }
}