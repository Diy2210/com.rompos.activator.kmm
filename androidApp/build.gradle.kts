plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("com.squareup.sqldelight")
    id("kotlinx-serialization")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.rompos.activator.kmm.androidApp"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    packagingOptions {
        pickFirst("META-INF/*.kotlin_module")
    }
    kapt {
        generateStubs = true
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.1")

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.activity:activity-ktx:1.1.0")
    implementation("androidx.fragment:fragment-ktx:1.2.5")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")


    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.2.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")

    implementation("com.squareup.sqldelight:android-driver:1.4.4")
    implementation("org.kodein.di:kodein-di:7.1.0")
}