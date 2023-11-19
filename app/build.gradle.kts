plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.renzo.remuzgo.poketinder"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.renzo.remuzgo.poketinder"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
        // Or shorter:
        jvmToolchain(8)

    }

}

dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val http3Version = "4.9.0"
    val retrofit2Version = "2.9.0"
    val gsonVersion = "2.8.7"
    val glideVersion = "4.12.0"

    // Retrofit
    implementation("com.google.code.gson:gson:$gsonVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")
    implementation("com.squareup.okhttp3:logging-interceptor:$http3Version")
    implementation("com.squareup.okhttp3:okhttp:$http3Version")

    // Glide
    implementation("com.github.bumptech.glide:glide:$glideVersion")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Card
    implementation("com.yuyakaido.android:card-stack-view:2.3.4")

    //Navigation
    implementation ("androidx.navigation:navigation-fragment:2.5.3")
    implementation ("androidx.navigation:navigation-ui:2.5.3")

    // Room
    val room_version = "2.4.3"
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")


}