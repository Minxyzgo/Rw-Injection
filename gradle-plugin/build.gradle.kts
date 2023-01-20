plugins {
    `java-gradle-plugin`
}

tasks.jar {
    from(rootDir) {
        include("game-lib-output.jar")
    }
}

gradlePlugin {
    plugins {
        create("ex") {
            id = "com.github.rwij.plugin"
            implementationClass = "rwij.GradlePlugin"
        }
    }
}