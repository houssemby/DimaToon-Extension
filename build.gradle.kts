plugins {
    kotlin("jvm") version "1.8.21"
}

group = "com.github.houssemby"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.recloudstream:cloudstream3:main-SNAPSHOT")
    implementation("org.jsoup:jsoup:1.15.4")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}