import groovy.lang.Closure

plugins {
    id("kotlin-multiplatform")
}

apply {
    from("../gradle/common.gradle")
    from("../gradle/js.gradle")
}

(extra["setupJS"] as Closure<*>)()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
            }
        }
        commonTest {
            dependencies {
                api(project(":testmodels"))
            }
        }
    }
}

