package com.example.nighteventsapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC), // Roxo vibrante para o modo escuro
    onPrimary = Color.Black, // Contraste com o primário
    secondary = Color(0xFF03DAC6), // Verde-água
    onSecondary = Color.Black,
    tertiary = Color(0xFFCF6679), // Vermelho suave
    onTertiary = Color.Black,
    background = Color(0xFF121212), // Fundo escuro padrão
    onBackground = Color(0xFFE0E0E0), // Texto claro no fundo escuro
    surface = Color(0xFF1E1E1E), // Superfícies para contraste sutil
    onSurface = Color(0xFFE0E0E0), // Texto em superfícies
    error = Color(0xFFFF5722), // Laranja vibrante para erros
    onError = Color.Black // Texto em erros
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EA), // Roxo mais escuro e elegante
    onPrimary = Color.White,
    secondary = Color(0xFF018786), // Verde-água mais denso
    onSecondary = Color.White,
    tertiary = Color(0xFFD81B60), // Rosa profundo
    onTertiary = Color.White,
    background = Color(0xFFFFF8E1), // Bege suave para menos brilho
    onBackground = Color(0xFF1A1A1A), // Texto escuro em fundo claro
    surface = Color(0xFFFFFFFF), // Branco limpo para superfícies
    onSurface = Color(0xFF1A1A1A), // Texto escuro
    error = Color(0xFFB00020), // Vermelho clássico para erros
    onError = Color.White // Texto em erros
)



val TypographyPerson = Typography(
    titleLarge = TextStyle( // h4
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 32.sp
    ),
    titleMedium = TextStyle( // h5
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 28.sp
    ),
    titleSmall = TextStyle( // h6
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp
    ),
)

@Composable
fun NightEventsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = TypographyPerson,
        content = content
    )
}
