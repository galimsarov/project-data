package ru.cobalt42.projectData.api.v1

import ru.cobalt42.api.v1.models.ObjectStatus
import ru.cobalt42.api.v1.models.Project
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class RequestSerializationTest {
    private val project = Project(
        name = "projectName",
        code = "projectCode",
        country = "projectCountry",
        region = "projectRegion",
        city = "projectCity",
        street = "projectStreet",
        house = "projectHouse",
        building = "projectBuilding",
        postCode = "projectPostCode",
        objectStatus = ObjectStatus(statusId = 1)
    )

    @Test
    fun serialize() {
        val json = apiV1Mapper.writeValueAsString(project)

        assertContains(json, Regex("\"name\":\\s*\"projectName\""))
        assertContains(json, Regex("\"code\":\\s*\"projectCode\""))
        assertContains(json, Regex("\"country\":\\s*\"projectCountry\""))
        assertContains(json, Regex("\"city\":\\s*\"projectCity\""))
        assertContains(json, Regex("\"street\":\\s*\"projectStreet\""))
        assertContains(json, Regex("\"house\":\\s*\"projectHouse\""))
        assertContains(json, Regex("\"building\":\\s*\"projectBuilding\""))
        assertContains(json, Regex("\"postCode\":\\s*\"projectPostCode\""))
        assertContains(json, Regex("\"statusId\":\\s*1"))
    }

    @Test
    fun deserialize() {
        val json = apiV1Mapper.writeValueAsString(project)
        val obj = apiV1Mapper.readValue(json, Project::class.java)

        assertEquals(project, obj)
    }
}