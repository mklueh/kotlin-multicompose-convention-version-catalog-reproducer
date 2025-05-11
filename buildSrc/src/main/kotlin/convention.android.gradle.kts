plugins {
    //alias(libs.plugins.kotlin.android)

    /**
     * I'm not Android expert, but the below plugin gives the following error:
     * ```
     * > Failed to apply plugin 'com.android.application'.
     *    > Could not create an instance of type org.jetbrains.kotlin.gradle.plugin.mpp.KotlinAndroidTarget.
     *       > Could not generate a decorated class for type KotlinAndroidTarget.
     *          > com/android/build/gradle/api/BaseVariant
     * ```
     */
//    alias(libs.plugins.kotlin.android)
    //alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose.compiler)

    /*
    alias(android.plugins.android.application)

    alias(libs.plugins.kotlin.multiplatform).apply(false) //Unresolved reference: libs
    alias(libs.plugins.compose.multiplatform).apply(false)

    alias(android.plugins.android.library).apply(false)
    alias(android.plugins.android.application).apply(false)

    */
}
