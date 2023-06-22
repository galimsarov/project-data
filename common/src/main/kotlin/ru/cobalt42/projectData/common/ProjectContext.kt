package ru.cobalt42.projectData.common

import ru.cobalt42.projectData.common.models.InternalProject

data class ProjectContext(
    var projectRequest: InternalProject = InternalProject(),
    var projectResponse: InternalProject = InternalProject()
)
