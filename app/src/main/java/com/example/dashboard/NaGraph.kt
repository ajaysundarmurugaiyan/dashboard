package com.example.dashboard

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dashboard.Screen.CalenderScreen
import com.example.dashboard.Screen.ChatsScreen
import com.example.dashboard.Screen.InboxScreen
import com.example.dashboard.Screen.MapsScreen
import com.example.dashboard.Screen.ReportScreen
import com.example.dashboard.Screen.SettingsScreen
import com.example.dashboard.Screen.TipsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = DashBoard.Home.route){
        composable(
            route = DashBoard.Home.route
        ){
            Dashboard(navController = navController)
        }
        composable(
                route = DashBoard.Inbox.route
                ){
            InboxScreen(navController = navController)
        }
        composable(
                route = DashBoard.Maps.route
                ){
            MapsScreen(navController = navController)
        }
        composable(
            route = DashBoard.Chats.route
        ){
            ChatsScreen(navController = navController)
        }
        composable(
            route = DashBoard.Report.route
        ){
            ReportScreen(navController = navController)
        }
        composable(
            route = DashBoard.Calender.route
        ){
            CalenderScreen(navController = navController)
        }
        composable(
            route = DashBoard.Tips.route
        ){
            TipsScreen(navController = navController)
        }
        composable(
            route = DashBoard.Settings.route
        ){
            SettingsScreen(navController = navController)
        }
        composable(
            route = DashBoard.BottomNav.route
        ){
            BottomNavigationScreen()
        }
    }
}