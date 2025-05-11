plugins {
    alias(libs.plugins.convention.android)

    /**
     * Preferred way: having android libs in the android.versions.toml
     *
     * * What went wrong:
     * Script compilation errors:
     *
     *   Line 5:     alias(android.plugins.android.application)
     *                             ^ Function invocation 'plugins(...)' expected
     *
     *   Line 5:     alias(android.plugins.android.application)
     *                             ^ Unresolved reference. None of the following candidates is applicable because of receiver type mismatch:
     *                                 public fun Project.plugins(block: PluginDependenciesSpec.() -> Unit): Nothing defined in org.gradle.kotlin.dsl
     *
     * 2 errors
     */
    alias(androidLibs.plugins.android.application)


    /**
     * Alternative way: having android libs also in the libs.versions.toml
     *
     * Error resolving plugin [id: 'com.android.application', version: '8.9.2']
     * > The request for this plugin could not be satisfied because the plugin is already on the classpath
     *  with an unknown version, so compatibility cannot be checked.
     */
//    alias(libs.plugins.android.application)


}

android {
    compileSdk = 31
    namespace = "com.example"
}
