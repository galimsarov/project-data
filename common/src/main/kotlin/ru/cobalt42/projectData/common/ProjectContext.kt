package ru.cobalt42.projectData.common

import ru.cobalt42.projectData.common.models.InternalCommand
import ru.cobalt42.projectData.common.models.InternalError
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalState

data class ProjectContext(
    var command: InternalCommand = InternalCommand.NONE,
    var state: InternalState = InternalState.NONE,
    var errors: MutableList<InternalError> = mutableListOf(),

    var projectRequest: InternalProject = InternalProject(),
    var projectValidating: InternalProject = InternalProject(),
    var projectValidated: InternalProject = InternalProject(),
    var projectResponse: InternalProject = InternalProject()
)