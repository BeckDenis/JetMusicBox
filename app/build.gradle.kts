
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    kotlin("kapt")
    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.5.31"
    id("com.google.protobuf") version "0.8.17"
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "denis.beck.jetmusicbox"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val localProperties = gradleLocalProperties(rootDir)

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField(
                "String", "clientId", localProperties.getProperty("clientId")
            )
            buildConfigField(
                "String", "clientSecret", localProperties.getProperty("clientSecret")
            )
            buildConfigField(
                "String", "authURL", "\"https://accounts.spotify.com\""
            )
            buildConfigField(
                "String", "baseURL", "\"https://api.spotify.com/v1/\""
            )
            buildConfigField(
                "String", "redirectURI", "\"https://www.denisbeck.com\""
            )
        }
        getByName("debug") {
            isDebuggable = true

            buildConfigField(
                "String", "clientId", localProperties.getProperty("clientId")
            )
            buildConfigField(
                "String", "clientSecret", localProperties.getProperty("clientSecret")
            )
            buildConfigField(
                "String", "authURL", "\"https://accounts.spotify.com\""
            )
            buildConfigField(
                "String", "baseURL", "\"https://api.spotify.com/v1/\""
            )
            buildConfigField(
                "String", "redirectURI", "\"https://www.denisbeck.com\""
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
        kotlinCompilerExtensionVersion = "1.0.5"
    }
}

dependencies {
    // Android
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.activity:activity-compose:1.4.0")

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.ui:ui-tooling:1.1.1")
    implementation("androidx.compose.foundation:foundation:1.1.1")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.18.0")

    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.compose.material:material-icons-core:1.1.1")
    implementation("androidx.compose.material:material-icons-extended:1.1.1")

    implementation("androidx.compose.runtime:runtime-livedata:1.1.1")

    // LifeCycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // DataStore
    implementation("androidx.datastore:datastore:1.0.0")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.5.0-alpha03")

    // Coil
    implementation("io.coil-kt:coil-compose:1.4.0")

    /** Test */
    testImplementation("junit:junit:")

    /** Android Test */
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}