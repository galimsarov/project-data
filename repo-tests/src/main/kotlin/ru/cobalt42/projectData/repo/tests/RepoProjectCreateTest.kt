package ru.cobalt42.projectData.repo.tests

import org.junit.Test
import ru.cobalt42.projectData.common.models.InternalLock
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid
import ru.cobalt42.projectData.common.repo.DbProjectRequest
import ru.cobalt42.projectData.common.repo.IProjectRepository
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class RepoProjectCreateTest {
    abstract val repo: IProjectRepository

    protected open val lockNew: InternalLock = InternalLock("20000000-0000-0000-0000-000000000002")

    private val createObj = InternalProject(
        name = "createObject",
        code = "createCode",
        country = "createCountry",
        region = "createRegion",
        city = "createCity",
        street = "createStreet",
        house = "1",
        building = "createBuilding",
        postCode = "123456",
        objectStatus = InternalObjectStatus(statusId = 1)
    )

    @Test
    fun createSuccess() = runRepoTest {
        val result = repo.createCommodity(DbProjectRequest(createObj))
        val expected = createObj.copy(uid = result.data?.uid ?: InternalUid.NONE)
        assertTrue(result.isSuccess)
        assertEquals(expected.name, result.data?.name)
        assertEquals(expected.code, result.data?.code)
        assertEquals(expected.country, result.data?.country)
        assertEquals(expected.region, result.data?.region)
        assertEquals(expected.city, result.data?.city)
        assertEquals(expected.street, result.data?.street)
        assertEquals(expected.house, result.data?.house)
        assertEquals(expected.building, result.data?.building)
        assertEquals(expected.postCode, result.data?.postCode)
        assertEquals(expected.objectStatus.statusId, result.data?.objectStatus?.statusId)
    }
}