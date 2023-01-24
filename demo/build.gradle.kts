import com.github.minxyzgo.rwij.injection

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri(rootDir.absolutePath + "/repo") }
    }


    dependencies {
        classpath("com.github.minxyzgo.rwij:com.github.minxyzgo.rwij.gradle.plugin:1.5")
    }

}
//
apply<com.github.minxyzgo.rwij.GradlePlugin>()
injection {
    deobfuscation(com.github.minxyzgo.rwij.Libs.`game-lib`)
    initJadx("game-lib.jar")
}
//
//dependencies {
//    //injectRwCore("1.4")
//    injectRwLib("1.4")
//}
