package rwij

import java.io.File

//上一次的修改时间，用于代码的增量更新
var latestModTime = 0L

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
            CodeBuilder.build(sourceFile, modTime)
            timeTempFile.writeText(latestModTime.toString())
            //CodeBuilder.buildJar(File("annotations\\src\\main\\resources\\game-lib-output.jar"), CodeBuilder.tree, CodeBuilder.pool)
        }

//        "buildJar" -> {
//            val (cp, tree) = CodeBuilder.buildNewClassTree()
//            CodeBuilder.buildJar(File("annotations\\src\\main\\resources\\game-lib-output.jar"), tree, cp)
//        }
        else -> throw IllegalArgumentException("unknown param: $param")
    }
}