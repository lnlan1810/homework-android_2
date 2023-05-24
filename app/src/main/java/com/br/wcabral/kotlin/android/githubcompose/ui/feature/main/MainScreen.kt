package com.br.wcabral.kotlin.android.githubcompose.ui.feature.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.wcabral.kotlin.android.githubcompose.screens.ComplexScreen
import com.br.wcabral.kotlin.android.githubcompose.settings.SettingsScreens
import com.br.wcabral.kotlin.android.githubcompose.ui.navigation.AppNavigation
import com.br.wcabral.kotlin.android.githubcompose.ui.navigation.Router
import com.br.wcabral.kotlin.android.githubcompose.screens.Screen


//@ExperimentalAnimationApi
@Composable
fun MainScreen(
    router: Router
) {
    // Stored in memory NavHostController
    // Live through recompose and configuration changed cycle by rememberSaveable
    val navController = rememberNavController()
    val bottomItems = listOf(Screen.List, Screen.Complex, Screen.Setting)

    Scaffold(
        bottomBar = {
            BottomNavigation {
                bottomItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate(screen.screenName) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                             //   popUpTo = navController.graph.startDestination

                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                            }
                        },
                        label = { Text(stringResource(id = screen.titleResourceId)) },
                        icon = {

                        })
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.List.screenName) {
            composable(Screen.List.screenName) { AppNavigation() }
            composable(Screen.Complex.screenName) { ComplexScreen(navController) }
           // composable(Screen.Setting.screenName) { SettingScreen(navController) }
            composable(Screen.Setting.screenName) { SettingsScreens(navController) }
            //composable(Screen.Settings.screenName) { SettingsScreens(navController) }

        }
    }
}