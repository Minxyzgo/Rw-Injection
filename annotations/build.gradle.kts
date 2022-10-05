repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(rootProject)
    compileOnly(files("${System.getProperty("java.home")}/../lib/tools.jar"))
}