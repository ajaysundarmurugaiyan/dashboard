@file:OptIn(ExperimentalFoundationApi::class)

package com.example.dashboard.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.DashBoard

@SuppressLint("SuspiciousIndentation")
@Composable
fun InboxScreen(navController: NavController){
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(DashBoard.Home.route){
                    popUpTo(DashBoard.Home.route){
                        inclusive = true
                    }
                }
            },
            text = "Inbox",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
    val tabItems = listOf(
        TabItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        TabItem(
            title = "Browse",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart
        ),
        TabItem(
            title = "Account",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle
        ),
    )
      Surface{
          var selectedTabIndex by remember { mutableIntStateOf(0) }
          val pagerState = rememberPagerState {
              tabItems.size
          }
          LaunchedEffect(selectedTabIndex) {
              pagerState.animateScrollToPage(selectedTabIndex)
          }
          LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress) {
              if (!pagerState.isScrollInProgress) {
                  selectedTabIndex = pagerState.currentPage
              }
          }
          Column(
              modifier = Modifier
                  .fillMaxSize()
          ) {
              TabRow(selectedTabIndex = selectedTabIndex) {
                  tabItems.forEachIndexed {index,item ->
                      Tab(
                          selected = index == selectedTabIndex,
                          onClick = {
                              selectedTabIndex = index
                          },
                          text = {
                              Text(text = item.title)
                          },
                          icon = {
                              Icon(
                                  imageVector = if (index == selectedTabIndex){
                                      item.selectedIcon
                                  }else item.unselectedIcon,
                                  contentDescription = item.title

                              )
                          }
                      )
                  }
              }
              HorizontalPager(
                  state = pagerState,
                  modifier = Modifier
                      .fillMaxWidth()
                      .weight(1f)
              ) {index ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = tabItems[index].title)
                    }
              }
          }
          
      }
}


@Composable
@Preview(showBackground = true)
fun Screen(){
    InboxScreen(navController = rememberNavController())
}

data class TabItem(
    val title :String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector
)
