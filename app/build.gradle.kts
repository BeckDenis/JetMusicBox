import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("kotlin-android")
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

            buildConfigField("String", "apiKey", localProperties.getProperty("apiKey"))
            buildConfigField(
                "String", "authURL", "\"https://accounts.spotify.com/authorize\""
            )
            buildConfigField(
                "String", "redirectURI", "\"https://www.denisbeck.com\""
            )
        }
        getByName("debug") {
            isDebuggable = true

            buildConfigField("String", "apiKey", localProperties.getProperty("apiKey"))
            buildConfigField(
                "String", "authURL", "\"https://accounts.spotify.com/authorize\""
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
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.0.5")
    implementation("androidx.compose.ui:ui-tooling:1.0.5")
    implementation("androidx.compose.foundation:foundation:1.0.5")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.18.0")

    implementation("androidx.compose.material:material:1.0.5")
    implementation("androidx.compose.material:material-icons-core:1.0.5")
    implementation("androidx.compose.material:material-icons-extended:1.0.5")

    implementation("androidx.compose.runtime:runtime-livedata:1.0.5")

    // LifeCycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.0")

    /** Test */
    testImplementation("junit:junit:4.+")

    /** Android Test */
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
}