subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

plugins {
    kotlin("jvm") version "1.7.0"
    kotlin("kapt") version "1.7.0"
    java
}

group = "com.github.minxyzgo"
version = "1.0-SNAPSHOT"

sourceSets.main.configure {
    java {
        exclude("**/META-INF/**")
    }
}

with(java) {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

project(":annotations") {
    addDependencies()
}

addDependencies()

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

fun Project.addDependencies() {
    dependencies {
        implementation("org.javassist:javassist:3.29.2-GA")
        implementation("com.squareup:javapoet:1.13.0")
        implementation(fileTree("dir" to "$rootDir/lib", "exclude" to "xxx.jar", "include" to "*.jar"))
        implementation(kotlin("reflect"))

        testImplementation(project(":source"))
    }
}
//
//task("start", Jar::class) {
//    dependsOn(tasks.build)
//    from("$buildDir/classes/java/main/") {
//        this.include { true }
//    }
////    from("game-lib/") {
////        this.include { true }
////    }
//    archiveFileName.set("game-lib.jar")
//    val rwPath = "G:\\steam\\steamapps\\common\\Rusted Warfare\\"
//    archiveFile.get().asFile.copyTo(File("$rwPath\\game-lib.jar"), true)
//}