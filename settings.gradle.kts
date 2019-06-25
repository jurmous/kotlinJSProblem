pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }

    repositories {
        mavenCentral()

        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
}

fun includeProjects(vararg names: String) {
    for (name in names) {
        include(":$name")
        project(":$name").projectDir = file(name.replace('-', '/'))
    }
}

includeProjects(
    "testmodels",
    "core"
)

rootProject.name = "test"

enableFeaturePreview("GRADLE_METADATA")
