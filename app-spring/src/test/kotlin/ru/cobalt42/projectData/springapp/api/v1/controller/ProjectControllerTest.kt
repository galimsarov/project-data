package ru.cobalt42.projectData.springapp.api.v1.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.cobalt42.api.v1.models.Project
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.mappers.v1.toTransportProjectCreateUpdateResponse
import ru.cobalt42.projectData.mappers.v1.toTransportProjectGet
import ru.cobalt42.projectData.stubs.InternalProjectStub

@WebMvcTest(ProjectController::class)
class ProjectControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Test
    fun createProject() {
        val request = mapper.writeValueAsString(Project())
        val response = mapper.writeValueAsString(
            ProjectContext().apply { projectResponse = InternalProjectStub.get() }
                .toTransportProjectCreateUpdateResponse()
        )

        mvc.perform(
            MockMvcRequestBuilders.post("/api/ktMain/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().json(response))
    }

    @Test
    fun readProject() {
        val response = mapper.writeValueAsString(
            ProjectContext().apply { projectResponse = InternalProjectStub.get() }.toTransportProjectGet()
        )

        mvc.perform(MockMvcRequestBuilders.get("/api/ktMain/project/uid"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().json(response))
    }

    @Test
    fun updateProject() {
        val request = mapper.writeValueAsString(Project())
        val response = mapper.writeValueAsString(
            ProjectContext().apply { projectResponse = InternalProjectStub.get() }
                .toTransportProjectCreateUpdateResponse()
        )

        mvc.perform(
            MockMvcRequestBuilders.post("/api/ktMain/project/uid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().json(response))
    }
}