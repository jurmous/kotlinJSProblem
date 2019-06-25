import groovy.lang.Closure

plugins {
    id("kotlin-multiplatform")
}

apply {
    from("../gradle/common.gradle")
    from("../gradle/js.gradle")
}

(extra["setupJS"] as Closure<*>)(false)

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":core"))
                api(kotlin("stdlib-js"))
                api(kotlin("test-js"))
            }
        }
    }
}
