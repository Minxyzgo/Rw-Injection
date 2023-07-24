@file:Suppress("unused")

package com.github.minxyzgo.rwij

import org.gradle.api.Action
import org.gradle.api.Project

fun Project.injection(configure: Action<GradlePlugin.InjectionExtension>) =
    this.extensions.getByType(GradlePlugin.InjectionMultiplatformExtension::class.java).jvm { configure.execute(this) }

fun Project.injectionMultiplatform(configure: Action<GradlePlugin.InjectionMultiplatformExtension>) =
    this.extensions.configure("injectionMultiplatform", configure)

