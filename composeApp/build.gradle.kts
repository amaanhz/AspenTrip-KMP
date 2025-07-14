import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

val ktorVersion = "3.2.1"
val ktorfitVersion = "2.6.1"

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            implementation("io.ktor:ktor-client-android:3.2.1")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.navigation.compose)
            implementation("io.coil-kt.coil3:coil-compose:3.2.0")
            implementation("io.coil-kt.coil3:coil-svg:3.2.0")
            implementation(libs.ktor.client.core)
            implementation("io.insert-koin:koin-compose:4.0.3")
            implementation("io.insert-koin:koin-compose-viewmodel:4.0.3")
            implementation("io.insert-koin:koin-compose-viewmodel-navigation:4.0.3")
            implementation("io.insert-koin:koin-core:4.0.3")
            implementation("de.jensklingenberg.ktorfit:ktorfit-lib:$ktorfitVersion")
            // implementation("de.jensklingenberg.ktorfit:ktorfit-lib-light:$ktorfitVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
            implementation("de.jensklingenberg.ktorfit:ktorfit-converters-response:$ktorfitVersion")
            implementation("de.jensklingenberg.ktorfit:ktorfit-converters-call:$ktorfitVersion")
            implementation("de.jensklingenberg.ktorfit:ktorfit-converters-flow:$ktorfitVersion")

            // Only needed when you want to use Kotlin Serialization
            implementation("io.ktor:ktor-client-serialization:$ktorVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
        }
        appleMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:3.2.1")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.aspentrip"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.aspentrip"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

