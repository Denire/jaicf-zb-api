plugins {
    kotlin("jvm") version Version.kotlin
    kotlin("plugin.serialization") version Version.kotlin
    `maven-publish`
}

dependencies {
    implementation(kotlin("stdlib"))
    api("com.justai.jaicf:core" version { jaicf })
    api("com.justai.jaicf:jaicp" version { jaicf })
    api("com.justai.jaicf:jaicp" version { jaicf })
    api("com.fasterxml.jackson.core:jackson-core" version { jackson })
    api("com.fasterxml.jackson.core:jackson-databind" version { jackson })
    api("com.fasterxml.jackson.module:jackson-module-kotlin" version { jackson })
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
    }
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
        }
    }
}

apply {
    from(rootProject.file("release.gradle"))
}