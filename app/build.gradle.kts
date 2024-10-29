plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.splashscreen"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.splashscreen"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation( "androidx.navigation:navigation-compose:2.7.5")
    implementation ("androidx.compose.ui:ui:1.5.0")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.0")

    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("androidx.activity:activity-compose:1.7.0")


    implementation ("androidx.compose.material3:material3:1.1.0")

    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.ui.android)
    implementation("io.coil-kt:coil-compose:2.1.0")

    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha10") // Verifica la versión más reciente
    implementation ("androidx.compose.ui:ui:1.0.0")
    implementation ("androidx.activity:activity-compose:1.3.0")
    implementation ("androidx.navigation:navigation-compose:2.5.0")

    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.navigation:navigation-compose:2.5.3")

    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("androidx.activity:activity-compose:1.7.2")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)




}