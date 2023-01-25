plugins {
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("ex") {
            id = "com.github.minxyzgo.rwij"
            implementationClass = "com.github.minxyzgo.rwij.GradlePlugin"
        }
    }
}

//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            groupId = "com.github.minxyzgo.rwij"
//            artifactId =  "com.github.minxyzgo.rwij.gradle.plugin"
//            version = rootProject.version.toString()
//
//            from(components.getByName("java"))
//        }
//    }
//
//    repositories {
//        maven {
//            mavenLocal()
//            url = uri(rootDir.absolutePath + "/repo")
//        }
//    }
//}