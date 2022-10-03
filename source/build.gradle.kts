group = "source"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(fileTree("dir" to "$rootDir/lib", "exclude" to "xxx.jar", "include" to "*.jar"))
    compileOnly(project(":annotations", configuration = "default"))
    kapt(project(":annotations", configuration = "default"))
}