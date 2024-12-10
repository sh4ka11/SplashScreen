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

    // Retrofit para consumo de API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    implementation ("com.google.code.gson:gson:2.8.9")

    implementation ("androidx.security:security-crypto:1.1.0-alpha06")

    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Librerías de Lifecycle y ViewModel para arquitectura
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose y Material3
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation(libs.androidx.appcompat)
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")


    implementation ("com.github.bumptech.glide:glide:4.12.0")

    implementation ("com.cloudinary:cloudinary-android:3.0.2")


    implementation("io.coil-kt:coil-compose:2.4.0")

    // Navegación en Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Subida y carga de imágenes
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Otros componentes de Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)

    // Test y debug
    implementation ("androidx.navigation:navigation-compose:2.5.0-alpha01") // Verifica la versión más reciente
    implementation ("androidx.compose.ui:ui:1.0.0")
    implementation ("androidx.activity:activity-compose:1.3.0")
    implementation ("androidx.navigation:navigation-compose:2.5.0")

    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.navigation:navigation-compose:2.5.3")

    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("androidx.activity:activity-compose:1.7.2")

    implementation("androidx.compose.ui:ui:1.x.x")
    implementation("androidx.compose.material3:material3:1.x.x")
    implementation("androidx.navigation:navigation-compose:2.x.x")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //de miguel
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // ViewModel y LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    //de miguel



}