tasks.jar {
    exclude("game-lib.jar")
    from(rootDir) {
        include("game-lib-output.jar")
        rename("game-lib-output.jar", "game-lib.jar")
    }
}

tasks.test {
    useJUnitPlatform()
}
