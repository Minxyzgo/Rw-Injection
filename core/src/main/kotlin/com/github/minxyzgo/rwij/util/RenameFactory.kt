package com.github.minxyzgo.rwij.util

import com.github.minxyzgo.rwij.LibRequiredApi
import javassist.CodeConverter
import javassist.CtClass
import javassist.CtField
import javassist.CtMethod

@LibRequiredApi
@Suppress("MemberVisibilityCanBePrivate")
class RenameFactory(
    val root: ClassTree,
    val otherTree: Array<ClassTree> = emptyArray()
) {
    private val renameClasses = mutableListOf<Pair<CtClass, String>>()
    private var renamePackages = mutableListOf<Pair<String, String>>()
    private val renameFields = mutableListOf<Pair<CtField, String>>()
    private val renameMethods = mutableListOf<Pair<CtMethod, String>>()

    /**
     * @param newName new simple name
     */
    fun renameClass(
        oldClass: CtClass,
        newName: String,
    ) {
        renameClasses.add(oldClass to newName)
    }

    fun renameField(
        oldField: CtField,
        newName: String,
    ) {
        renameFields.add(oldField to newName)
    }

    fun renameMethod(
        oldMethod: CtMethod,
        newName: String,
    ) {
        renameMethods.add(oldMethod to newName)
    }

    /**
     * @param packageName the entire name of the old package
     * @param newName new simple name(the package name behind the last dot)
     */
    fun renamePackage(
        packageName: String,
        newName: String
    ) {
        renamePackages.add(packageName to newName)
    }

    fun rename() {
        renamePackages.sortedBy { -it.first.length }.forEach {
            val last = root.allPackageFromRoot[it.first]!!
            last.name = it.second
        }

        arrayOf(root, *otherTree).forEach { tree ->
            tree.forEachAllClassesWithTree { clazz, t ->
                renameFields.forEach { (oldField, newName) ->
                    val codeConverter = CodeConverter()
                    codeConverter.redirectFieldAccess(
                        oldField,
                        oldField.declaringClass,
                        newName
                    )
                    clazz.instrument(codeConverter)
                    if(oldField.name != newName) {
                        oldField.name = newName
                    }
                }

                renameMethods.forEach { (method, newName) ->
                    val codeConverter = CodeConverter()
                    val oldName = method.name
                    if(oldName != newName) method.name = newName
                    codeConverter.redirectMethodCall(
                        oldName,
                        method,
                    )
                    clazz.instrument(codeConverter)
                }

                renameClasses.forEach { (oldClass, newName) ->
                    val currentTree = tree.allPackageFromRoot[oldClass.packageName] ?: tree.allPackageFromRoot.values.first { it.longName == oldClass.packageName }
                    val _newName = currentTree.longName + oldClass.name.removePrefix(oldClass.packageName)
                    if(oldClass.simpleName != newName) {
                        currentTree.classesName.remove(oldClass.simpleName)
                        currentTree.classesName.add(newName)
                        oldClass.name = _newName.split(".").toMutableList().apply {
                            this[lastIndex] = newName
                        }.joinToString(".")
                    }
                    clazz.replaceClassName(oldClass.name, _newName)
                }

                t.allPackageFromRoot[clazz.packageName]?.longName?.let {
                    if(clazz.packageName != it) {
                        clazz.name = t.longName + clazz.name.removePrefix(clazz.packageName)
                    }
                }
            }
        }

        root.allPackageFromRoot.forEach { (t, u) ->
            println("$t ${u.longName}")
        }
        root.flushAllPackages()

        renameFields.clear()
        renameClasses.clear()
        renameMethods.clear()
    }
}