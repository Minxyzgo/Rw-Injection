package com.github.minxyzgo.rwij

import org.gradle.api.Action
import org.gradle.api.Project

fun Project.injection(configure: Action<GradlePlugin.InjectionExtension>) =
    this.extensions.configure("injection", configure)