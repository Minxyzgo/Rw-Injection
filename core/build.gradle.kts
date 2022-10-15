tasks.jar {
    doLast {
        project(":source").copySpec {
            from(buildDir) {
                include("game-lib.jar")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
