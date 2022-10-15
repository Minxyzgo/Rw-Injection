dependencies {
    implementation(project(":core"))
    compileOnly(files("${System.getProperty("java.home")}/../lib/tools.jar"))
}