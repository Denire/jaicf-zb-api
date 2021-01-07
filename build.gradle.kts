val coreProject = rootProject.project("jaicf-zb-api")

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:0.10.0")
    }
}

allprojects {
    group = "com.justai.jaicf"
    version = "0.10.0"

    repositories {
        google()
        jcenter()
        mavenCentral()
        mavenLocal()
        maven(uri("https://jitpack.io"))
    }
}