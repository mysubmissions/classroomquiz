package com.shankarlohar.classroomquiz.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun ClassroomQuizTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = darkColorScheme(
        primary = Black,
        secondary = Grey,
        tertiary = Green,
        error = Red,
        onPrimary = White,
        onSecondary = White,
        onTertiary = White,
        onError = White,
        onBackground = White,
        onSurface = White
    )

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
