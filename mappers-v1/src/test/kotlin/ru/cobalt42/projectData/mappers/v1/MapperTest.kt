package ru.cobalt42.projectData.mappers.v1

import ru.cobalt42.api.v1.models.ObjectStatus
import ru.cobalt42.api.v1.models.Project
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalChangeDate
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid
import kotlin.test.Test
import kotlin.test.assertEquals

class MapperTest {
    @Test
    fun fromTransport() {
        val project = Project(
            uid = "123",
            name = "projectName",
            code = "projectCode",
            country = "projectCountry",
            region = "projectRegion",
            city = "projectCity",
            street = "projectStreet",
            house = "projectHouse",
            building = "projectBuilding",
            postCode = "projectPostCode",
            objectStatus = ObjectStatus(changeDate = "2023-01-01", statusId = 1)
        )

        val context = ProjectContext()
        context.fromTransport(project)

        assertEquals("123", context.projectRequest.uid.asString())
        assertEquals("projectName", context.projectRequest.name)
        assertEquals("projectCode", context.projectRequest.code)
        assertEquals("projectCountry", context.projectRequest.country)
        assertEquals("projectRegion", context.projectRequest.region)
        assertEquals("projectCity", context.projectRequest.city)
        assertEquals("projectStreet", context.projectRequest.street)
        assertEquals("projectHouse", context.projectRequest.house)
        assertEquals("projectBuilding", context.projectRequest.building)
        assertEquals("projectPostCode", context.projectRequest.postCode)
        assertEquals("2023-01-01", context.projectRequest.objectStatus.changeDate.asString())
        assertEquals(1, context.projectRequest.objectStatus.statusId)
    }

    @Test
    fun toTransportGet() {
        val context = ProjectContext(
            projectResponse = InternalProject(
                uid = InternalUid("123"),
                name = "projectName",
                code = "projectCode",
                country = "projectCountry",
                region = "projectRegion",
                city = "projectCity",
                street = "projectStreet",
                house = "projectHouse",
                building = "projectBuilding",
                postCode = "projectPostCode",
                objectStatus = InternalObjectStatus(changeDate = InternalChangeDate("2023-01-01"), statusId = 1)
            )
        )

        val projectResponse = context.toTransportProjectGet()

        assertEquals("123", projectResponse.result?.first()?.uid)
        assertEquals("projectName", projectResponse.result?.first()?.name)
        assertEquals("projectCode", projectResponse.result?.first()?.code)
        assertEquals("projectCountry", projectResponse.result?.first()?.country)
        assertEquals("projectRegion", projectResponse.result?.first()?.region)
        assertEquals("projectCity", projectResponse.result?.first()?.city)
        assertEquals("projectStreet", projectResponse.result?.first()?.street)
        assertEquals("projectHouse", projectResponse.result?.first()?.house)
        assertEquals("projectBuilding", projectResponse.result?.first()?.building)
        assertEquals("projectPostCode", projectResponse.result?.first()?.postCode)
        assertEquals("2023-01-01", projectResponse.result?.first()?.objectStatus?.changeDate)
        assertEquals(1, projectResponse.result?.first()?.objectStatus?.statusId)
    }

    @Test
    fun toTransportCreate() {
        val context = ProjectContext(
            projectResponse = InternalProject(
                uid = InternalUid("123"),
                name = "projectName",
                code = "projectCode",
                country = "projectCountry",
                region = "projectRegion",
                city = "projectCity",
                street = "projectStreet",
                house = "projectHouse",
                building = "projectBuilding",
                postCode = "projectPostCode",
                objectStatus = InternalObjectStatus(changeDate = InternalChangeDate("2023-01-01"), statusId = 1)
            )
        )

        val projectResponse = context.toTransportProjectCreateUpdateResponse()

        assertEquals("123", projectResponse.result?.result?.uid)
        assertEquals("projectName", projectResponse.result?.result?.name)
        assertEquals("projectCode", projectResponse.result?.result?.code)
        assertEquals("projectCountry", projectResponse.result?.result?.country)
        assertEquals("projectRegion", projectResponse.result?.result?.region)
        assertEquals("projectCity", projectResponse.result?.result?.city)
        assertEquals("projectStreet", projectResponse.result?.result?.street)
        assertEquals("projectHouse", projectResponse.result?.result?.house)
        assertEquals("projectBuilding", projectResponse.result?.result?.building)
        assertEquals("projectPostCode", projectResponse.result?.result?.postCode)
        assertEquals("2023-01-01", projectResponse.result?.result?.objectStatus?.changeDate)
        assertEquals(1, projectResponse.result?.result?.objectStatus?.statusId)
    }
}