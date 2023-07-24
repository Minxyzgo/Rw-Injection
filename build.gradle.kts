subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "maven-publish")

    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

allprojects {
    if(name != "gradle-plugin") publish()

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
//            freeCompilerArgs = freeCompilerArgs + listOf(
//                "-Xcontext-receivers", "-Xskip-prerelease-check"
//            )
            //gradle dsl目前无法支持context receivers遂废弃
        }
    }
}

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
}

plugins {
    id("maven-publish")
    kotlin("jvm") version "1.8.20"
    java
}

group = "com.github.minxyzgo"
version = "1.9.4"

with(java) {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

project(":core") {
    sourceSets.getByName("test").resources {
        srcDirs("$rootDir/lib")
    }
    dependencies {
        compileOnly("org.javassist:javassist:3.29.2-GA")
        compileOnly("com.fasterxml.jackson.core:jackson-databind:2.13.4")
        testCompileOnly(fileTree("dir" to "$rootDir/lib", "include" to listOf("game-lib.jar")))
        testImplementation("org.javassist:javassist:3.29.2-GA")
        testImplementation("com.fasterxml.jackson.core:jackson-databind:2.13.4")
        api(kotlin("reflect"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}

project(":gradle-plugin") {
    dependencies {
        api(project(":core"))
        api("org.javassist:javassist:3.29.2-GA")
        api("com.fasterxml.jackson.core:jackson-databind:2.13.4")

        sourceSets.main.configure {
            resources {
                srcDirs("$rootDir/lib")
            }
        }
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

task("publishAll") {
    dependsOn(rootProject.tasks.getByName("publishMavenPublicationToMavenLocal"))
    dependsOn(project(":core").tasks.getByName("publishMavenPublicationToMavenLocal"))
    //dependsOn(project(":gradle-plugin").tasks.getByName("publishMavenPublicationToMavenLocal"))
}

fun Project.publish() {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.minxyzgo"
                artifactId = this@publish.name
                version = rootProject.version.toString()

                from(components.getByName("java"))
            }
        }
    }
}