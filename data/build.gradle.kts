import java.util.Properties

plugins {
    kotlin("kapt")
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = Constants.namespace + ".data"
    compileSdk = Constants.compileSdk

    defaultConfig {
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val properties = Properties().apply {
            load(File("$rootDir/secretkey.properties").reader())
        }

        buildConfigField("String", "API_KEY", "\"${properties.getProperty("apiKey")}\"")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Constants.javaTarget
        targetCompatibility = Constants.javaTarget
    }
    kotlinOptions {
        jvmTarget = Constants.jvmTarget
    }
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))

    implementation(DataImplementationDependencies.androidCore)
    implementation(DataImplementationDependencies.retrofit)
    implementation(DataImplementationDependencies.gsonByRetrofit)
    implementation(DataImplementationDependencies.hilt)
    kapt(DataKaptDependencies.hilt)
    testImplementation(DataTestImplementationDependencies.jUnit)
    testImplementation(DataTestImplementationDependencies.hilt)
    kapt(DataTestKaptDependencies.hilt)
    androidTestImplementation(DataAndroidTestImplementationDependencies.testJUnit)
    androidTestImplementation(DataAndroidTestImplementationDependencies.espresso)
    androidTestImplementation(DataAndroidTestImplementationDependencies.hilt)
    kapt(DataAndroidTestKaptDependencies.hilt)
}