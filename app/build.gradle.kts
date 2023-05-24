plugins {
    id(Dependencies.Plugins.application)
    id(Dependencies.Plugins.kotlinAndroid)
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Android
    implementation(Dependencies.Android.coreKts)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.activityCompose)
    implementation(Dependencies.Android.navigationCompose)

    implementation(Dependencies.Android.composeUi)
    implementation(Dependencies.Android.composeMaterial)
    implementation(Dependencies.Android.composeUiMaterial3)
    implementation(Dependencies.Android.material3)
    implementation(Dependencies.Android.composeMaterialIconsExtended)
    implementation(Dependencies.Android.composeUiTooling)
    implementation(Dependencies.Android.composeUiToolingPreview)

    implementation(Dependencies.Android.lifecycleRuntimeKtx)
    implementation(Dependencies.Android.lifecycleViewModelKtx)
    implementation(Dependencies.Android.lifecycleExtensions)
    implementation(Dependencies.Android.lifecycleViewModelCompose)

    // Third Party
    implementation(Dependencies.ThirdParty.coilCompose)
    implementation(Dependencies.ThirdParty.androidMaterial)

    implementation(Dependencies.ThirdParty.kotlinxCoroutinesCore)
    implementation(Dependencies.ThirdParty.kotlinxCoroutinesAndroid)

    implementation(Dependencies.ThirdParty.retrofit)
    implementation(Dependencies.ThirdParty.retrofitConverterGson)

    implementation(Dependencies.ThirdParty.koinAndroid)
    implementation(Dependencies.ThirdParty.koinAndroidxCompose)

}

tasks.register<Copy>("detektCollateReports") {
    // Set up task
    dependsOn(
        "android-views:detekt",
        "android-compose:detekt",
        "core:detekt"
    )
    from(
        rootDir.resolve("android-views/build/reports/detekt/"),
        rootDir.resolve("android-compose/build/reports/detekt/"),
        rootDir.resolve("core/build/reports/detekt/")
    )
    include("detekt.sarif")

    // Delete any existing contents
    buildDir.resolve("reports/detekt/").deleteRecursively()

    // Set up copy
    destinationDir = buildDir.resolve("reports/detekt/")
    rename {
        val totalCount = destinationDir.list()?.count()
        "$totalCount-$it"
    }
}
