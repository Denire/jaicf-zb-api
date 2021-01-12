plugins {
    kotlin("jvm") version Version.kotlin
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":jaicf-zb-api"))
    implementation(jaicf("telegram"))
}
