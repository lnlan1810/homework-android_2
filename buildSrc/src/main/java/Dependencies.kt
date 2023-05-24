object Dependencies {

    object Plugins {
        const val application = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val id = "io.gitlab.arturbosch.detekt:1.18.1"
    }

    object ClassPath {

        object Version {
            const val gradle = "7.0.4"
            const val kotlin = "1.6.10"
        }

        const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    }

    object Android {

        object Version {
            const val material3 = "3.3.0-rc01"
            const val coreKtx = "1.7.0"
            const val appCompat = "1.4.1"
            const val activityCompose = "1.4.0"
            const val compose = "1.1.1"
            const val lifecycle = "2.5.0-rc01"
            const val lifecycleExtensions = "2.2.0"
        }

        const val composeUiMaterial3 = "androidx.compose.material3:material3-window-size-class:1.0.1"
        const val material3 = "androidx.compose.material3:material3:1.0.1"

        const val coreKts = "androidx.core:core-ktx:${Version.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"

        // Compose
        const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
        const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${Version.compose}"

        // Lifecycle
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleExtensions}"

        // Navigation
        const val navigationCompose = "androidx.navigation:navigation-compose:${Version.lifecycle}"
        const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
    }

    object ThirdParty {

        object Version {
            const val androidMaterial = "1.6.1"
            const val coilCompose = "1.3.2"
            const val coroutines = "1.6.0"
            const val retrofit = "2.9.0"
            const val koin = "3.1.5"

        }

        // Coroutines
        const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

        // Retrofit
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

        const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
        const val coilCompose = "io.coil-kt:coil-compose:${Version.coilCompose}"

        // Koin
        const val koinAndroid = "io.insert-koin:koin-android:${Version.koin}"
        const val koinAndroidxCompose = "io.insert-koin:koin-androidx-compose:${Version.koin}"
    }

}