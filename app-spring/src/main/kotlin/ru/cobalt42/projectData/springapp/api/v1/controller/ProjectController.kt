package ru.cobalt42.projectData.springapp.api.v1.controller

import org.springframework.web.bind.annotation.*
import ru.cobalt42.api.v1.models.Project
import ru.cobalt42.api.v1.models.ProjectPaginatedResponse
import ru.cobalt42.api.v1.models.ProjectResponse
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.mappers.v1.fromTransport
import ru.cobalt42.projectData.mappers.v1.toTransportProjectCreateUpdateResponse
import ru.cobalt42.projectData.mappers.v1.toTransportProjectGet
import ru.cobalt42.projectData.stubs.InternalProjectStub

@CrossOrigin
@RestController
@RequestMapping("api/ktMain/project")
@Suppress("unused")
class ProjectController {
    @PostMapping
    fun createProject(@RequestBody project: Project): ProjectResponse {
        val context = ProjectContext()
        context.fromTransport(project)
        context.projectResponse = InternalProjectStub.get()
        return context.toTransportProjectCreateUpdateResponse()
    }

    @GetMapping("/{uid}")
    fun readProject(@PathVariable uid: String): ProjectPaginatedResponse {
        val context = ProjectContext()
        context.projectResponse = InternalProjectStub.get()
        return context.toTransportProjectGet()
    }

    @PostMapping("/{uid}")
    fun updateProject(@PathVariable("uid") uid: String, @RequestBody project: Project): ProjectResponse {
        val context = ProjectContext()
        context.fromTransport(project)
        context.projectResponse = InternalProjectStub.get()
        return context.toTransportProjectCreateUpdateResponse()
    }
}