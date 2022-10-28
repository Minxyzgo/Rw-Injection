group = "source"
version = rootProject.version

dependencies {
    implementation(fileTree("dir" to "$rootDir/lib", "includes" to listOf("*.jar"), "excludes" to listOf("game-lib.jar")))
    compileOnly(project(":annotations", configuration = "default"))
    kapt(project(":annotations", configuration = "default"))
}

kapt {
    arguments {
        arg("buildDir", "$rootDir/game-lib-output.jar")
    }
}