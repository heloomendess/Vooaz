package com.vooazdomain.Vooaz.bottombar

import com.vooazdomain.Vooaz.R
object ConstantsBottomNavItem {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Chat",
            icon = R.drawable.chatbubble,
            route = "ChatSearchConectsScreen",
            size = 32
        ),
        BottomNavItem(
            label = "Destination",
            icon = R.drawable.destinationicon,
            route = "test/Chat",
            size = 32

        ),
        BottomNavItem(
            label = "Airplane",
            icon = R.drawable.airplaneicon,
            route = "HomePageScreen",
            size = 32

        ),
        BottomNavItem(
            label = "Guides",
            icon = R.drawable.tourguides,
            route = "GuideSearch",
            size = 32

        ),
        BottomNavItem(
            label = "Settings",
            icon = R.drawable.settingsicon,
            route = "SettingsScreen",
            size = 26

        ),
    )
}
