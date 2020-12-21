package com.github.marwin1991.intelijgitlabplugin.services

import com.intellij.openapi.project.Project
import com.github.marwin1991.intelijgitlabplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
