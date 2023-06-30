package ru.cobalt42.projectData.repo.tests

import org.junit.Test
import ru.cobalt42.projectData.common.models.InternalLock
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid
import ru.cobalt42.projectData.common.repo.DbProjectRequest
import ru.cobalt42.projectData.common.repo.IProjectRepository
import kotlin.test.assertEquals

abstract class RepoProjectUpdateTest {
    abstract val repo: IProjectRepository
    protected open val updateSuccess = initObjects[0]
    protected val updateConcurrency = initObjects[1]
    private val updateUidNotFound = InternalUid("project-repo-update-not-found")
    protected val lockBad = InternalLock("20000000-0000-0000-0000-000000000009")
    protected val lockNew = InternalLock("20000000-0000-0000-0000-000000000002")

    private val reqUpdateSuccess by lazy {
        InternalProject(
            uid = updateSuccess.uid,
            name = "update object",
            code = "update object code",
            country = "update object country",
            region = "update object region",
            city = "update object city",
            street = "update object street",
            house = "1",
            building = "update object building",
            postCode = "123456",
            objectStatus = InternalObjectStatus(statusId = 1),
            lock = initObjects.first().lock,
        )
    }
    private val reqUpdateNotFound = InternalProject(
        uid = updateUidNotFound,
        name = "update object not found",
        code = "update object not found code",
        country = "update object not found country",
        region = "update object not found region",
        city = "update object not found city",
        street = "update object not found street",
        house = "1",
        building = "update object not found building",
        postCode = "123456",
        objectStatus = InternalObjectStatus(statusId = 1),
        lock = initObjects.first().lock,
    )
    private val reqUpdateConcurrency = InternalProject(
        uid = updateUidNotFound,
        name = "update object not found",
        code = "update object not found code",
        country = "update object not found country",
        region = "update object not found region",
        city = "update object not found city",
        street = "update object not found street",
        house = "1",
        building = "update object not found building",
        postCode = "123456",
        objectStatus = InternalObjectStatus(statusId = 1),
        lock = lockBad,
    )

    @Test
    fun updateSuccess() = runRepoTest {
        val result = repo.updateCommodity(DbProjectRequest(reqUpdateSuccess))
        assertEquals(true, result.isSuccess)
        assertEquals(reqUpdateSuccess.uid, result.data?.uid)
        assertEquals(reqUpdateSuccess.name, result.data?.name)
        assertEquals(reqUpdateSuccess.code, result.data?.code)
        assertEquals(reqUpdateSuccess.country, result.data?.country)
        assertEquals(reqUpdateSuccess.region, result.data?.region)
        assertEquals(reqUpdateSuccess.city, result.data?.city)
        assertEquals(reqUpdateSuccess.street, result.data?.street)
        assertEquals(reqUpdateSuccess.house, result.data?.house)
        assertEquals(reqUpdateSuccess.building, result.data?.building)
        assertEquals(reqUpdateSuccess.postCode, result.data?.postCode)
        assertEquals(reqUpdateSuccess.objectStatus.statusId, result.data?.objectStatus?.statusId)
        assertEquals(emptyList(), result.errors)
    }

    companion object : BaseInitProject("update") {
        override val initObjects: List<InternalProject> = listOf(
            createInitTestModel("update"),
            createInitTestModel("updateConcurrency"),
        )
    }
}