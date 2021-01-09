object Version {
    // Kotlin
    const val kotlin = "1.4.10"
    const val stdLib = "1.4.10"

    // Jaicf
    const val jaicf = "x0.10.1"

    // Libraries
    const val jackson = "2.10.0"
}

infix fun String.version(versionProvider: Version.() -> String) =
    "$this:${versionProvider(Version)}"