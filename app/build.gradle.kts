plugins { id("com.android.application") }

android {
    compileSdk = 37
    useLibrary("org.apache.http.legacy", false)
    enableKotlin = false
    defaultConfig {
        minSdk = 26
        targetSdk = 37
        ndk.abiFilters.addAll(setOf("arm64-v8a", "armeabi-v7a"))
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }
    buildTypes.named("release") {
        isMinifyEnabled = true
        isShrinkResources = true
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
}

apply(from = "demo.gradle")

dependencies {
    implementation(files("libs/sud-gi-white.aar"))
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.5")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.constraintlayout:constraintlayout:2.2.2")
    implementation("androidx.core:core:1.16.0")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.exifinterface:exifinterface:1.3.6")
    implementation("androidx.lifecycle:lifecycle-livedata:2.9.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.9.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.9.4")
    implementation("androidx.palette:palette:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("com.airbnb.android:lottie:3.7.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.google.android.material:material:1.13.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
    implementation("cn.nubia.accounts:nbaccounts-sdk:2.4.8.07081")
    implementation("com.alipay.sdk:alipaysdk-android:15.8.42")
    implementation("com.anythink.sdk:adapter-taku-csj:7.8.1.5.1.0")
    implementation("com.anythink.sdk:adapter-taku-gdt:4.710.1580.1.0")
    implementation("com.anythink.sdk:core-taku:6.6.40")
    implementation("com.pangle.cn:ads-sdk-pro:7.8.1.5")
    implementation("com.qq.e.union:union:4.710.1580")
    implementation("com.tencent.mm.opensdk:wechat-sdk-android:6.8.40")
    implementation("com.verbto.tools:util:1.1.5")
}
