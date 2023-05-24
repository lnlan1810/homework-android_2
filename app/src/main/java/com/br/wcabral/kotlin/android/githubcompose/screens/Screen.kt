package com.br.wcabral.kotlin.android.githubcompose.screens

import com.br.wcabral.kotlin.android.githubcompose.R

sealed class Screen(val screenName: String, val titleResourceId: Int) {
    object Main: Screen("main", -1)
    object List: Screen("list", R.string.title_list)
    object Complex: Screen("complex", R.string.title_complex)
    object Setting: Screen("Setting", R.string.title_push)

}