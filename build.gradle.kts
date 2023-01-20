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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-Xcontext-receivers"
            )
        }
    }
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
version = "1.4"

sourceSets.main.configure {
    java {
        exclude("**/META-INF/**")
    }

    resources {
        srcDirs("$rootDir/lib")
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

project(":gradle-plugin") {
    dependencies {
        api(project(":core"))
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

fun Project.addDependencies() {
    dependencies {
        implementation("org.javassist:javassist:3.29.2-GA")
        implementation("com.squareup:javapoet:1.13.0")
        implementation(kotlin("reflect"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
        testCompileOnly(project(":source"))
    }

    sourceSets.main.configure {
        resources {
            srcDirs(rootProject.sourceSets.main.get().resources)
        }
    }
}

task("publishAll") {
    dependsOn(rootProject.tasks.getByName("publishMavenPublicationToMavenLocal"))
    dependsOn(project(":source").tasks.getByName("publishMavenPublicationToMavenLocal"))
    dependsOn(project(":core").tasks.getByName("publishMavenPublicationToMavenLocal"))
    dependsOn(project(":gradle-plugin").tasks.getByName("publishMavenPublicationToMavenLocal"))
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