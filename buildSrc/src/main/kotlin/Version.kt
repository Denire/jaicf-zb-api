import org.gradle.kotlin.dsl.DependencyHandlerScope

object Version {
    // Kotlin
    const val kotlin = "1.4.21"
    const val stdLib = "1.4.21"
    const val reflect = "1.4.0"

    // Libraries
    const val jackson = "2.12.3"
    const val slf4j = "1.7.30"
    const val jUnit = "5.6.0"
    const val jetty = "9.4.3.v20170317"

    const val ktor = "1.5.1"
    const val serializationRuntime = "1.0.1"
    const val coroutinesCore = "1.4.2"
    const val tomcatServletApi = "6.0.53"
    const val logbackGelfAppender = "1.5"
    const val mockk = "1.10.2"

    // JAICF
    const val jaicf = "1.1.0"
}

infix fun String.version(versionProvider: Version.() -> String) = "$this:${versionProvider(Version)}"

fun DependencyHandlerScope.ktor(module: String): String = "io.ktor:$module" version { ktor }

fun DependencyHandlerScope.jaicf(module: String): String = "com.just-ai.jaicf:$module" version { Version.jaicf }

fun DependencyHandlerScope.kotlinx(module: String): String = "org.jetbrains.kotlinx:$module"
