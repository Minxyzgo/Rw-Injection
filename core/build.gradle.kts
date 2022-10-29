tasks.jar {
//    exclude("game-lib.jar")
    exclude("*.jar")
//    from(rootDir) {
//        include("game-lib-output.jar")
//        rename("game-lib-output.jar", "game-lib.jar")
//    }
}

tasks.test {
    useJUnitPlatform()
}
