repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.javassist:javassist:3.29.2-GA")
    implementation(rootProject)
    implementation(fileTree("dir" to "$rootDir/lib", "exclude" to "xxx.jar", "include" to "*.jar"))
    compileOnly(files("${System.getProperty("java.home")}/../lib/tools.jar"))
}