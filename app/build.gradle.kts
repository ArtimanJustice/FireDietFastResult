import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.artiuil.lab.firediet"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.artiuil.lab.firediet"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.2.33"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localProperties.load(FileInputStream(localPropertiesFile))
        }

        val edamamAppId: String = localProperties.getProperty("edamam_app_id") ?: System.getenv("EDAMAM_APP_ID") ?: ""
        val edamamAppKey: String = localProperties.getProperty("edamam_app_key") ?: System.getenv("EDAMAM_APP_KEY") ?: ""
        val baseUrl: String = localProperties.getProperty("base_url") ?: System.getenv("BASE_URL") ?: ""

        // Adding BuildConfig fields
        buildConfigField("String", "EDAMAM_APP_ID", "\"$edamamAppId\"")
        buildConfigField("String", "EDAMAM_APP_KEY", "\"$edamamAppKey\"")
        buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
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
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.coil.compose)
    implementation(project(":recipeapi"))
    implementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.ui.tooling)
}