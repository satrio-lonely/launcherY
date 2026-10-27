# LauncherY - Absen Launcher Android App

A sleek native Android launcher application built with **Kotlin**, **Jetpack Compose**, and **Material 3**, featuring a modern **Dark Glassmorphism** visual aesthetic.

## Tech Stack
- **Kotlin 2.0.21** + **Jetpack Compose** (BOM 2024.10.00)
- **Material 3** + **WindowSizeClass** (Adaptive Landscape & Portrait)
- **Hilt** (Dependency Injection)
- **Navigation Compose**
- **Room Database** & **DataStore Preferences**
- **Storage Access Framework (SAF)**

## Visual Architecture: Dark Glassmorphism
- **Palette**: Charcoal base (`#1E1A1B` to `#2B2627`), Crimson Accent (`#C2413B`), Translucent White Glass (`8%` surface, `15%` border).
- **Glassmorphism**: Dynamic hardware blur on Android 12+ (`Modifier.blur`), elegant translucency fallback on Android 8.0 - 11.
- **Top Tab Bar**: Centered pills for `MAIN`, `PLUGIN`, and `ARCHIVE`.
