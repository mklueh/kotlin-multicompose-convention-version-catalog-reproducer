import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    idea
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.allopen)
}

kotlin {
    // Use a specific Java version to make it easier to work in different environments.
    jvmToolchain(23)
}

tasks.withType<Test>().configureEach {
    // Configure all test Gradle tasks to use JUnitPlatform.
    useJUnitPlatform()

    // Log information about all test results, not only the failed ones.
    testLogging {
        events(FAILED, PASSED, SKIPPED)
    }
}
