subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

allprojects {
    publish()
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

plugins {
    id("maven-publish")
    kotlin("jvm") version "1.7.0"
    kotlin("kapt") version "1.7.0"
    java
}

group = "com.github.minxyzgo"
version = "1.2"

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

project(":core") {
    addDependencies()
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

fun Project.addDependencies() {
    dependencies {
        api("org.javassist:javassist:3.29.2-GA")
        implementation("com.squareup:javapoet:1.13.0")
        runtimeOnly(fileTree("dir" to "$rootDir/lib", "exclude" to "xxx.jar", "include" to "*.jar"))
        implementation(kotlin("reflect"))

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
        testCompileOnly(project(":source"))
    }
}

task("publishAll") {
    dependsOn(rootProject.tasks.getByName("publishMavenPublicationToMavenLocal"))
    dependsOn(project(":source").tasks.getByName("publishMavenPublicationToMavenLocal"))
    dependsOn(project(":core").tasks.getByName("publishMavenPublicationToMavenLocal"))
}

fun Project.publish() {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.minxyzgo"
                artifactId = this@publish.name
                version = this@publish.version.toString()

                from(components.getByName("java"))
            }
        }
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