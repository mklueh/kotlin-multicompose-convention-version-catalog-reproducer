// The settings file is the entry point of every Gradle build.
// Its primary purpose is to define the subprojects.
// It is also used for some aspects of project-wide configuration, like managing plugins, dependencies, etc.
// https://docs.gradle.org/current/userguide/settings_file_basics.html

pluginManagement {
    repositories {
        gradlePluginPortal()
        // the google repository is needed not only in buildSrc but also in the main build
        // since we apply the android plugins both from convention plugins and directly
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
    }
}

dependencyResolutionManagement {
    // Use Maven Central as the default repository (where Gradle will download dependencies) in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }

    // custom version catalogs must be registered manually (only libs works out of the box)
    versionCatalogs {
        // the name 'android' is very unfortunate since there is a name clash between extensions registered
        // by version catalog and the android plugin -> 'android.plugins.*' vs. 'android { compileSdk = ... }'
        create("androidLibs") {
            from(files("gradle/androidLibs.versions.toml"))
        }
    }
}

plugins {
    // Use the Foojay Toolchains plugin to automatically download JDKs required by subprojects.
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

// Include the `app` and `utils` subprojects in the build.
// If there are changes in only one of the projects, Gradle will rebuild only the one that has changed.
// Learn more about structuring projects with Gradle - https://docs.gradle.org/8.7/userguide/multi_project_builds.html
//include(":app")
include(":apps:some-app")
include(":apps:some-app:androidApp")

rootProject.name = "kotlin-multicompose-convention-version-catalog-reproducer"
