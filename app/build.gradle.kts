plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.parkease"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.parkease"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Material Components library (Version 1.1.0)
    implementation(libs.material.v1100)

    // Material Components library (latest version)
    implementation(libs.material)

    // AndroidX core KTX extension library
    implementation(libs.androidx.core.ktx)

    // AppCompat for backward-compatible UI components
    implementation(libs.androidx.appcompat)

    // DrawerLayout for navigation drawers in the app
    implementation("androidx.drawerlayout:drawerlayout:1.1.1")

    // Google Material Components library (version 1.10.0)
    implementation("com.google.android.material:material:1.10.0")

    // Google Play services Maps SDK (via version catalog)
    implementation(libs.play.services.maps)

    // AndroidX Activity library
    implementation(libs.androidx.activity)

    // ConstraintLayout for flexible UI layouts
    implementation(libs.androidx.constraintlayout)

    // CardView for material-style cards
    implementation(libs.cardview)

    // AndroidX annotations for nullability and other annotations
    implementation(libs.androidx.annotation)

    // LiveData KTX extension for reactive UI updates
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // ViewModel KTX extension for managing UI-related data lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Unit testing with JUnit
    testImplementation(libs.junit)

    // Android test dependencies (JUnit for Android)
    androidTestImplementation(libs.androidx.junit)

    // Espresso for UI testing
    androidTestImplementation(libs.androidx.espresso.core)
}
