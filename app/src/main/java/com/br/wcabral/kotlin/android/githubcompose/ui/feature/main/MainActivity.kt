package com.br.wcabral.kotlin.android.githubcompose.ui.feature.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.wcabral.kotlin.android.githubcompose.settings.LocalSettingsEventBus
import com.br.wcabral.kotlin.android.githubcompose.settings.SettingsEventBus
import com.br.wcabral.kotlin.android.githubcompose.ui.custom.ItisTheme
import com.br.wcabral.kotlin.android.githubcompose.screens.Screen
import com.br.wcabral.kotlin.android.githubcompose.ui.navigation.createExternalRouter

class MainActivity : ComponentActivity() {

  //  @ExperimentalAnimationApi
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val settingsEventBus = remember { SettingsEventBus() }

            derivedStateOf {

            }
            val currentSettings = settingsEventBus.currentSettings.collectAsState().value

            ItisTheme(  style = currentSettings.style,
                darkTheme = currentSettings.isDarkMode,
                corners = currentSettings.cornerStyle,
                textSize = currentSettings.textSize,
                paddingSize = currentSettings.paddingSize) {
                CompositionLocalProvider(
                    LocalSettingsEventBus provides settingsEventBus
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.Main.screenName) {
                        composable(Screen.Main.screenName) {
                            MainScreen(
                                createExternalRouter { screen, params ->
                                    //    navController.navigate(screen, params)
                                }
                            )
                        }

                    }
                }
            }
            }

        }
    }


