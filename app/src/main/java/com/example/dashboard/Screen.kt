package com.example.dashboard

sealed class DashBoard(val route :String) {
    object Home:DashBoard(route = "DashBoard")
    object Inbox : DashBoard(route = "Inbox_Screen")
    object Maps : DashBoard(route = "Maps_Screen")
    object Chats : DashBoard(route = "Chats_Screen")
    object Report : DashBoard(route = "Report_Screen")
    object Calender : DashBoard(route = "Calender_Screen")
    object Tips : DashBoard(route = "Tips_Screen")
    object Settings : DashBoard(route = "Settings_Screen")
    object BottomNav : DashBoard(route = "Bottom_Navigation")
}