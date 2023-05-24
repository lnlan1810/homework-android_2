package com.br.wcabral.kotlin.android.githubcompose.settings

import com.br.wcabral.kotlin.android.githubcompose.ui.custom.ItisCorners
import com.br.wcabral.kotlin.android.githubcompose.ui.custom.ItisSize
import com.br.wcabral.kotlin.android.githubcompose.ui.custom.ItisStyle

data class CurrentSettings(
    val isDarkMode: Boolean,
    val textSize: ItisSize,
    val paddingSize: ItisSize,
    val cornerStyle: ItisCorners,
    val style: ItisStyle,
)
