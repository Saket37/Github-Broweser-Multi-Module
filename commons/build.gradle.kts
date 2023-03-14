plugins {
    id("com.android.library")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.commons"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(Dependencies.Core.legacySupport)
    implementation(Dependencies.Core.coreKtx)
    implementation(Dependencies.Core.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    // Dagger - Hilt
    implementation(Dependencies.Hilt.hilt)
    implementation(Dependencies.Hilt.hiltViewModel)
    kapt(Dependencies.Hilt.hiltCompiler)

    //Retrofit And Moshi
    implementation(Dependencies.RetrofitAndMoshi.retrofit)
    implementation(Dependencies.RetrofitAndMoshi.retrofitMoshiConverter)
    implementation(Dependencies.RetrofitAndMoshi.loggingInterceptor)
    implementation(Dependencies.RetrofitAndMoshi.moshi)
    implementation(Dependencies.RetrofitAndMoshi.moshiAdapters)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espresso)
}