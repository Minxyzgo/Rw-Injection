package rwij

import java.io.File

//上一次的修改时间，用于代码的增量更新
var latestModTime = 0L
val jarFile = File("source\\build\\libs\\game-lib-output.jar")

fun main(args: Array<String>) {
    val param = args.first()
    latestModTime = System.currentTimeMillis()
    when(param) {
        "buildCode" -> {
            val sourceFile = File("source\\src\\main\\java")
            val timeTempFile = File(sourceFile.absolutePath + "\\timeTemp.txt")
            val modTime = if(timeTempFile.exists()) timeTempFile.readText().toLong() else {
                timeTempFile.createNewFile()
                0
            }
            Builder.build(sourceFile, modTime)
            timeTempFile.writeText(latestModTime.toString())
            Builder.buildJar(File("annotations\\src\\main\\resources\\game-lib-output.jar"), Builder.tree, Builder.pool)
        }
        else -> throw IllegalArgumentException("unknown param: $param")
    }
}