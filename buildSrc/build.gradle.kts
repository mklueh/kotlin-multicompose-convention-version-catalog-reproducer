plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(23)
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.allopen.plugin)
}
